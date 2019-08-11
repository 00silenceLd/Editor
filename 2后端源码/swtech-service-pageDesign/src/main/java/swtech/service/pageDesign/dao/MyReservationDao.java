package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.MyReservation;

public interface MyReservationDao extends BaseDao<MyReservation>{
//    int deleteByPrimaryKey(Integer mrRid);
//
//    int insert(MyReservation record);
//
    int insertSelectiveMyReservation(MyReservation record);
    
    List<Integer>  useTheCode();
    
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