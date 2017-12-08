package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrintWriter提供了用于流的嵌套(流的链接)使用的构造方法
 * 
 * PrintWriter(OutputStream out) //传字节流
 * PrintWriter(Writer writer) //传字符流
 * 
 * @author 全文超
 * 2016-07-28 11:06:36
 *
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws IOException{
		
		/**
		 * 链接字节流
		 */
		FileOutputStream fos = new FileOutputStream("pw1.txt");
		
		/**
		 * 直接将字节输出流转换为PrintWriter的话，会按照系统默认字符集写出字符串。
		 */
		PrintWriter pw = new PrintWriter(fos, true);
		
		pw.print("随便了");
		pw.println("我是第一行");
		pw.println("我是第二行");
		
		pw.flush();  //缓冲流里面都有缓冲区，需要调用flush方法刷新
		
	}
}
