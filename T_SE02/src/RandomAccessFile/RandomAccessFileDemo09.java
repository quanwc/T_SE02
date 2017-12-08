package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RandomAccessFile实现追加写操作
 * @author 全文超
 * 2015-08-29 12:35:38
 *
 */
public class RandomAccessFileDemo09 {
	public static void main(String[] args) throws IOException{
		
		/*
		 * 写操作都是从文件开头进行写操作。
		 * 写之前先将游标移动到文件末尾，再进行写操作，这样就是追追加内容了。
		 */
		RandomAccessFile raf = new RandomAccessFile("append.txt", "rw");
		
		/*
		 * RandomAccessFile同样支持length()方法
		 * 用于获取文件的字节量
		 */
//		raf.seek(raf.length());//游标向后移动的长度：文件的长度
		
		raf.skipBytes((int)raf.length());//在当前位置上连续忽略多少个长度，不能往前。seek方法可前可后
		
		raf.write("药".getBytes("utf-8"));
		
		raf.close();
		
	}
}
