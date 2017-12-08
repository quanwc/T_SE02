package Exception;

import java.io.FileInputStream;

/**
 * java的异常分为两类：
 * 检查异常：
 * 		程序抛出一个检查异常。
 * 		编译器会检查是否有处理异常的代码片段，没有则编译不通过。
 * 非检查异常：
 * 		当程序抛出该类异常时，编译器忽略检查。
 * 		RuntimeException属于非检查异常。即就是运行期异常(RuntimeException)可忽略不管。
 * @author 全文超
 * 2015-09-03 14:50:13
 *
 */
public class RuntimeExceptionDemo {
	public static void main(String[] args) {
		
		String str = null;
		if(str == null){
			throw new NullPointerException();
		}
		
		
		/*
		 * parseInt方法抛出NumberFormatException。
		 * 该异常时继承自RuntimeException的，所以它是非检查异常(运行期异常)，
		 * 编译时会忽略检查 是否处理该异常。
		 */
		String str2 = "aa";
		int i = Integer.parseInt(str2);
		
		
		
		
		
		/*
		 * 这里编译时不通过的，因为FileInputStream的构造方法抛出FileNotFoundException，
		 * 而该异常是一个检查异常。那么编译器在编译时会检查该异常是否得到了处理，如果没有处理则编译不通过。 
		 */
//		FileInputStream fis = new FileInputStream("ex3.dat");
		
	}
}
