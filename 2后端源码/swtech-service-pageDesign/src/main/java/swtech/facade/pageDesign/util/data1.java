package swtech.facade.pageDesign.util;

public class data1 implements Comparable<data1>{
	private String data1;
	private Integer id;
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int compareTo(data1 o) {
		return o.getId().compareTo(this.id);
	}
	@Override
	public String toString() {
		return "{\"data1\":\""+data1+"\",\"id\":"+ id +"}";
	}
}
