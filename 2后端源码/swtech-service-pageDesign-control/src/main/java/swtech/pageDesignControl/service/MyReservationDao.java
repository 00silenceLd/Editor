package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReservation;
import swtech.pageDesignControl.entity.MyReservation;

import java.util.List;



public interface MyReservationDao {
//    int deleteByPrimaryKey(Integer mrRid);
//
//    int insert(MyReservation record);
//
    ReturnMsg insertSelectiveMyReservation(MyReservation record);

    ReturnMsg  useTheCode();

    ReturnMsg   selectReserva(Integer mrStatus);

    ReturnMsg updReserva(MyReservation record);

    ReturnMsg  selectCode(Integer Code);

    ReturnMsg selectMrRid(Integer mrRid);


//
//    MyReservation selectByPrimaryKey(Integer mrRid);
//
//    int updateByPrimaryKeySelective(MyReservation record);
//
//    int updateByPrimaryKey(MyReservation record);
}