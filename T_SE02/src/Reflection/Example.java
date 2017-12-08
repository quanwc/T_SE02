package Reflection;
/**
 * java中的反射：
 * 
 * 	需求：
 * 		获取String类型的描述信息
 * 	实现：借助Class类型的对象
 * 		访问class属性、TYPE属性、引用的getClass()方法
 * 
 * 	Class类型：
 * 		称为类类型，用于存储类的描述信息。注入类名，接口，方法，构造器，属性等。
 * @author 全文超
 * 2016-07-30 08:50:13
 *
 */
public class Example {
	public static void main(String[] args) {
		
		//1.访问class属性
		//Class obj = String.class;
		
		//2.访问TYPE属性
		//Class obj = Integer.class; //只有int、float、double等数字类型才有TYPE属性
		
		//3.通过引用调用getClass()方法
		String str = "aaa";
		Class obj = str.getClass();

		System.out.println(obj.getName());
		System.out.println(obj.getSimpleName());
		System.out.println(obj.getSuperclass().getName());
		
		System.out.println("================");
		
		Class[] infos = obj.getInterfaces();//返回值：String实现了哪些接口，返回值是一个数组
		for(Class info : infos){
			System.out.println(info.getName());
		}
		
	}
}
