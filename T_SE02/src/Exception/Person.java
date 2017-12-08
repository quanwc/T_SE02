package Exception;
/**
 * 测试异常抛出的第二种情况
 * 当不满足业务逻辑时
 * @author 全文超
 * 2015-09-02 20:03:38
 *
 */
public class Person {
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return name + ":" + age + "岁";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	
	/**
	 * 设置年龄
	 * @param age
	 * @throws Exception	当设置的年龄超出人类范畴，抛出该异常
	 */
	public void setAge(int age) throws Exception{
		
		//不满足业务逻辑，可以主动抛出一个异常
		if( age<0 || age >100 ){
//			throw new RuntimeException("超出人类年龄范围");
			
			
			//使用自定义异常，可以更准确的说明异常
			throw new IllegalAgeException("超出人类年龄范围了啊");
		}
		
		this.age = age;
	}
	
	public static void main(String[] args) {
		
		Person person = new Person();
		person.setName("范传奇");
		/*
		 * 调用一个有throws声明抛出异常的方法时，这段代码必须要求处理方法声明时抛出的异常
		 * 处理的方式有两种：
		 * 	 ·自行try-catch解决
		 * 	 ·继续向外抛出异常
		 */
		try {
			person.setAge(200);
		} catch (Exception e) {
			
			//输出错误堆栈，追查代码出现错误的过程。
			e.printStackTrace();
		}
		
		System.out.println(person);
	}
	
}
