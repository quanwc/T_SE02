package Thread;

import java.awt.Frame;

/**
 * 第二种创建线程的方式
 * 实现Runnable接口，来单独定义线程任务。
 * @author 全文超
 * 2015-09-04 11:16:37
 *
 */
public class ThreadDemo02 {
	public static void main(String[] args) {
		
		MyRunnable1 r1 = new MyRunnable1();
		MyRunnable2 r2 = new MyRunnable2();
		
		Thread t1 = new Thread(r1); //线程和任务之间没有必然的耦合关系
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}


class MyRunnable1 implements Runnable{
	
	@Override
	public void run() {
		for(int i=0; i<100; ++i){
			System.out.println("你是谁啊。");
		}
	}
}


class MyRunnable2 implements Runnable{
	
	@Override
	public void run() {
		for(int i=0; i<100; ++i){
			System.out.println("我是修水表的。");
		}
	}
}