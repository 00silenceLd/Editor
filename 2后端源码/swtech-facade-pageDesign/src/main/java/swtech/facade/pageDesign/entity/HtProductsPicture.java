package swtech.facade.pageDesign.entity;

import java.io.Serializable;

import swtech.common.entity.BaseEntity;

public class HtProductsPicture extends BaseEntity implements Serializable{
    private Integer hppId;

    private String hppUrl;
    
    
    

    public HtProductsPicture() {
		super();
	}
    

	public HtProductsPicture(String hppUrl) {
		super();
		this.hppUrl = hppUrl;
	}


	public Integer getHppId() {
        return hppId;
    }

    public void setHppId(Integer hppId) {
        this.hppId = hppId;
    }

    public String getHppUrl() {
        return hppUrl;
    }

    public void setHppUrl(String hppUrl) {
        this.hppUrl = hppUrl == null ? null : hppUrl.trim();
    }
}