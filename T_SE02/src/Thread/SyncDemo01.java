package Thread;
/**
 * 线程安全问题:
 * 		解决办法：synchronized锁
 * @author 全文超
 * 2015-09-06 19:59:55
 *
 */
public class SyncDemo01 {
	public static void main(String[] args) {
		
		final Table table = new Table();
		
//		t1.getBean();在线程的run方法里面调用此方法
		
		Thread t1 = new Thread(){
			
			@Override
			public void run() {
				while(true){
					System.out.println(getName() + ":" + table.getBean());
				}
			}
		};
		
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				while(true){
					System.out.println(getName() + ":" + table.getBean());
				}
			}
		};
		
		
		t1.start();
		t2.start();
	}
}


class Table{
	
	private int beans = 20;
	
	public int getBean(){//解决办法：synchronized锁
		synchronized(this){
		if(beans == 0){
			throw new RuntimeException("没有豆子了。");
		}
 
		Thread.yield();//放弃当前cpu使时间片，此在只是为了线程并发安全问题出现的机会
		
		return beans--;
		}
	}
}