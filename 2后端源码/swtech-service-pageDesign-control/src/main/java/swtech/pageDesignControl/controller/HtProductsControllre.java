package swtech.pageDesignControl.controller;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtProducts;
import swtech.pageDesignControl.entity.HtProductsPicture;
import swtech.pageDesignControl.service.HtProductsPictureDao;
import swtech.pageDesignControl.service.HtproductsDao;



/**
 * 袁君选
 * @author Administrator
 *	餐品上传操作
 */

@RestController
@CrossOrigin
@RequestMapping(value="/htProductsFacade")
public class HtProductsControllre {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtProductsControllre.class);
	
	@Autowired
	private HtproductsDao htproductsDao;
	
	@Autowired
	private HtProductsPictureDao htProductsPictureDao;

	/**
	 * 餐品上传
	 * 袁君选
	 */
	@RequestMapping(value = "/insertSelectiveProducts",method = RequestMethod.POST)
	public ReturnMsg insertSelectiveProducts(@RequestBody  HtProducts htProducts) {
	
		System.out.println(htProducts.toString());

		ReturnMsg msg = new ReturnMsg(); 
		try {
			msg = htproductsDao.insertSelectiveProducts(htProducts);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping("/allProducts")
	public ReturnMsg allProducts(Integer productsCategory) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = htproductsDao.allProducts(productsCategory);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;

		// TODO Auto-generated method stub
//		System.out.println(productsCategory);
//		return htproductsDao.allProducts(productsCategory);
	}

	@RequestMapping(value = "/selectByPrimaryKey")
	public ReturnMsg selectByPrimaryKeyProducts( Integer productsId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = htproductsDao.selectByPrimaryKeyProducts(productsId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;

//		HtProducts htProducts = htproductsDao.selectByPrimaryKeyProducts(productsId);
//			System.out.println(htProducts);
//
//		return htProducts;
	}

	@RequestMapping(value = "/insertSelectiveHtProductsPicture",method = RequestMethod.POST)
	public ReturnMsg insertSelectiveHtProductsPicture(@RequestBody HtProductsPicture htProductsPicture) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = htProductsPictureDao.insertSelectiveHtProductsPicture(htProductsPicture);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
		// TODO Auto-generated method stub
//		System.out.println("fasdfas");
//		System.out.println(htProductsPicture.getHppUrl());
//		return htProductsPictureDao.insertSelectiveHtProductsPicture(htProductsPicture);
	}

	@RequestMapping("/theme")
	public ReturnMsg theme(Integer nodeIdqwe) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg =  htProductsPictureDao.theme(nodeIdqwe);
		} catch (Exception e) {
			e.printStackTrace();
//			logger.in
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
//		// TODO Auto-generated method stub
//		return htProductsPictureDao.theme();
	}

}
