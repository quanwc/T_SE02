package Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 转换线程安全的集合和Map:
 * Collections提供了很多的静态方法，允许我们将现有的集合或Map转换为线程安全的。
 * @author 全文超
 * 2015-09-09 16:52:03
 *
 */
public class SyncCollectionMapDemo {
	public static void main(String[] args) {
		
		//List集合
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//转换为线程安全的List集合。
		list = Collections.synchronizedList(list);//返回的集合是安全的。
		/*
		 * 能保证：
		 * 		对集合元素进行操作的方法都是同步且互斥的。保证了线程安全。
		 * 注意：
		 * 		集合在遍历的过程中，依然可以增删元素。
		 * 		与之前集合遍历矛盾，之前的集合遍历的时候不能增删元素。
		 * 		不足之处是没有将遍历的过程也给锁上，一个线程在遍历的时候，另一个线程却可以增删元素。
		 * 解决办法：
		 * 		对遍历的代码片段加锁，锁的是集合这个对象。
		 */
		System.out.println(list);
		synchronized(list){
			Iterator<String> it = list.iterator();
			while(it.hasNext()){
				System.out.print(it.next());
			}
		}
		System.out.println();
		
		
		
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("a");
		set.add("a");
		
		//将set集合转换为线程安全的。
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("zs", 22);
		
		//将map转换为一个线程安全的。
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
	}
}
