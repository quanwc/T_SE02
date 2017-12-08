package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 完整的异常操作
 * 使用异常捕获机制来完成复制文件的异常处理
 * @author 全文超
 * 2015-09-03 14:14:41
 *
 */
public class FileUtilsExceptionDemo {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			fis = new FileInputStream("ex2.dat");
			fos = new FileOutputStream("ex2_copy.dat");
			
			int d = -1;
			while( (d = fis.read()) != -1 ){
				fos.write(d);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		} catch(IOException e){
			System.out.println("读写初出了错");
		} catch(Exception e){
			System.out.println("出了个其它错");
		} finally{
			if(fis != null){
			try {
				fis.close();//关闭流的时候也会抛出错，我们不用对其予以处理。
			} catch (IOException e) {
			}
			
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
			}
		}
		
	}
}
