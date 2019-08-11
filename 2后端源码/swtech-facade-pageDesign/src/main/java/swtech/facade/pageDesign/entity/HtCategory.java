package swtech.facade.pageDesign.entity;

import java.io.Serializable;

import swtech.common.entity.BaseEntity;

/**
 * 	袁君选
 * @author Administrator
 *	新增类别
 */
public class HtCategory extends BaseEntity  implements Serializable {
    private Integer cid;

    private String categoryname;

    private Integer relevance;

    private Integer state;

    public HtCategory() {
    }

    public HtCategory(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}