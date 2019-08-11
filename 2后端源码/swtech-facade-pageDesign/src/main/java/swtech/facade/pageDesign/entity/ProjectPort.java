package swtech.facade.pageDesign.entity;

import swtech.common.entity.BaseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @描述 记录新建企业时其jar包的修改情况的实体类（主要是端口号的记录）
 * @author 曾泽亦
 */
public class ProjectPort extends BaseEntity{

    private Integer id;
    private String projectName;
    private String jarSuffixName;
    private Integer portNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getJarSuffixName() {
        return jarSuffixName;
    }

    public void setJarSuffixName(String jarSuffixName) {
        this.jarSuffixName = jarSuffixName == null ? null : jarSuffixName.trim();
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }
}