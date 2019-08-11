package swtech.service.pageDesign.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CommentInfo;
import swtech.facade.pageDesign.entity.HerdNode;
import swtech.facade.pageDesign.entity.HtCategory;
import swtech.facade.pageDesign.service.HtCategoryFacade;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.HtCategoryDao;

import javax.annotation.Resource;
import javax.ws.rs.QueryParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("HtCategoryDao")
public class HtCategoryDaoimpl extends BaseDaoImpl<HtCategory> implements HtCategoryDao {

 
    @Override
    public ReturnMsg insertSelectiveIn(String record){
    	ReturnMsg msg = new ReturnMsg(); 
    	
		//验证参数合法性

		if(record==null)throw new ServiceException("record不能为空");
	
		//封装参数，查询数据库
		HtCategory params = new HtCategory(record);
		
		Integer insertSelectiveIn = getSessionTemplate().insert("insertSelectiveIn", params);

		//对查询结果进行判断

		if(insertSelectiveIn!=0) {	
			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
		}else {
			msg.setStatus("108");
			msg.setStatusMsg("添加失败");
		}

		
		return msg;
   
    }

 

    @Override
    public List<HtCategory> all() {
    	return getSessionTemplate().selectList("all");
    }
}
