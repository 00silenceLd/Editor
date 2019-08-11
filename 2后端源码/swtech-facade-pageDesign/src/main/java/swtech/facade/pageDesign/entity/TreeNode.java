package swtech.facade.pageDesign.entity;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hamcrest.core.IsNull;

import swtech.common.entity.BaseEntity; 
public class TreeNode extends BaseEntity {
	private static final Log log = LogFactory
			.getLog(TreeNode.class);
	public boolean is_delete; 
	public String value;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String node_level;
	public int node_type; 
	public int getNode_type() {
		return node_type;
	}

	public void setNode_type(int node_type) {
		this.node_type = node_type;
	}

	public long parent_id;
	public Integer node_sore;
    public boolean isLeaf;
    public int createrUid; 

	public int getCreaterUid() {
		return createrUid;
	}

	public void setCreaterUid(int createrUid) {
		this.createrUid = createrUid;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<TreeNode> children = new ArrayList<TreeNode>();

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) { 
		this.children = children;
	}

	public boolean isIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}  

	public String getNode_level() {
		return node_level;
	}

	public void setNode_level(String node_level) {
		this.node_level = node_level;
	}	 

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getNode_sore() {
		return node_sore;
	}

	public void setNode_sore(Integer node_sore) {
		this.node_sore = node_sore;
	}
 
	
}
