package swtech.pageDesignControl.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.TestEntity;
import swtech.pageDesignControl.mapper.TestMapper;
import swtech.pageDesignControl.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(TestServiceImpl.class);

	@Autowired
	private TestMapper testMapper;

	@Override
	public ReturnMsg check() {
		ReturnMsg msg = new ReturnMsg();
		logger.info("这里TestServiceImpl");

		List<TestEntity> testEntityList = testMapper.check();
		logger.info(testEntityList.toString());
		if(testEntityList==null)throw new ServiceException("测试返回异常");

		
		TestEntity testEntity = testMapper.selectById(1);
		System.out.println(testEntity);
		
		/*testEntity.setId(null);
		testEntity.setName("很多很多2.0");
		testEntity.setPassword("123456");
		int insertResult = testMapper.insert(testEntity);
		System.out.println("insertResult="+insertResult);
		System.out.println("testEntity的id="+testEntity.getId());*/
		
		
		/*logger.trace("I am trace log.");
		logger.debug("I am debug log.");
		logger.warn("I am warn log.");
		logger.error("I am error log.");*/

		msg.setStatus("200");
		msg.setStatusMsg("测试接口成功");
		msg.setMsg(testEntityList);
		return msg;
	}
	
	

}
