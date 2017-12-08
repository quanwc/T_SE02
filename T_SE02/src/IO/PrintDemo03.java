package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader：
 * 	缓冲字符输入流。特点是可以按行读取字符串、速度比较快。
 * 
 * 
 * 将当前程序的原文件读取出来并输出到控制台
 * @author 全文超
 * 2015-09-02 14:40:36
 *
 */
public class PrintDemo03 {
	public static void main(String[] args) throws IOException{
		
		//用于从文件中读取字节
		FileInputStream fis = new FileInputStream("." + File.separator
					+ "src" + File.separator + "IO" 
					+ File.separator + "PrintDemo03.java");
		
		//将字节按照给定的编码集转换为字符
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		
		//可以以行为单位读取字符串，缓冲流可以提高读取效率
		//BufferedReader的构造方法：必须要求传入一个字符流。
		//即就是：缓冲字符输入流只能包装字符流
		BufferedReader br = new BufferedReader(isr);
		
		
		/**
		 * String readLine():
		 * 	缓冲字符输入流的该方法可以按行为单位读取字符串
		 * 
		 * 	它会读取若干字符，直到读取了换行符为止，然后将换行符之前的所有字符组成一个字符串后返回。
		 * 但是返回的字符串中不包括换行符！若返回值为null，则说明读取到文件末尾了，没有数据可以读取了。
		 */
		String line = null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		
		br.close();
		
	}
}
