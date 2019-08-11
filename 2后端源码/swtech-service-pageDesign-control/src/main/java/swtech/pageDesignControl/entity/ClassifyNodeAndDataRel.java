package swtech.pageDesignControl.entity;

import java.io.Serializable;

import lombok.Data;

/*
 * 
   

 *
 *
 *             ,%%%%%%%%, 
 *           ,%%/\%%%%/\%% 
 *          ,%%%\c "" J/%%% 
 * %.       %%%%/ o  o \%%% 
 * `%%.     %%%%    _  |%%% 
 *  `%%     `%%%%(__Y__)%%' 
 *  //       ;%%%%`\-/%%%'
 * ((       /  `%%%%%%%' 
 *  \\    .'          | 
 *   \\  /       \  | | 
 *    \\/         ) | | 
 *     \         /_ | |__ 
 *     (___________))))))) 攻城湿 
 *
 * @QualifiedName:swtech.pageDesignControl.entity.ClassifyNodeAndDataRel
 * @ClassName: ClassifyNodeAndDataRel
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:41:43
 * @Description: 编辑器树形分类控件中分类节点与数据关系表实体类
 *
 */
//@Data
public class ClassifyNodeAndDataRel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;//
	private Integer pId;//父id
	private Integer dataId;//数据id
	private Integer userId;//用户id
	private Integer roleId;//组织id
	private String dataUuid;//数据主键使用UUID的id
	private String commonData;//用以存放字符信息
	
	
	private Integer nodeId;//用于查询关系表名的分类表nodeId
	private Integer newPId;//用于移动 数据到其他节点的新节点id
	private String relationshipTableName;//用于临时存储关系表 名
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
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDataUuid() {
		return dataUuid;
	}
	public void setDataUuid(String dataUuid) {
		this.dataUuid = dataUuid;
	}
	public String getCommonData() {
		return commonData;
	}
	public void setCommonData(String commonData) {
		this.commonData = commonData;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getNewPId() {
		return newPId;
	}
	public void setNewPId(Integer newPId) {
		this.newPId = newPId;
	}
	public String getRelationshipTableName() {
		return relationshipTableName;
	}
	public void setRelationshipTableName(String relationshipTableName) {
		this.relationshipTableName = relationshipTableName;
	}
	@Override
	public String toString() {
		return "ClassifyNodeAndDataRel [id=" + id + ", pId=" + pId + ", dataId=" + dataId + ", userId=" + userId
				+ ", roleId=" + roleId + ", dataUuid=" + dataUuid + ", commonData=" + commonData + ", nodeId=" + nodeId
				+ ", newPId=" + newPId + ", relationshipTableName=" + relationshipTableName + "]";
	}
	
	
	
	

}
