package Reflection;

import java.lang.reflect.Modifier;

/**
 * 需求：获取类的属性信息
 * 实现方式：借助Field类存储相关信息
 * @author 全文超
 * 2016-07-30 15:35:29
 *
 */
public class FieldDemo {
	public static void main(String[] args) throws Exception {
		
		//获取BaseClass类的类型信息
		Class typeInfo = BaseClass.class;
		
		/**
		 * getFields():
		 * 		获取所有public级别的属性
		 * getDeclaredFields():
		 * 		获取声明过的属性，即获取所有级别的属性
		 */
		java.lang.reflect.Field[] allField = typeInfo.getFields();
		java.lang.reflect.Field[]allField2 = typeInfo.getDeclaredFields();
		
		for(java.lang.reflect.Field f : allField){
			System.out.print("修饰符：" + Modifier.toString(f.getModifiers()) + ", ");
			System.out.print("属性的类型： " + f.getType().getName() + ", ");
			System.out.println("属性名： " + f.getName());
		}
		
		
		System.out.println("===========");
		
		
		
		/**
		 * 获取某一个具体的属性
		 * 	getField(String name)
		 */
		java.lang.reflect.Field fieldInfo = typeInfo.getDeclaredField("name");
		//fieldInfo: 代表了名字为name的属性
		
		BaseClass obj = new BaseClass(100, "zsf", 56, 78);
		fieldInfo.setAccessible(true);//允许访问私有属性
		Object value = fieldInfo.get(obj);  //属性.get(对象)：获取obj对象的"name"属性值
		System.out.println(value);
		
		
		
		/**
		 * 给对象的属性赋值：
		 * 		fieldInfo.set(obj, "张三丰")
		 * 		给name属性设置值，参数为obj对象，和具体的参数值
		 * 
		 * 	注：
		 * 		fieldInfo： 封装了name属性，肯定是给name属性设置值，而不是给其它属性设置值
		 * 		obj： 指定要给哪个对象的name属性设置值
		 * 		"张三丰"： 指定要设置的具体name值
		 * 
		 */
		fieldInfo.set(obj, "张三丰");
		System.out.println(fieldInfo.get(obj));
		
	}
}
