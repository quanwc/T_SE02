package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 	  主要解决两个问题：控制数量、保证重用
 * @author 全文超
 * 2015-09-10 09:09:24
 *
 */
public class ThreadPoolDemo01 {
	public static void main(String[] args) {
		
		//创建了一个含有2个线程的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<5; ++i){//启动5个任务
			Handle handle = new Handle();
			threadPool.execute(handle);//制定任务
			//线程池的execute方法需要传入一个Runnable实例。将我们的任务指派到线程池中去。
		}
		
		threadPool.shutdown(); //线程池执行完任务后结束
		//threadPool.shutdownNow(); //不管线程有没有执行任务，必须马上中断，马上停止
	}
}


class Handle implements Runnable{
	
	public void run(){
		
		//获取运行当前任务的线程名字
		String name = Thread.currentThread().getName();
		System.out.println(name + "正在执行任务");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println(name + "执行任务完毕");
	}
}