package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端
 * @author 全文超
 * 2015-09-12 16:32:24
 *
 */


			
								//？？？？？？
								//加昵称。 加公网，让其他人也能连接到你。

		
public class Server {

	//用于与客户端连接的服务端ServerSocket
	private ServerSocket server;//得先启动服务器，这样客户端才可以连接。
	
	
	//存放所有客户端的输出流，用于传播信息
	private List<PrintWriter> allOut;
	
	
	//线程池，用于控制服务端数量， 并重用线程
	private ExecutorService threadPool;
	
	
	/**
	 * 构造方法，用于初始化服务器相关内容。
	 */
	public Server(){
		

		try {
			
			//初始化ServerSocket
			/*
			 * 初始化的时候，要求我们传入一个整数，表示的是端口号。
			 * 客户端就是通过这个端口号连接到服务端的。
			 */
			server = new ServerSocket(8088);
			
			//初始化存放所有客户端输入流的集合
			allOut = new ArrayList<PrintWriter>();
			
			
			//初始化线程池
			threadPool = Executors.newFixedThreadPool(50);//最多允许创建50个线程
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * 多个客户端可能同时连接上服务端。在遍历集合，添加元素，删除元素时都是线程不安全的。
	 * 我们需要将线程变为安全的。
	 * 这样太麻烦，我们定义三个方法，让三个方法,并且三个操作集合的方法要互斥
	 */
	/**
	 * 将给定的输出流存入共享集合中
	 * @param out
	 */
	private synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	
	
	/**
	 * 从共享集合中删除给定的输出流
	 */
	private synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	 
	
	/**
	 * 遍历集合
	 */
	private synchronized void sendMsgToAllClient(String message){
		
		/**
		 * 遍历集合：
		 * 		遍历所有的输出流，将给定的字符串发送给所有客户端
		 */ 
		for(PrintWriter pw : allOut){
			
			//将读取到的信息发送给客户端
			pw.println(message);
		}
	}
	
	
	/**
	 * 服务器开始工作的方法
	 */
	public void start(){
	
		try {
			
			/*
			 * Socket accept()
			 * 该方法是一个阻塞方法，用于等待客户端的连接。
			 * 一旦有一个客户端连接上，该方法返回的就是：刚才与它刚刚连接上的客户端(Socket)。
			 * 连接不上的话，会一直在等待着(卡着)
			 */
			
			//死循环的目的是一直监听不同客户端的连接。
			while(true){
				
				System.out.println("等待客户端的连接...");
				Socket socket = server.accept();//server在8088端口上监听，监听等待一个客户端与它连接。
				System.out.println("有一个客户端连接了。");
				
				/*
				 * 当一个客户端连接后，启动一个线程，将该客户端的Socket传入，使该线程与客户端通信。
				 * 
				 */
				Runnable clientHandler = new ClientHandler(socket);
				//Runnable意思是可运行的，要交给线程
				
//				Thread t = new Thread(clientHandler);//创建一个线程，将任务需要执行的任务传入。
//				t.start();
				
				//将任务指派给线程池
				threadPool.execute(clientHandler);
				
			}
			
		} catch (Exception e) {
//			e.printStackTrace();
			
		}finally{
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Server server = new Server();
		server.start();
	}
	
	
	/**
	 * 该线程的作用是：与给定的客户端Socket进行通信
	 * @author 全文超
	 */
	class ClientHandler implements Runnable{
		
		//该socket是用于与指定客户端的socket打交道的Socket
		private Socket socket;
		
		/**
		 * 创建线程体时将需要交互的Socket传入
		 * @param socket
		 */
		public ClientHandler( Socket socket){
			this.socket = socket;
		}
		
		
		@Override
		public void run(){
			
			//定义在try外面是因为finally中要引用
			PrintWriter pw = null;
			try {
				
				/*
				 * 通过Socket获取输出流，用于将信息发送给客户端
				 */
				OutputStream out = socket.getOutputStream();
				
				OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
				
				//带有自动的行刷新
				pw = new PrintWriter(osw, true);
				
				addOut(pw);
				
				System.out.println("当前在线人数:" + allOut.size());
				
				
				/*
				 * 客户端一旦发送消息，服务端就要接收。
				 * 因为accept方法的返回值就是刚才与服务端连接上的客户端(Socket)对象。所以就可以使用该对象的输入流来读取
				 * 
				 * 通过连接上的客户端的Socket获取输入流，来读取客户端发送过来的信息。
				 */
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				
				//包装为缓冲字符输入流，就可以按行读取字符串了。
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while( (message = br.readLine()) != null ){
					
//					System.out.println("客户端:" + message);
					
					
//					pw.println(message);
					sendMsgToAllClient(message);//将当前消息广播(转发)给给所有的客户端
				}
			} catch (Exception e) {
				
			}finally{
				/*
				 * linux的客户端若断开连接，服务端会读取到null
				 * windows的客户端断开连接，服务端会抛出异常
				 * 所以，finally是我们最后做处理的最佳地点。
				 */
				System.out.println("客户端下线了。");
				
				//当客户端下线后，将其输出流从共享集合中删除
				removeOut(pw);
				
				System.out.println("当前在线人数:" + allOut.size());
				
				/*
				 * 不用分别关闭输入流与输出流
				 * 关闭socket即可。因为这两个流都是Socket获取的
				 * 就像打完电话之后，只需将电话(socket)挂了就可以了，不用讲麦克风(输出流)和听筒(输入流)抠下来。
				 */
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
