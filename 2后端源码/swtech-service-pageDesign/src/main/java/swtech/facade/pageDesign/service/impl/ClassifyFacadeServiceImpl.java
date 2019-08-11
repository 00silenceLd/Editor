package swtech.facade.pageDesign.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ClassifyNode;
import swtech.facade.pageDesign.entity.ClassifyShowRelation;
import swtech.facade.pageDesign.entity.ClassifyTreeInfo;
import swtech.facade.pageDesign.service.ClassifyFacadeService;
import swtech.facade.pageDesign.util.File.Pinyin4jUtil;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.ClassifyTreeInfoDao;

/*
 * 
   

 *
 *
 *             ,%%%%%%%%, 
 *           ,%%/\%%%%/\%% 
 *          ,%%%\c "" J/%%% 
 * %.       %%%%/ o  o \%%% 
 * `%%.     %%%%    _  |%%% 
 *  `%%     `%%%%(__Y__)%%' 
 *  //       ;%%%%`\-/%%%'
 * ((       /  `%%%%%%%' 
 *  \\    .'          | 
 *   \\  /       \  | | 
 *    \\/         ) | | 
 *     \         /_ | |__ 
 *     (___________))))))) 攻城湿 
 *
 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeServiceImpl
 * @ClassName: ClassifyFacadeServiceImpl
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:21:21
 * @Description:  树形分类控件业务实现类
 *
 */
@Component
public class ClassifyFacadeServiceImpl implements ClassifyFacadeService {
	private static final Logger log = LoggerFactory.getLogger(ClassifyFacadeServiceImpl.class);


	@Autowired
	private ClassifyTreeInfoDao ctid;

	@Transactional
	@Override
	public ReturnMsg createClassifyTable(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();

		//检查合法性
		Integer nodeId = classifyTreeInfo.getNodeId();
		String treeName = classifyTreeInfo.getTreeName();
		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(StringUtils.isBlank(treeName))throw new ServiceException("分类名不能为空");


		//查询ht_classify_tree_info表，该节点的树形分类是否存在
		ClassifyTreeInfo classifyTreeInfo1 = ctid.getClassifyTreeInfoByNodeId(nodeId);
		if(classifyTreeInfo1==null) {//如果该页面从未创建过分类页面
			// 将分类名，中文转为拼音
			String classifyTableName = Pinyin4jUtil.toPinyin(treeName);
			classifyTableName = classifyTableName.toLowerCase();
			//首字母大写
			classifyTableName = PageDesignOperatorFacadeImpl.captureName(classifyTableName);
			//与nodeId拼接
			classifyTableName +=nodeId+"Classify";
			System.out.println(classifyTableName);
			//封装
			classifyTreeInfo.setClassifyTableName(classifyTableName);

			//检查该表是否存在
			Integer row = ctid.createClassifyTable(classifyTableName);

			//创建完分类节点信息表之后，还需创建该节点信息表对应的数据储存关系表
			//用以保存该节点下的数据对应的关系 relationshipTableName

			// 将分类名，中文转为拼音
			String relationshipTableName = Pinyin4jUtil.toPinyin(treeName);
			relationshipTableName = relationshipTableName.toLowerCase();
			//首字母大写
			relationshipTableName = PageDesignOperatorFacadeImpl.captureName(relationshipTableName);
			//与nodeId拼接
			relationshipTableName +=nodeId+"Rel";
			System.out.println(relationshipTableName);
			//封装
			classifyTreeInfo.setRelationshipTableName(relationshipTableName);
			//创建该分类信息表对应的节点与数据关系表
			ctid.createRelTable(relationshipTableName);



			//保存记录ht_classify_tree_info
			Integer row2 = ctid.saveClassifyTreeInfo(classifyTreeInfo);
			//判断
			if(row2==0)throw new ServiceException("保存分类基本信息失败");
			msg.setStatusMsg("保存成功");
		}else {//如果存在，就改为修改classifyTreeInfo(treeName),其对应的分类表不用动
			Integer row = ctid.updateClassifyTreeInfo(classifyTreeInfo);
			msg.setStatusMsg("修改成功");
		}


		msg.setStatus("200");

		return msg;
	}
	@Transactional
	@Override
	public ReturnMsg getAllClassifyNodeByNodeId(Integer nodeId) {
		ReturnMsg msg = new ReturnMsg();
		//检查合法性
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//根据nodeId查询ht_classify_tree_info表，获取该nodeId页面对应的分类表名
		String classifyTableName = ctid.getClassifyTableNameByNodeId(nodeId);
		if(StringUtils.isBlank(classifyTableName))throw new ServiceException("获取分类表名失败");

		//查询该分类表中的所有记录
		List<ClassifyNode> classifyNodeList = ctid.getClassifyNodeByTableName(classifyTableName);
		//		if(classifyNodeList==null||classifyNodeList.size()==0)throw new ServiceException("获取分类表数据失败");

		msg.setMsg(classifyNodeList);
		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		return msg;
	}

	@Override
	public ReturnMsg createClassify(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();
		//检查合法性
		Integer nodeId = classifyTreeInfo.getNodeId();
		List<ClassifyNode> classifyNodeList = classifyTreeInfo.getClassifyNodeList();
		if(classifyNodeList==null||classifyNodeList.size()==0)throw new ServiceException("分类节点不能为空");
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//根据nodeId查询ht_classify_tree_info表，获取该nodeId页面对应的分类表名
		String classifyTableName = ctid.getClassifyTableNameByNodeId(nodeId);
		if(StringUtils.isBlank(classifyTableName))throw new ServiceException("获取分类表名失败");

		//遍历classifyNodeList
		List<Integer> idList = new ArrayList<Integer>();
		for(ClassifyNode classifyNode:classifyNodeList) {
			String nodeName = classifyNode.getNodeName();
			Integer pId = classifyNode.getpId();
			if(StringUtils.isBlank(nodeName))throw new ServiceException("分类节点名不能为空");
			if(pId==null)throw new ServiceException("分类节点父节点不能为空");

			//根据分类表名，对该表进行插入数据操作
			Integer id = ctid.createClassifyNodeByTable(classifyTableName,pId,nodeName);
			idList.add(id);
		}


		msg.setStatus("200");
		msg.setStatusMsg("创建成功");
		msg.setMsg(idList);

		return msg;
	}

	@Override
	public ReturnMsg updateClassifyNode(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();
		//检查合法性
		Integer nodeId = classifyTreeInfo.getNodeId();
		List<ClassifyNode> classifyNodeList = classifyTreeInfo.getClassifyNodeList();
		if(classifyNodeList==null||classifyNodeList.size()==0)throw new ServiceException("分类节点不能为空");
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//根据nodeId查询ht_classify_tree_info表，获取该nodeId页面对应的分类表名
		String classifyTableName = ctid.getClassifyTableNameByNodeId(nodeId);
		if(StringUtils.isBlank(classifyTableName))throw new ServiceException("获取分类表名失败");

		//遍历classifyNodeList
		for(ClassifyNode classifyNode:classifyNodeList) {
			Integer id = classifyNode.getId();
			String nodeName = classifyNode.getNodeName();
			Integer pId = classifyNode.getpId();
			//			if(StringUtils.isBlank(nodeName))throw new ServiceException("分类节点名不能为空");
			if(pId==null) {//pid为null，就修改nodeName
				//根据分类表名，对该表进行修改nodeName
				Integer row = ctid.updateNodeNameByTable(classifyTableName,nodeName,id);
				if(row==0)throw new ServiceException("修改节点名失败");

			}else {//否则就修改pid
				//根据分类表名，对该表进行修改pid
				Integer row = ctid.updateNodePIdByTable(classifyTableName,pId,id);
				if(row==0)throw new ServiceException("修改父节点失败");
			}


		}


		msg.setStatus("200");
		msg.setStatusMsg("修改成功");


		return msg;
	}

	@Override
	public ReturnMsg deleteClassify(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();
		//检查合法性
		Integer nodeId = classifyTreeInfo.getNodeId();
		List<ClassifyNode> classifyNodeList = classifyTreeInfo.getClassifyNodeList();
		if(classifyNodeList==null||classifyNodeList.size()==0)throw new ServiceException("分类节点不能为空");
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//根据nodeId查询ht_classify_tree_info表，获取该nodeId页面对应的分类表名
		String classifyTableName = ctid.getClassifyTableNameByNodeId(nodeId);
		if(StringUtils.isBlank(classifyTableName))throw new ServiceException("获取分类表名失败");

		//遍历classifyNodeList
		for(ClassifyNode classifyNode:classifyNodeList) {
			Integer id = classifyNode.getId();
			//根据分类表名，对该表进行修改nodeName
			Integer row = ctid.deleteClassifyNodeByTable(classifyTableName,id);
			if(row==0)throw new ServiceException("删除节点名失败");
		}


		msg.setStatus("200");
		msg.setStatusMsg("删除成功");


		return msg;
	}

	@Transactional
	@Override
	public ReturnMsg getAllClassify() {
		ReturnMsg msg = new ReturnMsg();

		List<ClassifyTreeInfo> classifyTreeInfoList = 
				ctid.getAllClassify();

		if(classifyTreeInfoList==null)throw new ServiceException("获取分类源失败");
		if(classifyTreeInfoList.size()==0)throw new ServiceException("没有分类源");

		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(classifyTreeInfoList);

		return msg;
	}

	
	
	
	
	@Override
	public ReturnMsg saveShowClassifyRelation(ClassifyShowRelation classifyShowRelation) {
		ReturnMsg msg = new ReturnMsg();

		//检查合法性
		Integer nodeId = classifyShowRelation.getNodeId();
		List<Integer> classifyTreeIds = classifyShowRelation.getClassifyTreeIds();
		if(classifyTreeIds==null||classifyTreeIds.size()==0)throw new ServiceException("请选择分类源");
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//根据nodeId查询ht_classify_show_relation表，是否存在
		Integer count = ctid.getRelationCountByNodeId(nodeId);
		System.out.println(count);
		if(count!=0) {
			ctid.deleteRelationByNodeId(nodeId);

		}


		//遍历分类Id
		for(Integer classifyTreeId:classifyTreeIds) {
			//将nodeId和classifyTreeId保存进ht_classify_show_relation表中

			Integer row = ctid.insertShowRelation(nodeId,classifyTreeId);
			if(row==0)throw new ServiceException("插入关系失败");

		}


		msg.setStatus("200");
		msg.setStatusMsg("插入成功");



		return msg;
	}
	@Transactional
	@Override
	public ReturnMsg getClassifyByNodeId(Integer nodeId) {
		ReturnMsg msg = new ReturnMsg();

		//检查合法性
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//根据nodeid查询ht_classify_show_relation表，获取该节点下有哪些分类表
		List<ClassifyTreeInfo> classifyTreeInfoList= ctid.getClassifyByNodeId(nodeId);

		if(classifyTreeInfoList==null)throw new ServiceException("获取分类源失败");
		if(classifyTreeInfoList.size()==0)throw new ServiceException("没有分类源");

		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(classifyTreeInfoList);

		return msg;
	}

}
