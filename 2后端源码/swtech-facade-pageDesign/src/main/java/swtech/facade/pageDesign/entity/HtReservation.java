package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.List;

import swtech.common.entity.BaseEntity;

public class HtReservation extends BaseEntity  implements Serializable{
	   private Integer rid;

	    private Integer num;

	    private String productsId;

	    private Integer reUserId;

	    private String recanceltime;

	    private String getshoptime;

	    private String rePerpor;

	    private String rePhone;

	    private Integer rePerNum;

	    private String reUrl;

	    private Integer orderId;

	    private Integer reBeiId;

	    private String orderid;
	    
	    private List<HtShopcar> reserShop;
	    
	    
	    
	    

	    public HtReservation(Integer rid, Integer orderId) {
			super();
			this.rid = rid;
			this.orderId = orderId;
		}

		public List<HtShopcar> getReserShop() {
			return reserShop;
		}

		public void setReserShop(List<HtShopcar> reserShop) {
			this.reserShop = reserShop;
		}

		public HtReservation(Integer rid, String recanceltime, String reUrl) {
			super();
			this.rid = rid;
			this.recanceltime = recanceltime;
			this.reUrl = reUrl;
		}

		public Integer getRid() {
	        return rid;
	    }

	    public void setRid(Integer rid) {
	        this.rid = rid;
	    }

	    public Integer getNum() {
	        return num;
	    }

	    public void setNum(Integer num) {
	        this.num = num;
	    }

	    public String getProductsId() {
	        return productsId;
	    }

	    public void setProductsId(String productsId) {
	        this.productsId = productsId == null ? null : productsId.trim();
	    }

	    public Integer getReUserId() {
	        return reUserId;
	    }

	    public void setReUserId(Integer reUserId) {
	        this.reUserId = reUserId;
	    }

	    public String getRecanceltime() {
	        return recanceltime;
	    }

	    public void setRecanceltime(String recanceltime) {
	        this.recanceltime = recanceltime == null ? null : recanceltime.trim();
	    }

	    public String getGetshoptime() {
	        return getshoptime;
	    }

	    public void setGetshoptime(String getshoptime) {
	        this.getshoptime = getshoptime == null ? null : getshoptime.trim();
	    }

	    public String getRePerpor() {
	        return rePerpor;
	    }

	    public void setRePerpor(String rePerpor) {
	        this.rePerpor = rePerpor == null ? null : rePerpor.trim();
	    }

	    public String getRePhone() {
	        return rePhone;
	    }

	    public void setRePhone(String rePhone) {
	        this.rePhone = rePhone == null ? null : rePhone.trim();
	    }

	    public Integer getRePerNum() {
	        return rePerNum;
	    }

	    public void setRePerNum(Integer rePerNum) {
	        this.rePerNum = rePerNum;
	    }

	    public String getReUrl() {
	        return reUrl;
	    }

	    public void setReUrl(String reUrl) {
	        this.reUrl = reUrl == null ? null : reUrl.trim();
	    }

	    public Integer getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(Integer orderId) {
	        this.orderId = orderId;
	    }

	    public Integer getReBeiId() {
	        return reBeiId;
	    }

	    public void setReBeiId(Integer reBeiId) {
	        this.reBeiId = reBeiId;
	    }

	    public String getOrderid() {
	        return orderid;
	    }

	    public void setOrderid(String orderid) {
	        this.orderid = orderid == null ? null : orderid.trim();
	    }
        
    
    
    public HtReservation() {
		super();
	}

	public HtReservation(String getshoptime, String rePerpor, String rePhone, String orderid) {
		super();
		this.getshoptime = getshoptime;
		this.rePerpor = rePerpor;
		this.rePhone = rePhone;
		this.orderid = orderid;
	}
	
	

}