package XML;
/**
 * 员工类:该类用来描述xml文件中一个员工的信息
 * 
 * 使用类来封装表示一个表格。有几列就有几个属性。这种设计方式我们要习惯
 * 对于一个表格保存的所有数据而言，有多少列(字段)，我们这里就对应定义相应类型的属性。
 * 这样我们可以用该类的每一个实例保存表格中的每一行数据。
 * 
 * @author 全文超
 * 2015-09-15 08:50:01
 *
 * vo:value Object:值对象，就是用来保存一条数据。
 */
public class Emp {
	
	private int id;
	private String name;
	private int age;
	private String gender;
	private int salary;
	
	
	//构造方法
	public Emp(){
		
	}
	public Emp(int id, String name, int age, String gender, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "[" + id + ", " + name + ", " + age
				+ ", " + gender + ", " + salary + "]";
	}
	
	
	
}
