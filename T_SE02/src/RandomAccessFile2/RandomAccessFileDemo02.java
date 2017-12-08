package RandomAccessFile2;

import java.io.RandomAccessFile;

/**
 * 复制文件：
 * 		使用两个RandomAccessFile，一个读，一个写。
 * 		方法：d=src.read()   desc.write(d)，一次读1个字节，写一个字节。
 * 注：
 * 		这种方式比较慢，类似于抄作业。从5楼跑到1楼，读学霸的作业，抄1个字节，再跑到5楼写到自己的作业本，
 * 	  就这样一直跑上跑下，直到抄完为止。这样会将大量的时间浪费在路上，读写的次数过多，导致效率低下。
 * 
 * @author 全文超
 * 2016-07-19 15:17:22
 *
 */
public class RandomAccessFileDemo02 {
	public static void main(String[] args) throws Exception {
		
		//创建RandomAccessFile读取文件内容
		RandomAccessFile src = new RandomAccessFile("钢琴曲 - 我心永恒.mp3", "r");
		
		
		//创建RandomAccessFile向目标文件写
		RandomAccessFile desc = new RandomAccessFile("钢琴曲 - 我心永恒_copy.mp3", "rw");
		
		int d = -1;
		long start = System.currentTimeMillis();
		while( (d=src.read()) != -1){
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!  耗时:" + (end-start) + "ms");
		
		src.close();
		desc.close();
	}
}
