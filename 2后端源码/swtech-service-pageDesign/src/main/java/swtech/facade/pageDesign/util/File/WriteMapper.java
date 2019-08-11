package swtech.facade.pageDesign.util.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import swtech.facade.pageDesign.constants.PathConstants;
import swtech.facade.pageDesign.entity.PageEditor;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年11月17日 下午3:54:41 
 *
 * 写入接口方法
 *
 */

public class WriteMapper {

	/**
	 * 
	 * Swwfss
	 * @param param2 
	 * 
	 * */
	public static void writeMapperFile(String fileName,String nodeName, String param) {

		File file = new File(PathConstants.TARGET_PATH + fileName + "/"+ nodeName + "Mapper.xml");
		File file1 = new File(PathConstants.TARGET_PATH + fileName + "/"+ nodeName + "Mapper.java");
		BufferedReader reader = null;
		BufferedReader reader1 = null;
		StringBuffer sb = new StringBuffer();
		int mark = 0;
		try {
			
			//读写mapper.xml
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;

			while ((tempString = reader.readLine()) != null) {
				
				//包含插入语句  替换
				if(!tempString.contains("<insert id=\"insert\"")){
					sb.append(tempString+"\n");	
				}else{
					sb.append("<insert id=\"insert\" parameterType=\""+fileName+"."+nodeName+"\" useGeneratedKeys=\"true\" keyProperty=\"id\" >"+"\n");	
				}
				
				//增加模糊搜索语句
				//if(tempString.contains("<sql id=\"Base_Column_List\">"));
			}
			
			
			
			String str = sb.toString();
			if(!str.contains("selectList")){
				str = str.replace("</mapper>", "");
				sb.delete(0, sb.length());
				sb.append(str);
				sb.append("\n");
				sb.append("    <select id=\"selectList\"  resultMap=\"BaseResultMap\">");
				sb.append("\n");
				sb.append("        select * from "+fileName +" where is_delete = 0");
				sb.append("\n");
				sb.append("    </select>");
				sb.append("\n");
				
			}
			
			//添加查询接口
			if(param != null){
				String[] value = param.toString().split(",");
				//关联查询
				sb.append("\n");
				sb.append("    <select id=\"searchKey\" parameterType=\""+fileName+"."+nodeName+"\" resultMap=\"BaseResultMap\">");
				sb.append("\n");
				sb.append("        select * from "+fileName +" where is_delete = 0");
				sb.append("\n");
				for (int i = 0; i < value.length; i++) {
						sb.append("\t\t");
						sb.append("<if test=\""+value[i]+" != null\">");
						sb.append("\n");
						sb.append("\t\t\t");
						sb.append("AND "+value[i]+" LIKE #{"+value[i]+"}");
					    sb.append("\n");
					    sb.append("\t\t");
					    sb.append("</if>");
					    sb.append("\n");
				}
				sb.append("    </select>");
				sb.append("\n");
				//查询全部字段包含该关键字的记录
				sb.append("\n");
				sb.append("    <select id=\"searchAllKey\" parameterType=\"java.lang.String\" resultMap=\"BaseResultMap\">");
				sb.append("\n");
				sb.append("        select * from "+fileName+" where is_delete = 0");
				sb.append("\n");
				for (int i = 0; i < value.length; i++) {
							sb.append("\t\t");
							sb.append("<if test=\"_parameter != null\">");
							sb.append("\n");
							sb.append("\t\t\t");
							sb.append("OR "+value[i]+" LIKE #{_parameter,jdbcType=VARCHAR}");
							sb.append("\n");
							sb.append("\t\t");
						    sb.append("</if>");
						    sb.append("\n");
				}
				sb.append("    </select>");
				sb.append("\n");
				sb.append("\n");
				//添加批量删除命令
				sb.append("\t");
				sb.append("<delete id=\"deleteArray\" parameterType=\"int\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("delete from "+fileName+" where id in");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("<foreach item=\"ids\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("#{ids}");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("</foreach>");
				sb.append("\n");
				sb.append("\t");
				sb.append("</delete>");
				sb.append("\n");
				sb.append("\n");
				//添加分页查询
				sb.append("\t\t");
				sb.append("<select id=\"getQueryPage\" parameterType=\"java.util.Map\" resultMap=\"BaseResultMap\">");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("select * from "+fileName +" where is_delete = 0");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("<if test=\"tableFieldAll !=null and searchContent !=null\">");
			    sb.append("\n");
				sb.append("\t\t\t");
				sb.append("and  CONCAT_WS('null',${tableFieldAll}) LIKE \"%\"#{searchContent}\"%\" ");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("</if>");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("<if test=\"orderByClause != null\">");
				sb.append("\n");
				sb.append("\t\t\t\t");
			    sb.append("order by id ${orderByClause}");  
			    sb.append("\n");
				sb.append("\t\t\t");
			    sb.append("</if>");
				sb.append("<if test=\"page != null and pageSize >= 0\">");
				sb.append("\n");
				sb.append("\t\t\t\t");
				sb.append("limit #{page} , #{pageSize}");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("</if>");
				sb.append("\n");
				
				sb.append("\n");
				sb.append("    </select>");
				sb.append("\n");
				sb.append("\n");
				//查询数据总数
				sb.append("\t");
				sb.append("<select id=\"getCount\" resultType=\"java.lang.Long\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("select count(*) from "+fileName +" where is_delete = 0");
				sb.append("\n");
				sb.append("\t");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("</select>");
				sb.append("\n");
				sb.append("\n");
				//查询数据总数
				sb.append("\t");
				sb.append("<select id=\"getCountByQuery\" parameterType=\"java.util.Map\" resultType=\"java.lang.Long\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("select count(*) from "+fileName +" where is_delete = 0");
				sb.append("\n");
				sb.append("\t");
				sb.append("<if test=\"tableFieldAll !=null and searchContent !=null\">");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("and  CONCAT_WS('null',${tableFieldAll}) LIKE \"%\"#{searchContent}\"%\" ");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("</if>");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("</select>");
				sb.append("\n");
				sb.append("\n");
				//更新is_delete字段
				sb.append("\t");
				sb.append("<update id=\"updateDelete\" parameterType=\"java.util.Map\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("update "+fileName +" set is_delete = #{bl} where id = #{id}");
				sb.append("\n");
				sb.append("\t");
				sb.append("</update>");
				sb.append("\n");
				sb.append("\n");
				//回收多个数据
				sb.append("\t");
				sb.append("<update id=\"isDeleteArray\" parameterType=\"int\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("update "+fileName+" set is_delete = 1 where id in");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("<foreach item=\"ids\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("#{ids}");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("</foreach>");
				sb.append("\n");
				sb.append("\t");
				sb.append("</update>");
				sb.append("\n");
				sb.append("\n");
				//更新is_delete字段
				sb.append("\t");
				sb.append("<update id=\"reNewData\" parameterType=\"int\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("update "+fileName +" set is_delete = 0 where id = #{id}");
				sb.append("\n");
				sb.append("\t");
				sb.append("</update>");
				sb.append("\n");
				sb.append("\n");
				//恢复多条数据
				sb.append("\t");
				sb.append("<update id=\"reNewDataArray\" parameterType=\"int\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("update "+fileName+" set is_delete = 0 where id in");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("<foreach item=\"ids\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">");
				sb.append("\n");
				sb.append("\t\t\t");
				sb.append("#{ids}");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("</foreach>");
				sb.append("\n");
				sb.append("\t");
				sb.append("</update>");
				sb.append("\n");
				sb.append("\n");
				//动态查询事务管理
				//分页查询  也要加防注入 这里也要
				sb.append("\t");
				sb.append("<select id=\"getReportForm\" parameterType=\"java.lang.String\" resultMap=\"BaseResultMap\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("${_parameter}");
				sb.append("\n");
				sb.append("\t");
				sb.append("</select>");
				sb.append("\n");
				sb.append("\n");
				//资源库关联查询
				sb.append("\t");
				sb.append("<select id=\"getResourceLibrary\" parameterType=\"java.lang.String\" resultType=\"java.util.Map\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("${_parameter}");
				sb.append("\n");
				sb.append("\t");
				sb.append("</select>");
				sb.append("\n");
				sb.append("\n");
				//查询回收站信息
				sb.append("\t");
				sb.append("<select id=\"searchIsDelete\" resultMap=\"BaseResultMap\">");
				sb.append("\n");
				sb.append("\t\t");
				sb.append("        select * from "+fileName+" where is_delete = 1");
				sb.append("\n");
				sb.append("\t");
				sb.append("</select>");
				sb.append("\n");
				sb.append("\n");
				sb.append("</mapper>");
				
				//searchIsDelete
			}else{
				sb.append("</mapper>");
			}
			
			
			
			createFile(sb.toString(), PathConstants.TARGET_PATH + fileName + "/"+ nodeName + "Mapper.xml");
			sb.delete(0, sb.length());

			//读写mapperImpl.java
			reader1 = new BufferedReader(new FileReader(file1));
			String tempString1 = null;
			int i = 0;
			while ((tempString1 = reader1.readLine()) != null) {
				sb.append(tempString1+"\n");	
				
				if(i == 1){
					sb.append("import java.util.Map;");
					sb.append("\n");
				}
				i++;
			}
			String str1 = sb.toString();
			
			if(!str1.contains("selectList")){
				sb.deleteCharAt(sb.length() - 2);
				sb.deleteCharAt(sb.length() - 1);
				sb.append("\n");
				sb.append("public List<"+nodeName+"> selectList();");
				sb.append("\n");
				sb.append("\n");
				sb.append("public List<"+nodeName+"> searchKey("+nodeName+" entity);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public List<"+nodeName+"> searchAllKey(String str);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long deleteArray(int[] ids);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public List<"+nodeName+"> getQueryPage(Map<String,Object> map);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long getCount();");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long getCountByQuery(Map<String,Object> map);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long updateDelete(Map<String, Object> map);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long updateByPrimaryKeySelective("+nodeName+" entity);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long isDeleteArray(int[] ids);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long reNewData(int id);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public long reNewDataArray(int[] ids);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public List<"+nodeName+"> getReportForm(String sql);");
				sb.append("\n");
				sb.append("\n");
				sb.append("public List<"+nodeName+"> searchIsDelete();");
				sb.append("\n");
				sb.append("\n");
				sb.append("public List<Map<String, String>> getResourceLibrary(String sql);");
				sb.append("\n");
				sb.append("\n");
				 
				sb.append("}");
			}

			createFile(sb.toString(), PathConstants.TARGET_PATH + fileName + "/"+ nodeName + "Mapper.java");
			reader.close();
			reader1.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
    public static void createFile(String fileContent, String fileName) {
        try {
            File file = new File(fileName);
            System.out.print("保存的文件路径是："+fileName);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            PrintWriter out = new PrintWriter(file, "UTF-8");
            out.write(fileContent);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
	//首字母大写
	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
		//char[] cs = name.toCharArray();
		//cs[0] -= 32;
		//return String.valueOf(cs);
	}
	
	public static String Html(String filePath,Integer nodeId) {
		try {
			
			BufferedReader reader = null;
			File file = new File(filePath);
			reader = new BufferedReader(new FileReader(file));
			String tempString1 = null;
			StringBuffer sb = new StringBuffer();
			int i = 0;
			while ((tempString1 = reader.readLine()) != null) {
				
				if(tempString1.contains("${nodeId}")) {
					tempString1 = tempString1.replace("${nodeId}", nodeId+"");
				} 
				sb.append(tempString1+"\n");
				i++;
			}
			
			WriteMapper.createFile(sb.toString(), file.getAbsolutePath());
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filePath;
	}

	public static String[] writeNodeName(String node_name) throws IOException {
		String tempString = "";
		try {
			node_name = Pinyin4jUtil.toPinyin(node_name);
			node_name = captureName(node_name.toLowerCase());
			
			BufferedReader buff = null;
			File file =  new File(PathConstants.TARGET_PATH + node_name+"/"+node_name+".sw");
			System.out.println("==========file===="+file.getPath());
			if(file.exists()) {
				buff = new BufferedReader(new FileReader(file));
				tempString = buff.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] str = {node_name,tempString.trim()};
		return str;
	}

	//修改预览项目页面表单ID
	public static void editorHtml(String path, Integer id) throws IOException {
		
		File file = new File(path);
		BufferedReader buff = null;
		buff = new BufferedReader(new FileReader(file));
		String tempString = "";
		StringBuffer sb = new StringBuffer();
		while ((tempString = buff.readLine()) != null ) {
			
			if(tempString.contains("var exportIsLink = false;")) {
				sb.append("        var exportIsLink = true;" + "\n");
			}else if(tempString.contains("var exportNodeId = ")) {
				sb.append("            var exportNodeId = "+id+";" + "\n");
			}else {
				sb.append(tempString + "\n");
			}
			
		}

		//创建文件
		buff.close();
		createFile(sb.toString(), path);
	}
	
	//修改预览项目页面下表单ID
	public static void editorHtmls(String path, Integer id) throws IOException {

		File file = new File(path);
		BufferedReader buff = null;
		buff = new BufferedReader(new FileReader(file));
		String tempString = "";
		StringBuffer sb = new StringBuffer();
		
		
		while ((tempString = buff.readLine()) != null ) {
			
			if(tempString.contains("var exportIsLink = false;")) {
				sb.append("        var exportIsLink = true;" + "\n");
			}else if(tempString.contains("var exportNodeId = ")) {
				sb.append("            var exportNodeId = "+id+";" + "\n");
			}else {
				sb.append(tempString + "\n");
			}
		}
		
		//创建文件
		buff.close();
		createFile(sb.toString(), path.replace("preview.html", id+".html"));
		
	}
}