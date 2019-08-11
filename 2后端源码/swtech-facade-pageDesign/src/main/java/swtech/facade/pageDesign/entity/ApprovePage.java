package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.Date;

public class ApprovePage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String node_name;
	private Integer is_approve;
	private Integer createrUid;
	private Date create_time;
	private String creater;
	private String createTimeStr;
	
	
	
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	public Integer getIs_approve() {
		return is_approve;
	}
	public void setIs_approve(Integer is_approve) {
		this.is_approve = is_approve;
	}
	public Integer getCreaterUid() {
		return createrUid;
	}
	public void setCreaterUid(Integer createrUid) {
		this.createrUid = createrUid;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	@Override
	public String toString() {
		return "ApprovePage [id=" + id + ", node_name=" + node_name + ", is_approve=" + is_approve + ", createrUid="
				+ createrUid + ", create_time=" + create_time + ", creater=" + creater + ", createTimeStr="
				+ createTimeStr + "]";
	}
	


}
