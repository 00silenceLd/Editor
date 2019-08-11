package swtech.facade.pageDesign.service;

import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;

public interface PageDesignQueryFacade {
	// 获取表单内容页
	public ReturnMsg getPageContent(long id);

	// 获取关联表单内容页
	public ReturnMsg getPageContent(Integer id, long gid);

	// 获取表单数据字段
	public ReturnMsg getPageEditorData(long nodeId);

	// 搜索热区关键字
	public ReturnMsg searchWifiKey(String data);

	// 查询数据库表名称
	public ReturnMsg searchDatabase(String baseName);

	// 查询数据表字段名
	public ReturnMsg searchDataField(String baseName, String tableName);

	// 查询数据表字段名
	public ReturnMsg selectFormRecordByNodeId(String record );

	// 获取分组标签
	public ReturnMsg getInformGroupTags();

	// 级联分类查询
	public ReturnMsg getCascadeClassify(Integer rootId);
	
	// 根据父id查询子分类
	public ReturnMsg getclassifyByParentId(Integer pid);
	
	// 根据uId获取同组织所有分类
	public ReturnMsg getAllCascadeClassify(Integer uId);
	
	/**
	 * 搜索控件之根据名字查询该表的字段名及其备注(注意)
	 */
	public ReturnMsg getTableInformationByName(String tableName);
	/**
	 * 搜索控件 (根据不定数据源及不定搜索条件搜索)
	 */
	public ReturnMsg selectDynamicSearch(JSONObject record);
	
	// 获取组织及子组织下的所有用户
	//public List<Integer> getAllUidByRoleId(Integer roleId);
	
	//查询用户是否有访问编辑器权限(0:否;1:是)
	public ReturnMsg getAdminWebshell(Integer uId);
	
	//临时写的注册编辑器
	public ReturnMsg registerWebShell(JSONObject json);
	//临时写的登录编辑器
	public ReturnMsg logWebShell(JSONObject json);
	public ReturnMsg getAdminWebShell();
	public ReturnMsg updateAdminWebShell(Integer id,Integer isdelete);
	
	public ReturnMsg getPageControl( long node_id);
	
	
	//根据nodeId查询对应的表，再从表中根据selectId查
	//public ReturnMsg selectTableByNodeIdAndId(JSONObject record);
	public ReturnMsg selectTableByNodeIdAndId(Integer nodeId,String selectId);
	//根据nodeId查询对应的表，再从表中根据selectId删除
	public ReturnMsg deleteTableByNodeIdAndId(Integer nodeId,String selectId);
}
