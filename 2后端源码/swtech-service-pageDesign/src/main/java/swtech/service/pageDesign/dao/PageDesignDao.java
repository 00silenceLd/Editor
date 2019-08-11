package swtech.service.pageDesign.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import swtech.common.core.dao.BaseDao;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CascadeClassify;
import swtech.facade.pageDesign.entity.KePuVideo;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.PaiCourse;
import swtech.facade.pageDesign.entity.PushMsg;
import swtech.facade.pageDesign.entity.QueryVo;
import swtech.facade.pageDesign.entity.SearchControl;
import swtech.facade.pageDesign.entity.SortChildren;
import swtech.facade.pageDesign.entity.UserHasNode;
import swtech.facade.pageDesign.entity.WebShell;

public interface PageDesignDao extends BaseDao<PageEditor> {  
	public ReturnMsg savePage(PageEditor pageEditor);
	
	public PageEditor getByNodeId(long id);
	//获取表单内容
	public ReturnMsg getPageEditor(Long node_id,String key,String groupCon,String wifiField,String nodeName);
	//更新文件
	public int updatePageEditor(PageEditor page);
	//添加文件
	public int addPageEditor(PageEditor page);
	//绑定结点
	public int addUserNode(UserHasNode user);
	//查询node_id是否存在
	public int getCountForNodeId(Map<String, Object> param);
	//更新文件id_delete 状态
	public int updateIsDelete(Map<String, Object> param);
	//获取表单对象
	public PageEditor selectPageEditor(long id);
	//获取关联表单内容
	public ReturnMsg getPageEditorGid(Integer node_id, Long gid, String value);
	//回复评论
	public ReturnMsg insertComment(String content, String field, Integer contentId, String userName, String datasource, Integer nodeId);
	//发布资源提交表单
	public ReturnMsg ReleaseResources(PageEditor pageEditor);
	//删除分类节点
	public int delSort(int id);
	//更新分类节点
	public int upSort(SortChildren sort);
	//添加分类节点
	public int addSort(SortChildren sort);  
	//查询表名称
	public List<String> searchDatabase(String baseName);
	//查询字段名
	public List<String> searchDataField(String baseName,String tableName);
	//查看课程条件
	public List<Map> getCourseEq();
	//按条件搜索课程信息
	public List<Map> searchCourse(JSONObject json);

	//根据根节点获取分类对象
	public CascadeClassify getCascadeClassifyByRootId(Integer rootId);
	//删除分类节点
	public void delCascadeClassifyById(Integer id);
	//添加分类记录
	public Integer insertCascadeClassifyRecord(CascadeClassify classify);
	//根据父节点获取子节点
	public List<Map> getCascadeClassifyByParentId(int rootId);
	//修改分类信息
	public void updateCascadeClassify(CascadeClassify classify);

	//根据中文名字转换拼音，拼音缩写即表名，查出该表字段名及备注
	public List<Map> getTableInformationByName(String tableName);
	
	//根据中文名字转换拼音，拼音缩写即表名，查出该表所有字段名
	public List<String> getTableFieldionByName(String tableName);
	
	//搜索控件
	public Integer insertSearchControlRecord(SearchControl searchControl);
	/**
	 * 搜索控件 (根据不定数据源及不定搜索条件搜索)
	 */
	public List<Map> selectDynamicSearch(QueryVo vo);

	
	//根据用户id获取openid
	public Map getUserWxOpenidByUid(int uId);

	//根据分组获取用户openid
	public List<Map> getUserWxOpenidByGroup(Integer groupId);

	public List<Map> getAllCascadeClassify();

	//根据用户id获取组织分类
	public List<CascadeClassify> getRoleClassifyIdByUid(Integer uId);

	//获取大于当前的组织id和父id
	public List<Map> getRoleByThanRoleId(Integer roleId);

	public List<Map> getUserWeiXinOpenidByUserList(List list);

	public List<Integer> getUserWeiXinOpenidByRoleIdList(List<Integer> paramList);

	public List<Integer> getUserWeiXinOpenidByPidList(List<Integer> paramList);

	public void insertPushMsg(PushMsg push);

	public void insertPushReceive(Map param);
	
	public Map selectWebshell(Integer uId);
	
	public int registerWebShell(String username,String password,String chinesename);
	
	public WebShell logWebShell(String username,String password);

	public List<Map> selectUserMobileByuIds(List list);

	public List<Map> getWebShell();
	
	public void updateWebShell(Integer id,Integer isdelete);
	
	public Map getNodeByNodeId(long nodeId);
	
	/**
	 * 科普视频资源库
	 */
	public int getKPCount();
	
	public List<KePuVideo> getKPQueryPage(Map map);
	
	//ajax修改控件
	public void updateControl(Map map);
	
	/**
	 * 导出Excel表格方法derivedForm
	 */
	public List<Map> derivedForm(Map map);
	
	//增加控件
	public void insertControl(Map map);
	
	//删除控件
	public void deleteControl(Map map);
	/**
	 * 排课管理
	 */
	public int getPaiCourseCount();
	
	public List<PaiCourse> getPaiCourseQueryPage(Map map);
	
	//获取页面表单控件
	public PageEditor getPageControl(long node_id);

	//根据树形节点查询对应的表与下属的表
	public List<Map> selectTableById(Map map);

	//根据树形节点删除对应的表与下属的表接方法deleteTableById
	public int deleteTableById(Map map);

	//删除表购买选项记录
	public void deleteNodeRecordById(Map map);

	public int checkColumn(String column, String shareToName);
	//根据nodeId查询对应的表，再从表中根据selectId查
	public List<Map> selectTableByNodeIdAndId(Map<String, Object> map);
	//public List<Map> selectTableByNodeIdAndId(String node_name, Integer selectId);
	//根据nodeId查询对应的表，再从表中根据selectId删除
	public int deleteTableByNodeIdAndId(Map<String, Object> map);

	//根据nodeId获取数据表名
	public String getNodeNameByNodeId(Integer dataTableId);
}
