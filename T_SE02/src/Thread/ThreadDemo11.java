package Thread;
/**
 * 用于显示图片是否下载完毕
 * @author 全文超
 * 2015-09-06 18:13:33
 *
 */
public class ThreadDemo11 {
	
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
			}
		};
		
		
		Thread show = new Thread(){
			
			@Override
			public void run(){
				System.out.println("显示其它文本信息。");
				System.out.println("显示图片。");
				
				//这里应当等待download线程工作完毕
				try {
					/**
					 * 当一个方法的局部内部类中若想引用当前方法的其他局部变量，那么该变量
					 * 必须被声明为final的。JDK1.8后不再
					 */
					download.join();//多线程中也可以实现同步，这需要我们实现一些操作。
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
