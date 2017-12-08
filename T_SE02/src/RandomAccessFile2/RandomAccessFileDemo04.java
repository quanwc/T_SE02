package RandomAccessFile2;

import java.io.RandomAccessFile;

/**
 * 批量读取字节:
 * 		方法:
 * 		raf.read(byte[] buf)
 * @author 全文超
 * 2016-07-19 16:42:04
 *
 */
public class RandomAccessFileDemo04 {
	public static void main(String[] args) throws Exception {
		
		RandomAccessFile raf = new RandomAccessFile("bitch.txt", "r");
		
		byte [] buf = new byte[100];
		
		/*
		 * int read(byte[] data)
		 * 		读取给定的字节数组data的length个字节，并存入该字节数组中，
		 * 	返回值为实际读取到的字节量
		 */
		int len = raf.read(buf);//返回值为实际读取到的长度：21
		System.out.println("读取的字节数: " + len);
		
		//将字节数组转换为字符串: 从0位置开始，连续读取len个字节，按照utf-8格式转为字符串
		String str = new String(buf, 0, len, "UTF-8");
		System.out.println(str);
		
		
		raf.close();
	}
}
