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
 * 聊天室客户端
 * @author 全文超
 * 2016-09-07 15:08:49
 *
 */
public class Client2 {
	
	/**
	 * 客户端的Socket，用于连接服务端的ServerSocket，并与服务端通讯
	 */
	private Socket socket;
	
	
	/**
	 * 构造方法
	 */
	public Client2(){
		try {
			socket = new Socket("localhost", 8088); //服务端地址，服务端端口
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		
		try {

			/*
			 * 启动一个线程，用来读取服务端发送过来的消息
			 */
			GetServerMessageHandler hanler = new GetServerMessageHandler();
			Thread t = new Thread(hanler);
			t.start(); //启动线程
			
			
			/*
			 * 通过socket获取输出流，用于将数据写出到服务端
			 */
			OutputStream out = socket.getOutputStream();
			
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			
			PrintWriter pw = new PrintWriter(osw, true);
			
			//获取用户输入
			Scanner scan = new Scanner(System.in);
			//循环将键盘输入的内容发送给服务端
			while(true){
				pw.println(scan.nextLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Client2 client = new Client2();
		client.start();
	}
	
	
	private class GetServerMessageHandler implements Runnable{
		
		@Override
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine()) != null){
					System.out.println(message);
				}
			} catch (Exception e) {
				
			}
		}
	}
	
}
