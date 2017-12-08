package Exception;
/**
 * finally中写return
 * @author 全文超
 * 2016-09-04 15:00:40
 *
 */
public class ExceptionReutrn {
	public static void main(String[] args) {
		System.out.println(test("0"));  //3
		System.out.println(test("null")); //3
		System.out.println(test(""));  //3
	}
	
	
	public static int test(String str){
		try {
			return str.charAt(0) - '0';
		} catch (NullPointerException e) {
			return 1;
		} catch(Exception e){
			return 2;
		} finally{
			return 3;
		}
	}
	
}
