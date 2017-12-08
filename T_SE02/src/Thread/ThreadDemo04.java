package Thread;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 编写一个程序，让窗口在白色与黑色之间切换
 * @author 全文超
 * 2015-09-04 12:01:52
 *
 */
public class ThreadDemo04 extends JFrame implements Runnable{
		
	@Override
	public void run() {
		
		int i=0;
		JPanel panel = new JPanel();
		panel.setSize(300, 300);
		this.setContentPane(panel);
		
		while(true){
			i = (i==0) ? 1 : 0;//i值在此处修改
			if(i==0){
				panel.setBackground(Color.black);
				//因为panel的颜色要改变，所以panel就必须放在线程的run()方法内
			}else{
				panel.setBackground(Color.white);
			}
		}
	}
	
	public static void main(String[] args) {
		
		ThreadDemo04 jf = new ThreadDemo04();
		jf.setLocation(500, 500);
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		Thread t = new Thread(jf);
		t.start();
	}
}
