package swtech.facade.pageDesign.entity;

import swtech.common.entity.BaseEntity;

public class CopyNode extends BaseEntity{
	private Integer uid;
	private Integer node_id;
	private String excludeNode;
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getNode_id() {
		return node_id;
	}
	public void setNode_id(Integer node_id) {
		this.node_id = node_id;
	}
	public String getExcludeNode() {
		return excludeNode;
	}
	public void setExcludeNode(String excludeNode) {
		this.excludeNode = excludeNode;
	}
}
