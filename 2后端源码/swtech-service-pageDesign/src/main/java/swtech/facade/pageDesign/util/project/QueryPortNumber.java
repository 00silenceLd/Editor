package swtech.facade.pageDesign.util.project;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @描述 调用linux命令查询251主机下已被占用的端口号 工具类
 * @author 曾泽亦
 */
public class QueryPortNumber {
	private static final Logger log = LoggerFactory.getLogger(QueryPortNumber.class);
    /**
     * @描述 调用linux命令查询192主机下已被占用的端口号
     * @author 曾泽亦
     */
    public static List<Integer> queryPortNumber(){
        List<Integer> list = new ArrayList<Integer>();
        String command = "netstat -anptu";
        String s = Command.exeCommand(command);
        String[] strings = s.split("\n");
        int port = 0;
        for(int  i=2;i<strings.length;i++){
            String s1 = strings[i];
            String[] strings2 = s1.split("\\s+");
            String s2 = strings2[3];
            s2 = StringUtils.substringAfterLast(s2, ":");
            try {
                port = Integer.parseInt(s2);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            log.info(""+port);
            //添加属于40000-50000范围的端口到list集合
            if(40000<=port && port<=50000){
                list.add(port);
                Collections.sort(list);
            }
        }
        return list;
    }

    /**
     * @描述 可用端口号集合
     * @author 曾泽亦
     * @param projectPortList（已创建项目使用的端口号集合s）
     */
    public static List<Integer> availablePortList(List<Integer> projectPortList){
        List list = new ArrayList<Integer>();
        //192主机下已被占用的端口号集合
        List exitPortList = queryPortNumber();
        //不能使用的端口号集合（包括表的和主机被占用的）
        List<Integer> allList = new ArrayList<Integer>();
//        for(int i=40000;i<50000;i++){
        for(int i=40000;i<50000;i++){
            allList.addAll(exitPortList);
            allList.addAll(projectPortList);
            //set去重
            allList = new ArrayList(new HashSet(allList));
            if(!allList.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
    /**
     * @描述 获取可用端口号集合的第一个元素作为端口号（40000-50000之间的端口号）
     * @author 曾泽亦
     * @param projectPortList（已创建项目使用的端口号集合s）
     */
    public static Integer getAvailablePort(List<Integer> projectPortList){
        //获取所有可用端口的集合
        List list = availablePortList(projectPortList);
        Integer portNumber = null;
        if(list != null && list.size() >= 1){
            portNumber = (Integer)list.get(0);
        }
        return portNumber;
    }
}
