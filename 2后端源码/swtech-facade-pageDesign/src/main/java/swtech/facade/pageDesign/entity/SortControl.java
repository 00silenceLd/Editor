package swtech.facade.pageDesign.entity;

import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import swtech.common.entity.BaseEntity;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 分类控件
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年4月11日 下午2:53:47
 **/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class SortControl extends BaseControl{

	private int pluginId;
	private String action;
	private String nodes;
	private boolean isShow;
    private String type; 
	private List<SortChildren> children;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNodes() {
		return nodes;
	}
	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	public int getPluginId() {
		return pluginId;
	}
	public void setPluginId(int pluginId) {
		this.pluginId = pluginId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public List<SortChildren> getChildren() {
		return children;
	}
	public void setChildren(List<SortChildren> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "SortControl [pluginId=" + pluginId + ", action=" + action + ", nodes=" + nodes + ", isShow=" + isShow
				+ ", children=" + children + "]";
	}
	
	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	
}
 