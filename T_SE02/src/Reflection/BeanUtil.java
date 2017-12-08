package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * javaBean的拷贝：
 * 
 * 该类是bean的拷贝工具
 * @author 全文超
 * 2016-08-09 08:03:34
 *
 */
public class BeanUtil {
	public static void copyProperties(Object source, Object target) throws Exception{
		//step1: 获取两个对象的类信息
		Class sourceType = source.getClass();
		Class targetType = target.getClass();
		
		//step2: 获取原对象的所有私有属性名称
		Field[] fields = sourceType.getDeclaredFields();
		for(Field f : fields){
			String fieldName = f.getName(); //获取属性名
			Field targetField = null;
			try {
				
				//在target目标对象中查找是否有该属性
				targetField = targetType.getDeclaredField(fieldName);
			} catch (SecurityException e) {
				break;
			} catch (NoSuchFieldException e) {
				continue; //没有找到该字段，直接进入下一次循环
			}
			
			//如果类型不一致，则返回
			if(f.getType() != targetField.getType()){
				return;
			}
			
			//step3: 构建该属性的get、set方法名
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + 
						fieldName.substring(1);
			String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + 
						fieldName.substring(1);
			
			//step4: 构造get、set方法的对象，并调用
			Method getMethod = sourceType.getMethod(getMethodName, new Class[]{});
			Method setMethod = targetType.getMethod(setMethodName, f.getType());
			
			//调用get方法获取原对象的属性值
			Object result = getMethod.invoke(source, new Object[]{});
			//调用set方法为目标对象赋值
			setMethod.invoke(target, result);
		
		}
	}
	

	
	
	/**
	 * 获取对象指定属性的值
	 */
	public static Object getFieldValue(Object obj, String fieldName) throws Exception{
		Class typeInfo = obj.getClass();
		Field field = typeInfo.getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(obj);
	}
	
	
	
	/**
	 * 为对象的指定属性赋值
	 */
	public static void setField(Object obj, String fieldName, Object value){
		
	}
	
	
	/**
	 * 调用对象的某方法并返回调用结果
	 */
	public static Object invokeMethod(Object obj, String methodName, Object[] params){
		return null;
	}
	
	
	
	public static boolean invokeNoReturnMethod(Object obj, String methodName, Object[] params){
		return false;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		//测试该拷贝类
		BeanBase obj1 = new BeanBase(1, "md", 79.5);
		BeanBase obj2 = new BeanBase();
		BeanUtil.copyProperties(obj1, obj2);
		
		System.out.println(obj2.getId() + ", " + obj2.getName() + ", " + obj2.getScore());
	}


}
