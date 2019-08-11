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
*分类控件中树形菜单的分类节点
* 
* 实体类
*
*/

public class ClassifyNode extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//
	private Integer pId;//父id
	private String nodeName;//该节点名字
	private Integer treeId;//该节点所属的树形图id
	private Integer tree2Id;//在2.0树形中创建的树Id，此处对应数据表字段值只有从classifyTree表转过来的分类记录才有。
	
	
	
	public Integer getTree2Id() {
		return tree2Id;
	}
	public void setTree2Id(Integer tree2Id) {
		this.tree2Id = tree2Id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public Integer getTreeId() {
		return treeId;
	}
	public void setTreeId(Integer treeId) {
		this.treeId = treeId;
	}
	@Override
	public String toString() {
		return "ClassifyNode [id=" + id + ", pId=" + pId + ", nodeName=" + nodeName + ", treeId=" + treeId
				+ ", tree2Id=" + tree2Id + "]";
	}

	
	
	
	
	
	
	
}
 