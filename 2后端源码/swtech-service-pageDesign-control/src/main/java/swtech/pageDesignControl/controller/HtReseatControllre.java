package swtech.pageDesignControl.controller;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReseat;
import swtech.pageDesignControl.service.HtReseatDao;

/**
   *   餐桌操作
 * @author 袁君选
 *
 */

@RestController
@CrossOrigin
@RequestMapping(value="/htReseatFacade")
public class HtReseatControllre {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtReseatControllre.class);
	
	@Autowired
	private HtReseatDao htReseatDao;

	@RequestMapping("/resertall")
//	public List<HtReseat> resertall() {
		public ReturnMsg  resertall(Integer seatstatus) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = htReseatDao.resertall(seatstatus);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
		

//		return htReseatDao.resertall();
//		return all;
	}

	@RequestMapping("/insertSelectiveReseat")
	public ReturnMsg insertSelectiveReseat(@RequestBody HtReseat htReseat) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htReseatDao.insertSelectiveReseat(htReseat);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
//		return htReseatDao.insertSelectiveReseat(htReseat);
	}

	@RequestMapping("/delseat")
	public ReturnMsg delseat() {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htReseatDao.delseat();
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
//		return htReseatDao.delseat();

	}

	@RequestMapping(value = "/updseat",method = RequestMethod.POST)
	public ReturnMsg updseat(String svalue,@RequestParam("updseat") Integer updsert) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = htReseatDao.updseat(svalue,updsert);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub

		
	}

}
