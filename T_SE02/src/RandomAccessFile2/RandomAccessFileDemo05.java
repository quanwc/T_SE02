package RandomAccessFile2;

import java.io.RandomAccessFile;

/**
 * 若想要提高读写效率，就要减少读写的次数
 * 使用批量读写字节的方法来提高读写的数据量，从而减少读写的次数来完成复制工作。
 * @author 全文超
 * 2016-07-22 08:17:09
 *
 */
public class RandomAccessFileDemo05 {
	public static void main(String[] args) throws Exception {
		
		RandomAccessFile src = new RandomAccessFile("少时_终极版.mp3", "r");
		
		RandomAccessFile desc = new RandomAccessFile("少时_终极版_cppy.mp3", "rw");
		
		
		byte [] buf = new byte[1024*10];//10K大小的缓冲数组
		
		int len = -1; //每次实际读取到的字节量
		
		long start = System.nanoTime();
		
		while((len=src.read(buf))!=-1){
			/*
			 * void write(byte[], int offset, int len)
			 * 将字节数组中的字节写出，不过是从offset位置开始写len个长度
			 */
			desc.write(buf, 0, len);  //write(byte[])的重载方法
		}
		
		long end = System.nanoTime();
		System.out.println("复制完毕！耗时：" + (end-start) + "纳秒");
		
		src.close();
		desc.close();
	}
}
