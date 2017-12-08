package Exception;
/**
 * 使用try-catch捕获并解决异常
 * @author 全文超
 * 2015-09-02 16:15:13
 *
 *
 */
public class ExceptionDemo01 {
	public static void main(String[] args) throws Exception{
		
		System.out.println("程序开始...");
		
		try {
			
//			String str = null;
			String str = "a";//这也是一个字符串，只不过里面一个内容都没有。
							//内容为空，长度为0，与null不同，不会产生异常。
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
			//将对应的字符串转换为整数。前提要求：该字符串必须是数字类型的字符串
			
			/*
			 * 当上面的代码出现异常后，程序跳入catch，try语句中剩下的代码均不会被执行。
			 */
			System.out.println("其他代码...");
			
		} catch (NullPointerException e) {
			System.out.println("出现了空指针异常");
	
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("程序下标越界了。");
		
		}catch(Exception e){//在最后一个catch，要捕获最大的异常。
							//以防止出现了一个我们未捕获的异常而导致程序的中断。
			System.out.println("反正就是出了");
		}
		
		/*
		 * jvm:
		 * 1.当运行到str.length()时发现str是null
		 * 2.jvm实例化了一个NullPointerException的实例
		 * 3.将程序执行过程中的详细信息设置到该异常实例中
		 * 4.将其在str.length()这个位置抛出该异常实例
		 * 5.查看出错的地方str.length()是否被try语句包含
		 * 6.若没有被try语句包含，jvm会将该异常向str.length()所在的方法之外抛出。
		 * 	  若抛出到main()方法之外，那么该程序被终止。
		 * 7.若被try语句包含，顺序调用try下面的catch，查看那个catch可以捕获该异常。
		 * 	  若有则进入catch内部来执行处理代码片段，否则和第6步相同。
		 * 
		 * 注：抛出的异常要能被catch捕获，catch类型要能接收异常的类型。
		 * 	     即catch的类型要能与异常的类型匹配上，其类型不能比异常的类型小。
		 */
		
		System.out.println("程序结束...");
	}
}
