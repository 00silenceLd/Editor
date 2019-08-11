package swtech.facade.pageDesign.entity;

import java.util.ArrayList;
import java.util.List;

import swtech.common.entity.BaseEntity;
public class CascadeClassify extends BaseEntity{
 private Integer id;
 private Integer parentId;
 private String name ;
 private List children = new ArrayList();
 private Integer roleId; //职位id
 private Integer jobId; //组织id
 
 
public Integer getRoleId() {
	return roleId;
}
public void setRoleId(Integer roleId) {
	this.roleId = roleId;
}
public Integer getJobId() {
	return jobId;
}
public void setJobId(Integer jobId) {
	this.jobId = jobId;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getParentId() {
	return parentId;
}
public void setParentId(Integer parentId) {
	this.parentId = parentId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List getChildren() {
	return children;
}
public void setChildren(List children) {
	this.children = children;
}
 
 

}
