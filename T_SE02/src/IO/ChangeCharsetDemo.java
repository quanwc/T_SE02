package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字符集转换：
 * 		一个文件的编码是utf-8，将其转换为GBK格式的编码
 * 		osw.txt文件是用utf-8编码的，将其编码转换为GBK存入另一个文件，内容不能改变。
 * @author 全文超
 * 2016-07-28 09:50:12
 *
 */
public class ChangeCharsetDemo {
	public static void main(String[] args) throws IOException {
		
		/**
		 * 将osw.txt文件编码转换为GBK，并存入另一个文件
		 * 
		 * 思路：
		 * 	由于osw.txt文件中的字符数据都是以UTF-8编码转换的字节保存的。
		 * 所以我们先要用UTF-8编码将每一个字符读取出来，然后再将该字符按照GBK编码写入另一个文件即可。
		 */
		
		FileInputStream fis = new FileInputStream("osw.txt");
		
		//使用UTF-8格式读取文件
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		
		
		
		FileOutputStream fos = new FileOutputStream("ows_gbk.txt");
		
		//使用GBK格式将读取到的内容写到另一个文件
		OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
		
		
		int len = -1;
		char [] buf = new char[1024];//缓冲数组。用来提高读写效率
		while((len=isr.read(buf))!=-1){
			osw.write(buf, 0, len);
		}
		
		System.out.println("转码完毕！");
		isr.close();
		osw.close();
		
	}
}
