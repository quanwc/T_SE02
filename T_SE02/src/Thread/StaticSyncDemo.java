package Thread;
/**
 * 静态方法锁：
 * 		锁的是类对象
 * @author 全文超
 * 2015-09-09 10:21:25
 *
 */
public class StaticSyncDemo {
	public static void main(String[] args) {
		
		final StaticDemo sd = new StaticDemo();
		final StaticDemo sd2 = new StaticDemo();
		
		Thread t1 = new Thread(){
			
			@Override
			public void run(){
				sd.methodB();
			}
		};
		
		
		Thread t2 = new Thread(){
			
			@Override
			public void run(){
				
				//非静态方法上锁后，不同对象之间没有同步效果。
				//静态方法上锁之后，同步是跨对象的，即不同对象之间是同步的。
				sd2.methodB();
			}
		};
		
		
		t1.start();
		t2.start();
	}
}


class StaticDemo{
	
	public void methodA(){
		String name = Thread.currentThread().getName();
		System.out.println(name + "调用了methodA()方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(name + "调用methodA()方法结束");
	}
	
	
	public synchronized static void methodB(){
		String name = Thread.currentThread().getName();
		System.out.println(name + "调用了methodB()静态方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(name + "调用methodB()静态方法结束");
	}
	
}