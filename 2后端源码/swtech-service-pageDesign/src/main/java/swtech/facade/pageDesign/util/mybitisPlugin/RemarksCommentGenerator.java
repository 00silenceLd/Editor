package swtech.facade.pageDesign.util.mybitisPlugin;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 官方类似的功能见，在版本1.3.3中添加的 addRemarkComments <br>
 * http://www.mybatis.org/generator/configreference/commentGenerator.html <br>
 * https://github.com/mybatis/generator/issues/23
 *
 * @see DefaultCommentGenerator#addRemarkComments
 */
public class RemarksCommentGenerator extends DefaultCommentGenerator {

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @数表名称 "+introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(" * @开发日期 "+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        topLevelClass.addJavaDocLine(" * @开发作者 by:long ");
        topLevelClass.addJavaDocLine(" */");
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remark = introspectedColumn.getRemarks();
        String columnName = introspectedColumn.getActualColumnName();
        List<IntrospectedColumn> primaryKey = introspectedTable.getPrimaryKeyColumns();
        for (IntrospectedColumn pk : primaryKey) {
        	if(columnName.equals(pk.getActualColumnName())){
        		remark +=" (主健ID)";
        		continue;	//主健属性上无需生明可选项跟必填项介绍
        	}
        	if (StringUtility.stringHasValue(remark)) {
        		remark += introspectedColumn.isNullable() ? "(可选项)" : "(必填项)";
        	}
		}
        String defaultValue = introspectedColumn.getDefaultValue();
        remark += null != defaultValue ? "  (默认值为: "+defaultValue+")" : " (无默认值)";
        field.addJavaDocLine("/** "+ remark+" */");
    }
}