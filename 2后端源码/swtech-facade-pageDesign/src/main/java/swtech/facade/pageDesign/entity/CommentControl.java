package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

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
 * @description : 评论控件
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年2月27日 下午3:28:20
 **/

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class CommentControl extends BaseControl{

	private String datasource;

	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		//&quot;
		if(datasource.contains("&quot;")) {
			this.datasource = datasource = datasource.replaceAll("&quot;", "\"");
		}else {
			this.datasource = datasource;
		}
		
	}
	

	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	
	@Override
	public String toString() {
		return "CommentControl [datasource=" + datasource + "]";
	}
}
 