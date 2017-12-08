package Exception;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * finally块：
 * 		无条件执行，无论程序是否出错都要执行。
 * 		通常程序的收尾工作放在这里。
 * @author 全文超
 * 2015-09-02 17:33:02
 *
 */
public class ExceptionDemo02 {
	public static void main(String[] args) {
		
		PrintWriter pw = null;
		
		System.out.println("程序开始了");
		try {
			 
			pw= new PrintWriter("ex.txt");
			pw.print("你好!");
			pw.print("".charAt(0));
			pw.print("再见");
		} catch (FileNotFoundException e) {
			System.out.println("文件按创建不成功");
		}catch(Exception e){
			System.out.println("出了个错");
		}finally{
			if(pw!=null){//又可能pw创建不成功，为null
				System.out.println("流关闭了");
				pw.close();
			}
		}
		
		System.out.println("程序结束");
	}
}
