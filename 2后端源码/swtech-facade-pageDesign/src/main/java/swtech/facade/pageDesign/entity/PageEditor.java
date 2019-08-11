package swtech.facade.pageDesign.entity;

import java.util.List;

import swtech.common.entity.BaseEntity;

public class PageEditor extends BaseEntity {
	private int node_id;
	private String node_name;
	private boolean is_delete;
	private int fields;
	private List<BaseControl> data;
	private String parse;
	private String title;
	private String selected;
	private String phoneParse;
	private String wifiField;
	private String name;
	
	private String shareTo_name;
	private int shareTo_nodeId;
	private int isForShare = 0;
	
	private Integer is_approve;
	
	public Integer getIs_approve() {
		return is_approve;
	}

	public void setIs_approve(Integer is_approve) {
		this.is_approve = is_approve;
	}

	public String getShareTo_name() {
		return shareTo_name;
	}

	public int getShareTo_nodeId() {
		return shareTo_nodeId;
	}

	public void setShareTo_nodeId(int shareTo_nodeId) {
		this.shareTo_nodeId = shareTo_nodeId;
	}

	public void setShareTo_name(String shareTo_name) {
		this.shareTo_name = shareTo_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWifiField() {
		return wifiField;
	}

	public void setWifiField(String wifiField) {
		this.wifiField = wifiField;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNode_id() {
		return node_id;
	}

	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}

	public String getNode_name() {
		return node_name;
	}

	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}

	public boolean isIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	public int getFields() {
		return fields;
	}

	public void setFields(int fields) {
		this.fields = fields;
	}

	public List<BaseControl> getData() {
		return data;
	}

	public void setData(List<BaseControl> data) {
		this.data = data;
	}

	public String getParse() {
		return parse;
	}

	public void setParse(String parse) {
		this.parse = parse;
	}

	public String getPhoneParse() {
		return phoneParse;
	}

	public void setPhoneParse(String phoneParse) {
		this.phoneParse = phoneParse;
	}

	public int getIsForShare() {
		return isForShare;
	}

	public void setIsForShare(int isForShare) {
		this.isForShare = isForShare;
	}

	@Override
	public String toString() {
		return "PageEditor [node_id=" + node_id + ", node_name=" + node_name + ", is_delete=" + is_delete + ", fields="
				+ fields + ", data=" + data + ", parse=" + parse + ", title=" + title + ", selected=" + selected
				+ ", phoneParse=" + phoneParse + ", wifiField=" + wifiField + ", name=" + name + ", shareTo_name="
				+ shareTo_name + ", shareTo_nodeId=" + shareTo_nodeId + ", isForShare=" + isForShare + ", is_approve="
				+ is_approve + "]";
	}

	







}
