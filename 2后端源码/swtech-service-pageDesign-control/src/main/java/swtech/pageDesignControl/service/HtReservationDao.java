package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReservation;

import java.util.List;
import java.util.Map;



public interface HtReservationDao {

  /*  ReturnMsg deleteByPrimaryKeyReservation(Integer rid);

    ReturnMsg insertReservation(HtReservation record);

    ReturnMsg insertSelectiveReservation(HtReservation record);

    ReturnMsg selectByPrimaryKeyReservation(Integer rid);

    ReturnMsg updateByPrimaryKeySelectiveReservation(HtReservation record);

    ReturnMsg updateByPrimaryKeyReservation(HtReservation record);*/

//    ReturnMsg latestData();

  /*  ReturnMsg  useTheCode();

    ReturnMsg getReservationId();*/

//    ReturnMsg ordercentel();
//
//    ReturnMsg orderdetails(Integer reBeiId);
//
//    ReturnMsg allorder(Integer shopcarStatus);
//
//    ReturnMsg confirm(Integer reBeiId);

    /*ReturnMsg orderIdrid(HtReservation htReservation);

    ReturnMsg estimateReoid(Integer reBeiId);*/


    /**
     * fac
     */
    ReturnMsg reservation(HtReservation htReservation);

    ReturnMsg latestData();

    ReturnMsg cencel(HtReservation htReservation);

    ReturnMsg ordercentel();

    ReturnMsg orderdetails(Integer reBeiId);

    ReturnMsg allorder(Integer shopcarStatus);

    ReturnMsg confirm(Integer reBeiId);
}
