package swtech.facade.pageDesign.entity;
import org.codehaus.jackson.annotate.JsonTypeInfo; 

@JsonTypeInfo(use = JsonTypeInfo.Id 

.CLASS, property = "typeName")		 
public class Search extends  BaseControl{
	private String nodeid, prdid, key, pname, istrue, name, style,title,orgtd,orgchecked,leipiplugins,orgwidth, orgheight;

	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrgtd() {
		return orgtd;
	}
	public void setOrgtd(String orgtd) {
		this.orgtd = orgtd;
	}
	public String getOrgchecked() {
		return orgchecked;
	}
	public void setOrgchecked(String orgchecked) {
		this.orgchecked = orgchecked;
	}
	public String getPrdid() {
		return prdid;
	}
	public void setPrdid(String prdid) {
		this.prdid = prdid;
	}	
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIstrue() {
		return istrue;
	}
	public void setIstrue(String istrue) {
		this.istrue = istrue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name 

 = name;
	}
	public String getLeipiplugins() {
		return leipiplugins;
	}
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}
	public String getOrgwidth() {
		return orgwidth;
	}
	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}
	public String getOrgheight() {
		return orgheight;
	}
	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}
	
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	private String classname;
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "Onlinehard [nodeid=" + nodeid + "]";
	}
	public String getDatasource() {
		// TODO Auto-generated method stub
		return null;
	}   
	
}
