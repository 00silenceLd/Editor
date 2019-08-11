package swtech.facade.pageDesign.service;

import java.util.List;
import java.util.Map;

import swtech.facade.pageDesign.entity.HtProducts;
import swtech.facade.pageDesign.entity.HtReservation;

public interface HtReservationFacade {

    
//    htReservation.get 
    int reservation(HtReservation htReservation);
    
    HtReservation latestData();
    
    int cencel(HtReservation htReservation);
    
    List<Map<String, Object>> ordercentel();
    
    List<Map<String, Object>> orderdetails(Integer reBeiId);
    
    List<HtReservation> allorder(Integer shopcarStatus);
    
    int confirm(Integer reBeiId);
}
