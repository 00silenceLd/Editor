package swtech.pageDesignControl.controller;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import swtech.pageDesignControl.common.vo.ReturnMsg;

import swtech.pageDesignControl.entity.HtShopcar;
import swtech.pageDesignControl.service.HtShopcarDao;

/**
 * 餐品加减操作
 * @author 袁君选
 *
 */
@RestController
@RequestMapping(value="/htShopcarFacade")
@CrossOrigin
public class HtShopcarControllre {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtShopcarControllre.class);

	@Autowired
	private HtShopcarDao htShopcarDao;
	
//	@Autowired
//	private HtReservationDao htReservationDao;

	@RequestMapping(value = "/insertSelectiveShopCar",method = RequestMethod.POST)
	public ReturnMsg  insertSelectiveShopCar(@RequestBody HtShopcar record) {
//		System.out.println(record.toString());
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htShopcarDao.insertSelectiveShopCar(record);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		
	}

	@RequestMapping("/allHtShopcar")
	public ReturnMsg allHtShopcar() {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htShopcarDao.allHtShopcar();
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return  msg;
	}

	@RequestMapping("/deleteByPrimaryKeyShopCar")
	public ReturnMsg deleteByPrimaryKeyShopCar(Integer productsId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htShopcarDao.deleteByPrimaryKeyShopCar(productsId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return  msg;
	}

	@RequestMapping("/emptyCart")
	public ReturnMsg emptyCart() {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htShopcarDao.emptyCart();
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return  msg;
	}

	@RequestMapping("/allorder")
	public ReturnMsg allorder(Integer shopBeiId) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htShopcarDao.allorder(shopBeiId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return  msg;
	}

	/**
	 * 立即支付
	 * 袁君选
	 */
	@RequestMapping(value = "/paynow",method = RequestMethod.POST)
	public ReturnMsg paynow(@RequestBody HtShopcar htShopcar) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =htShopcarDao.paynow(htShopcar);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return  msg;
	}

	

}
