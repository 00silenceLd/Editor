package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.BaseEntity;

/**
*
* @author 曾智宏
*
* @version 1.0
*
* 创建时间：2019年4月4日 下午14:10:21
*
* 评论信息
* 
* 实体类
*
*/

public class CommentInfo extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getSelectId() {
		return selectId;
	}
	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}
	public String getPubUser() {
		return pubUser;
	}
	public void setPubUser(String pubUser) {
		this.pubUser = pubUser;
	}
	public String getPubContent() {
		return pubContent;
	}
	public void setPubContent(String pubContent) {
		this.pubContent = pubContent;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPubApprove() {
		return pubApprove;
	}
	public void setPubApprove(Integer pubApprove) {
		this.pubApprove = pubApprove;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	@Override
	public String toString() {
		return "CommentInfo [id=" + id + ", uid=" + uid + ", nodeId=" + nodeId + ", selectId=" + selectId + ", pubUser="
				+ pubUser + ", pubContent=" + pubContent + ", pubTime=" + pubTime + ", pubApprove=" + pubApprove
				+ ", theme=" + theme + ", commentCount=" + commentCount + ", username=" + username + ", chineseName="
				+ chineseName + "]";
	}
	
	
	
	
	
	
	
}
 