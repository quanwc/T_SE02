package Thread;
/**
 * 死锁的演示：
 * 
 * 死锁：两个线程都在等待对方释放锁，所处的一种"僵持"状态。
 * @author 全文超
 * 2016-09-05 15:09:41
 *
 */
public class DeadLockDemo {
	
	Object k1 = new Object();
	Object k2 = new Object();
	
	public void a(){
		synchronized(k1) {
			Thread t = Thread.currentThread();
			System.out.println(t + "正在调用a方法");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			
			b(); //t1线程只有执行完b方法才会释放k1			
		}
	}
	
	public void b(){
		synchronized(k2) {
			Thread t = Thread.currentThread();
			System.out.println(t + "正在调用b方法");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			
			a(); //t2线程只有执行完a方法才会释放k2	
		}
	}
	
	
	public static void main(String[] args) {
		
		final DeadLockDemo dld = new DeadLockDemo();
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				dld.a();
				System.out.println(getName() + "执行完毕了");
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				dld.b();
				System.out.println(getName() + "执行完毕了");
			}
		};
		
		t1.start();
		t2.start();
	}
}
