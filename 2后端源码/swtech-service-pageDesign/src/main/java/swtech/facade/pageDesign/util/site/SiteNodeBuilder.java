package swtech.facade.pageDesign.util.site;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.alibaba.fastjson.JSONObject;

import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.util.File.SpringTool;
import swtech.service.pageDesign.dao.NodeDao;

/**
 * @描述 将list数组构建成树形结构
 * @author 林致杰
 *
 */
public class SiteNodeBuilder {
	
	private static List<Node> node1 = new ArrayList<Node>();
	
	private static NodeDao nodeDao = (NodeDao) SpringTool.getBean("nodeDao");

	
	

}
