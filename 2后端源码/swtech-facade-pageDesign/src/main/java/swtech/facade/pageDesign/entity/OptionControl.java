package swtech.facade.pageDesign.entity;

import swtech.common.entity.BaseEntity;


public class OptionControl extends BaseEntity{
	private long control_id;
	private String value;
	private String name;
	private String type;
	private String checked;
	private String onclick;
	
	
	
	public String getOnclick() {
		return onclick;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	public long getControl_id() {
		return control_id;
	}
	public void setControl_id(long ret_id) {
		this.control_id = ret_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	@Override
	public String toString() {
		return "OptionControl [control_id=" + control_id + ", value=" + value
				+ ", name=" + name + ", type=" + type + ", checked=" + checked
				+ "]";
	}
	

}
