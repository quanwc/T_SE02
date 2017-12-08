package Reflection;

import java.lang.reflect.Constructor;

/**
 * 需求：
 * 		获取类的构造器信息
 * 实现：
 * 		使用Constructor的对象存储信息
 * @author 全文超
 * 2016-08-08 23:26:27
 *
 */
public class ConstructorDemo {
	public static void main(String[] args) throws Exception {
		
		Class typeInfo = BaseClass.class;
		Constructor[] allCons = typeInfo.getConstructors();

		//获取指定的构造器
		Constructor con = typeInfo.getConstructor(new Class[]{int.class, 
					String.class, double.class, double.class});
		
		//通过构造器创建对象
		BaseClass obj = (BaseClass)con.newInstance(
				new Integer(10), "tf", new Double(3.14), new Double(5.17));
		obj.printInfo();
	}
}
