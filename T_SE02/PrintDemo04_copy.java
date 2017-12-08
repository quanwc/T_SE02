package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 复制当前类的源程序到根目录
 * @author 全文超
 * 2015-09-02 15:28:11
 *
 */
public class PrintDemo04 {
	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = new FileInputStream("src"+File.separator+"IO"+File.separator+"PrintDemo04.java");
		
		//将字节输入流转换为字符输入流
		InputStreamReader isr = new InputStreamReader(fis);
		
		//按行为读取字符串，将isr转换为BufferedReader类型
		BufferedReader br = new BufferedReader(isr);
		
		
		//写到目标文件中
		PrintWriter pw = new PrintWriter("PrintDemo04_copy.java");
		
		String line = null;
		while( (line = br.readLine()) != null){
			pw.println(line);//此处写的时候要有换行，因为：按行读取的时候，并没有将换行符返回回来。
		}
		
		pw.close();
		br.close();
	}
}
