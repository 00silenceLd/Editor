package swtech.facade.pageDesign.entity;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * 
 * 排序筛选搜索控件筛选功能名存放 表名：ht_sort_search
 * 
 * @author
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class SortSearch extends  BaseControl {
	private Integer Id;            //id
	private Integer ParentId;
	private String Name;       //筛选功能名
	private String DataSource; //数据源
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getParentId() {
		return ParentId;
	}
	public void setParentId(Integer parentId) {
		ParentId = parentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDataSource() {
		return DataSource;
	}
	public void setDataSource(String dataSource) {
		DataSource = dataSource;
	}
	
	

}
