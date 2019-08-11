package swtech.pageDesignControl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

//@Data
@TableName("family_member")
public class TestEntity implements Serializable{
	private static final long serialVersionUID = 1L;
@TableId
	private Integer id;
	private String name;
	private String password;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	
	
}