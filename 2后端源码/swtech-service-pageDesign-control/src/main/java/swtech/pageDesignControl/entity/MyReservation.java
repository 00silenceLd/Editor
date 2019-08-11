package swtech.pageDesignControl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("my_reservation")
public class MyReservation  implements Serializable {
    @TableId
    private Integer mrRid;

    private String bcBcid;

    private String mrTime;

    private String mrPhone;

    private String mrCardid;

    private String mrArrive;

    private String mrComment;

    private Integer mrStatus;

    private Integer mrAuthCode;

    private String mrOrderNumber;

    private  int uid;
    
    private MyBeautyCommodity myBeautyCommodity;
    
    
//
//    public MyBeautyCommodity getMyBeautyCommodity() {
//		return myBeautyCommodity;
//	}
//
//
//
//	public void setMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity) {
//		this.myBeautyCommodity = myBeautyCommodity;
//	}
//
//
//
//	public MyReservation(String bcBcid, String mrTime, String mrPhone, String mrArrive, String mrComment,
//			Integer mrAuthCode, String mrOrderNumber) {
//		super();
//		this.bcBcid = bcBcid;
//		this.mrTime = mrTime;
//		this.mrPhone = mrPhone;
//		this.mrArrive = mrArrive;
//		this.mrComment = mrComment;
//		this.mrAuthCode = mrAuthCode;
//		this.mrOrderNumber = mrOrderNumber;
//	}
//
//
//
//	public MyReservation() {
//		super();
//	}
//
//
//
//	public Integer getMrRid() {
//        return mrRid;
//    }
//
//    public void setMrRid(Integer mrRid) {
//        this.mrRid = mrRid;
//    }
//
//    public String getBcBcid() {
//        return bcBcid;
//    }
//
//    public void setBcBcid(String bcBcid) {
//        this.bcBcid = bcBcid == null ? null : bcBcid.trim();
//    }
//
//    public String getMrTime() {
//        return mrTime;
//    }
//
//    public void setMrTime(String mrTime) {
//        this.mrTime = mrTime == null ? null : mrTime.trim();
//    }
//
//    public String getMrPhone() {
//        return mrPhone;
//    }
//
//    public void setMrPhone(String mrPhone) {
//        this.mrPhone = mrPhone == null ? null : mrPhone.trim();
//    }
//
//    public String getMrCardid() {
//        return mrCardid;
//    }
//
//    public void setMrCardid(String mrCardid) {
//        this.mrCardid = mrCardid == null ? null : mrCardid.trim();
//    }
//
//    public String getMrArrive() {
//        return mrArrive;
//    }
//
//    public void setMrArrive(String mrArrive) {
//        this.mrArrive = mrArrive == null ? null : mrArrive.trim();
//    }
//
//    public String getMrComment() {
//        return mrComment;
//    }
//
//    public void setMrComment(String mrComment) {
//        this.mrComment = mrComment == null ? null : mrComment.trim();
//    }
//
//    public Integer getMrStatus() {
//        return mrStatus;
//    }
//
//    public void setMrStatus(Integer mrStatus) {
//        this.mrStatus = mrStatus;
//    }
//
//    public Integer getMrAuthCode() {
//        return mrAuthCode;
//    }
//
//    public void setMrAuthCode(Integer mrAuthCode) {
//        this.mrAuthCode = mrAuthCode;
//    }
//
//    public String getMrOrderNumber() {
//        return mrOrderNumber;
//    }
//
//    public void setMrOrderNumber(String mrOrderNumber) {
//        this.mrOrderNumber = mrOrderNumber == null ? null : mrOrderNumber.trim();
//    }
}