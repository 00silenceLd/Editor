package swtech.facade.pageDesign.entity;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import swtech.common.entity.BaseEntity;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class QueryVo extends BaseEntity {
	private String table_name; // 搜索的表名即绑定的数据源
	private String table_field;// 搜索的字段名
	private String searchContent;// 搜索内容
	private String sortingConditions;// 排序的条件
	private Integer currentPage = 1; // 当前页 默认为1
	private String searchId; // 标识
	private String table_field_all; // 该表所有字段

	public String getTable_field_all() {
		return table_field_all;
	}

	public void setTable_field_all(String table_field_all) {
		this.table_field_all = table_field_all;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {

		this.table_name = table_name;
	}

	public String getTable_field() {
		return table_field;
	}

	public void setTable_field(String[] table_field) {
		StringBuffer sb = new StringBuffer();
		if (table_field.length > 0) {
			for (int i = 0; i < table_field.length; i++) {
				if (i == 0) {
					sb.append(table_field[i]);
				}
				if (i >= 1) {
					sb.append("," + table_field[i]);
				}
			}
		}
		this.table_field = sb.toString();
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String getSortingConditions() {
		return sortingConditions;
	}

	public void setSortingConditions(String sortingConditions) {
		this.sortingConditions = sortingConditions;
	}

}
