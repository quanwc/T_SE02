package RandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 可以读写文件数据
 * 	读写操作是基于指针完成的，总是在指针当前位置进行读写操作
 * 
 * 两种读写模式
 * 2015-08-28 11:33:38
 * @author 全文超
 */
public class RandomAccessFileDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		/*
		 * 读取demo.txt文件
		 * 第二个参数：r表示只读
		 */
		
		//下面两个读操作的构造方法效果一样。但推荐前者
		//RandomAccessFile raf = new RandomAccessFile("demo123.txt", "r");
		
//		File file = new File("demo.txt");
//		RandomAccessFile raf = new RandomAccessFile(file, "r");
		
		
		
		
		/*
		 * 
		 * 在创建RandomAccessFile的时候抛出FileNotFoundException异常。
		 * 会有两种情况：
		 * 	1.当设置为只读模式时，若指定的文件不存在，(编译通过，运行时不会报错)则会抛出。
		 *  2.当设置为读写模式时，(编译通过，运行时不会报错)。当我们写入数据时，若该文件不存在，则会自动创建。
		 *    若创建不成功则会抛出。
		 */
//		RandomAccessFile raf2 = new RandomAccessFile("raf.dat", "rw");

	
	
	
		/**
		 * 读写当前目录下的文件demo.dat
		 */
		RandomAccessFile ra = new RandomAccessFile("demo.dat", "rw");
		
		
	}
}
