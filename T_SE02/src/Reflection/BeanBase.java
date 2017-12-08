package Reflection;
/**
 * javaBean的拷贝：
 * 
 * 该类是复合规范的javaBean
 * @author 全文超
 * 2016-08-09 08:01:23
 *
 */
public class BeanBase {
	private int id;
	private String name;
	private double score;
	
	
	//无参的构造
	public BeanBase() {
		super();
	}
	
	//有参的构造
	public BeanBase(int id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
}
