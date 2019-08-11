package swtech.facade.pageDesign.service;

import java.util.List;
import java.util.Map;

import swtech.facade.pageDesign.entity.HtReseat;

public interface HtReseatFacade {
//	List<HtReseat>  resertall();
	Map<String, Object> resertall(Integer seatstatus);
	 
    int	insertSelectiveReseat(HtReseat htReseat); 
    
    int delseat();
    
    int updseat(String snum,Integer updsert);

}
