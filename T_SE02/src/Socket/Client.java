package Socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * @author 全文超
 * 2015-09-12 16:32:13
 * 
 */
public class Client {

	//用于与服务端相连的客户端(Socket)
	//客户端：相当于是Socket; 服务端：相当于是ServerSocket
	private Socket socket;
	
	
	/**
	 * 构造方法， 用于初始化客户端相关内容
	 */
	public Client(){
		
		try {
			
			/*
			 * 我们创建Socket客户端，目的就是要与服务端连接。
			 * 实例化Socket的过程就是连接的过程。
			 * 		通常我们需要传入两个参数
			 * 			i>:字符串，服务器的IP地址
			 * 			ii>:整数，服务器端申请的端口号
			 * 			(在这个程序中，ServerSocket创建时生气的端口：8088)
			 */
			System.out.println("正在连接服务器...");
			socket = new Socket("localhost", 8088);//此时已经与服务器连接上了。
			//只要成功的创建一个Socket，就已经与服务器连接上了。如果没有连接上，new完之后会报错。
			
			System.out.println("以连接服务器。");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 客户端用于交互的方法
	 * 		向服务端发送字符串：你好，服务端
	 * 
	 */
	public void start(){
		try {
			
			/*
			 * 创建一个线程，用于读取服务端发送过来的信息
			 */
			Runnable handler = new GetMessageFromServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			
			/*
			 * 客户端向服务端发送消息：
			 * 			客户端写出信息，是输出流。服务端读入信息，是输入流。
			 * 
			 * 客户端想向服务器发送信息，通过Socket获取输出流，之后写出数据即可。
			 */
			OutputStream out = socket.getOutputStream();
			
			/* 字节流什么都可以传输，但向服务端发送字符串，我们可以考虑使用字符流。
			 * 此时，我们可以考虑将字节流转换为缓冲字符输出流:PrintWriter
			 * 注意：编码格式。
			 */
			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
			
			//发送一个字符串就应当立即写出，所以要自动行刷新。
			PrintWriter pw = new PrintWriter(osw, true);//自动行刷新
			
			/*
			 * 创建Scanner，将控制台的字符串通过pw对象发送给服务端 
			 */
			Scanner scan = new Scanner(System.in);
			System.out.println("please input words:");
		
			while(true){
				String message = scan.nextLine();
				pw.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Client client = new Client();
		client.start();
	}
	
	
	
	/**
	 * 该线程的作用：让客户端可以读取服务器发送过来的信息。
	 * @author 全文超
	 *
	 */
	class GetMessageFromServerHandler implements Runnable{

		
		@Override
		public void run(){
			/*
			 * 通过Socket获取输入流，再转换为缓冲字符输入流。
			 * 最后循环读取服务端发送的每一行信息。
			 */
			
			try {
				
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				
				//可以按行读取
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while( (message = br.readLine()) != null ){
					System.out.println(message);
				}
				
			} catch (Exception e) {
				
			}
		}
	}
	
}
