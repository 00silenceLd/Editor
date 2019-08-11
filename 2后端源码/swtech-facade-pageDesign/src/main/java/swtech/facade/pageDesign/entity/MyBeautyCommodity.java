package swtech.facade.pageDesign.entity;

import java.io.Serializable;

import swtech.common.entity.BaseEntity;

public class MyBeautyCommodity extends BaseEntity implements Serializable{
    private Integer bcId;

    private String bcName;

    private String bcBookInformation;

    private Double bcPrice;

    private Double bcMemberPrice;

    private Integer bcRack;

    private String bcInfo;

    private Integer bcSmid;

    private String bcPicture;
    
    

    public MyBeautyCommodity() {
		super();
	}

    
    
	public MyBeautyCommodity(Integer bcId, String bcName, String bcBookInformation, Double bcPrice,
			Double bcMemberPrice, Integer bcRack, String bcInfo, Integer bcSmid, String bcPicture) {
		super();
		this.bcId = bcId;
		this.bcName = bcName;
		this.bcBookInformation = bcBookInformation;
		this.bcPrice = bcPrice;
		this.bcMemberPrice = bcMemberPrice;
		this.bcRack = bcRack;
		this.bcInfo = bcInfo;
		this.bcSmid = bcSmid;
		this.bcPicture = bcPicture;
	}



	public Integer getBcId() {
        return bcId;
    }

    public void setBcId(Integer bcId) {
        this.bcId = bcId;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName == null ? null : bcName.trim();
    }

    public String getBcBookInformation() {
        return bcBookInformation;
    }

    public void setBcBookInformation(String bcBookInformation) {
        this.bcBookInformation = bcBookInformation == null ? null : bcBookInformation.trim();
    }

    public Double getBcPrice() {
        return bcPrice;
    }

    public void setBcPrice(Double bcPrice) {
        this.bcPrice = bcPrice;
    }

    public Double getBcMemberPrice() {
        return bcMemberPrice;
    }

    public void setBcMemberPrice(Double bcMemberPrice) {
        this.bcMemberPrice = bcMemberPrice;
    }

    public Integer getBcRack() {
        return bcRack;
    }

    public void setBcRack(Integer bcRack) {
        this.bcRack = bcRack;
    }

    public String getBcInfo() {
        return bcInfo;
    }

    public void setBcInfo(String bcInfo) {
        this.bcInfo = bcInfo == null ? null : bcInfo.trim();
    }

    public Integer getBcSmid() {
        return bcSmid;
    }

    public void setBcSmid(Integer bcSmid) {
        this.bcSmid = bcSmid;
    }

    public String getBcPicture() {
        return bcPicture;
    }

    public void setBcPicture(String bcPicture) {
        this.bcPicture = bcPicture == null ? null : bcPicture.trim();
    }
}