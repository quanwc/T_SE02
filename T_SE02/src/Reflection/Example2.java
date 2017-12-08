package Reflection;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 需求：
 * 		通过输入的字符串找到对应的类的信息
 * 实现方式：
 * 		借助Class的forName()方法
 * 
 * @author 全文超
 * 2016-07-30 10:29:58
 *
 */
public class Example2 {
	public static void main(String[] args) {
		
		try {
			
			Scanner input = new Scanner(System.in);
			String msg = input.next();
			
			//动态加载类
			Class info = Class.forName(msg);
			
			System.out.println(info.getName());
			System.out.println(info.getSimpleName());
			System.out.println(info.getSuperclass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
