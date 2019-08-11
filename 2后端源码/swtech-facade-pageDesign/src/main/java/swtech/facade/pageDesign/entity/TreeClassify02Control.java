package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo; 



@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class TreeClassify02Control extends BaseControl {  
//	name,placeholder,node_id
	
	

	private Integer node_id;
	private String placeholder;
	
	
	public Integer getNode_id() {
		return node_id;
	}
	public void setNode_id(Integer node_id) {
		this.node_id = node_id;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	@Override
	public String toString() {
		return "TreeClassifyControl [node_id=" + node_id + ", placeholder=" + placeholder + "]";
	}

	
	





}