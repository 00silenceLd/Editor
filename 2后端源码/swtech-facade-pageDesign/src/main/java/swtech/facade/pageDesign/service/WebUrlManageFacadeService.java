package swtech.facade.pageDesign.service;


import java.util.List;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.entity.WebUrlManage;

/*
 * 
* @ClassName: ScoreFacadeService
* @author 曾智宏
* @date 2019年5月25日
* @Description: 评分控件业务层接口
*
 */

public interface WebUrlManageFacadeService {

	LayuiTabReturn getAllWebUrl(Integer page, Integer limit);

	ReturnMsg deleteWebUrl(List<Integer> idList);

	ReturnMsg saveWebUrl(WebUrlManage webUrlManage);

}
