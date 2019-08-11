package swtech.pageDesignControl.mapper;

import swtech.pageDesignControl.entity.MyReservation;

import java.util.List;



public interface MyReservationMapper {
//    int deleteByPrimaryKey(Integer mrRid);
//
//    int insert(MyReservation record);
//
    int insertSelectiveMyReservation(MyReservation record);
    
    List<Integer>  mrAuthCode();
    
    List<MyReservation>   selectReserva(Integer mrStatus);
    
    int updReserva(MyReservation record);
    
    MyReservation  selectCode(Integer Code);
    
    MyReservation selectMrRid(Integer mrRid);
//
//    MyReservation selectByPrimaryKey(Integer mrRid);
//
//    int updateByPrimaryKeySelective(MyReservation record);
//
//    int updateByPrimaryKey(MyReservation record);
}