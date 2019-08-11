package Cs;

import java.io.Serializable;
import java.util.Date;
import swtech.common.entity.BaseEntity;

/**
 * @数表名称 cs
 * @开发日期 2018-06-21
 * @开发作者 by:long 
 */
public class Cs511 extends BaseEntity implements Serializable {
    /**   (默认值为: 0) */
    private Boolean isDelete;

    /** onlinehard(可选项) (无默认值) */
    private String data1;

    /** 关联的记录id(可选项) (无默认值) */
    private Integer gid;

    /** 处理人(可选项) (无默认值) */
    private String assignee;

    /** 任务id(可选项) (无默认值) */
    private String taskid;

    /** 流程实例id(可选项) (无默认值) */
    private String processinsid;

    /** 流程定义id(可选项) (无默认值) */
    private String processdefid;

    /** 发起人用户id(可选项) (无默认值) */
    private String userid;

    /** 保留字段(可选项) (无默认值) */
    private String other;

    /** 流程部署id(可选项) (无默认值) */
    private String deploymentid;

    /** 用户名(可选项) (无默认值) */
    private String username;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1 == null ? null : data1.trim();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee == null ? null : assignee.trim();
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public String getProcessinsid() {
        return processinsid;
    }

    public void setProcessinsid(String processinsid) {
        this.processinsid = processinsid == null ? null : processinsid.trim();
    }

    public String getProcessdefid() {
        return processdefid;
    }

    public void setProcessdefid(String processdefid) {
        this.processdefid = processdefid == null ? null : processdefid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getDeploymentid() {
        return deploymentid;
    }

    public void setDeploymentid(String deploymentid) {
        this.deploymentid = deploymentid == null ? null : deploymentid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", isDelete=").append(isDelete);
        sb.append(", data1=").append(data1);
        sb.append(", gid=").append(gid);
        sb.append(", assignee=").append(assignee);
        sb.append(", taskid=").append(taskid);
        sb.append(", processinsid=").append(processinsid);
        sb.append(", processdefid=").append(processdefid);
        sb.append(", userid=").append(userid);
        sb.append(", other=").append(other);
        sb.append(", deploymentid=").append(deploymentid);
        sb.append(", username=").append(username);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Cs511 other = (Cs511) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getData1() == null ? other.getData1() == null : this.getData1().equals(other.getData1()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAssignee() == null ? other.getAssignee() == null : this.getAssignee().equals(other.getAssignee()))
            && (this.getTaskid() == null ? other.getTaskid() == null : this.getTaskid().equals(other.getTaskid()))
            && (this.getProcessinsid() == null ? other.getProcessinsid() == null : this.getProcessinsid().equals(other.getProcessinsid()))
            && (this.getProcessdefid() == null ? other.getProcessdefid() == null : this.getProcessdefid().equals(other.getProcessdefid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getOther() == null ? other.getOther() == null : this.getOther().equals(other.getOther()))
            && (this.getDeploymentid() == null ? other.getDeploymentid() == null : this.getDeploymentid().equals(other.getDeploymentid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getData1() == null) ? 0 : getData1().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAssignee() == null) ? 0 : getAssignee().hashCode());
        result = prime * result + ((getTaskid() == null) ? 0 : getTaskid().hashCode());
        result = prime * result + ((getProcessinsid() == null) ? 0 : getProcessinsid().hashCode());
        result = prime * result + ((getProcessdefid() == null) ? 0 : getProcessdefid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getOther() == null) ? 0 : getOther().hashCode());
        result = prime * result + ((getDeploymentid() == null) ? 0 : getDeploymentid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}