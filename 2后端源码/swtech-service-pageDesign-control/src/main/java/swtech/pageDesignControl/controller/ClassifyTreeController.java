package swtech.pageDesignControl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.ClassifyNodeAndDataRel;
import swtech.pageDesignControl.service.ClassifyTreeOperateService;
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
 * @QualifiedName:swtech.pageDesignControl.controller.ClassifyTreeController
 * @ClassName: ClassifyTreeController
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:32:11
 * @Description: 编辑器树形分类控件应用方面相关功能控制层
 *
 */
@RestController
@RequestMapping("/classify")
@CrossOrigin
public class ClassifyTreeController {

	@Autowired
	private ClassifyTreeQueryService classifyTreeQueryService;

	@Autowired
	private ClassifyTreeOperateService classifyTreeOperateService;



	/*
	 * 该接口用于根据nodeId与当前节点Id，
	 * 查询ht_classify_tree_info表与对应分类信息表，
	 * 获取其当前节点下一级的所有分类节点
	 * 
	 */
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午1:57:09
	 * @QualifiedName:swtech.pageDesignControl.controller.ClassifyTreeController
	 * @MethodName: getNextLvClassifyNodeByNodeIdAndId
	 * @param nodeId 当前页面nodeId
	 * @param id 当前分类节点id
	 * @return
	 * @Description: 获取其当前分类节点下一级的所有分类节点信息
	 *
	 */
	@RequestMapping("/getNextLvClassifyInfoByNodeIdAndId/{nodeId}/{id}")
	public ReturnMsg getNextLvClassifyNodeByNodeIdAndId(
			@PathVariable Integer nodeId,@PathVariable Integer id) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyTreeQueryService.getNextLvClassifyNodeByNodeIdAndId(nodeId,id);
		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}




	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午1:59:26
	 * @QualifiedName:swtech.pageDesignControl.controller.ClassifyTreeController
	 * @MethodName: getRelByClassifyNodeAndDataRel
	 * @param nodeId 当前页面nodeId（必选）
	 * @param pId 需查询数据的父节点Id（必选）
	 * @param userId 用户id（可选）
	 * @param roleId 角色id（可选）
	 * @return
	 * @Description: 获取在该分类节点下保存的数据id（根据不同查询条件）
	 *
	 */
	@RequestMapping(value="/getRelByClassifyNodeAndDataRel",method=RequestMethod.POST)
	public ReturnMsg getRelByClassifyNodeAndDataRel(@RequestBody ClassifyNodeAndDataRel classifyNodeAndDataRel) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyTreeQueryService.getRelByClassifyNodeAndDataRel(classifyNodeAndDataRel);
		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}





	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午2:16:18
	 * @QualifiedName:swtech.pageDesignControl.controller.ClassifyTreeController
	 * @MethodName: saveRelForDataIdWithClassifyPid
	 * @param nodeId 当前页面nodeId（必选）
	 * @param pId 父节点id（必选）
	 * @param userId 用户id（可选）
	 * @param roleId 父节点id（可选）
	 * @param dataId 数据id（可选）
	 * @param dataUuid 数据Uuid（可选）
	 * @return
	 * @Description:保存数据记录与分类节点的关系（可当复制）
	 *
	 */
	@RequestMapping(value="/saveRelForDataIdWithClassifyPid",method=RequestMethod.POST)
	public ReturnMsg saveRelForDataIdWithClassifyPid(@RequestBody List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyTreeOperateService.saveRelForDataIdWithClassifyPid(classifyNodeAndDataRels);
		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("保存失败");
		}
		return msg;
	}




	/*(该接口暂无用)
	 * 
	 * 该接口用于保存数据记录与第二分类节点的关系（如 第二层筛选）
	 */
	@RequestMapping(value="/saveSecondRelForDataIdWithClassifyPid",method=RequestMethod.POST)
	public ReturnMsg saveSecondRelForDataIdWithClassifyPid(@RequestBody List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyTreeOperateService.saveSecondRelForDataIdWithClassifyPid(classifyNodeAndDataRels);
		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("保存失败");
		}
		return msg;
	}

	/*(该接口暂无用)
	 * 
	 * 该接口用于保存数据记录与第三分类节点的关系
	 */
	@RequestMapping(value="/saveThirdRelForDataIdWithClassifyPid",method=RequestMethod.POST)
	public ReturnMsg saveThirdRelForDataIdWithClassifyPid(@RequestBody List<ClassifyNodeAndDataRel> classifyNodeAndDataRels) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyTreeOperateService.saveThirdRelForDataIdWithClassifyPid(classifyNodeAndDataRels);
		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("保存失败");
		}
		return msg;
	}



	/*
	 * 该接口用于删除数据记录与分类节点的关系
	 * 
	 */
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午2:26:06
	 * @QualifiedName:swtech.pageDesignControl.controller.ClassifyTreeController
	 * @MethodName: deleteRelForDataIdWithClassifyPid
	 * @param nodeId 当前页面nodeId（必选）
	 * @param pId 父节点id（必选）
	 * @param userId 用户id（可选）
	 * @param roleId 父节点id（可选）
	 * @param dataId 数据id（可选）
	 * @param dataUuid 数据Uuid（可选）
	 * @return
	 * @Description:删除数据记录与分类节点的关系（根据不同条件）
	 *
	 */
	@RequestMapping(value="/deleteRelForDataIdWithClassifyPid",method=RequestMethod.POST)
	public ReturnMsg deleteRelForDataIdWithClassifyPid(@RequestBody List<ClassifyNodeAndDataRel> classifyNodeAndDataRels ) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyTreeOperateService.deleteRelForDataIdWithClassifyPid(classifyNodeAndDataRels);
		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("删除失败");
		}
		return msg;
	}


	/*
	 * 该接口用于移动数据至其他分类节点
	 * 
	 */
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午2:30:00
	 * @QualifiedName:swtech.pageDesignControl.controller.ClassifyTreeController
	 * @MethodName: moveDataToOtherClassifyNode
	 * @param nodeId 当前页面nodeId（必选）
	 * @param newPId 新的父节点id（必选）
	 * @param pId 父节点id（必选）
	 * @param userId 用户id（可选）
	 * @param roleId 父节点id（可选）
	 * @param dataId 数据id（可选）
	 * @param dataUuid 数据Uuid（可选）
	 * @return
	 * @Description:移动数据至其他分类节点
	 *
	 */
	
	@RequestMapping(value="/moveDataToOtherClassifyNode",method=RequestMethod.POST)
	public ReturnMsg moveDataToOtherClassifyNode(@RequestBody List<ClassifyNodeAndDataRel> classifyNodeAndDataRels ) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyTreeOperateService.moveDataToOtherClassifyNode(classifyNodeAndDataRels);
		} catch (Exception e) {
			msg.setMsg(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("移动失败");
		}
		return msg;
	}





}
