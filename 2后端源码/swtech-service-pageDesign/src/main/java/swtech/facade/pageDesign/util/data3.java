package swtech.facade.pageDesign.util;

public class data3 implements Comparable<data3>{

	private String data3;
	private Integer id;
	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int compareTo(data3 o) {
		return o.getId().compareTo(this.id);
	}
	@Override
	public String toString() {
		return "{\"data3\":\""+data3+"\",\"id\":"+ id +"}";
	}
}

