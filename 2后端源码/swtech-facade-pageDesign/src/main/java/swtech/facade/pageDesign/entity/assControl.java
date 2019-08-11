package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 
*
* @author 林致杰
*
* @Email: 1003392067@qq.com
*
* @version 创建时间：2018年2月1日 下午4:29:39 
*
* 关联控件绑定关系
*/

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class assControl extends BaseControl{
	
/*	leipiplugins - 控件名称
	name  - 控件标识
	pname - 当前表名
	ename - 关联名
	istrue - 是否
	eid  - 关联id*/

	private String pname;
	private String ename;
	private String nonull;
	private Integer eid;
		
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getNonull() {
		return nonull;
	}

	public void setNonull(String nonull) {
		this.nonull = nonull;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getSqlString() {
		String sqlString = this.getName() + " TEXT  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	
	@Override
	public String toString() {
		return "assControl [pname=" + pname + ", ename=" + ename + ", nonull=" + nonull + ", eid=" + eid + "]";
	}
}
 