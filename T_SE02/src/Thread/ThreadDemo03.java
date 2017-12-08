package Thread;
/**
 * 使用匿名内部类的方式创建线程
 * @author 全文超
 * 2015-09-04 11:38:15
 *
 */
public class ThreadDemo03 {
	public static void main(String[] args) {
		
		//1.继承Thread
		Thread t1 = new Thread(){
			
			@Override
			public void run() {
				for(int i=0; i<100; i++){
					System.out.println("你是谁啊。");
				}
			}
		};
		
		
		//2.使用Runnable接口
		Runnable r1 = new Runnable(){
			public void run() {
				for(int i=0; i<100; i++){
					System.out.println("我是修水表的。");
				}
			}
		};
		
		Thread t2 = new Thread(r1);
		
		t1.start();
		t2.start();
	}
}
