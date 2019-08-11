package swtech.facade.pageDesign.entity;

import java.util.Date;

import swtech.common.entity.BaseEntity;

public class KePuVideo extends BaseEntity {
	private Integer id;           //视频ID
	private String name;          //视频名称
	private String pic;           //视频图片
	private String url;           //路径
	private String ftype;         //视频类型
	private String fdesc;         //视频描述
	private Long   grade;         //视频所属年级
	private String grade_desc;    //年级描述
	private Long   praise_cnt;    //被点赞次数
	private Long   browse_cnt;    //被浏览次数
	private Integer is_recommend; //是否为推进视频
	private Integer is_from_kp;   //是否来自科普 0是 1否
	private Integer status;       //状态
	private Date create_time;     //创建时间
	private Date last_update_time;//最后更新时间时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	public Long getGrade() {
		return grade;
	}
	public void setGrade(Long grade) {
		this.grade = grade;
	}
	public String getGrade_desc() {
		return grade_desc;
	}
	public void setGrade_desc(String grade_desc) {
		this.grade_desc = grade_desc;
	}
	public Long getPraise_cnt() {
		return praise_cnt;
	}
	public void setPraise_cnt(Long praise_cnt) {
		this.praise_cnt = praise_cnt;
	}
	public Long getBrowse_cnt() {
		return browse_cnt;
	}
	public void setBrowse_cnt(Long browse_cnt) {
		this.browse_cnt = browse_cnt;
	}
	public Integer getIs_recommend() {
		return is_recommend;
	}
	public void setIs_recommend(Integer is_recommend) {
		this.is_recommend = is_recommend;
	}
	public Integer getIs_from_kp() {
		return is_from_kp;
	}
	public void setIs_from_kp(Integer is_from_kp) {
		this.is_from_kp = is_from_kp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}
	
}
