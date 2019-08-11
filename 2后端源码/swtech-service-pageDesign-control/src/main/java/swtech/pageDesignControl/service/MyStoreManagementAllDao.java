package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.MyBeautyCommodity;
import swtech.pageDesignControl.entity.MyReservation;
import swtech.pageDesignControl.entity.MyStoreManagement;

import java.util.List;
import java.util.Map;

public interface MyStoreManagementAllDao {


    /**
     * 店铺操作
     */
    ReturnMsg insertMyStoreManagement(MyStoreManagement myStoreManagement);

    ReturnMsg selectMsmAll();

//	MyStoreManagement selectSm();

    /**
     * 商品操作
     */
    ReturnMsg insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity);

    ReturnMsg selectAll(String nodeIdqwe);

    ReturnMsg updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity);

    ReturnMsg selectByPrimaryKey(Integer bcId);

    ReturnMsg deleteByPrimaryKeyCommodity(Integer bcId);

    ReturnMsg updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity  myBeautyCommodity);

//	MyBeautyCommodity  selectByPrimaryKeyBeautyCommodity(Integer bcId);

    /**
     * 预订操作
     */
    ReturnMsg insertSelectiveMyReservation(MyReservation record);

    ReturnMsg selectReserva(Integer mrStatus);

    ReturnMsg updReserva(MyReservation record);

    ReturnMsg selectCode(Integer Code);

    ReturnMsg selectMrRid(Integer mrRid);



}
