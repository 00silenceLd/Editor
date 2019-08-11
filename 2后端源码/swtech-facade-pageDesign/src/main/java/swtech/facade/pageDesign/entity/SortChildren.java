package swtech.facade.pageDesign.entity;

import java.util.List;

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
 * @description : 分类控件树节点存放
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年4月11日 下午4:15:22
 **/
public class SortChildren extends BaseEntity {

	private int pid;
	private String name;
	private String url;
	private int nodeId;
	private String attributes;
	private List<SortChildren> children;
	
	
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public List<SortChildren> getChildren() {
		return children;
	}
	public void setChildren(List<SortChildren> children) {
		this.children = children;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	
	@Override
	public String toString() {
		return "SortChildren [pid=" + pid + ", name=" + name + ", url=" + url + ", nodeId=" + nodeId + ", attributes="
				+ attributes + ", children=" + children + "]";
	}
	
}
 