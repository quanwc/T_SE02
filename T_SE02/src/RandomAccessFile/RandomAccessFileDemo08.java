package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * seek方法以及RandomAccessFile其他的读取方法
 * @author 全文超
 * 2015-08-29 12:00:18
 *
 */
public class RandomAccessFileDemo08 {	
	public static void main(String[] args) throws IOException{

		//读取Demo07中的data.dat文件。
		RandomAccessFile raf = new RandomAccessFile("data.dat", "r");
		
		int d = raf.read();
		char c = (char)d;
		System.out.println(c);//a
		System.out.println(raf.getFilePointer());//1
		
		/*
		 * int readInt()
		 * 连续读取4个字节，并转换为对应的int值
		 */
		int max = raf.readInt();
		System.out.println(max);//MAX_VALUE
		System.out.println(raf.getFilePointer());//5
		
		//跳过double，读取"你好"
		raf.seek(13);
		String str = raf.readUTF();
		System.out.println(str);//你好
		
		str = raf.readUTF();
		System.out.println(str);//切克闹
		
		
		//还想将double读回来
		raf.seek(5);
		double dd = raf.readDouble();
		System.out.println(dd);//3.141592654
		
		raf.close();
	}
}
