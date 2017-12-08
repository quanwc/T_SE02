package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用ObjectOutputStream将对象写入文件
 * 
 * 对象输出流：
 * 		ObjectOutputStream，将java中的对象转化为一组字节。
 * 
 * 序列化：
 * 		从数据结构转化为字节的过程，称为序列化 。也可以理解为我们常说的编码。
 * 
 * 对象序列化：
 * 		将java中的对象转换为字节的过程，称为对象序列化。
 * 持久化：
 * 		把内存上的数据写入磁盘中做长久保存的过程称之为持久化。 
 * 		FileOutputStream流就是做持久化的，将字节写入到硬盘
 * 		//内存是纯电路，断电数据就没了。
 * @author 全文超
 * 2015-09-01 17:47:50
 *
 */
public class PersonSerializable {
	public static void main(String[] args) throws IOException {
		
		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("其他信息1");
		otherInfo.add("其他信息2");
		otherInfo.add("其他信息");
		
		
		Person person = new Person("zs", 22, 110, 1, otherInfo);
		//1:男    0:女
		System.out.println(person);
		
		
		/*
		 * 将Person序列化后写入文件中
		 * 1.向文件中写数据的流： FileOutputStream
		 * 2.将对象序列化的流：     ObjectOutputStream
		 */
		
		//他们两者相互配合
		//负责持久化：将字节写入硬盘
		FileOutputStream fos = new FileOutputStream("person.obj");
		//负责序列化：将对象转换为字节
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * 该方法的作用:
		 * 		将给定的对象序列化后写出
		 * 将数据写入磁盘的过程称之为：持久化
		 */
		oos.writeObject(person);
		System.out.println("对象序列化完毕！");
		
		oos.close();
	}
}
