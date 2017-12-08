package Thread;
/**
 * 测试线程与synchronized的关系
 * @author 全文超
 * 2015-09-10 21:19:57
 * 
 */
public class SyncTest {
	public static void main(String[] args) {
		
		final Foo foo = new Foo();
		final Foo foo2 = new Foo();
		
		Thread t1 = new Thread(){
			public void run(){
				foo.methodA();
			}
		};
		
		
		Thread t2 = new Thread(){
			public void run(){
				foo.methodB();
			}
		};
		
		t1.start();
		t2.start();
	}
}	

class Foo{
	public synchronized void methodA(){
		String name = Thread.currentThread().getName();
		System.out.println(name + "调用了methodA()方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "调用methodA()方法结束");
	}
	
	public synchronized void methodB(){
		String name = Thread.currentThread().getName();
		System.out.println(name + "调用了methodB()方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "调用methodB()方法结束");
	}
}
