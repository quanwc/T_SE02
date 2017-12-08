package Exception;


public class ThrowsSon extends ThrowsFather{
	
	/*
	 * 1.重写方法是可以不throws抛出任何异常
	 * 2.仅抛出父类父类抛出的部分异常
	 * 3.可以抛出父类抛出异常的子类异常
	 * 		FileNOtFoundException是IOException的子类。
	 * 
	 * 
	 * 1.不允许抛出额外异常.
	 * 2.不允许抛出父类抛出异常的父类异常。
	 * 	   只能抛出父类异常或其父类异常的子类异常
	 */
	@Override
	public void dosome() {
		
	}
}
