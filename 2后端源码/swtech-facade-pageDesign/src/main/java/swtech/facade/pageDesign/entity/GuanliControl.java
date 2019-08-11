package swtech.facade.pageDesign.entity;
import org.codehaus.jackson.annotate.JsonTypeInfo; 

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")		 
public class GuanliControl extends  BaseControl{
    private String nodeid; 
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	} 
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String value;
	private String classname;
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "GuanliControl [nodeid=" + nodeid + "]";
	}
	public String getDatasource() {
		// TODO Auto-generated method stub
		return null;
	}   
	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
}
