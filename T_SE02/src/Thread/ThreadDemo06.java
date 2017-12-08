package Thread;
/**
 * 获取当前代码片段的线程
 * @author 全文超
 * 2015-09-04 17:25:56
 *
 */
public class ThreadDemo06 {
	public static void main(String[] args) {
		
		/*
		 * 当启动程序的时候，OS会启动一个进程来运行JVM，
		 * 而JVM启动后会创建一个线程来运行main()方法
		 */
		
		//这里获取的就是运行main()方法的线程
		Thread t = Thread.currentThread();
		System.out.println("运行main()的线程:" + t);
		//运行main()的线程:Thread[main,5,main]
	
		
		//在main中调用
		testCurrent();
		
		//创建一个线程
		Thread t1 = new Thread(){
			
			public void run(){
				System.out.println("运行t1的线程:" + Thread.currentThread());
				//运行t1的线程:Thread[Thread-0,5,main]
			
				//在线程中调用
				testCurrent();
			}
		};
		t1.start();
	}
	
	
	
	/*
	 * 输出调用当前方法的线程
	 */
	public static void testCurrent(){
		System.out.println("运行testCurrent方法的线程:" + Thread.currentThread());
	}
}
