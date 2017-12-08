package Socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 使用UDP的通信的服务端
 * 
 * 步骤：
 * 	step1：创建Socket，并指定服务端口
 * 	step2：准备要给接收数据的包
 *  step3：接收数据。包中包含了客户端的地址信息
 *  step4：拆包拿数据
 * @author 全文超
 * 2015-09-13 15:19:52
 *
 */
public class Server {
	public static void main(String[] args) {
		
		//创建服务端的DatagramSocket
		DatagramSocket server = null;
		try {
			server = new DatagramSocket(8088);
			
			//创建一个100字节的数组
			byte [] recvBuf = new byte[100];
			
			//创建数据包，将获取的数据填满给定的数组
			DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
			
			//监听8088端口的数据，并将发送过来的数据存入数据报
			server.receive(recvPacket);
			
			//返回数据报中保存的字节数组
			byte [] data = recvPacket.getData();
			
			//将服务端接收到的字节数组转换为字符串
			//数据报的getLength()方法用于返回接收到的实际字节长度
			String str = new String(data, 0, recvPacket.getLength());
			
			System.out.println("客户端说:" + str);
			
			
			
			
			//服务端回复客户端
			String message = "hello, Client. I'm Server";
			byte [] sendBuf = message.getBytes();
			
			/*
			 * 通过之前客户端发送过来的数据报我们还可以得知对方的地址以及使用的端口
			 */
			InetAddress address = recvPacket.getAddress();
			int port = recvPacket.getPort();
			
			//将要发送的数据打包：DatagramPacket类型
			DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, address, port);
			
			server.send(sendPacket);
			
		} catch (Exception e) {
			
		}finally{
			
		}
	}
}
