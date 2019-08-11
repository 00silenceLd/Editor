package swtech.facade.pageDesign.service.impl;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HtCategory;
import swtech.facade.pageDesign.service.HtCategoryFacade;
import swtech.service.pageDesign.dao.HtCategoryDao;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.List;

/**
 * 袁君选
 * @author Administrator
 *	添加类别操作
 */
@Path("htCategoryFacade")
@Component("htCategoryFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class HtCategoryDaoFacadeimpl implements HtCategoryFacade {
	@Resource
	private   HtCategoryDao htCategoryDao;



	@POST
	@Path("/insertSelectiveIn")
	public ReturnMsg insertSelectiveIn(String record) {
		System.out.println("nodeId="+record);
		JSONObject jsonObj = JSONObject.parseObject(record);
		record =jsonObj.getString("record");
		System.out.println(record);
		ReturnMsg msg = new ReturnMsg(); 
		try {
			msg = htCategoryDao.insertSelectiveIn(record);
			//			log.info("这里是service实现类");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg(e.getMessage());
		}
		return msg;
	}

	@POST
	@Path("/all")
	public List<HtCategory> all() {
		return htCategoryDao.all();
	}
}
