package IO;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件字节输出流向文件中写出数据
 * @author 全文超
 * 2015-09-01 09:03:48
 *
 */
public class FileDemo01 {
	public static void main(String[] args) throws IOException {
		
	/*
		//1.
		FileOutputStream fos = new FileOutputStream("data.dat");
		//2.
		File file = new File("data.dat");
		FileOutputStream fos2 = new FileOutputStream(file);	
		//以上两种构造方法的效果相同。如果之前已经创建过文件，第2种方式简单，如果没有创建过，第1种方式简单。
	*/	
		
		 FileOutputStream fos = new FileOutputStream("data.txt");//路径不存在，就会创建data.txt文件
		 
		 String str = "我爱 苍老师";
		 fos.write(97);
		 fos.write(str.getBytes("utf-8"));//
		 fos.close();//流使用完了要记得关闭。就像打完电话要挂电话一样。
		 
		 
		 
		 /*
		  * 使用FOS写出内容时，它会首先将原文件的全部内容清除。
		  * 如果不想被清除，继续在原文件中进行写操作，可在其构造方法中做修改
		  * 	FileOutputStream(File file, boolean append)
		  * 	FileOutputStream(String path, boolean append)
		  *     若第二个参数为true，则是追加操作。
		  */
		 
	}
}
