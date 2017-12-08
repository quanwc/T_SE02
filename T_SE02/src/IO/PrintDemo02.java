package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 使用指定的字符集并带有自动行刷新
 * @author 全文超
 * 2015-09-02 13:52:42
 *
 */
public class PrintDemo02 {
	public static void main(String[] args) throws IOException{
		
		/*
		 * 设置字符集：使用OutputStreamWriter	
		 */
		
		//向pw.txt2文件中写入字节
		FileOutputStream fos = new FileOutputStream("pw2.txt");
		
		//将字符按照给定的编码集转换为字节
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		
		//提高读写效率，可以以行为单位写出字符串。
		
		PrintWriter pw = new PrintWriter(osw,true);
		//PW把流交给OSW，之后再交给FOS
		
		
		/*
		 * PrintWriter带有自动行刷新：
		 * 每当我们调用println()方法写出字符串时，都会自动的flush()。
		 * 调用print()方法不会自动flush(),只有调用println()方法才会flush().
		 */
		pw.println("大家哈");
		pw.println("呵呵");
		pw.println("嘿嘿");
		
		
		pw.close();
		
		
	}
}
