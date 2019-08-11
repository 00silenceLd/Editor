package swtech.pageDesignControl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("")
public class HtRefectoryOrder  implements Serializable {
    @TableId
    private Integer orderId;

    private String orderNumber;

    private Integer orderUser;

    private Integer rid;

    private Integer orderStatus;

    private String orderShiyong;

    private Integer orderBei;

//    public HtRefectoryOrder() {
//    }
//
//    public Integer getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getOrderNumber() {
//        return orderNumber;
//    }
//
//    public void setOrderNumber(String orderNumber) {
//        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
//    }
//
//    public Integer getOrderUser() {
//        return orderUser;
//    }
//
//    public void setOrderUser(Integer orderUser) {
//        this.orderUser = orderUser;
//    }
//
//    public Integer getRid() {
//        return rid;
//    }
//
//    public void setRid(Integer rid) {
//        this.rid = rid;
//    }
//
//    public Integer getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(Integer orderStatus) {
//        this.orderStatus = orderStatus;
//    }
//
//    public String getOrderShiyong() {
//        return orderShiyong;
//    }
//
//    public void setOrderShiyong(String orderShiyong) {
//        this.orderShiyong = orderShiyong == null ? null : orderShiyong.trim();
//    }
//
//    public Integer getOrderBei() {
//        return orderBei;
//    }
//
//    public void setOrderBei(Integer orderBei) {
//        this.orderBei = orderBei;
//    }
}