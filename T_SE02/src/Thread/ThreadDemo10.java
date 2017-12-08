package Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep阻塞：
 * 		让当前线程进入阻塞状态。当阻塞状态结束后，当前线程会重新进入Runnable状态，等待分配时间片。
 * @author 全文超
 * 2015-09-04 19:19:58
 *
 */
public class ThreadDemo10 {
	public static void main(String[] args) {
		
		//实现一个电子表功能
		/*
		 * 每秒输出一下当前系统时间  -> 19:24:58
		 * 1.创建SimpleDateFormat，同时在构造方法中指定时间格式
		 * 2.创建当前系统使劲按所对应的Date对象
		 * 3.通过SimpleDateFormat的format()方法将Date转换为字符串
		 * 4.想实现电子表功能，就循环每间隔1秒执行一次2，3步骤
		 */
		
		//1
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(true){
		//2
		 Date now = new Date();
					
		//3
		String str = sdf.format(now);//将Date -> String
		System.out.println(str);
					
		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
