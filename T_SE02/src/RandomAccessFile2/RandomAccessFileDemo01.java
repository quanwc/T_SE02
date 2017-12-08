package RandomAccessFile2;

import java.io.RandomAccessFile;

/**
 * 读写操作：
 * write(int d): 传入一个int值，但只将一个字节(低8位)写入到文件
 * read(): 读取一个字节 
 * @author 全文超
 * 2016-07-19 14:32:05
 *
 */
public class RandomAccessFileDemo01 {
	public static void main(String[] args) throws Exception {
		
		RandomAccessFile raf = new RandomAccessFile("hh.dat", "rw");
		raf.write(97);
		raf.close();
		
		
		
		
		RandomAccessFile raf2 = new RandomAccessFile("hh.dat", "r");
		/**
		 * 读取一个字节：
		 * 		返回的int值为-1，说明读取到了文件末尾。
		 * 
		 * 注：
		 * 		读文件时，若设置为"rw"模式，read()方法的返回值总是-1。
		 * 	因为不但读，而且写，指针会指到文件末尾处
		 */
		int i = raf2.read();
		System.out.println(i);//97
		raf2.close();
		
		
	}
}
