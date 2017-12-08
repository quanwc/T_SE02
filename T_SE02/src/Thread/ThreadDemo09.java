package Thread;
/**
 * 前台线程与后台线程
 * 
 * 后台线程，又叫守护线程，使用上与前台线程没有区别。
 * 不同点在于结束的时间：当进程中所有的前台线程都结束时，无论后台线程是否还在运行都要强制结束，并最终结束进程。
 * 
 * 进程结束：
 * 		当一个进程中的所有前台线程都结束了，进程也就结束了。所以并不是说main方法(前台线程)执行完毕进程一定结束。
 * @author 全文超
 * 2015-09-04 18:25:48
 *
 */
public class ThreadDemo09 {
	public static void main(String[] args) {
		
		/*
		 * rose  扮演者：前台线程
		 */
		Thread rose = new Thread(){

			@Override
			public void run() {
				for(int i=0; i<10; ++i){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose: 啊啊啊啊啊AAAAAaaaaa.....");
				System.out.println("音效：噗通！");
			}
		};
		
		
		/*
		 * jack  扮演者：后台线程
		 */
		Thread jack = new Thread(){
			@Override
			public void run() {
			while(true){
					System.out.println("jack: you jump, I jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		//设置后台线程的工作要在start()方法之前
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
		/**
		 * main线程是前台线程。它将rose，jack两个线程启动，自己的任务也就结束了，因此main线程就会结束。
		 * 所以说：并不是说main线程结束了，程序就结束了。
		 * eg：该程序中，main线程结束了，前台线程rose和后台线程jack都没有结束。我们应该说，所有的前台
		 * 线程结束了，后台线程
		 */
		System.out.println("main线程结束了！");
	}
}
