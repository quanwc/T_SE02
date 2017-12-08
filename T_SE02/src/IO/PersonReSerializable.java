package IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 实现对象的反序列化
 * 	ObjectInputStream：
 * 		将一组字节转换为对应的java对象，也称为对象的反序列化。
 * @author 全文超
 * 2015-09-01 18:33:09
 *
 */
public class PersonReSerializable {
	public static void main(String[] args) throws Exception{
		
		/*
		 * 从文件中读取字节数据，再转换为对象
		 * 1.通过FIS读取文件
		 * 2.通过OIS反序列化
		 */
		FileInputStream fis = new FileInputStream("person.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		
		/**
		 * 该方法会读取一组字节并将其转换为对应的对象，这个操作就是对象的反序列化。
		 * 
		 * 1.在反序列化时，会检前后类的版本是否一致。若不一致，
		 * 	则会抛出异常，反序列化失败！
		 * 
		 * 2.若版本号没变，但是类定义发生了改变，那么采用兼容模式。
		 * 	兼容模式：
		 * 		原来对象有的属性，现在还有的就还原
		 * 		原来对象有的属性，现在没有的就忽略
		 * 		原来对象没有的属性，现在有的则使用默认值。
		 */
		Person person = (Person)ois.readObject();//反序列化的方法
		
		System.out.println(person.toString());
		
		
		ois.close();
	}
}
