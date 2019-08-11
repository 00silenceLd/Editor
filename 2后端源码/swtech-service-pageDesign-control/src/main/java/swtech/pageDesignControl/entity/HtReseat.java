package swtech.pageDesignControl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("ht_reseat")
public class HtReseat implements Serializable{
    @TableId
    private Integer seatId;

    private String seatNum;

    private Integer seatStatus;
    
    

//    public HtReseat(String seatNum) {
//		super();
//		this.seatNum = seatNum;
//	}
//
//	public HtReseat() {
//		super();
//	}
//
//	public Integer getSeatId() {
//        return seatId;
//    }
//
//    public void setSeatId(Integer seatId) {
//        this.seatId = seatId;
//    }
//
//    public String getSeatNum() {
//        return seatNum;
//    }
//
//    public void setSeatNum(String seatNum) {
//        this.seatNum = seatNum == null ? null : seatNum.trim();
//    }
//
//    public Integer getSeatStatus() {
//        return seatStatus;
//    }
//
//    public void setSeatStatus(Integer seatStatus) {
//        this.seatStatus = seatStatus;
//    }
}