package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * PrintWriter的嵌套
 * 
 * 若想按照指定的字符集写出，我们需要将字节流转换为OutputStreamWriter，然后指定字符集
 * 
 * 
 * PrintWriter(OutputStream out, boolean autoFlush)
 * //传字节流，第二个参数为true，则具有自动行刷新功能
 *
 * PrintWriter(Writer writer) //传字符流
 * 
 * @author 全文超
 * 2016-07-28 12:34:54
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws IOException {
	
		FileOutputStream fos = new FileOutputStream("pw3.txt");
		
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		
		/**
		 * PrintWriter去包装OutputStreamWriter，OutputStreamWriter指定了编码集，
		 * 所以可以理解为：PrintWriter写的时候就按照这个编码集来写
		 * 
		 * 自动行刷新：
		 * 		意思是每当我们调用println()方法就会自动调用flush()方法
		 * 		条件：
		 * 			构造方法第二个参数必须为true
		 * 			同时，调用println()方法，而不是print()方法
		 */
		PrintWriter pw = new PrintWriter(osw, true);
		
		pw.println("下雨天。。");
		pw.println("吐槽吧，我是不会改的！");
		pw.println("绝壁老司机");
		pw.println("好吧，我们---");
		
	}
}
