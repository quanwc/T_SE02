package RandomAccessFile2;

import java.io.RandomAccessFile;

/**
 * 批量写出字节：
 * 		方法：
 * 		void write(byte[] data)， read(byte [] data)
 * 
 * 
 * @author 全文超
 * 2016-07-19 15:55:32
 *
 */
public class RandomAccessFileDemo03 {
	public static void main(String[] args) throws Exception {
		
		RandomAccessFile raf = new RandomAccessFile("bitch.txt", "rw");
		
		String str = "我爱北京天安门,，我爱苍老师！";
		//记事本会将str字节按照自己的方式解码，按照字符串看，所以能够看懂
		
		
		/*
		 * str.getBytes()
		 * 		该方法会将当前字符串按照当前系统默认的编码集转换为对应的一组字节。
		 * 当然也可以指定编码方式。
		 */
		byte [] data = str.getBytes("UTF-8");
	
		
		/*
		 * void write(byte[] data)
		 * 		该方法会将给定的字节数组中的所有字节一次性写出。
		 */
		raf.write(data);
		
		raf.close();
		
	}
}
