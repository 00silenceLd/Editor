package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.Date;

public class LayuiTabReturn<T> implements Serializable{
	private String status;
	private String statusMsg;
	private T msg;
	private Integer count;

	public LayuiTabReturn() {
	}

	public LayuiTabReturn(String status) {
		this.status = status;
	}

	public LayuiTabReturn(String status, String statusMsg) {
		super();
		this.status = status;
		this.statusMsg = statusMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getMsg() {
		return msg;
	}

	public void setMsg(T msg) {
		this.msg = msg;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
