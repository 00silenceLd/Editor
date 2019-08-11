package swtech.facade.pageDesign.entity;

import swtech.common.entity.BaseEntity;

public class SiteFirst  extends BaseEntity{
     private int node_id;
     private int site_id;
     private boolean is_pc;
     private String domain;
     
	 
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public boolean isIs_pc() {
		return is_pc;
	}
	public void setIs_pc(boolean is_pc) {
		this.is_pc = is_pc;
	}
	public int getNode_id() {
		return node_id;
	}
	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}
	public int getSite_id() {
		return site_id;
	}
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
}
