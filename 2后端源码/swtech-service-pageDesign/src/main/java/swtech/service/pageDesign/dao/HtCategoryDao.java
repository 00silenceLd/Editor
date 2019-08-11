package swtech.service.pageDesign.dao;



import java.util.List;

import javax.ws.rs.QueryParam;

import swtech.common.core.dao.BaseDao;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HtCategory;

public interface HtCategoryDao extends  BaseDao<HtCategory>{

	public ReturnMsg insertSelectiveIn (String record);

    List<HtCategory> all();
}