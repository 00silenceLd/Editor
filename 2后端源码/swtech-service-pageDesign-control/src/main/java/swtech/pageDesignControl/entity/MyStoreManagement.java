package swtech.pageDesignControl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("my_store_management")
public class MyStoreManagement  implements Serializable{
    @TableId
    private Integer smId;

    private String smName;

    private String smSite;

    private String smPhone;

    private String smInfo;

    private String smPicture;
    
    private String smTime;
    
    
//
//    public String getSmTime() {
//		return smTime;
//	}
//
//	public void setSmTime(String smTime) {
//		this.smTime = smTime;
//	}
//
//	public Integer getSmId() {
//        return smId;
//    }
//
//    public void setSmId(Integer smId) {
//        this.smId = smId;
//    }
//
//    public String getSmName() {
//        return smName;
//    }
//
//    public void setSmName(String smName) {
//        this.smName = smName == null ? null : smName.trim();
//    }
//
//    public String getSmSite() {
//        return smSite;
//    }
//
//    public void setSmSite(String smSite) {
//        this.smSite = smSite == null ? null : smSite.trim();
//    }
//
//    public String getSmPhone() {
//        return smPhone;
//    }
//
//    public void setSmPhone(String smPhone) {
//        this.smPhone = smPhone == null ? null : smPhone.trim();
//    }
//
//    public String getSmInfo() {
//        return smInfo;
//    }
//
//    public void setSmInfo(String smInfo) {
//        this.smInfo = smInfo == null ? null : smInfo.trim();
//    }
//
//    public String getSmPicture() {
//        return smPicture;
//    }
//
//    public void setSmPicture(String smPicture) {
//        this.smPicture = smPicture == null ? null : smPicture.trim();
//    }
}