package swtech.facade.pageDesign.entity;

import java.io.Serializable;

import swtech.common.entity.BaseEntity;
/**
 * 
 * @author 刘东
 * 2019.7.19
   *   审核控件实体类
 */
public class ApproveInfo extends BaseEntity implements Serializable{
	private int id;
	private int nodeId;
	private int selectId;
	private int isApprove;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public int getSelectId() {
		return selectId;
	}
	public void setSelectId(int selectId) {
		this.selectId = selectId;
	}
	public int getIsApprove() {
		return isApprove;
	}
	public void setIsApprove(int isApprove) {
		this.isApprove = isApprove;
	}
	@Override
	public String toString() {
		return "ApproveInfo [id=" + id + ", nodeId=" + nodeId + ", selectId=" + selectId + ", isApprove=" + isApprove
				+ "]";
	}
	

}
