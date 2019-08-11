package swtech.facade.pageDesign.service;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.PageEditor;

public interface PageDesignOperatorFacade {
	
	public ReturnMsg saveDesignPage(PageEditor pageEditor); 
	
	/**
	 * 添加数据
	 * */
	public ReturnMsg insertFormRecord(String record); 
	/**
	 * 删除数据
	 * */
	public ReturnMsg deleteFormRecord(String record); 
	/**
	 * 更新数据
	 * */
	public ReturnMsg updateFormRecord(String record); 
	/**
	 * 查询数据
	 * */
	public ReturnMsg selectFormRecord(String record); 
	
	/**
	 * 批量删除数据
	 * */
	public ReturnMsg deleteArray(String record);
	
	/**
	 * 更新隐藏显示selected
	 * */
	public ReturnMsg updatePageEditor(String record);
	
	/**
	 * 分页查询
	 * */
	public ReturnMsg getQueryPage(String record);
	
	/**
	 * 回收站恢复
	 * */
	public ReturnMsg reNewData(String record);
	
	/**
	 * 在线更新功能 beta1.0
	 * */
	public ReturnMsg updateEditor();
	
	/**
	 * 在线更新功能 beta2.0
	 * */
	public ReturnMsg update(Integer nodeId);
	
	/**
	 * 数据查询
	 * */
	public ReturnMsg getDataSource(String data);
	
	/**
	 * 评论控件回复插入
	 * */
	public ReturnMsg insertComment(String data);
	

	/**
	 * 发布上传资源功能
	 * */
	public ReturnMsg ReleaseResources(PageEditor pageEditor);
	
	//------------------分类树形控件----------------------//
	//删除分类树形控件
	public ReturnMsg delSort(int id);
	//更新分类树形控件
	public ReturnMsg upSort();
	//添加分类树形控件
	public ReturnMsg addSort();
	
	//--------------//
	//获取课程搜索条件
	public ReturnMsg getCourseEq();
	
	//按条件搜索课程
	public ReturnMsg searchCourse(JSONObject json);	
	
	/**
	 * 级联分类增加
	 */
	public ReturnMsg addCascadeClassify(JSONObject record);
	
	/**
	 * 级联分类删除
	 */
	public ReturnMsg delCascadeClassify(Integer id);
	
	/**
	 * 级联分类修改
	 */
	public ReturnMsg updateCascadeClassify(JSONObject record);
	
	/**
	 * 搜索控件
	 */
	public ReturnMsg  addSearchControl(JSONObject record);
	
	/**
	 * 生成静态页面
	 */
	public ReturnMsg creatStaticPage(JSONObject record);
	/**
	 * 
	 * @Description: TODO
	 * @param @param 发送模板消息
	 * @param @return   
	 * @return ReturnMsg  
	 * @throws
	 * @author 张宇
	 * @date 2018年9月21日下午7:00:39
	 */
	public ReturnMsg jointTemplateMsg(JSONObject data);
	
	/**
	 * @Description: ajax修改控件
	 * @param record
	 * @return 200 成功 ;400 失败
	 * @throws
	 * @author pyb
	 * @date 2018.10.06
	 */
	public ReturnMsg updateControl(JSONObject record);
	/**
	 * @Description: ajax增加控件
	 * @param record
	 * @return 200 成功 ;400 失败
	 * @throws
	 * @author pyb
	 * @date 2018.10.06
	 */
	public ReturnMsg insertControl(JSONObject record);
	/**
	 * @Description: 删除控件
	 * @param record
	 * @return 200 成功 ;400 失败
	 * @throws
	 * @author pyb
	 * @date 2018.10.06
	 */
	public ReturnMsg deleteControl(JSONObject record);
	
	public ReturnMsg contrastiveAnalysis(JSONObject record);
	
	/**
	 * 导出Excel表格方法derivedForm
	 */
	public ReturnMsg derivedForm(JSONObject record);
	
	/**
	 * 根据树形节点id删除对应的表与下属的表接方法deleteTableById
	 */
	public ReturnMsg deleteTableById(JSONObject record);
	
	public ReturnMsg importExportSqlFile(JSONObject record);
}
