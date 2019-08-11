package swtech.pageDesignControl.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtCategory;
import swtech.pageDesignControl.mapper.HtCategoryMapper;
import swtech.pageDesignControl.service.HtCategoryDao;






import java.util.List;


@Service
public class HtCategoryServiceimpl implements HtCategoryDao {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtCategoryServiceimpl.class);

 	@Autowired
	private HtCategoryMapper htCategoryMapper;

    @Override
	@Transactional
    public ReturnMsg insertSelectiveIn(String record){
    	ReturnMsg msg = new ReturnMsg();

    	
		//验证参数合法性

		if(record==null)throw new ServiceException("record不能为空");
	
		//封装参数，查询数据库
		HtCategory params = new HtCategory();
		params.setCategoryname(record);

		int i = htCategoryMapper.insertSelectiveIn(params);

		if(i==0)throw new ServiceException("操作失败");
//		Integer insertSelectiveIn = getSessionTemplate().insert("insertSelectiveIn", params);

		//对查询结果进行判断


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(i);



		
		return msg;
   
    }

 

    @Override
	@Transactional
    public ReturnMsg all() {
		ReturnMsg msg = new ReturnMsg();

		List<HtCategory> all = htCategoryMapper.all();

		if(all==null)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(all);

		return msg;
//		return getSessionTemplate().selectList("all");
    }
}
