package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 用户每输入一句话，就将其写入到文件中
 * @author 全文超
 * 2016-07-28 14:18:58
 *
 */
public class PrintWriterDemo3 {
	public static void main(String[] args) throws IOException {
		
//		//是低级流，将内容写入到文件
//		FileOutputStream fos = new FileOutputStream("pw_user.txt");
//		
//		//是高级流，封装fos。 同时可以指定编码
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		
//		//是高级流，封装osw。同时具有自动行刷新功能
//		PrintWriter pw = new PrintWriter(osw, true);
		
		FileOutputStream fos = new FileOutputStream("pw_user.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		PrintWriter pw = new PrintWriter(osw, true);
		
		
		Scanner scan = new Scanner(System.in);
		String line = null;
		while(true){
			line = scan.nextLine();
			if("exit".equals(line)){
				System.out.println("程序退出！");
				break;
			}
			
			pw.println(line);//会自动调用flush
		}
		
		pw.close();
		
		
	}
}
