package Reflection;
/**
 * 基础类：
 * 		具备完整的属性，构造器，方法
 * 
 * 获取类的信息都是以该类为基础，都是获取该类中的属性、方法、构造器
 * @author 全文超
 * 2016-07-30 15:39:29
 *
 */
public class BaseClass {
	int id;
	private String name;
	protected double score;
	public double grade;
	
	
	//构造器
	public BaseClass(){}
	
	public BaseClass(int id, String name, 
			double score, double grade){
		this.id = id;
		this.name = name;
		this.score = score;
		this.grade = grade;
	}
	
	
	//方法
	public void fun1(){
		System.out.println("fun1(), 无参，无返回值的方法");
	}
	
	public String fun2(String msg, int age){
		System.out.println("fun2(), 有参，又返回的方法");
		return this.name + msg;
	}
	
	public void printInfo(){
		System.out.println(this.id + ", " + this.name + ", " + this.score + ", " + this.grade);
	}
	
}
