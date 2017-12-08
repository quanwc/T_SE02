package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 将一个字符串存入文件
 * @author 全文超
 * 2015-08-28 16:09:28
 *
 */
public class RandomAccessFileDemo03 {
	public static void main(String[] args) throws IOException {
		
		/*
		 * 将字符串： 大家好，才是真的好！ 写入文件按
		 * 问题：
		 * 	1.只有自己才可以写入文件， 如何将字符串转换为字节
		 *  2.转换后肯定不止一个字节(8位)，如何将一组字节写出
		 */
		
		RandomAccessFile raf = new RandomAccessFile("raf2.txt", "rw");
		
		String str = "大家好,才是真的好!";//UTF-8:中文3字节，英文2字节
//		byte [] arr = str.getBytes();//将字符串按照系统默认的编码集转换为对应的字节
		
		byte [] arr = str.getBytes("utf-8");//将字符串按照给定的编码集转换为对应的字节，编码集的名字不区分大小写
		System.out.println("长度:" + arr.length);//26
		
		raf.write(arr);
		raf.close();
		
		
		/*
		 * 作业:
		 * 编写一个程序
		 * 		从控制台输入内容，将这些内容写入文件中。
		 * 		类似记事本的内容。 
		 */
	}
}
