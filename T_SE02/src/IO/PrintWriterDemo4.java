package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 按行读取用户输入的内容
 * @author 全文超
 * 2016-07-28 15:17:57
 *
 */
public class PrintWriterDemo4 {
	public static void main(String[] args) throws IOException {
		
		InputStream in = System.in;//从按盘读，不再从文件读取内容
		
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		while(true){
			line = br.readLine();
			System.out.println(line);
		}
		
	}
}
