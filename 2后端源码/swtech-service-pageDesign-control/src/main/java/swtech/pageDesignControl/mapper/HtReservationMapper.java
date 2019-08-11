package swtech.pageDesignControl.mapper;

import swtech.pageDesignControl.entity.HtReservation;

import java.util.List;
import java.util.Map;



public interface HtReservationMapper {
	
	int deleteByPrimaryKeyReservation(Integer rid);

    int insertReservation(HtReservation record);

    int insertSelectiveReservation(HtReservation record);

    HtReservation selectByPrimaryKeyReservation(Integer rid);

    int updateByPrimaryKeySelectiveReservation(HtReservation record);

    int updateByPrimaryKeyReservation(HtReservation record);
    
    HtReservation latestData();
    
     List<Integer>  useTheCode();
     
    int getReservationId();

    List<Map<String, Object>> ordercentel();
    
    List<Map<String, Object>> orderdetails(Integer reBeiId);
    
    List<HtReservation> allsss(Integer shopcarStatus);
    
    int confirm(Integer reBeiId);
    
    int orderIdrid(HtReservation htReservation);
    
    int estimateReoid(Integer reBeiId);
}
