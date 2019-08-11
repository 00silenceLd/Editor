package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReseat;

import java.util.List;
import java.util.Map;



public interface HtReseatDao{
	ReturnMsg resertall(Integer seatstatus);

	ReturnMsg	insertSelectiveReseat(HtReseat htReseat);

	ReturnMsg delseat();
	 
//	 int updseat(List<String> seatnum);
    ReturnMsg updseat(String snum,Integer updsert);

	ReturnMsg selno(Integer seatstatus);

}
