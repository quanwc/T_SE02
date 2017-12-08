package XML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 李科：使用DOM解析xml文件
 * @author 全文超
 * 2016-05-13 20:09:55
 *
 */
public class MemcacheLiHao {
	
	public static List getAllMemcache() throws Exception{
		
		List<Memcache> list = new ArrayList<Memcache>();
		
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		//输入流读取xml文件
		InputStream in = new FileInputStream("memcache.xml");
		
		Document doc = reader.read(in);//解析读取xml，返回对应的Document对象
		
		Element root = doc.getRootElement();//获取根标签：memcaches
		
		//获取memcaches标签下面所有名为memcache的标签
		List<Element> elements = root.elements();
		
		//循环遍历所有的子标签memcache
		for(Element element : elements){
			
			//System.out.println("标签：" + element.getName());//获取标签名memcache
			
			//获取memcache标签中的type属性
			Attribute attr = element.attribute("type");
			String type = attr.getValue();
			//System.out.println("type:" + type);
			
			//获取memcache标签中ip标签
			Element nameEle = element.element("ip");
			String ip = nameEle.getText();
			//System.out.println("ip:" + ip);
			
			//获取memcache标签中prefix标签
			String prefix = element.element("prefix").getText();
			//System.out.println("prefix:" + prefix);
			
			Memcache mem = new Memcache(type, ip, prefix);
			list.add(mem);
			//System.out.println();
			
		}
		
		return list;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		List<Memcache> list = getAllMemcache();  //返回集合
		for(Memcache m : list){  //遍历
			System.out.println(m);
		}
	}
}
