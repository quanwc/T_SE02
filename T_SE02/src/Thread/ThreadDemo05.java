package Thread;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 使用匿名内部类的方式实现窗口颜色切换
 * @author 全文超
 *  2015-09-04 12:01:52
 *  2015-09-04 17:01:36
 *
 */
public class ThreadDemo05 {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		final JPanel panel = new JPanel();
		//一个方法的匿名内部类中，要想引用该方法的其它局部变量(匿名内部类外面的局部变量)，
		//那么这个变量必须是final的。
		
		
		frame.setLocation(500, 500);
		frame.setLocation(500, 300);
		frame.setSize(300, 300);
		panel.setSize(300, 300);
		frame.setContentPane(panel);
		frame.setVisible(true);
		
		
		//上面的步骤已经将窗体设置好了，下面就可以创建线程控制它了
		Thread t = new Thread(){
			
			@Override
			public void run() {
				int i = 0; 
				while(true){
					i = (i==0) ? 1 : 0;	
					if(i==0){
						panel.setBackground(Color.yellow);
					}else{
						panel.setBackground(Color.red);
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		
		t.start();
	}
}
