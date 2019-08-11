package swtech.pageDesignControl.controller;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReservation;
import swtech.pageDesignControl.service.HtReservationDao;



/**
 * 袁君选
 * @author Administrator
 *	餐品上传操作
 */


@RestController
@CrossOrigin
@RequestMapping(value="/htReservationFacade")
public class HtReservationControllre {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtReservationControllre.class);
	
//	@Autowired
//	private HtShopcarDao htShopcarDao;
	
	@Autowired
	private HtReservationDao htReservationDao;

	

	/**
	 * 餐品预订
	 * 袁君选
	 */
	@RequestMapping("/reservation")
	public ReturnMsg reservation(@RequestBody HtReservation htReservation) {
		ReturnMsg msg = new ReturnMsg();
		try {

			msg  = htReservationDao.reservation(htReservation);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;

		// TODO Auto-generated method stub

//		return 0;
	}

	/**
	 * 预订成功
	 * 袁君选
	 */
	@RequestMapping("/latestData")
	public ReturnMsg latestData() {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htReservationDao.latestData();
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
//		HtReservation latestData = htReservationDao.latestData();
//		return latestData;
	}
	
	/**
	 * 取消订单
	 * 袁君选
	 */
	@RequestMapping(value = "/cencel",method = RequestMethod.POST)
	public ReturnMsg cencel(@RequestBody HtReservation htReservation) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htReservationDao.cencel(htReservation);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub


//		return 0;
	}

	/**
	 * 订单中心
	 * 袁君选
	 */
	@RequestMapping("/ordercnetel")
	public ReturnMsg ordercentel() {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = htReservationDao.ordercentel();
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
//		List<Map<String, Object>> ordercentel = htReservationDao.ordercentel();
//		return ordercentel;
	}

	/**
	 * 订单详情
	 * 袁君选
	 */
	@RequestMapping("/orderdetails")
	public ReturnMsg orderdetails(Integer reBeiId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htReservationDao.orderdetails(reBeiId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
//		List<Map<String,Object>> orderdetails = htReservationDao.orderdetails(reBeiId);
//		return orderdetails;
	}

	/**
	 * 已预订
	 * 袁君选
	 */
	@RequestMapping("/all")
	public ReturnMsg allorder(Integer shopcarStatus) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htReservationDao.allorder(shopcarStatus);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
//		return htReservationDao.allorder(shopcarStatus);
	}
	
	/**
	 * 确认跳转
	 */
	@RequestMapping("/confirm")
	public ReturnMsg confirm(Integer reBeiId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htReservationDao.confirm(reBeiId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
//		int estimateReoid = htReservationDao.estimateReoid(reBeiId);
//		if(estimateReoid==0) {
//			return htReservationDao.confirm(reBeiId);
//		}else {
//			return 0;
//		}
		
	}


}
