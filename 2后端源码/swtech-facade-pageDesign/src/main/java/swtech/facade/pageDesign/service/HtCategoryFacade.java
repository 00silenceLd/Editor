package swtech.facade.pageDesign.service;



import java.util.List;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HtCategory;

/**
 *       袁君选
 * @author Administrator
 *	新增类别
 */
public interface HtCategoryFacade {

	public ReturnMsg insertSelectiveIn(String record);

    List<HtCategory> all();
}