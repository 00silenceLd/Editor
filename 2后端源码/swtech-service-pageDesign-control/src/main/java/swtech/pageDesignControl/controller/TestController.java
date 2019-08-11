package swtech.pageDesignControl.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.service.TestService;


@RestController
@RequestMapping(value="/test")
@CrossOrigin
public class TestController {
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(TestController.class);

	@Autowired
	private TestService testService;


	@RequestMapping(value="/check",method=RequestMethod.GET)
	public ReturnMsg check() {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = testService.check();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("测试接口失败");
			msg.setMsg(e.getMessage());

		}

		return msg;
	}


}
