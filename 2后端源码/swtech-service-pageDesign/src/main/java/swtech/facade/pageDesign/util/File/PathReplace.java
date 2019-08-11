package swtech.facade.pageDesign.util.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import swtech.facade.pageDesign.constants.PathConstants;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年11月23日 上午11:19:39 
 *
 * 替换路径 自动填充
 *
 */

public class PathReplace {

	public static String replaceFile(String fileName,String nodeName) {	
		
		File file = new File(PathConstants.TARGET_PATH + fileName);
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		String name = nodeName+new Random().nextInt(1000);
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				tempString = tempString.replace("/home/pageDesign", PathConstants.ROOT_PATH);
				if(nodeName != null) {
					tempString = tempString.replace("domainObjectName=\"swwfss\"", "domainObjectName=\""+name+"\"");
					tempString = tempString.replace("<table tableName=\"swwfss\" ", "<table tableName=\""+nodeName+"\" ");
					tempString = tempString.replace(" targetPackage=\"Swwfss\" ", " targetPackage=\""+nodeName+"\" ");
				}
				sb.append(tempString+"\n");
			}
			createFile(sb.toString(), PathConstants.TARGET_PATH + fileName);
				
		} catch (Exception e) {
			e.printStackTrace();	                    
		}
		return name;
	}
	public static void createFile(String fileContent, String fileName) {
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.getParentFile().mkdir();
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
}
 