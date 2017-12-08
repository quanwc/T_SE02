package Thread;
/**
 * 测试线程的相关方法
 * @author 全文超
 * 2015-09-04 17:47:25
 *
 */
public class ThreadDemo07 {
	public static void main(String[] args) {
		
		//获取调用main()方法的线程
		Thread main = Thread.currentThread();
		
		System.out.println("id:" + main.getId());
		System.out.println("name:" + main.getName());
		System.out.println("priority:" + main.getPriority());
		System.out.println("state:" + main.getState());
		System.out.println("isAlive:" + main.isAlive());
		//测试线程是否处于活动状态
		
		System.out.println("isDaemon:" + main.isDaemon());
		System.out.println("isInterrupt:" + main.isInterrupted());
	}
}
