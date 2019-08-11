package swtech.facade.pageDesign.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.entity.WebUrlManage;
import swtech.facade.pageDesign.service.WebUrlManageFacadeService;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.WebUrlManageDao;


/*
 * 

 ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 * @ClassName: WebUrlManageFacadeServiceImpl
 * @author 曾智宏
 * @date 2019年7月20日
 * @Description:
 * a标签跳转地址管理 业务层
 *
 */
@Component
public class WebUrlManageFacadeServiceImpl implements WebUrlManageFacadeService {
	private static final Logger log = LoggerFactory.getLogger(WebUrlManageFacadeServiceImpl.class);

	@Autowired
	private WebUrlManageDao webUrlManageDao;


	@Override
	public LayuiTabReturn getAllWebUrl(Integer page, Integer limit) {
		LayuiTabReturn msg = new LayuiTabReturn();

		//检查合法性
		if(page==null)throw new ServiceException("page不能为空");
		if(limit==null)throw new ServiceException("limit不能为空");

		//查询所有webUrl，并进行分页
		List<WebUrlManage> webUrlManageList = webUrlManageDao.getAllWebUrl(page,limit);
		log.info(webUrlManageList.toString());

		List<WebUrlManage> webUrlManageList2 = new ArrayList<WebUrlManage>();
		for(WebUrlManage w :webUrlManageList) {//遍历，查出所有的 用户名，并重新封装
			Integer createUid = w.getCreateUid();
			Integer updateUid = w.getUpdateUid();

			String createUserName = webUrlManageDao.getUserNameByUid(createUid);
			String updateUserName = webUrlManageDao.getUserNameByUid(updateUid);
			w.setCreateUserName(createUserName);
			w.setUpdateUserName(updateUserName);

			webUrlManageList2.add(w);
		}

		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(webUrlManageList2);
		msg.setCount(webUrlManageList2.size());
		return msg;
	}

	@Override
	@Transactional
	public ReturnMsg deleteWebUrl(List<Integer> idList) {
		ReturnMsg msg = new ReturnMsg();

		if(idList==null||idList.size()==0)throw new ServiceException("ids不能为空");
		
		for(Integer id :idList) {//遍历删除
			
			Integer row = webUrlManageDao.deleteWebUrl(id);
			if(row == 0)throw new ServiceException("删除Url失败");
		}
		


		msg.setStatus("200");
		msg.setStatusMsg("删除成功");
		return msg;
	}

	@Override
	@Transactional
	public ReturnMsg saveWebUrl(WebUrlManage webUrlManage) {
		ReturnMsg msg = new ReturnMsg();
		
		//检查合法性
		Integer id = webUrlManage.getId();
		String webUrl = webUrlManage.getWebUrl();
		if(StringUtils.isBlank(webUrl))throw new ServiceException("webUrl不能为空");
		
		if(id==null) {//保存
			Integer createUid = webUrlManage.getCreateUid();
			if(createUid==null)throw new ServiceException("createUid不能为空");
			
			//保存进数据库
			webUrlManage.setUpdateUid(createUid);
			webUrlManage.setCreateTime(new Date());
			webUrlManage.setUpdateTime(new Date());
			Integer row = webUrlManageDao.saveWebUrl(webUrlManage);
			if(row == 0)throw new ServiceException("保存Url失败");
			msg.setStatusMsg("保存成功");
		}else {//修改
			Integer updateUid = webUrlManage.getUpdateUid();
			if(updateUid==null)throw new ServiceException("updateUid不能为空");
			
			//修改数据库
			webUrlManage.setUpdateTime(new Date());
			Integer row = webUrlManageDao.updateWebUrl(webUrlManage);
			if(row == 0)throw new ServiceException("修改Url失败");
			msg.setStatusMsg("修改成功");
		}
		msg.setStatus("200");
		return msg;
	}




}
