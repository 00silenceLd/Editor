package swtech.pageDesignControl.controller;



import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;
import swtech.pageDesignControl.common.vo.ReturnMsg;

import swtech.pageDesignControl.service.HtCategoryDao;


/**
 * 袁君选
 * @author Administrator
 *	添加类别操作
 */

@RestController
@CrossOrigin
@RequestMapping(value="/htCategoryFacade")
public class HtCategoryControllre {
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtCategoryControllre.class);


	@Autowired
	private HtCategoryDao htCategoryDao;

	@RequestMapping(value = "/insertSelectiveIn",method =  RequestMethod.POST)
	public ReturnMsg insertSelectiveIn(String record) {

//		System.out.println("nodeId="+record);
//		JSONObject jsonObj = JSONObject.parseObject(record);
//		record =jsonObj.getString("record");
//		System.out.println(record);
		ReturnMsg msg = new ReturnMsg(); 
		try {
			msg = htCategoryDao.insertSelectiveIn(record);
			//			log.info("这里是service实现类");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public ReturnMsg all() {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = htCategoryDao.all();
			//			log.info("这里是service实现类");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("操作失败");
			msg.setMsg(e.getMessage());
			logger.info(e.getMessage());
		}
		return msg;

//		return htCategoryDao.all();
	}
}
