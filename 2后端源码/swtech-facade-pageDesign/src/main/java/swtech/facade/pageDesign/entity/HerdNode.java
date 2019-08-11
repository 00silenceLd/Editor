package swtech.facade.pageDesign.entity;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.BaseEntity;

/** 
* @author 作者 E-mail: 1003392067@qq.com
* @version 创建时间：2018年1月15日 下午3:35:01 
*
* 网群管理实体类
*/
public class HerdNode extends BaseEntity implements Comparable<HerdNode>{

	private int version;
	private boolean is_delete;
	//node_name
	private String value;
	private String node_level;
	private int node_type;
	private int parent_id;
	private int node_sore;
	private int createrUid;
	private JSONObject settings;
	private List<HerdNode> children;
	private String url;
	private boolean isFolder;
    private boolean isFirst;
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public boolean isIsFolder() {
		return isFolder;
	}
	public void setIsFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getNode_level() {
		return node_level;
	}
	public void setNode_level(String node_level) {
		this.node_level = node_level;
	}
	public int getNode_type() {
		return node_type;
	}
	public void setNode_type(int node_type) {
		this.node_type = node_type;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getNode_sore() {
		return node_sore;
	}
	public void setNode_sore(int node_sore) {
		this.node_sore = node_sore;
	}
	public int getCreaterUid() {
		return createrUid;
	}
	public void setCreaterUid(int createrUid) {
		this.createrUid = createrUid;
	}
	public JSONObject getSettings() {
		return settings;
	}
	public void setSettings(JSONObject settings) {
		this.settings = settings;
	}
	public List<HerdNode> getChildren() {
		return children;
	}
	public void setChildren(List<HerdNode> children) {
		this.children = children;
	}
	
	@Override
	public int compareTo(HerdNode o) {
		int i = this.getNode_sore() - o.getNode_sore();
		
		return i;
	}
}
 