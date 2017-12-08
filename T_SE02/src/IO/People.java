package IO;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
/**
 * 
 * 实现序列化：
 * 	方式二：实现Externalizable接口
 * 
 * 	Externalizable接口继承了Serializable接口
 * @author 全文超
 * 2016-04-13 21:03:03
 *
 */

public class People implements Externalizable {

	
	private String name;
	private int age;
	
	/**
	 * 必须定义无参构造:
	 * 		因为在反序列化时会默认调用无参构造实例化对象，如果没有此无参构造，
	 *  则运行时将会出现异常
	 */
	public People(){
		
	}
	
	
	public People(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	
	/**
	 * 序列化是时候调用该方法，需要传入ObjectOutput接口类型的对象
	 * 
	 * 该方法作用：
	 * 		定义那些属性可以序列化，那些不能序列化。
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name);//保存姓名属性
		System.out.println("111");
		out.writeInt(this.age);//保存年龄属性
	}

	
	/**
	 * 反序列化时候调用该方法，需要传入ObjectInput接口类型的对象
	 * 
	 * 根据需要读取内容
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
	   this.name = (String)in.readObject() ; // 读取姓名属性  
       this.age = in.readInt();// 读取年龄 
       System.out.println("222");
	}
	
	
	@Override
	public String toString(){
		return name + ", " + age;
	}

}
