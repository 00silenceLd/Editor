package swtech.pageDesignControl.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import swtech.pageDesignControl.entity.CommentInfo;
import swtech.pageDesignControl.entity.TestEntity;

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
 * @QualifiedName:swtech.pageDesignControl.mapper.ListOneCommentMapper
 * @ClassName: ListOneCommentMapper
 * @Author 曾智宏
 * @Date 2019年7月30日 上午12:26:30
 * @Description: 编辑器自定义模板控件中评论功能的持久层接口
 *
 */

public interface ListOneCommentMapper extends BaseMapper<CommentInfo>{

	List<CommentInfo> getComment(Integer nodeId, Integer selectId);

	Map<String, String> getUserByUidOnComment(Integer uid);

	int releaseComment(CommentInfo commentInfo);

	Integer commentCount(Integer id);

	int deleteComment(Integer id);

	int passApproveComment(Integer id);

	List<CommentInfo> getNotApproveComment(Integer begin, Integer limit);

	String getNodeNameByNodeIdz(Integer nodeId);

	String getThemeByNodeName(Map<String, String> paramMap);

	Integer getNotApproveCommentCount();


	
}
