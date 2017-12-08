package Thread;
/**
 * 线程优先级
 * 线程优先级有10个级别: 1-10。
 * 1最小： 对应常量 MIN_PRIORITY
 * 10最大：对应常量MAX_PRIORITY
 * 5为默认的优先级，也有常量对应NORM_PRIORITY
 * 理论上优先级越高的线程获取时间片的次数越多
 * @author 全文超
 * 2015-09-04 18:16:57
 *
 */
public class ThreadDemo08 {
	public static void main(String[] args) {
		
		Thread min = new Thread(){
			
			@Override
			public void run() {
				for(int i=0; i<1000; ++i){
					System.out.println("min");
				}
			}
		};
		
		
		Thread nor = new Thread(){
			
			@Override
			public void run() {
				for(int i=0; i<1000; ++i){
					System.out.println("nor");
				}
			}
		};
		
		
		Thread max = new Thread(){
			
			@Override
			public void run() {
				for(int i=0; i<1000; i++){
					System.out.println("max");
				}
			}
		};
		
		
		//设置线程优先级
		min.setPriority(Thread.MIN_PRIORITY);
		nor.setPriority(Thread.NORM_PRIORITY);//默认优先级是5，可以不用设置
		max.setPriority(Thread.MAX_PRIORITY);
		
		min.start();
		nor.start();
		max.start();
	}
}
