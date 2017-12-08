
package IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲输出流的缓冲区问题
 * @author 全文超
 * 2015-09-01 11:42:32
 *
 */
public class BufferedDemo02 {
	public static void main(String[] args) throws IOException{
		
		FileOutputStream fos = new FileOutputStream("bos.txt", true);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String str = "hello";
		bos.write(str.getBytes("utf-8"));
	
		
//		bos.close();
		/*
		 * 使用Buffer如果没有关闭，则文件里没有内容写入。
		 * 若关闭了，才会有内容写入。
		 * 为了避免这种问题，我们调用flush()方法
		 */
		
		/*
		 * flush()方法：
		 * 		一般情况：缓冲区里存满了才让fos一次写出到文件。就像bos把车子装满了才让fis把车子里的砖块拉到工地去。
		 * 		强制将缓冲输出流里面的缓冲区中的所有数据一次性写出。
		 * 		频繁调用该方法会提高写出次数从而降低写出的效率。
		 */
		bos.flush();
		
		bos.close();
		//close()方法内封装了flush()方法，缓冲流的close()方法会自动调用flush。
		//在close()关闭的时候，先flush一下，把自己手中的内容写出去，再close。
	}
} 
