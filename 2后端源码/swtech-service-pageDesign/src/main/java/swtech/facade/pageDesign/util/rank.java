package swtech.facade.pageDesign.util;

public class rank implements Comparable<rank>{
	private String data2;
	private Integer id;
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int compareTo(rank o) {
		return o.getId().compareTo(this.id);
	}
	@Override
	public String toString() {
		return "{\"data2\":\""+data2+"\",\"id\":"+ id +"}";
	}
	
	
}
