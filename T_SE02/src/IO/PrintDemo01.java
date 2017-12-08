package IO;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 缓冲字符流：
 * 	好处：  读写字符串速度快、 可以以行为单位读写字符串
 * 
 * 缓冲字符输入流：BufferedReader
 * 缓冲字符输出流：BufferedWriter，但是我们一般不用该类，一般用PrintWriter类。
 * PrintWriter内部嵌套了BufferedWriter，也具有缓冲功能。
 * PrintWriter还提供了自动行刷新功能，所以我们通常使用它来当作缓冲字符输出流
 * 
 * 带有自动行刷新的缓冲字符输出流PrintWriter
 * @author 全文超
 * 2015-09-02 13:34:16
 *
 */
public class PrintDemo01 {
	public static void main(String[] args) throws IOException{
		
		/*
		 * 将一个字符串写入文本文件
		 */
		PrintWriter writer = new PrintWriter("pw.txt", "UTF-8");
		//如果没有说明字符集，则默认系统默认的字符集。
		
		writer.print("helloworld!");
		writer.println("hello");
		writer.print("world");
		writer.println("helloworld");
		
		writer.close();
	}
}
