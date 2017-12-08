package Thread;

public class TT {
	public static void main(String[] args) {
		
		AA a = new AA();
		Thread t = new Thread(a);
		t.start();
		System.out.println(Thread.currentThread().getPriority());
		System.out.println("main()...");
	}
}


class AA implements Runnable{
		@Override
		public void run() {
			System.out.println("run()...");
		}
}