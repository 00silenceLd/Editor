package swtech.facade.pageDesign.entity;

import swtech.common.entity.BaseEntity;

public class PageCanvas extends BaseEntity {
	private long node_id;
	private String content;
	private String content_parse;
	private int page_type; 
	 
	public int getPage_type() {
		return page_type;
	}
	public void setPage_type(int page_type) {
		this.page_type = page_type;
	}
	public long getNode_id() {
		return node_id;
	}
	public void setNode_id(long node_id) {
		this.node_id = node_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent_parse() {
		return content_parse;
	}
	public void setContent_parse(String content_parse) {
		this.content_parse = content_parse;
	}

}
