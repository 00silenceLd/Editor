package swtech.facade.pageDesign.entity;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.alibaba.fastjson.JSONObject;

/** 
*
* @author 林致杰
*
* @Email: 1003392067@qq.com
*
* @version 创建时间：2018年1月29日 下午4:21:49 
*
* 报表控件
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class ReportControl extends BaseControl{

	/*
	node_name - 节点名称
	node_id - 节点id
	field - 参数条件
	orderby - 静态/动态 0/1*/
	
	private String node_name;
	private String field;
	private Integer orderby;
	private String sqlStr;
	//储存查询出来的数据对象
	private Object data;
	//字段标题
	private String fields;
	//pid
	private Integer pid;
	private String visualreport;
	private String placeholder;
	private String readonly;
	private String scoresourceid;
	private String tps;
	
	private String statisticstheme;
	private String statisticalmaterials;
	
	
	
	
	
	
	
	public String getStatisticstheme() {
		return statisticstheme;
	}
	public void setStatisticstheme(String statisticstheme) {
		this.statisticstheme = statisticstheme;
	}
	public String getTps() {
		return tps;
	}
	public void setTps(String tps) {
		this.tps = tps;
	}
	public String getScoresourceid() {
		return scoresourceid;
	}
	public void setScoresourceid(String scoresourceid) {
		this.scoresourceid = scoresourceid;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public String getReadonly() {
		return readonly;
	}
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getVisualreport() {
		return visualreport;
	}
	public void setVisualreport(String visualreport) {
		this.visualreport = visualreport;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	public String getSqlStr() {
		return sqlStr;
	}
	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}
	
	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	public String getStatisticalmaterials() {
		return statisticalmaterials;
	}
	public void setStatisticalmaterials(String statisticalmaterials) {
		this.statisticalmaterials = statisticalmaterials;
	}
	@Override
	public String toString() {
		return "ReportControl [node_name=" + node_name + ", field=" + field + ", orderby=" + orderby + ", sqlStr="
				+ sqlStr + ", data=" + data + ", fields=" + fields + ", pid=" + pid + ", visualreport=" + visualreport
				+ ", placeholder=" + placeholder + ", readonly=" + readonly + ", scoresourceid=" + scoresourceid
				+ ", tps=" + tps + ", statisticstheme=" + statisticstheme + ", statisticalmaterials="
				+ statisticalmaterials + "]";
	}
	
	
	
	
	
}
 