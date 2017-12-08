package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端：
 * @author 全文超
 * 2016-09-07 14:55:37
 *
 */
public class Server2 {
	
	/**
	 * 运行在服务端的ServerSocket，用于监听服务端口，接收客户端的连接
	 */
	private ServerSocket server;

	/**
	 * 该集合用来保存所有客户端的输出流，便于传播信息
	 */
	private List<PrintWriter> allOut; 
	
	/**
	 * 构造方法，用来初始化
	 */
	public Server2(){
		try {
			
			allOut = new ArrayList<PrintWriter>();
			
			//创建ServerSocket的同时需要指定服务端口
			server = new ServerSocket(8088); //每种通讯协议都会有端口
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 向集合中添加一个输出流
	 */
	private synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	
	/**
	 * 将给定的输出流从集合中删除
	 */
	private synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	
	/**
	 * 遍历集合，将给定的消息发送给所有客户端
	 */
	private synchronized void sendMessageToAllClient(String message){
		for(PrintWriter pw : allOut){
			pw.println(message);
		}
	}
	
	
	
	/**
	 * 服务端开始工作的方法
	 */
	public void start(){
		try {
			/*
			 * Socket accept():
			 * 该方法是一个阻塞方法，用于等待一个客户端的连接。
			 * 返回值：是与它连接上的客户端Socket，用于与该客户端交互
			 */
			System.out.println("等待客户端的连接...");
			Socket socket = server.accept();
			System.out.println("一个客户端连接上了...");
			
			/*
			 * 启动一个线程，用来与当前客户端进行交互
			 */
			ClientHandler handler = new ClientHandler(socket);
			Thread t = new Thread(handler);
			t.start(); //启动线程
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Server2 server = new Server2();
		server.start();
	}
	
	
	
	
	/**
	 * 该内部类的作用：
	 * 		是一个线程要执行的任务，用于与给定的客户端交互
	 */
	private class ClientHandler implements Runnable {
		
		//当前线程需要与这个Socket客户端进行交互
		private Socket socket;
		
		//当前客户端的地址
		private String host;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			/*
			 * 通过socket获取远程计算机的信息
			 */
			InetAddress address = socket.getInetAddress(); //获取远程计算机的地址信息
			
			host = address.getHostAddress(); //获取ip
			System.out.println("[" + host + "]上线了!");
			
		}
		
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				
				/*
				 * 通过客户端的socket获取输出流，用来将消息发送给当前客户端
				 */
				OutputStream out = socket.getOutputStream();
				
				OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
				
				pw = new PrintWriter(osw, true);
				
				//将这个客户端的输出流添加到集合中
				addOut(pw);
				
				System.out.println("当前在线人数:" + allOut.size());
				
				
				
				/*
				 * 通过socket获取输入流，用于接收客户端的消息
				 */
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				/*
				 * 通过socket得到输入流，循环读取客户端的消息
				 * 
				 * windows的客户端与服务端断开连接之后，这里的readLine方法直接抛出异常，告知我们客户端与服务端断开了连接
				 */
				while((message = br.readLine()) != null){ 
					System.out.println("["+ host +"]说: " + message);
				//	pw.println(message);  //将客户端发送到服务器的消息，重新发送到客户端
				
					//当服务端读取到客户端发送过来的一句话后，转发给所有客户端
					sendMessageToAllClient("["+ host +"]说: " + message);
				}
			} catch (Exception e) {
				
			} finally{
				try {
					removeOut(pw);
					socket.close(); //客户端与服务器断开连接之后，应该关闭Socket以释放资源
					System.out.println("---");
					System.out.println("[" + host + "]下线了!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	} 
	
	
}
