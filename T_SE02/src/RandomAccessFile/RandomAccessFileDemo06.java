package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用批量读写来降低读写次数，提高读写效率
 * @author 全文超
 * 2015-08-29 10:23:23
 * 
 */
public class RandomAccessFileDemo06 {
	public static void main(String[] args) throws IOException{
		
		RandomAccessFile src = new RandomAccessFile("圣雄甘地.mp4", "r");
		
		RandomAccessFile des = new RandomAccessFile("圣雄甘地_copy.mp4", "rw");
		
		byte [] buf = new byte[1024*10];//10KB
		int len = -1;//每次读取到的字节量
		
		long start = System.currentTimeMillis();
		while( ( len=src.read(buf) ) != -1 ){
			//每次读取不可能将字节数组读满，所以不能写：des.write(buf),这样会将整个字节数组的内容写入。
			//每次将读取到的内容，存入到字节数组，从0开始，长度为len
			
			des.write(buf, 0, len);//写的时候，从字节数组下标为0的地方开始，读了多少(len)个，就写多少(len)个
		}
		long end = System.currentTimeMillis();
		System.out.println("赋值完毕，耗时:" + (end-start));
	}
}
