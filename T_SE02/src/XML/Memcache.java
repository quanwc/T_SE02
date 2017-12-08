package XML;
/**
 * 实体类：
 * 	Memcache，用来封装memcache.xml文件解析后的数据
 * @author 全文超
 * 2016-05-13 20:34:19
 *
 */
public class Memcache {
	
	private String type;
	private String ip;
	private String prefix;
	
	//无参构造
	public Memcache(){
		
	}
	
	
	//有参构造
	public Memcache(String type, String ip, String prefix){
		this.type = type;
		this.ip = ip;
		this.prefix = prefix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	
	@Override
	public String toString(){
		return type + ", " + ip + ", " + prefix;
	}
	
}
