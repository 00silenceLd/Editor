package swtech.service.pageDesign.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.WebUrlManage;
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
 * @ClassName: WebUrlManageDaoImpl
 * @author 曾智宏
 * @date 2019年7月20日
 * @Description: 
 * a标签地址跳转管理dao实现类
 *
 */

@Repository("webUrlManageDao")
//@Transactional
public class WebUrlManageDaoImpl extends BaseDaoImpl<WebUrlManage> implements WebUrlManageDao{
	private static final Logger log = LoggerFactory.getLogger(WebUrlManageDaoImpl.class);

	@Override
	public List<WebUrlManage> getAllWebUrl(Integer page, Integer limit) {
		Integer begin = page*limit-limit;
		Map<String, Integer> pageMap = new HashMap<String,Integer>();
		pageMap.put("begin", begin);
		pageMap.put("limit", limit);

		List<WebUrlManage> webUrlManageList = 
				getSessionTemplate().selectList("getAllWebUrl",pageMap);

		return webUrlManageList;
	}

	@Override
	public String getUserNameByUid(Integer uid) {
		Map<String, String> resultMap = new HashMap<String,String>();
		resultMap = getSessionTemplate().selectOne("getUserNameByUid",uid);
		String chinese_name;
		String username;
		if(resultMap!=null) {
			chinese_name = resultMap.get("chinese_name");
			username = resultMap.get("username");
		}else {
			chinese_name = "胜网坤智无名氏";
			username = "胜网坤智无名氏";
		}

		if(chinese_name==null) {
			return username;
		}else {
			return chinese_name;
		}

	}

	@Override
	public Integer saveWebUrl(WebUrlManage webUrlManage) {
		Integer row = getSessionTemplate().insert("saveWebUrl", webUrlManage);
		return row;
	}

	@Override
	public Integer updateWebUrl(WebUrlManage webUrlManage) {
		Integer row = getSessionTemplate().update("updateWebUrl", webUrlManage);
		return row;
	}

	@Override
	public Integer deleteWebUrl(Integer id) {
		Integer row = getSessionTemplate().delete("deleteWebUrl", id);
		return row;
	}






}
