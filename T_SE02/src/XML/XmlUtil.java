package XML;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 根据给定的xml文件名将该xml文件中的所有员工信息存入一个List集合中并返回
 * 将一个集合中的员工信息写入一个xml文件
 * @author 全文超
 * 2015-09-15 08:47:02
 *
 */
public class XmlUtil {
	public static List getAllEmp(String xmlFileName){
		
		List<Emp> list = new ArrayList<Emp>();
		
		try{
			/*
			 * 解析xml的步骤
			 * 1.创建按SAXReader
			 * 2.创建File对象来描述文件
			 * 3.使用SAXReader读取文件(解析的过程)，并返回Document对象，其封装了整棵树
			 * 4.通过Document对象获取根元素(根标签)
			 * 5.根据xml的结构获取不同节点以及对应的信息。
			 */

			//1.
			SAXReader reader = new SAXReader();
			//2.
			File file = new File(xmlFileName);
			//3.
			Document document = reader.read(file);//得到整棵树
			//4.
			Element root = document.getRootElement();//得到整棵树的根标签，相当于list标签
			//5.
			List<Element> elements = root.elements();
			
			//遍历每一个emp标签
			for(Element empEle : elements){
				//先获取id
				Attribute idAttr = empEle.attribute("id");
				int id = Integer.parseInt(idAttr.getValue());
				
				
				/*
				 * empEle.elementText("name")的作用：
				 * 获取empEle标签中名为name标签中的文本
				 */
				String name = empEle.elementText("name");
				int age = Integer.parseInt(empEle.elementText("age"));
				String gender = empEle.elementText("gender");				
				int salary = Integer.parseInt(empEle.elementText("salary"));
				
				//将解析出的一个用户信息存入一个Emp实例中，并放入集合
				Emp emp = new Emp(id, name, age, gender, salary);
				list.add(emp);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 使用DOM生成一个xml文件，即将给定集合中所有员工信息以xml形式写入给定文件中
	 * @param args
	 * @fileName
	 * 
	 * 
	 * 使用DOM写xml的原则：组织好整棵树
	 * 
	 */
	public static void writeXmlToFile(List<Emp> list, String fileName){
		
		try {
			/*
			 * 1.首先创建Document来描述整棵树
			 * 2.根据结构添加元素来组建树的结构
			 * 3.将树写入文件
			 */
			//1.
			Document doc = DocumentHelper.createDocument();//创建整棵树
			
			//2.
			/*
			 * Document的addElement(String name)方法用于添加根元素。
			 * 返回值为Element表示添加的这个根元素
			 * 
			 * Document的addElement方法只能调一次，因为根只有一个。第二次调该方法会抛异常
			 */
			Element root = doc.addElement("list");//root就是list这个标签
			
			//循环list集合。因为集合中存放的就是员工实例，有多少个员工，就添加多少个
			for(Emp emp : list){
				//向根元素中添加子元素emp
				Element empEle = root.addElement("emp");//返回emp这个标签
				
				/*
				 * Element的方法：
				 * addAttribute(String name, String value)用于向当前元素中追加属性
				 * 该方法的返回值还是当前这个标签(返回值e就是empEle标签)，调谁的addAttribute方法返回的还是谁。
				 * 为了能够连续添加，与StringBuilder很相似
				 */
				Element e = empEle.addAttribute("id", emp.getId()+"");
				
				//向emp中追加子元素name
				Element nameFile = empEle.addElement("name");
				
				/*
				 * Element的方法addText(String str)：用于向当前元素中追加文本信息(前后标记之间)
				 * <name>addText追加的文本</name>
				 * 
				 */
				nameFile.addText(emp.getName());//在name的标签中添加文本
				
				//追加年龄元素
				empEle.addElement("age").addText(emp.getAge()+"");
				
				//追加性别元素
				empEle.addElement("gender").addText(emp.getGender());
				
				//追加工资元素
				empEle.addElement("salary").addText(emp.getSalary()+"");
				
			}
			
			//3.
			FileOutputStream fos = new FileOutputStream(fileName);
			
			/*
			 * XMLWriter是一个高级流，该流可以简化我们写出繁琐的XML数据结构
			 */
			
			//XMLWriter xmlWriter = new XMLWriter(fos);//构造的同时传入输出流
			XMLWriter xmlWriter = new XMLWriter();
			xmlWriter.setOutputStream(fos);//构造方法里没有传入输出流，但也可以设置
			
			xmlWriter.write(doc);//将整棵树传入，会将整棵树写入到文件中
			
			xmlWriter.close();//写完后要记得关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	/**
	 * 测试XPath
	 * @param args
	 */
	public static void testXPath(){
		
		try {
			SAXReader reader = new SAXReader();
			File file = new File("book.xml");
			Document doc = reader.read(file);
			
			/*
			 * List selectNodes(String xpath)
			 * Demo4j的Document对xPath的支持，在该方法的参数地方就可以写路径表达式
			 */
			List list = doc.selectNodes("/bookstore/book/price");//默认检索出所有的
			System.out.println("检索出了:" + list.size() + "项");
			//类没有找到，此时要导入jaxen-1.1.jar这个jar包
			for(Object o : list){
				Element element = (Element)o;
				System.out.println(element.getText());//获取元素中间的文本
				//System.out.println(o);
			}
			
			System.out.println("======");
			
			List list2 = doc.selectNodes("//@lang");//@:属性， //：所有
			//默认得到的是所有属性，
			//eg: "/bookstore/book/title/@lang"， 得到特定的属性
			System.out.println("检索出了:" + list2.size() + "个属性");
			for(Object o : list2){
				Attribute attr = (Attribute)o;
				System.out.println(attr.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
//		List<Emp> list = getAllEmp("emp.xml");
//		for(Emp emp : list){
//			System.out.println(emp);
//		}
		
		
//		List<Emp> list = new ArrayList<Emp>();
//		list.add(new Emp(1, "zs", 12, "男", 500));
//		list.add(new Emp(2, "ls", 43, "女", 1520));
//		list.add(new Emp(3, "wmz", 52, "女", 5350));
//		list.add(new Emp(4, "wex", 18, "男", 2300));
//		
//		writeXmlToFile(list, "emp_copy.xml");
		//写出来是一行：ctrl+shift+f，之后就是树状结构了。
		
		testXPath();
	}
	
}
