package Exception;
/**
 * getCause方法
 * @author 全文超
 * 2015-09-03 16:12:08
 */
public class ExceptionAPIDemo02 {
	public static void main(String[] args) {
		
		try {
			dosome("ab");
		} catch (RuntimeException e) {
//			System.out.println(e);
			e.getCause() ;//获取真实的异常:NumberFormatException
//			e.printStackTrace();//获取的是包装后的异常：RuntimeException
		}
	}
	
	public static void dosome(String str){
		try {
			System.out.println(Integer.parseInt(str));
		} catch (NumberFormatException e) {//真实的错误是NumberFormatException
			throw new RuntimeException(e);
			//抛出更高级的错误。即就是把真实的错误包装后抛出。
		}
	}
}
