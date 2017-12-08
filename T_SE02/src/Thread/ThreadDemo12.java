package Thread;
/**
 * 线程中断
 * @author 全文超
 * 2015-09-06 19:00:02
 *
 */
public class ThreadDemo12 {
	public static void main(String[] args) {
		
		/*
		 * 林永健： 处于谁秒阻塞的线程
		 */
		final Thread lin = new Thread(){
			@Override
			public void run() {
				System.out.println("林:刚洗完澡，睡觉吧。");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					System.out.println("林：干嘛呢， 干嘛呢， 都破了相了。");
				}
				
			}
		};
		
		
		/*
		 * 黄宏：用于中断lin线程的线程
		 */
		Thread huang = new Thread(){
			
			@Override
			public void run() {
				System.out.println("黄：开始砸墙。");
				for(int i=0; i<10; i++){
					System.out.println("黄：80！");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("黄：搞定！");
				lin.interrupt();
			}
		};
		
		
		lin.start();
		huang.start();
	}
}
