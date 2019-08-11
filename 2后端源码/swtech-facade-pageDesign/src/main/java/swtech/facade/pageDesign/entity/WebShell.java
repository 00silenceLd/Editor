package swtech.facade.pageDesign.entity;

public class WebShell {
	public static final long SerialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String chinesename;
	private int isdelete;

	
	
	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}

}
