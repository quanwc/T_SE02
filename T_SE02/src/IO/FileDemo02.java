package IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用文件输入流将数据从文件中读取
 * @author 全文超
 * 2015-09-01 09:42:33
 *
 */
public class FileDemo02 {
	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = new FileInputStream("data.txt");
		int d = -1;
		 

		byte [] buf = new byte[100];
		

		while( (d = fis.read(buf)) != -1){
			String str = new String(buf, 0, d);//将每次读取到的字节数组转为字符串
			System.out.print(str);//
		}
		
		fis.close();
	}
}
