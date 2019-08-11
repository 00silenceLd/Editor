package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.WebUrlManage;

public interface WebUrlManageDao extends BaseDao<WebUrlManage>{

	List<WebUrlManage> getAllWebUrl(Integer page, Integer limit);


	String getUserNameByUid(Integer createUid);


	Integer saveWebUrl(WebUrlManage webUrlManage);


	Integer updateWebUrl(WebUrlManage webUrlManage);


	Integer deleteWebUrl(Integer id);





}
