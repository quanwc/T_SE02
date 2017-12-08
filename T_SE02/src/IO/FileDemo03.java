package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件的输入流与输出流实现文件复制工作
 * @author 全文超
 * 2015-09-01 09:55:18
 *
 */
public class FileDemo03 {
	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = new FileInputStream("少时_终极版.mp3");//用于读取
		FileOutputStream fos = new FileOutputStream("少时_终极版_copy.mp3");//用于写入
	
		int len = -1;
		int count = 0;
		byte [] data = new byte[10*1024];//10K
		
		while((len=fis.read(data))!=-1){
			fos.write(data, 0, len);
			count++;
		}
		
		System.out.println("复制完毕，读写次数: " + count);
		
		fis.close();
		fos.close();
	}
}
