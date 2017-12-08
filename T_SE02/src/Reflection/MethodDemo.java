package Reflection;
/**
 * 需求：
 * 		获取类的方法信息
 * 实现：
 * 		使用Method对象进行封装
 * @author 全文超
 * 2016-08-08 22:08:45
 *
 */
public class MethodDemo {
	public static void main(String[] args) throws Exception {
		
		Class typeInfo = Class.forName("Reflection.BaseClass");
		
		//获取类中的所有方法信息
		java.lang.reflect.Method[] allMethods = typeInfo.getDeclaredMethods();
		for(java.lang.reflect.Method m : allMethods){
			System.out.print("返回值: " + m.getReturnType().getName() + ", ");
			System.out.print("方法名: " + m.getName() + ", ");
			System.out.print("参数类型: " );
			Class[] pTypes = m.getParameterTypes(); //方法参数有多个
			for(Class t : pTypes){
				System.out.print(t.getName());
			}
			
			System.out.println("\n");
		}
		
		
		System.out.println("===========");
		
		//获取类中的某个指定方法
		java.lang.reflect.Method m = 
				typeInfo.getDeclaredMethod("fun1", new Class[]{});
		BaseClass o = new BaseClass();
		Object result = m.invoke(o, new Object[]{});//调用fun1方法
		System.out.println(result); //输出该方法的返回值
		
		java.lang.reflect.Method m2 = 
				typeInfo.getDeclaredMethod("fun2", 
						new Class[]{String.class, int.class}); //第二个参数是：参数类型
		Object result2 = m2.invoke(o, new Object[]{"hh", 10});
		System.out.println(result2);
	}
}
