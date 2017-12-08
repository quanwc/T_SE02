package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 序列化和反序列化People对象
 * @author 全文超
 * 2016-04-13 21:12:34
 *
 */
public class PeopleExter {
	public static void main(String[] args) throws Exception {
		ser();//序列化
		System.out.println("===========");
		dser();//反序列化
	}
	
	
	public static void ser()throws Exception{
		
		People people = new People("hr", 28);
		OutputStream os = new FileOutputStream("External.txt");//文件输出流
		//将文件输出流 包装为 对象输出流
		ObjectOutputStream oos = new  ObjectOutputStream(os);
		
		oos.writeObject(people);//保存对象到文件，调用writeExternal方法

		oos.close();//关闭输出流
	}
	
	
	
	public static void dser()throws Exception{
 
        InputStream in = new FileInputStream("External.txt");// 文件输出流  
        ObjectInputStream ois = new ObjectInputStream(in); // 为对象输出流实例化  
       
        Object obj = ois.readObject(); // 读取对象 ，调用readExternal方法
        
        ois.close(); // 关闭输出  
        System.out.println(obj);  
	}
}
