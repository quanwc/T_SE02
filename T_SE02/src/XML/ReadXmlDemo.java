package XML;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**
 * 使用DOM解析xml文件
 * @author 全文超
 * 2015-09-14 11:19:47
 *
 */
public class ReadXmlDemo {
	public static void main(String[] args) {
		
		try {
			
			SAXReader reader = new SAXReader();//导入org.demo4j.*
			
			//有好几种解析方式:常用的有两种，传入文件，传入流
			File xmlFile = new File("emp.xml");
			
//			InputStream in = new FileInputStream("emp.xml");
//			Document doc = reader.read(in);
			
			
			
			
			
			/*
			 * 解析xml，返回对应的Document对象
			 * 该对象封装了xml文档中的所有内容
			 */
			Document doc = reader.read(xmlFile);//此处比较耗时
			
			Element root = doc.getRootElement();//返回值为list这个标签
			
			
			
			
			/*
			 * 获取根标签(根元素)下面的所有子标签(子元素)
			 * 此处：获取所有的emp标签
			 */
			List<Element> elements = root.elements();
			
			/*
			 * 当前标签 下所有名为emp的子标签
			 */
//			List<Element> elemetns = root.elements("emp");//返回所有指定名字的子标签
			
			
			//遍历所有的子标签emp
			for(Element element : elements){
				System.out.println("标签:" + element.getName());
				
				//获取emp标签中的id属性的值
				Attribute attribute = element.attribute("id");//得到id
				//获取该属性(id)的值,返回值为String，需要将其转成int类型，使用包装类
				int id = Integer.parseInt(attribute.getValue());
				System.out.println("员工id:" + id);
				
				
						
//				int id = Integer.parseInt(element.elementText("id"));
//				System.out.println("id=" + id);
				
				
				//获取emp标签中的name标签
				Element nameEle = element.element("name");
				/*
				 * 获取前标记与后标记之间的文本：
				 * 若：<name>张三</name>
				 * 		则nameEle描述的是name标签
				 * 		nameEle.getTet()方法获取的就是字符串"张三"
				 * 调用该方法应知道name标签中是文本信息
				 */
				String name = nameEle.getText();
				System.out.println("员工名字:" + name);
				
				
				/*
				 * 获取年龄
				 * 
				 * 我们希望获取emp标签中的子标签age中的文本
				 * 两种方式：
				 * 		1.先获取age标签，在获取其中的文本，这和上面获取name做法一致
				 * 		2.调用elementText(String name)方法
				 * 			eg:element.elementText("age");这种方式更简便
				 */
				int age = Integer.parseInt(element.elementText("age"));
				System.out.println("员工年龄:" + age);
				
				
				/*
				 * 解析性别
				 */
				String gender = element.elementText("gender");
				System.out.println("员工性别:" + gender);
				
				
				/*
				 * 解析工资
				 */
				int salary = Integer.parseInt(element.elementText("salary"));
				System.out.println("员工工资:" + salary);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
