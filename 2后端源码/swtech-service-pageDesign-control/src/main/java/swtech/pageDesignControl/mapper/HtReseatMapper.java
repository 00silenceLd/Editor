package swtech.pageDesignControl.mapper;

import swtech.pageDesignControl.entity.HtReseat;

import java.util.List;
import java.util.Map;



public interface HtReseatMapper {
	 List<HtReseat>  resertall();

	 int insertSelectiveReseat(HtReseat htReseat);
	
	 int delseat();
	 
//	 int updseat(List<String> seatnum);
	 int updseat(Map<String, Object> upd);
	 
	 List<HtReseat> selno(Integer seatstatus);

}
