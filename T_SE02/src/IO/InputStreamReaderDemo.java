package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader:  
 * 		字符输入流，字节流 -> 字符流
 * 使用该流的目的：
 * 		按照指定的字符集读取字符串
 * 
 * 字符流都是高级流，只能用来读写文本数据(字符数据)
 * 使用字符输入流读取一个文本文件
 * @author 全文超
 * 2015-09-01 20:26:08
 *
 */
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = new FileInputStream("osw.txt");
		
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		//以utf-8写的，就用utf-8来读。
		
		int d = -1;
		char c = 'a';
		while( (d = isr.read()) != -1 ){
			c = (char)d;
			System.out.print(c);
		}
		
		isr.close();
	}
}
