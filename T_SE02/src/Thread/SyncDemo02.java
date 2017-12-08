package Thread;

/**
 * synchronized也叫互斥锁，即具有互斥效果。(有你没我，有我没你)
 * @author 全文超
 * 2015-09-06 20:26:55
 */
public class SyncDemo02 {
	public static void main(String[] args) {
		
		final Demo demo = new Demo();
		final Demo demo2 = new Demo();
		Thread t1 = new Thread(){
			
			@Override
			public void run() {
				demo.methodA();
			}
		};
		
		
		Thread t2 = new Thread(){
			
			@Override
			public void run() {
				demo.methodA();
			}
		};
		
		
		t1.start();
		t2.start();
	}
}


class Demo{
	
	public synchronized void methodA(){
		
		String name = Thread.currentThread().getName();//获得当前线程的名字
		System.out.println(name + "调用了methodA方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "调用methodA调用完毕");
	}
	
	
	public void methodB(){
		
		String name = Thread.currentThread().getName();//获得当前线程的名字
		System.out.println(name + "调用了methodB方法");
		try { 
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "调用methodB调用完毕");
	}
}