package swtech.facade.pageDesign.entity;
import org.codehaus.jackson.annotate.JsonTypeInfo; 

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")		 
public class TplControl extends  BaseControl{
	private String value;
	private String home,msg,site,work,workbench, personal, choicetpl,  tpltype, isshow;;
	
	public String getChoicetpl() {
		return choicetpl;
	}
	public void setChoicetpl(String choicetpl) {
		this.choicetpl = choicetpl;
	}
	public String getTpltype() {
		return tpltype;
	}
	public void setTpltype(String tpltype) {
		this.tpltype = tpltype;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	} 
	
	public String getDatasource() {
		// TODO Auto-generated method stub
		return null;
	}   
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getWorkbench() {
		return workbench;
	}
	public void setWorkbench(String workbench) {
		this.workbench = workbench;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
}
