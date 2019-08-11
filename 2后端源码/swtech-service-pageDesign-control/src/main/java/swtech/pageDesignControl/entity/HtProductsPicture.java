package swtech.pageDesignControl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("ht_products_picture")
public class HtProductsPicture  implements Serializable{
    @TableId
    private Integer hppId;

    private String hppUrl;

    private  Integer nodeId;

    
//
//    public HtProductsPicture() {
//		super();
//	}
//
//
//	public HtProductsPicture(String hppUrl) {
//		super();
//		this.hppUrl = hppUrl;
//	}
//
//
//	public Integer getHppId() {
//        return hppId;
//    }
//
//    public void setHppId(Integer hppId) {
//        this.hppId = hppId;
//    }
//
//    public String getHppUrl() {
//        return hppUrl;
//    }
//
//    public void setHppUrl(String hppUrl) {
//        this.hppUrl = hppUrl == null ? null : hppUrl.trim();
//    }
}