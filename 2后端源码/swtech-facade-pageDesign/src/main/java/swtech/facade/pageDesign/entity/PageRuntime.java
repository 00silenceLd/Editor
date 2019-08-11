package swtech.facade.pageDesign.entity;

import java.util.List;

import swtech.common.entity.BaseEntity;

public class PageRuntime extends BaseEntity{
	private String pageName;
	private int totle; 
	private int pageNumber;
	private int perTotle;
	private List records;
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public int getTotle() {
		return totle;
	}
	public void setTotle(int totle) {
		this.totle = totle;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPerTotle() {
		return perTotle;
	}
	public void setPerTotle(int perTotle) {
		this.perTotle = perTotle;
	}
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	
}
