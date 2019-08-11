package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtShopcar;

import java.util.List;
import java.util.Map;



public interface HtShopcarDao {


    ReturnMsg insertSelectiveShopCar(HtShopcar record);

    ReturnMsg allHtShopcar();

    ReturnMsg deleteByPrimaryKeyShopCar(Integer productsId);

    ReturnMsg emptyCart();

    ReturnMsg updateStatus(Integer getReservationId);

    ReturnMsg  allorder(Integer shopBeiId);

    ReturnMsg cancelorder(Integer shopBeiId);

    ReturnMsg paynow(HtShopcar htShopcar);
}