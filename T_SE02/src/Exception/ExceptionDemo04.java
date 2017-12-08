package Exception;
/**
 * 
 * @author 全文超
 *
 */
public class ExceptionDemo04 {
	 public static void main(String[] args) {
		
		 try{
			 //若出错，异常会跑到方法外面去。但在抛出之前，得先执行finally的内容。
		 }finally{
			 //无论是否出错，这里都要执行。
		 }
	}
}
