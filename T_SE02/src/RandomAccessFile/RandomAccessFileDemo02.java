package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件内容
 * 
 * @author 全文超
 * 2015-08-28 15:17:46
 *
 */
public class RandomAccessFileDemo02 {
	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		
		/*
		 * int read()
		 * 从文件中读取1个字节，并以int形式返回。  这个int值只有低8为有效，0-255之间。
		 * 若返回的int值为-1，则说明EOF(end of file),达到文件末尾了。
		 * 
		 * write: -1  11111111
		 * read:  255 00000000 00000000 00000000 11111111
		 * 若write读入的是-1，read读出的是255。原因如上，write存入8位，read返回值为int，是32位。
		 */
		raf.write(97);
		int d = raf.read();
		System.out.println(d);//255
		//每次读取只读8位，然后游标后移。游标指向紧挨着的8位的前面。
		
		
		d = raf.read();//当下一次再读取的时候，游标指向刚才后面的8为位的前面。
		System.out.println(d);//2

		d = raf.read();
		System.out.println(d);//-1, 游标指向文件末尾
		raf.close();
		
	}
}
