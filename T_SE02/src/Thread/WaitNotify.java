package Thread;
/**
 * wait()和notify()方法
 * 这两个方法是定义在Object上的，也就是说所有的对象都有这两个方法。
 * 
 * 	当一个线程调用一个对象的wait方法后，该线程进入阻塞状态，直到这个对象的notify方法被调用，
 * 当前线程才可以解除阻塞。这样的好处是在协调两个两个线程工作的时候更加灵活。
 * 
 * 注：调用哪个对象的wait和notify方法，就因该把哪个对象作为锁对象 锁上，这是java中API规定的。
 * @author 全文超
 * 2015-09-09 12:19:38
 *
 */
public class WaitNotify {
	
	//标识测试wait、notify
	private static Object obj = new Object();
	
	//图片是否下载完毕
	private static boolean isFinish = false;
	  
	public static void main(String[] args) {

		 final Thread download = new Thread(){

			public void run(){
				System.out.println("download:图片下载开始。");
				for(int i=0; i<100; i++){
					System.out.println("download:" + i + "%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("图片下载完毕");
				isFinish = true;
				
				/**
				 * 当图片下载完毕就应当通知显示图片的线程开始显示图片
				 */
				synchronized (obj) {					
					obj.notify();
				}
			
				System.out.println("下载附件开始：");
				for(int i=1; i<101; ++i){
					System.out.println("download:已完成" + i + "%");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download：下载附件完毕！");
			}
		};
		
		
		//用于显示图片
		Thread show = new Thread(){
			
			@Override
			public void run(){
				System.out.println("显示图片：");
				
//				//这里应当等待download线程工作完毕
//				try {
//					download.join();//多线程中也可以实现同步，这需要我们实现一些操作。
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				
				try {
					synchronized (obj) {
						obj.wait();
					}
				} catch (InterruptedException e) {
				}
				
				if(!isFinish){
					
					System.out.println("显示图片失败。");
				}else{
					System.out.println("显示图片成功。");
				}
			}
		};
		
		
		download.start();
		show.start();
	}
}
