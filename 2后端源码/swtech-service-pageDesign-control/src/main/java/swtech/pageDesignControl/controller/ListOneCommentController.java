package swtech.pageDesignControl.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import swtech.pageDesignControl.common.vo.QueryReturn;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.CommentInfo;
import swtech.pageDesignControl.service.ListOneCommentService;


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
 * @QualifiedName:swtech.pageDesignControl.controller.ListOneCommentController
 * @ClassName: ListOneCommentController
 * @Author 曾智宏
 * @Date 2019年7月30日 上午12:12:08
 * @Description: 编辑器自定义模板控件中评论功能控制层
 *
 */
@RestController
@RequestMapping(value="/commentFacade")
@CrossOrigin
public class ListOneCommentController {
//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(ListOneCommentController.class);

	@Autowired
	private ListOneCommentService listOneCommentService;
	
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月30日 下午11:18:34
	 * @QualifiedName:swtech.pageDesignControl.controller.ListOneCommentController
	 * @MethodName: getComment
	 * @param nodeId
	 * @param selectId
	 * @return ReturnMsg
	 * @Description:获取当前记录的所有通过审核的评论
	 *
	 */
	@RequestMapping(value="/getComment",method=RequestMethod.GET)
	public ReturnMsg getComment(Integer nodeId, Integer selectId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = listOneCommentService.getComment(nodeId,selectId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("获取评论失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}
	
	
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月30日 下午11:19:11
	 * @QualifiedName:swtech.pageDesignControl.controller.ListOneCommentController
	 * @MethodName: releaseComment
	 * @param commentInfo
	 * @return ReturnMsg
	 * @Description:发布对当前记录的评论
	 *
	 */
	@RequestMapping(value="/releaseComment",method=RequestMethod.POST)
	public ReturnMsg releaseComment(@RequestBody CommentInfo commentInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = listOneCommentService.releaseComment(commentInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("发布评论失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}
	
	
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月30日 下午11:19:15
	 * @QualifiedName:swtech.pageDesignControl.controller.ListOneCommentController
	 * @MethodName: deleteComment
	 * @param ids
	 * @return ReturnMsg
	 * @Description:删除评论
	 *
	 */
	@RequestMapping(value="/deleteComment",method=RequestMethod.POST)
	public ReturnMsg deleteComment(@RequestBody List<Integer> ids) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = listOneCommentService.deleteComment(ids);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("删除评论失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}
	
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月30日 下午11:19:20
	 * @QualifiedName:swtech.pageDesignControl.controller.ListOneCommentController
	 * @MethodName: passApproveComment
	 * @param ids
	 * @return ReturnMsg
	 * @Description:审核评论
	 *
	 */
	@RequestMapping(value="/passApproveComment",method=RequestMethod.POST)
	public ReturnMsg passApproveComment(@RequestBody List<Integer> ids) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = listOneCommentService.passApproveComment(ids);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("审核评论失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}
	
	
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月30日 下午11:19:24
	 * @QualifiedName:swtech.pageDesignControl.controller.ListOneCommentController
	 * @MethodName: getNotApproveComment
	 * @param page
	 * @param limit
	 * @return QueryReturn
	 * @Description:获取所有未通过审核的评论
	 *
	 */
	@RequestMapping(value="/getNotApproveComment",method=RequestMethod.GET)
	public QueryReturn getNotApproveComment(Integer page,Integer limit) {
		QueryReturn msg = new QueryReturn();
		try {
			msg = listOneCommentService.getNotApproveComment(page,limit);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("获取未审核评论失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}
	
	
	
}
