package swtech.pageDesignControl.controller;





import com.sun.org.apache.bcel.internal.classfile.Code;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.MyBeautyCommodity;
import swtech.pageDesignControl.entity.MyReservation;
import swtech.pageDesignControl.entity.MyStoreManagement;

import swtech.pageDesignControl.service.MyStoreManagementAllDao;


/**
 * 美业操作
 * @author 袁君选
 *
 */

@RestController
@RequestMapping(value="/myStoreManagementFacade")
@CrossOrigin
public class MyStoreManagementControllre {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(MyStoreManagementControllre.class);
	
	@Autowired
	private MyStoreManagementAllDao myStoreManagementAllDao;



	/**
	 * 店铺上传操作
	 */
	@RequestMapping(value = "/insertMyStoreManagement",method = RequestMethod.POST)
	public ReturnMsg insertMyStoreManagement(@RequestBody MyStoreManagement myStoreManagement) {
		// TODO Auto-generated method stub

		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.insertMyStoreManagement(myStoreManagement);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/selectMsmAll",method = RequestMethod.GET)
	public  ReturnMsg selectMsmAll(){
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.selectMsmAll();
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}
	
//	@POST
//	@Path("/selectSm")
//	public MyStoreManagement selectSm() {
//		// TODO Auto-generated method stub
//		return myStoreManagementDao.selectSm();
//	}

	/**
	 * 商品上传操作
	 */
//	@POST
//	@Path("/selectByPrimaryKeyBeautyCommodity")
//	public MyBeautyCommodity selectByPrimaryKeyBeautyCommodity(Integer bcId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@RequestMapping(value = "/updateByPrimaryKeySelectiveCommodity",method = RequestMethod.POST)
	public ReturnMsg updateByPrimaryKeySelectiveCommodity(@RequestBody MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.updateByPrimaryKeySelectiveCommodity(myBeautyCommodity);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping("/deleteByPrimaryKeyCommodity")
	public ReturnMsg deleteByPrimaryKeyCommodity( Integer bcId) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.deleteByPrimaryKeyCommodity(bcId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/insertMyBeautyCommodity",method = RequestMethod.POST)
	public ReturnMsg insertMyBeautyCommodity(@RequestBody MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.insertMyBeautyCommodity(myBeautyCommodity);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/selectAll",method = RequestMethod.GET)
	public ReturnMsg selectAll(String nodeIdqwe) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.selectAll(nodeIdqwe);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
	public ReturnMsg updateByPrimaryKeySelective(@RequestBody MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.updateByPrimaryKeySelective(myBeautyCommodity);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping("/selectByPrimaryKey")
	public ReturnMsg selectByPrimaryKey(Integer bcId) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.selectByPrimaryKey(bcId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}
	/**
	 * 预订
	 */

	@RequestMapping(value = "/insertSelectiveMyReservation",method = RequestMethod.POST)
	public ReturnMsg insertSelectiveMyReservation(@RequestBody MyReservation record) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.insertSelectiveMyReservation(record);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping("/selectReserva")
	public ReturnMsg selectReserva(Integer mrStatus) {
		// TODO Auto-generated method stub

		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.selectReserva(mrStatus);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/updReserva",method = RequestMethod.POST)
	public ReturnMsg updReserva(@RequestBody MyReservation record) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.updReserva(record);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping("/selectCode")
	public ReturnMsg selectCode(@RequestParam("code") Integer Code) {
		// TODO Auto-generated method stub
//		System.out.println(myReservationDao.selectCode(Code));
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.selectCode(Code);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping("/selectMrRid")
	public ReturnMsg selectMrRid( Integer mrRid) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =myStoreManagementAllDao.selectMrRid(mrRid);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	

	

	


}
