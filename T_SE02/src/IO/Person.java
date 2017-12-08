package IO;

import java.util.List;
import java.io.Serializable;

/**
 * 
 * 序列化的实现方式：
 * 		实现Serializable接口， 或实现Externalizable接口
 * 
 * 
 * 方式一：实现Serializable接口：
 * 
 * 每一个实例用于描述一个人的信息
 * Serializable  串行化==序列化
 * @author 全文超
 * 2015-09-01 17:43:16
 *
 */
public class Person implements Serializable{
	/**
	 * 对象流不会序列化static或 transient修饰的属性
	 */   
	private static final long serialVersionUID = 1L;//版本号，
	private String name;
	private static int ages;//不会被序列化
	private transient int photoNumber;
	private double money;
	private transient List<String> otherInfo;//不会被序列化
	
	
	public Person(String name, int age, int photoNumber, int salary, List<String> otherInfo) {
		super();
		this.name = name;
		this.ages = age;
		this.photoNumber = photoNumber;
		this.money = money;
		this.otherInfo = otherInfo;
	}
		
	
	@Override
	public String toString() {
		return name + ", " + ages + ", " + photoNumber +
				", " + money + ", " + otherInfo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static int getAges() {
		return ages;
	}


	public static void setAges(int ages) {
		Person.ages = ages;
	}


	public int getPhotoNumber() {
		return photoNumber;
	}


	public void setPhotoNumber(int photoNumber) {
		this.photoNumber = photoNumber;
	}





	public List<String> getOtherInfo() {
		return otherInfo;
	}


	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
