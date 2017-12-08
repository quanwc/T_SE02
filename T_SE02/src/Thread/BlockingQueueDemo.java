package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 双缓冲队列：
 * 			一个线程进行存操作，一个线程进行取操作。
 * @author 全文超
 * 2015-09-10 10:10:24
 *
 */
public class BlockingQueueDemo {
	public static void main(String[] args) {
	
	/*
	 * 双缓冲队列，需要传入一个参数，表示队列的长度。
	 * 该队列是单向的，遵循先进先出原则。	
	 */
	final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	
	/*
	 * 双缓冲双端队列，与单队列的区别在于，双缓冲双端队列两段都可以进出队列
	 */
	BlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>(10);
	
	
	
	
	//向队列中添加元素的线程
	Thread offerThread = new Thread(){
		public void run(){
			
			for(int i=0; i<20; i++){
				//添加成功返回true
//				boolean tf =  queue.offer(i);
				
				boolean tf = false;//局部变量使用前必须初始化。
								   //成员变量使用之前可以不初始化，有默认值
				
				try {
					/*
					 * 该方法允许我们设置一个延迟时间。
					 * 在超时后元素还没有被放入队列才返回false
					 */
					tf = queue.offer(i, 5, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("添加元素" + i + ":" + tf);
			}
			
		}
	};
	
	offerThread.start();
	
	
	
	
	
	//从队列中取出元素的线程
	Thread pollThread = new Thread(){
		
		public void run(){
			
			for(int i=0; i<20; ++i){
				Integer num = 0;
				try {
					num = queue.poll(5, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("取出的元素是:" + num);
			}
		}
	};
	
	try {
		//阻塞1秒钟，让存元素的线程先向队列中存入元素。
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	pollThread.start();
	
	}
}
