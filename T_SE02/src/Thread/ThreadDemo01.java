package Thread;

import java.io.FileInputStream;

/**
 * 测试第一种创建线程的方式
 * 直接继承Thread并重写run()方法
 * @author 全文超
 * 2015-09-04 10:36:29
 *
 */
public class ThreadDemo01 {
	public static void main(String[] args) {
		
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		
		/**
		 * 启动线程要调用start方法，而不是run方法！
		 * 原因：start方法启动后，该线程纳入线程调度，会被分配时间片运行。一旦获取了时间片，
		 * 	         该线程的run方法会被调用。
		 */
		t1.start();
		t2.start();
	}
}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
			
	    for (int i=0; i<100; i++) {			
		    System.out.println("你是谁啊。");
	    }	
	}
}


class MyThread2 extends Thread{
	
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("我是修水表的。");
			
		}
	}
} 