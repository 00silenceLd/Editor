package swtech.pageDesignControl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

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
 * @QualifiedName:swtech.pageDesignControl.entity.CommentInfo
 * @ClassName: CommentInfo
 * @Author 曾智宏
 * @Date 2019年7月30日 上午12:23:23
 * @Description: 编辑器自定义模板控件中评论信息的实体类
 *
 */
@Data
@TableName("ht_comment_data")
public class CommentInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId
	private Integer id;
	private Integer uid;//用户id，用来查找发布人用户名的
	private Integer nodeId;//数据源节点id
	private Integer selectId;//数据源所选记录的id
	private String pubUser;//发布评论的用户,用于文章下的评论信息显示
	private String pubContent;//发布内容
	private String pubTime;//发布时间
	private Integer pubApprove;//发布审核判断
	
	//以下不存入数据库
	private String theme;//发布主题，在数据表中title字段内容获取，或者是别的
	private Integer commentCount;//发布信息的总数
	private String username;//ht_user表的用户名，用于评论审核页面的账号
	private String chineseName;//ht_user表的中文名，用于评论审核页面的用户名
	





}