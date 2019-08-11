package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;
/**
 * 轮播控件
 * @author 王小东
 * @date 2018年10月30日 上午10:04:02
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")	
public class Lunbo extends BaseControl{
	private String name , leipiplugins , type , value , title , datasource , limtvalue , datapic , datatitle , dataurl ,  orgwidth  , orgheight,client;
	private String wtime,arrowselect;
	
	public String getArrowselect() {
		return arrowselect;
	}

	/**
	 * @param arrowselect the arrowselect to set
	 */
	public void setArrowselect(String arrowselect) {
		this.arrowselect = arrowselect;
	}

	public String getWtime() {
		return wtime;
	}

	/**
	 * @param wtime the wtime to set
	 */
	public void setWtime(String wtime) {
		this.wtime = wtime;
	}

	public String getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeipiplugins() {
		return leipiplugins;
	}

	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getLimtvalue() {
		return limtvalue;
	}

	public void setLimtvalue(String limtvalue) {
		this.limtvalue = limtvalue;
	}

	public String getDatapic() {
		return datapic;
	}

	public void setDatapic(String datapic) {
		this.datapic = datapic;
	}

	public String getDatatitle() {
		return datatitle;
	}

	public void setDatatitle(String datatitle) {
		this.datatitle = datatitle;
	}

	public String getDataurl() {
		return dataurl;
	}

	public void setDataurl(String dataurl) {
		this.dataurl = dataurl;
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
	

}
