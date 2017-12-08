package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter：  
 * 		字符输出流，字符流 -> 字节流
 * 使用该流的目的：按照指定的字符集写出字符串
 * 
 * 使用字符输出流向文件中写出字符串
 * @author 全文超
 * 2015-09-01 20:06:26
 *
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException{
		
		FileOutputStream fos = new FileOutputStream("osw.txt");
		
		/*
		 * 不指定字符集，字符输出流使用系统默认字符集
		 */
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		//按照指定的字符集写出字符串
		
		
		/*
		 * fos.write("helloworld".getBytes("utf-8"));
		 * fos.write("大家好!".getBytes("utf-8"));
		 * 
		 * 这样写每次都要指定编码格式，比较麻烦，所有我们使用OutputStreamWriter，在其构造方法中传入编码格式
		*/

		osw.write("我爱北京天安门");
		osw.write("天安门上太阳升");
		osw.write("伟大领袖毛主席");
		osw.write("指引我们向前进");
		
		osw.close();
	}
}
