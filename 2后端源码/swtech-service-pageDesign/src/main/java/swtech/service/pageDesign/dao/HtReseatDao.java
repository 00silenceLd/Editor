package swtech.service.pageDesign.dao;

import java.util.List;
import java.util.Map;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.HtReseat;

public interface HtReseatDao extends BaseDao<HtReseat>{
	List<HtReseat>  resertall();

	int	insertSelectiveReseat(HtReseat htReseat); 
	
	 int delseat();
	 
//	 int updseat(List<String> seatnum);
	 int updseat(Map<String, Object> upd);
	 
	 List<HtReseat> selno(Integer seatstatus);

}
