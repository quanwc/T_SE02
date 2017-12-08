package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流的批量读写操作复制文件
 * @author 全文超
 * 2015-09-01 10:12:13
 *
 */
public class FileDemo04 {
	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = new FileInputStream("YozoOffice.rar");//读取
		FileOutputStream fos = new FileOutputStream("YozoOffice_copy.rar");//写入
		
		int len = -1;//记录每次读取到的字节量
		byte [] arr = new byte[10*1024];//10KB
		while( (len = fis.read()) != -1 ){
			fos.write(arr, 0, len);
		}
		System.out.println("赋值完毕!");
		
		fis.close();
		fos.close();
	}
	
}
