package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 获取游标位置 已经对应基本类型进行写操作的方法
 * @author 全文超
 * 2015-08-29 11:12:06
 *
 */
public class RandomAccessFileDemo07 {
	public static void main(String[] args) throws IOException{
		
		RandomAccessFile raf = new RandomAccessFile("data.dat", "rw");
		
		System.out.println(raf.getFilePointer());//0
		
		raf.write('a');//写入一个字节。字符虽然占2个字节，但使用1个字节也可以表示。
		System.out.println(raf.getFilePointer());//1
		
		//raf.write(Integer.MAX_VALUE),只会将后8位写入文件。
		raf.writeInt(Integer.MAX_VALUE);//将32位写入文件，即将int最大值写入文件。
		System.out.println(raf.getFilePointer());//5
		
		raf.writeDouble(3.141592654);
		System.out.println(raf.getFilePointer());//13
		
		
		/*
		 * RandomAccessFile提供了一个写字符串的方法
		 * 使用UTF-8编码将字符串转换为字节直接写入
		 * void writeUTF(String str)
		 * 这个方法：每次会多写两个字节，用来记录当前字符串长度。
		 */
		String str = "你好";//1个汉字在utf-8中占3个字节。
//		byte [] arr = str.getBytes();
//		raf.write(arr);
		raf.writeUTF(str);//与上面两句话的作用相同。
		System.out.println(raf.getFilePointer());//21
		
		raf.writeUTF("切克闹");
		System.out.println(raf.getFilePointer());//32
		
		raf.close();
	}
}
