package swtech.pageDesignControl.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.ClassifyNodeAndDataRel;
import swtech.pageDesignControl.entity.ClassifyTreeInfo;
import swtech.pageDesignControl.mapper.ClassifyTreeMapper;
import swtech.pageDesignControl.service.ClassifyTreeOperateService;

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
 * @QualifiedName:swtech.pageDesignControl.service.impl.ClassifyTreeOperateServiceImpl
 * @ClassName: ClassifyTreeOperateServiceImpl
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:52:58
 * @Description: 编辑器树形分类控件应用方面相关功能操作业务实现类
 *
 */
@Service
@Transactional
public class ClassifyTreeOperateServiceImpl implements ClassifyTreeOperateService {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(ClassifyTreeOperateServiceImpl.class);
	@Autowired
	private ClassifyTreeMapper classifyTreeMapper;
	@Override
	public ReturnMsg saveRelForDataIdWithClassifyPid(
			List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();

		if(classifyNodeAndDataRels==null)throw new ServiceException("需要保存的分类关系 不能为空 ");

		Integer nodeId = classifyNodeAndDataRels.get(0).getNodeId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空 ");

		//根据nodeId查询ht_classify_tree_info,获取该nodeId页面中对应的表名以及节点数据关系表名
		ClassifyTreeInfo classifyTreeInfo = classifyTreeMapper.getClassifyInfoByNodeId(nodeId);
		//关系表名
		String relationshipTableName = classifyTreeInfo.getRelationshipTableName();
		if(relationshipTableName==null)throw new ServiceException("关系表名为空 ");

		//遍历关系
		for(ClassifyNodeAndDataRel c:classifyNodeAndDataRels) {
			//验证合法性
			Integer pId = c.getpId();
			Integer roleId = c.getRoleId();
			if(pId==null)throw new ServiceException("pId不能为空");
			c.setRelationshipTableName(relationshipTableName);

			//查看是否存在该记录（查看该用户是否有该文件）
			//			ClassifyNodeAndDataRel c2 = new ClassifyNodeAndDataRel();
			//			c2 = c;
			c.setpId(null);
			//			c.setRoleId(null);
			Integer count = classifyTreeMapper.getRelCountByClassifyNodeAndDataRel(c);


			if(count==0) {
				c.setpId(pId);
				//				c.setRoleId(roleId);
				//保存关系在对应的关系表中
				classifyTreeMapper.saveRelForNodeAndDataId(c);
			}
		}
		msg.setStatus("200");
		msg.setStatusMsg("保存关系成功");
		return msg;
	}


	@Override
	public ReturnMsg saveSecondRelForDataIdWithClassifyPid(
			List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();

		if(classifyNodeAndDataRels==null)throw new ServiceException("需要保存的分类关系 不能为空 ");
		Integer nodeId = classifyNodeAndDataRels.get(0).getNodeId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空 ");

		//根据nodeId查询ht_classify_tree_info,获取该nodeId页面中对应的表名以及节点数据关系表名
		ClassifyTreeInfo classifyTreeInfo = classifyTreeMapper.getClassifyInfoByNodeId(nodeId);
		//关系表名
		String relationshipTableName = classifyTreeInfo.getRelationshipTableName();
		if(relationshipTableName==null)throw new ServiceException("关系表名为空 ");

		//遍历关系
		for(ClassifyNodeAndDataRel c:classifyNodeAndDataRels) {
			//验证合法性
			Integer pId = c.getpId();
			if(pId==null)throw new ServiceException("pId不能为空");
			c.setRelationshipTableName(relationshipTableName);

			//查看是否存在该记录（查看该用户是否有该文件）筛选过滤条件
			//			ClassifyNodeAndDataRel c2 = c;
			c.setpId(null);
			Integer count = classifyTreeMapper.getRelCountByClassifyNodeAndDataRel(c);

			if(count==1) {
				c.setpId(pId);
				//保存关系在对应的关系表中
				classifyTreeMapper.saveRelForNodeAndDataId(c);

			}

		}
		msg.setStatus("200");
		msg.setStatusMsg("保存关系成功");
		return msg;
	}


	@Override
	public ReturnMsg saveThirdRelForDataIdWithClassifyPid(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();

		if(classifyNodeAndDataRels==null)throw new ServiceException("需要保存的分类关系 不能为空 ");
		Integer nodeId = classifyNodeAndDataRels.get(0).getNodeId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空 ");

		//根据nodeId查询ht_classify_tree_info,获取该nodeId页面中对应的表名以及节点数据关系表名
		ClassifyTreeInfo classifyTreeInfo = classifyTreeMapper.getClassifyInfoByNodeId(nodeId);
		//关系表名
		String relationshipTableName = classifyTreeInfo.getRelationshipTableName();
		if(relationshipTableName==null)throw new ServiceException("关系表名为空 ");

		//遍历关系
		for(ClassifyNodeAndDataRel c:classifyNodeAndDataRels) {
			//验证合法性
			Integer pId = c.getpId();
			if(pId==null)throw new ServiceException("pId不能为空");
			c.setRelationshipTableName(relationshipTableName);

			//查看是否存在该记录（查看该用户是否有该文件）筛选过滤条件
			//			ClassifyNodeAndDataRel c2 = c;
			c.setpId(null);
			Integer count = classifyTreeMapper.getRelCountByClassifyNodeAndDataRel(c);

			if(count==2) {
				c.setpId(pId);
				//保存关系在对应的关系表中
				classifyTreeMapper.saveRelForNodeAndDataId(c);
			}
		}
		msg.setStatus("200");
		msg.setStatusMsg("保存关系成功");
		return msg;
	}





	@Override
	public ReturnMsg deleteRelForDataIdWithClassifyPid(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();

		if(classifyNodeAndDataRels==null)throw new ServiceException("需要保存的分类关系 不能为空 ");

		Integer nodeId = classifyNodeAndDataRels.get(0).getNodeId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空 ");

		//根据nodeId查询ht_classify_tree_info,获取该nodeId页面中对应的表名以及节点数据关系表名
		ClassifyTreeInfo classifyTreeInfo = classifyTreeMapper.getClassifyInfoByNodeId(nodeId);
		//关系表名
		String relationshipTableName = classifyTreeInfo.getRelationshipTableName();
		if(relationshipTableName==null)throw new ServiceException("关系表名为空 ");


		//遍历关系
		for(ClassifyNodeAndDataRel c:classifyNodeAndDataRels) {
			//验证合法性
			Integer pId = c.getpId();
			//			Integer dataId = c.getDataId();
			//			Integer userId = c.getUserId();
			if(pId==null)throw new ServiceException("pId不能为空");
			//			if(dataId==null)throw new ServiceException("dataId不能为空");
			//			if(userId==null)throw new ServiceException("userId不能为空");
			c.setRelationshipTableName(relationshipTableName);

			//删除关系
			Integer row = classifyTreeMapper.deleteRelForNodeAndDataId(c);
			if(row==0)throw new ServiceException("记录不存在");


		}
		msg.setStatus("200");
		msg.setStatusMsg("删除关系成功");
		return msg;
	}



	@Override
	public ReturnMsg moveDataToOtherClassifyNode(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();

		if(classifyNodeAndDataRels==null)throw new ServiceException("需要保存的分类关系 不能为空 ");

		Integer nodeId = classifyNodeAndDataRels.get(0).getNodeId();
		//		Integer NewPId = classifyNodeAndDataRels.get(0).getNewPId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空 ");
		//		if(NewPId==null)throw new ServiceException("新pId不能为空 ");

		//根据nodeId查询ht_classify_tree_info,获取该nodeId页面中对应的表名以及节点数据关系表名
		ClassifyTreeInfo classifyTreeInfo = classifyTreeMapper.getClassifyInfoByNodeId(nodeId);
		//关系表名
		String relationshipTableName = classifyTreeInfo.getRelationshipTableName();
		if(relationshipTableName==null)throw new ServiceException("关系表名为空 ");


		//遍历关系
		for(ClassifyNodeAndDataRel c:classifyNodeAndDataRels) {
			//验证合法性
			Integer pId = c.getpId();
			Integer newPId = c.getNewPId();
			//			Integer dataId = c.getDataId();
			//			Integer userId = c.getUserId();
			if(pId==null)throw new ServiceException("原pId不能为空");
			if(newPId==null)throw new ServiceException("新pId不能为空");
			//			if(dataId==null)throw new ServiceException("dataId不能为空");
			//			if(userId==null)throw new ServiceException("userId不能为空");
			c.setRelationshipTableName(relationshipTableName);
			//			c.setNewPId(newPId);


			//修改pid
			Integer row = classifyTreeMapper.updatePIdByClassifyNodeAndDataRel(c);
			if(row==0)throw new ServiceException("记录不存在");


		}
		msg.setStatus("200");
		msg.setStatusMsg("移动成功");
		return msg;}






}
