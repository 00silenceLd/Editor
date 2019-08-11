package swtech.pageDesignControl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.ClassifyNode;
import swtech.pageDesignControl.entity.ClassifyNodeAndDataRel;
import swtech.pageDesignControl.entity.ClassifyTreeInfo;
import swtech.pageDesignControl.mapper.ClassifyTreeMapper;
import swtech.pageDesignControl.service.ClassifyTreeQueryService;

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
 * @QualifiedName:swtech.pageDesignControl.service.impl.ClassifyTreeQueryServiceImpl
 * @ClassName: ClassifyTreeQueryServiceImpl
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:53:25
 * @Description: 编辑器树形分类控件应用方面相关功能查询业务实现类
 *
 */
@Service
public class ClassifyTreeQueryServiceImpl implements ClassifyTreeQueryService {
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(ClassifyTreeQueryServiceImpl.class);


	@Autowired
	private ClassifyTreeMapper classifyTreeMapper;

	@Override
	public ReturnMsg getNextLvClassifyNodeByNodeIdAndId(Integer nodeId, Integer id) {
		ReturnMsg msg = new ReturnMsg();

		//检查合法性
		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(id==null)throw new ServiceException("id不能为空");


		//根据nodeId查询ht_classify_tree_info,获取该nodeId页面中对应的表名
		ClassifyTreeInfo classifyTreeInfo = classifyTreeMapper.getClassifyInfoByNodeId(nodeId);
		if(classifyTreeInfo==null)throw new ServiceException("没有该分类 信息表");
		String tableName = classifyTreeInfo.getClassifyTableName();
		if(tableName==null)throw new ServiceException("表名为空");

		//根据分类信息表表名与当前分类节点的id，查询当前节点下一级的分类节点
		//封装参数
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("tableName", tableName);
		paramMap.put("id", id);
		List<ClassifyNode> classifyNodeList = classifyTreeMapper.getNextLvClassifyNodeById(paramMap);

		logger.info(classifyNodeList);

		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(classifyNodeList);
		return msg;
	}

	@Override
	public ReturnMsg getRelByClassifyNodeAndDataRel(ClassifyNodeAndDataRel classifyNodeAndDataRel ) {
		ReturnMsg msg = new ReturnMsg();


		Integer nodeId = classifyNodeAndDataRel.getNodeId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空 ");
		Integer pId = classifyNodeAndDataRel.getpId();
		if(pId==null)throw new ServiceException("pId不能为空 ");
		

		//根据nodeId查询ht_classify_tree_info,获取该nodeId页面中对应的表名以及节点数据关系表名
		ClassifyTreeInfo classifyTreeInfo = classifyTreeMapper.getClassifyInfoByNodeId(nodeId);
		System.out.println(classifyTreeInfo);
		//关系表名
		String relationshipTableName = classifyTreeInfo.getRelationshipTableName();
		if(relationshipTableName==null)throw new ServiceException("关系表名为空 ");


		//		Integer pId = classifyNodeAndDataRel.getpId();
		//		Integer userId = classifyNodeAndDataRel.getUserId();
		classifyNodeAndDataRel.setRelationshipTableName(relationshipTableName);
		//		if(pId==null)throw new ServiceException("pId不能为空");
		//		if(userId==null)throw new ServiceException("userId不能为空");

		//获取该分类节点下符合条件的数据id
		List<Integer> dataIds = classifyTreeMapper.getDataIdByClassifyNodeAndDataRel(classifyNodeAndDataRel);
		if(dataIds==null||dataIds.get(0)==null) {//如果dataIds为空，则数据主键Id可能使用的是UUID
			//获取该分类节点下符合条件的数据id（dataUuid）
			List<String> dataUuids = classifyTreeMapper.getDataUuidByClassifyNodeAndDataRel(classifyNodeAndDataRel);
			msg.setStatus("200");
			msg.setStatusMsg("查询成功");
			msg.setMsg(dataUuids);
			return msg;
		
		}


		logger.info(dataIds);
		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(dataIds);
		return msg;
	}


}
