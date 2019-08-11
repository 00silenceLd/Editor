package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.List;

public class ClassifyShowRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//用于分类控件重做后2.0版本的一对多关系实体类
	
	private Integer id ;
	private Integer nodeId;//页面Id，一
	
	private List<Integer> classifyTreeIds;//该页面中可选择的分类，多
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public List<Integer> getClassifyTreeIds() {
		return classifyTreeIds;
	}
	public void setClassifyTreeIds(List<Integer> classifyTreeIds) {
		this.classifyTreeIds = classifyTreeIds;
	}
	@Override
	public String toString() {
		return "ClassifyShowRelation [id=" + id + ", nodeId=" + nodeId + ", classifyTreeIds=" + classifyTreeIds + "]";
	}
	
	
	
	
	

}
