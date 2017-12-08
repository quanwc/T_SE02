package Socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
 
/**
 * 使用UDP通信的客户端
 * 
 * 步骤：
 * 	step1：创建Socket
 * 	step2：准备数据
 * 	step3：打包(放数据，填地址)
 * 	step4：发送
 * @author 全文超
 * 2015-09-13 15:41:23
 *
 */
public class Client {
	public static void main(String[] args) {
		
		DatagramSocket client = null;
		
		try {
			
			client = new DatagramSocket();
			//客户端不用制定端口号。就像递快递，收货的人不能变，发货的人在哪里发都可以。系统会随机分配一个端口
			
			String str = "hello, Server! I'm Client!";
			
			byte [] sendBuf = str.getBytes();
			
			//创建用于描述服务端IP的InetAddress对象
			InetAddress address = InetAddress.getByName("127.0.0.1");//写"localhost"也可以
			
			//定义数据报，用于将数据发送给服务端
			DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, address, 8088);
			
			//将数据报按照数据报中指定的位置发送出去
			client.send(sendPacket);
			
			
			
			
			
			//接受服务端的数据
			
			byte [] recvBuf = new byte[100];
			//创建数据报
			DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
			
			client.receive(recvPacket);
			
			//收到之后进行组建
			byte [] arrByte = recvPacket.getData();
			String message = new String(arrByte, 0, recvPacket.getLength());
			//arrByte:也可以写出recvBuf。两者一样，就是获取回来的。
			
			System.out.println("服务端说:" + message);
			
			
			
		} catch (Exception e) {
			
		}finally{
			
		}
	}
}
