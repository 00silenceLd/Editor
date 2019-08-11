package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.BaseEntity;

/**
*
* @author 曾智宏
*
* @version 1.0
*
* 创建时间：
*
*分类控件中分类树的中央记录表
* 
* 实体类
*
*/

public class ClassifyTreeInfo extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//
	private String treeName;//该节点名字
	private Integer nodeId;//该分类所属的页面nodeId
	private String classifyTableName;//该分类的表名
	private String relationshipTableName;//该分类表中节点与数据的关系表
	
	private List<ClassifyNode> classifyNodeList;//该树形图的分类节点
	
	
	
	
	public String getRelationshipTableName() {
		return relationshipTableName;
	}
	public void setRelationshipTableName(String relationshipTableName) {
		this.relationshipTableName = relationshipTableName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public List<ClassifyNode> getClassifyNodeList() {
		return classifyNodeList;
	}
	public void setClassifyNodeList(List<ClassifyNode> classifyNodeList) {
		this.classifyNodeList = classifyNodeList;
	}
	public String getClassifyTableName() {
		return classifyTableName;
	}
	public void setClassifyTableName(String classifyTableName) {
		this.classifyTableName = classifyTableName;
	}
	@Override
	public String toString() {
		return "ClassifyTreeInfo [id=" + id + ", treeName=" + treeName + ", nodeId=" + nodeId + ", classifyTableName="
				+ classifyTableName + ", relationshipTableName=" + relationshipTableName + ", classifyNodeList="
				+ classifyNodeList + "]";
	}
	
	
	
	
}
 