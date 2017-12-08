package Exception;
/**
 * printStackTrace方法和getMessage()方法
 * @author 全文超
 * 2015-09-03 15:39:34
 *
 */
public class ExceptionAPIDemo01 {
	public static void main(String[] args) {
		
		try {
			Integer.parseInt("a");
		} catch (NumberFormatException e) {
			
			String str = e.getMessage();//出错的相关信息，返回一个字符串
			System.out.println(str);
			
			
			e.printStackTrace();//输出错误的堆栈信息，用来检查程序在哪出现了问题
		}
		
	}
}
