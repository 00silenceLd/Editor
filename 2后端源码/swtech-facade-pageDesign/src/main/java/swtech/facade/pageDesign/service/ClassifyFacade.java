package swtech.facade.pageDesign.service;


import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ClassifyShowRelation;
import swtech.facade.pageDesign.entity.ClassifyTreeInfo;

/**
 *
 * @author 曾智宏
 *
 * @version 1.0
 *
 * 创建时间：2019年4月25日
 *
 * 分类控件相关功能接口
 *
 */

public interface ClassifyFacade {

	/*1.1获取当前编辑器用户的数据表（源），如nodeQueryFacade/getDataSourceByUid?uId=123868*/

	/*1.2获取当前数据表（源）中存放数据的字段，如pageDesignQueryFacade/getPageEditorData?id=20052*/

/*
	public ReturnMsg saveTreeInitInfo(ClassifyTree classifyTree);

	public ReturnMsg getThisTreeAllNode(Integer nodeId);

	public ReturnMsg getThisTreeDataNode(Integer treeId);

	public ReturnMsg createClassifyNode(ClassifyNode classifyNode);

	public ReturnMsg moveClassifyNode(List<ClassifyNode> ClassifyNodeList);

	public ReturnMsg moveDataNode(List<DataNode> DataNodeList);

	public ReturnMsg deleteClassifyNode(Integer[] ids);

	public ReturnMsg deleteDataNode(Integer[] ids);

	public ReturnMsg deleteClassifyTree(Integer[] ids);

	public ReturnMsg renameClassifyNode(ClassifyNode classifyNode);

	public ReturnMsg renameDataNode(DataNode dataNode);



	//3.分类查询待定。。。。。
	//3.1根据传入参数tableName、fields查询对应表的字段数据
	public ReturnMsg getDataTableData(DataNode dataNode);

	//3.2根据tableName、id进行删除记录。
	public ReturnMsg deleteTableData(List<DataNode> dataNodeList);

	//3.3修改表信息，根据主键id，tableName、fields字段信息{"swprefixzzgg":"发大发","swprefixwenbenkuang":"发大发","swprefixduoxingwenbenkuang":"CVC"}
	public ReturnMsg updateTableData(List<DataNode> dataNodeList);

	public ReturnMsg saveTree02InitInfo(ClassifyTree02 classifyTree02);

	public ReturnMsg getAllClassifyTree();

	public ReturnMsg getThisTree02AllNode(Integer nodeId);*/



	//重做
	//1.0控件

	public ReturnMsg createClassifyTable(ClassifyTreeInfo classifyTreeInfo);

	public ReturnMsg getAllClassifyNodeByNodeId(Integer nodeId);

	public ReturnMsg createClassify(ClassifyTreeInfo classifyTreeInfo);

	public ReturnMsg updateClassifyNode(ClassifyTreeInfo classifyTreeInfo);

	public ReturnMsg deleteClassify(ClassifyTreeInfo classifyTreeInfo);

	//2.0控件

	public ReturnMsg getAllClassify();

	public ReturnMsg saveShowClassifyRelation(ClassifyShowRelation classifyShowRelation);

	public ReturnMsg getClassifyByNodeId(Integer nodeId);




}
