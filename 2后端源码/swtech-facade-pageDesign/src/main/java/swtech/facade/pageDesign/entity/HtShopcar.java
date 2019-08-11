package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.List;

import swtech.common.entity.BaseEntity;

public class HtShopcar extends BaseEntity   implements Serializable{
    private Integer shopcarId;

    private Integer productsId;

    private Integer shopcarStatus;

    private Integer shopcarBei;
    
    private Integer number;
    
    
	public HtShopcar(Integer productsId) {
		super();
		this.productsId = productsId;
	}
    
    

	public HtShopcar() {
		super();
	}




	public HtShopcar(Integer shopcarStatus, Integer shopcarBei) {
		super();
		this.shopcarStatus = shopcarStatus;
		this.shopcarBei = shopcarBei;
	}



	public Integer getNumber() {
		return number;
	}



	public void setNumber(Integer number) {
		this.number = number;
	}

	private List<HtProducts> shopProduct;
    

    public List<HtProducts> getShopProduct() {
		return shopProduct;
	}



	public void setShopProduct(List<HtProducts> shopProduct) {
		this.shopProduct = shopProduct;
	}





	

	@Override
	public String toString() {
		return "HtShopcar [shopcarId=" + shopcarId + ", productsId=" + productsId + ", shopcarStatus=" + shopcarStatus
				+ ", shopcarBei=" + shopcarBei + ", id=" + id + ", createTime=" + createTime + ", getShopcarId()="
				+ getShopcarId() + ", getProductsId()=" + getProductsId() + ", getShopcarStatus()=" + getShopcarStatus()
				+ ", getShopcarBei()=" + getShopcarBei() + ", getId()=" + getId() + ", getVersion()=" + getVersion()
				+ ", getCreateTime()=" + getCreateTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



	public Integer getShopcarId() {
        return shopcarId;
    }

    public void setShopcarId(Integer shopcarId) {
        this.shopcarId = shopcarId;
    }

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public Integer getShopcarStatus() {
        return shopcarStatus;
    }

    public void setShopcarStatus(Integer shopcarStatus) {
        this.shopcarStatus = shopcarStatus;
    }

    public Integer getShopcarBei() {
        return shopcarBei;
    }

    public void setShopcarBei(Integer shopcarBei) {
        this.shopcarBei = shopcarBei;
    }
}