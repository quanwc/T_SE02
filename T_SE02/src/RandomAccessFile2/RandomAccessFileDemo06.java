package RandomAccessFile2;

import java.io.RandomAccessFile;

/**
 * 
 * RandomAccessFile读写基本类型数据
 * 	同时也是基于指针操作
 * @author 全文超
 * 2016-07-22 08:37:03
 *
 */
public class RandomAccessFileDemo06 {
	public static void main(String[] args) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("hh2.txt", "rw");
		
		//获取指针当前位置，默认为文件的第一个字节，是0
		long pos = raf.getFilePointer();
		System.out.println(pos);
		
		int imax = Integer.MAX_VALUE;
		
		/*
		 * 将int值写入文件:
		 * 		底层是位移(>>>)操作
		 * 
		 * 01111111 11111111 11111111 11111111
		 * 							  vvvvvvvv
		 * 
		 * write(int )方法，只能写低8位，所以需要移位
		 * 	raf.write(imax>>>24);//将最高8位向右移动8位
		 *	raf.write(imax>>>16);
		 *	raf.write(imax>>>8);
		 *	raf.write(imax);
		 */
		raf.writeInt(imax);
		
		/*
		 * RandomAccessFile的所有读写操作都是基于指针当前位置的，并且操作完成后指针
		 * 会自动向后移动。
		 */
		System.out.println(raf.getFilePointer());
		raf.writeLong(123L);
		
		raf.writeDouble(123.123);
		
		System.out.println("===========");
		
		/*
		 * readInt()
		 *	连续读取4个字节并转换为int值返回，若在文件末尾读取时，该方法会抛出异常 
		 */
		raf.seek(0);
		int i = raf.readInt();
		System.out.println(i);
		
		//读取double
//		raf.seek(12);
//		double d = raf.readDouble();
//		System.out.println(d);
		raf.skipBytes(8);//在指针当前位置处开始，连续跳过给定的字节量
		double d = raf.readDouble();
		System.out.println(d);
		
		raf.close();
	}
}
