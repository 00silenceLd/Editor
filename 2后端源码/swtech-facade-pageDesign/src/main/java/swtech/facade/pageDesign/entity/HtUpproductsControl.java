package swtech.facade.pageDesign.entity;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.alibaba.fastjson.JSONObject;


/*
 * 

 ┏┓　　　┏┓
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
* @ClassName: MultiDataSourcePublic
* @author 曾智宏
* @date 2019年6月9日
* @Description: 多数源发布标识控件
*
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class HtUpproductsControl extends BaseControl{
	private String placeholder;
	private String node_id;

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	@Override
	public String toString() {
		return "UpproductsControl [placeholder=" + placeholder + ", node_id=" + node_id + "]";
	}

	
	
	
	
	
	
}
 