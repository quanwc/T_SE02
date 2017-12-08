package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲流来简化操作，简化为了提高读写效率而编写额外内容(byte数组)
 * 使用缓冲流可以提高读写效率
 * @author 全文超
 * 2015-09-01 11:08:47
 *
 */
public class BufferedDemo01 {
	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = new FileInputStream("KTY-I.mp4");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("KIY-I_copy.mp4");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int len = -1;
		int count=0;
		while((len=bis.read())!=-1){
			bos.write(len);
			count++;
		}
		
		System.out.println("复制完毕，次数: " + count);

		/*
		 * 关闭流的时候，只要关闭最外层的高级流即可
		 * 原因：所有高级流在关闭自己之前，会将自己处理的先流关闭。
		 * */
		bis.close();
		bos.close();
	}
}
