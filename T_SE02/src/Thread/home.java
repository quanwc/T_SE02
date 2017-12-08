package Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编写计时程序，每隔5秒钟输出当前的日期-时间，主线程结束后计时完毕。
 * @author 全文超
 * 2015-09-09 11:35:28
 *
 */
public class home {
	public static void main(String[] args) {
		
		Thread t = new Thread(){
			public void run(){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				while(true){
					Date now = new Date();
					System.out.println(sdf.format(now));
					//将Date对象通过sdf转成字符串后输出
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t.setDaemon(true);
		t.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
