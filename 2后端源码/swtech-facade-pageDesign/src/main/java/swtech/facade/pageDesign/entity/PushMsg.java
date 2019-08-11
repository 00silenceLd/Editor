package swtech.facade.pageDesign.entity;

public class PushMsg {
	private Integer id; 		//pkid
	private Integer sendUid;	//发送人id
	private String wxtagtype;	//通知对象类型
	private Integer msgflag;	//模板
	private String content;		//通知内容 json字符串
	private Long addTime; 		//添加时间
	private Integer isDelete;
	private String title;		//推送标题
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSendUid() {
		return sendUid;
	}
	public void setSendUid(Integer sendUid) {
		this.sendUid = sendUid;
	}
	public String getWxtagtype() {
		return wxtagtype;
	}
	public void setWxtagtype(String wxtagtype) {
		this.wxtagtype = wxtagtype;
	}
	public Integer getMsgflag() {
		return msgflag;
	}
	public void setMsgflag(Integer msgflag) {
		this.msgflag = msgflag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getAddTime() {
		return addTime;
	}
	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	

}
