package Reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 需求：通过反射实现简单工厂模式
 * 	         通过读取配置文件的信息动态创建对象
 * 
 * 实现步骤：
 * 		1.编写properties文件存储配置信息
 * 		2.编写产品接口
 * 		3.编写两个实现接口的类
 * 		4.编写简单工厂生产产品
 * 		5.编写测试类
 * @author 全文超
 * 2016-07-30 11:26:35
 *
 */


//产品接口
interface InterfaceBase{
	//int x = 3; 
	//接口中常量默认：public static final类型。static和final顺序可以互换，没有影响
	
	void fun1();//接口中方法默认：public abstract类型
	void fun2();
}


//第一个实现接口的类
class ClassA implements InterfaceBase{

	@Override
	public void fun1() {
		System.out.println("ClassA fun1()...");
	}

	@Override
	public void fun2() {
		System.out.println("ClassA fun2()...");
	}
	
}


//第二个实现接口的类
class ClassB implements InterfaceBase{

	@Override
	public void fun1() {
		System.out.println("ClassB fun1()...");
	}

	@Override
	public void fun2() {
		System.out.println("ClassB fun2()...");	
	}
	
}


//编写简单工厂类
class SimpleFactory{
	
	//读取配置文件的信息
	private static String getConfigInfo(){
		
		Properties p = new Properties();
		String typeName = "";
		
		try {
			p.load(new FileInputStream("reflection.properties"));//加载配置文件
			typeName = p.getProperty("appSet");//通过配置文件，读取工厂要创建的产品类型名
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		 
		return typeName;
	}
	
	
	//工厂方法，创建不同的产品，但产品有相同的规范
	public static InterfaceBase createProduce(){
		
		InterfaceBase obj = null;
		
		String typeName = null;

		try {
			typeName = SimpleFactory.getConfigInfo();
			obj = (InterfaceBase)Class.forName(typeName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}

//测试工厂类
public class SimpleFactory_Ref {
	public static void main(String[] args) {
		
		InterfaceBase obj = SimpleFactory.createProduce();
		obj.fun1();
		obj.fun2();
	}
}
