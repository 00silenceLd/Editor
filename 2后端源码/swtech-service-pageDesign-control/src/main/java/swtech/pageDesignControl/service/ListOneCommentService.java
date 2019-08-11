package swtech.pageDesignControl.service;

import java.util.List;

import swtech.pageDesignControl.common.vo.QueryReturn;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.CommentInfo;

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
 * @QualifiedName:swtech.pageDesignControl.service.ListOneCommentService
 * @ClassName: ListOneCommentService
 * @Author 曾智宏
 * @Date 2019年7月30日 上午12:24:54
 * @Description: 编辑器自定义模板控件中评论功能的业务层接口
 *
 */
public interface ListOneCommentService {

	ReturnMsg getComment(Integer nodeId, Integer selectId);

	ReturnMsg releaseComment(CommentInfo commentInfo);

	ReturnMsg deleteComment(List<Integer> ids);

	ReturnMsg passApproveComment(List<Integer> ids);

	QueryReturn getNotApproveComment(Integer page, Integer limit);



}
