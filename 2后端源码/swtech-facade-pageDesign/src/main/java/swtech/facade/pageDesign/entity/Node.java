package swtech.facade.pageDesign.entity;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.BaseEntity;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午4:19:04 
 *
 * Node实体类
 *
 */

public class Node extends BaseEntity implements Comparable<Node>{
	private static final Log log = LogFactory
			.getLog(Node.class);

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
	private List<Node> children;
	private String url;
	private Integer isFolder;
	private Integer type;
	private String childrenStr;
	private String node_name;
	private Integer userPrivate; //0 私有  1公有
	private Integer is_public;
	private Integer is_approve;
	private Date create_time;
	private Integer is_popularize;
	private Integer is_slave_page;

	
	
	
	
	
	
	
	
	private Integer is_project;//1为是，0为否
	private Integer module_classify;//
	private Integer page_classify;//
	private String page_path;
	
	
	
	
	
	
	
	
	
	
	
	



	public String getPage_path() {
		return page_path;
	}
	public void setPage_path(String page_path) {
		this.page_path = page_path;
	}
	public Integer getIs_project() {
		return is_project;
	}
	public void setIs_project(Integer is_project) {
		this.is_project = is_project;
	}
	public Integer getPage_classify() {
		return page_classify;
	}
	public void setPage_classify(Integer page_classify) {
		this.page_classify = page_classify;
	}
	public Integer getModule_classify() {
		return module_classify;
	}
	public void setModule_classify(Integer module_classify) {
		this.module_classify = module_classify;
	}
	public Integer getIs_slave_page() {
		return is_slave_page;
	}
	public void setIs_slave_page(Integer is_slave_page) {
		this.is_slave_page = is_slave_page;
	}
	public Integer getIs_popularize() {
		return is_popularize;
	}
	public void setIs_popularize(Integer is_popularize) {
		this.is_popularize = is_popularize;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getUserPrivate() {
		return userPrivate;
	}
	public Integer getIs_public() {
		return is_public;
	}
	public void setIs_public(Integer is_public) {
		this.is_public = is_public;
	}
	public void setUserPrivate(Integer userPrivate) {
		this.userPrivate = userPrivate;
	}
	public String getNode_name() {
		return node_name;
	}
	public String getChildrenStr() {
		return childrenStr;
	}
	public void setChildrenStr(String childrenStr) {
		this.childrenStr = childrenStr;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setSettings(JSONObject settings) {
		this.settings = settings;
	}
	public JSONObject getSettings() {
		return settings;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
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

	//	@Override
	//	public String toString() {
	//		return "Node [parent_id=" + parent_id + ", children=" + children +", id=" + id + "]";
	//	}

	@Override
	public int compareTo(Node o) {
		int i = this.getNode_sore() - o.getNode_sore();

		return i;
	}
	public Integer getIs_approve() {
		return is_approve;
	}
	public void setIs_approve(Integer is_approve) {
		this.is_approve = is_approve;
	}




	public Integer getIsFolder() {
		return isFolder;
	}
	public void setIsFolder(Integer isFolder) {
		this.isFolder = isFolder;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	@Override
	public String toString() {
		return "Node [version=" + version + ", is_delete=" + is_delete + ", value=" + value + ", node_level="
				+ node_level + ", node_type=" + node_type + ", parent_id=" + parent_id + ", node_sore=" + node_sore
				+ ", createrUid=" + createrUid + ", settings=" + settings + ", children=" + children + ", url=" + url
				+ ", isFolder=" + isFolder + ", type=" + type + ", childrenStr=" + childrenStr + ", node_name="
				+ node_name + ", userPrivate=" + userPrivate + ", is_public=" + is_public + ", is_approve=" + is_approve
				+ ", create_time=" + create_time + ", is_popularize=" + is_popularize + ", is_slave_page="
				+ is_slave_page + ", page_classify=" + page_classify + ", module_classify=" + module_classify
				+ ", is_project=" + is_project + ", page_path=" + page_path + "]";
	}




}
