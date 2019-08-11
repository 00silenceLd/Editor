package swtech.pageDesignControl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 袁君选
 * @author Administrator
 *	餐品上传
 */

@Data
@TableName("ht_products")
public class HtProducts  implements Serializable{

    @TableId
    private Integer productsId;

    private String productsName;

    private Double prodyctsPrice;

    private String productsInfo;

    private Integer productsCategory;

    private String productsComment;

    private Integer productsStatus;

    private Integer productsShop;

    private String productsPicture;
    
    private Integer number;
    
    
    
    
//    public Integer getNumber() {
//		return number;
//	}
//
//
//
//	public void setNumber(Integer number) {
//		this.number = number;
//	}
//
//    public HtProducts(Integer productsCategory) {
//		super();
//		this.productsCategory = productsCategory;
//	}
//
//	public HtProducts() {
//    }
//
//
//
//    public HtProducts(Integer productsId, String productsComment) {
//		super();
//		this.productsId = productsId;
//		this.productsComment = productsComment;
//	}
//
//	@Override
//    public String toString() {
//        return "HtProducts{" +
//                "productsId=" + productsId +
//                ", productsName='" + productsName + '\'' +
//                ", prodyctsPrice=" + prodyctsPrice +
//                ", productsInfo='" + productsInfo + '\'' +
//                ", productsCategory=" + productsCategory +
//                ", productsComment='" + productsComment + '\'' +
//                ", productsStatus=" + productsStatus +
//                ", productsShop=" + productsShop +
//                ", productsPicture='" + productsPicture + '\'' +
//                '}';
//    }
//
//
//
//    public HtProducts(String productsName, Double prodyctsPrice, String productsInfo, Integer productsCategory,
//			String productsComment, String productsPicture) {
//		super();
//		this.productsName = productsName;
//		this.prodyctsPrice = prodyctsPrice;
//		this.productsInfo = productsInfo;
//		this.productsCategory = productsCategory;
//		this.productsComment = productsComment;
//		this.productsPicture = productsPicture;
//	}
//
//	public Integer getProductsId() {
//        return productsId;
//    }
//
//    public void setProductsId(Integer productsId) {
//        this.productsId = productsId;
//    }
//
//    public String getProductsName() {
//        return productsName;
//    }
//
//    public void setProductsName(String productsName) {
//        this.productsName = productsName == null ? null : productsName.trim();
//    }
//
//    public Double getProdyctsPrice() {
//        return prodyctsPrice;
//    }
//
//    public void setProdyctsPrice(Double prodyctsPrice) {
//        this.prodyctsPrice = prodyctsPrice;
//    }
//
//    public String getProductsInfo() {
//        return productsInfo;
//    }
//
//    public void setProductsInfo(String productsInfo) {
//        this.productsInfo = productsInfo == null ? null : productsInfo.trim();
//    }
//
//    public Integer getProductsCategory() {
//        return productsCategory;
//    }
//
//    public void setProductsCategory(Integer productsCategory) {
//        this.productsCategory = productsCategory;
//    }
//
//    public String getProductsComment() {
//        return productsComment;
//    }
//
//    public void setProductsComment(String productsComment) {
//        this.productsComment = productsComment == null ? null : productsComment.trim();
//    }
//
//    public Integer getProductsStatus() {
//        return productsStatus;
//    }
//
//    public void setProductsStatus(Integer productsStatus) {
//        this.productsStatus = productsStatus;
//    }
//
//    public Integer getProductsShop() {
//        return productsShop;
//    }
//
//    public void setProductsShop(Integer productsShop) {
//        this.productsShop = productsShop;
//    }
//
//    public String getProductsPicture() {
//        return productsPicture;
//    }
//
//    public void setProductsPicture(String productsPicture) {
//        this.productsPicture = productsPicture == null ? null : productsPicture.trim();
//    }
}