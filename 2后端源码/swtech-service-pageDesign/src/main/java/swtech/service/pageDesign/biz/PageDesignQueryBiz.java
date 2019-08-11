package swtech.service.pageDesign.biz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.util.resourceLibraryCollection;
import swtech.facade.pageDesign.util.File.invokeUtil;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.PageDesignDao;

@Component("pageDesignQueryBiz")
//@Transactional(rollbackFor = Exception.class)
public class PageDesignQueryBiz {
	
	@Autowired
	private PageDesignDao pageDesignDao;
	
	@Autowired
	private NodeDao nodeDao;
	
	//获取表单内容
	public ReturnMsg getPageEditor(Long node_id) { 
		System.out.println("----------------------Node0"+node_id);
		//TODO 下行需要做优化
		Node node = nodeDao.getByNodeName(node_id.intValue());
		System.out.println("----------------------Node1======:"+node);
		return pageDesignDao.getPageEditor(node_id,null,null,null,node.getValue()); 
	}

	// 获取关联表单内容
	public ReturnMsg getPageEditorGid(Integer node_id,Long gid) {
		Node node = nodeDao.getByNodeName(node_id);
		
		return pageDesignDao.getPageEditorGid(node_id,gid,node.getValue());
	}
	
	//获取表单字段数据
	public ReturnMsg getPageEditorData(long nodeId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1","查询异常");
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String,Object> maps = new HashMap<String, Object>();
			Map node = pageDesignDao.getNodeByNodeId(nodeId);
			String nodeName= (String)node.get("node_name");
			if(nodeId == 3244) {
				//科普资源库
				maps = resourceLibraryCollection.getKePu();
				
			}else if(nodeName.equals("科普视频资源库")){
				//科普资源库
				maps = resourceLibraryCollection.getKuPuVideo();
			}else if(nodeName.equals("排课管理")){
				//科普资源库
				maps = resourceLibraryCollection.getPaiCourse();
			}else {
				
				PageEditor page = pageDesignDao.getByNodeId(nodeId);
				JSONArray jsonArray = JSONArray.parseArray(page.getTitle());
				//JSONObject jsonObject = JSONObject.parseObject(page.getSelected());
				//遍历字段 遍历名称
				int i = 1;
				LinkedHashMap<String, Object> jsonMap = JSON.parseObject(page.getSelected(),new TypeReference<LinkedHashMap<String, Object>>() {});
				for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
					// System.out.println(entry.getKey() + ":" + entry.getValue());
					map.put("text", jsonArray.get(i-1));
					map.put("value", entry.getKey());
					maps.put(i+"", map);
					map = new HashMap<String, Object>();
					i++;
				}
			}
			
			msg.setMsg(maps);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}

	//搜索热区关键字
	public ReturnMsg searchWifiKey(String data) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "无搜索结果");
		try {
		
			//获取搜索key
			JSONObject json = JSONObject.parseObject(data);
			String groupCon = json.getString("groupcon");
			Long nodeId = json.getLong("nodeId");
			String key = json.getString("key");
			String wifiField = json.getString("wifiField");
			
			Node node = nodeDao.getByNodeName(nodeId.intValue());
			
			msg = pageDesignDao.getPageEditor(nodeId,key,groupCon,wifiField,node.getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public ReturnMsg searchDatabase(String baseName) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "查询异常！");
		try {
			
			List<String> tableArr = pageDesignDao.searchDatabase(baseName);
			if(tableArr != null) {
				msg.setMsg(tableArr);
				msg.setStatus("0");
				msg.setStatusMsg("查询成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败！");
		}
		return msg;
	}

	public ReturnMsg searchDataField(String baseName,String tableName) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "查询异常！");
		try {
			
			List<String> fieldArr = pageDesignDao.searchDataField(baseName,tableName);
			if(fieldArr != null) {
				msg.setMsg(fieldArr);
				msg.setStatus("0");
				msg.setStatusMsg("查询成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败！");
		}
		return msg;
	}
 
}
