package swtech.facade.pageDesign.service;


import java.util.List;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.entity.WebUrlManage;



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
 * @ClassName: WebUrlManageFacade
 * @author 曾智宏
 * @date 2019年7月20日
 * @Description: 
 * 对编辑器中a标签跳转地址进行管理
 *
 */

public interface WebUrlManageFacade {
	//保存。修改编辑器允许跳转的WebUrl
	public ReturnMsg saveWebUrl(WebUrlManage webUrlManage);
	//删除编辑器允许跳转的WebUrl
	public ReturnMsg deleteWebUrl(List<Integer> idList);
	//查询所有编辑器允许跳转的WebUrl
	public LayuiTabReturn getAllWebUrl(Integer page, Integer limit);



}
