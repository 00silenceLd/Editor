package swtech.facade.pageDesign.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import swtech.common.entity.BaseEntity;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 文章功能类-评论功能
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月22日 下午2:46:24
 **/
public class ArticleComment extends BaseEntity{

	private int gid;
	private int nodeId;
	private int uid;
	private String content;
	private int pid;
	private boolean isDelete;
	private String nickName;
	private String photo;
	private List<ArticleComment> children;
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<ArticleComment> getChildren() {
		return children;
	}
	public void setChildren(List<ArticleComment> children) {
		this.children = children;
	}
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "ArticleComment [gid=" + gid + ", nodeId=" + nodeId + ", uid=" + uid + ", content=" + content + ", pid="
				+ pid + ", isDelete=" + isDelete + ", nickName=" + nickName + ", photo=" + photo + ", children="
				+ children + "]";
	}
}
 