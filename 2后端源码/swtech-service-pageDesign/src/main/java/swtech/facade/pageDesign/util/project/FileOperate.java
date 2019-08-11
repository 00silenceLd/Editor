package swtech.facade.pageDesign.util.project;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import swtech.facade.pageDesign.constants.PathConstants;

/**
 * @描述 文件操作工具类
 * @author 曾泽亦
 */
public class FileOperate {
	private static final Logger log = LoggerFactory.getLogger(FileOperate.class);
    /**
     * @描述 新增文件夹
     * @author 曾泽亦
     */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            // 判断目录是否存在
            log.info("创建目录失败，目标目录已存在！");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            // 结尾是否以"/"结束
            destDirName = destDirName + File.separator;
        }
        if (dir.mkdirs()) {
            // 创建目标目录
            log.info("创建目录成功！" + destDirName);
            return true;
        } else {
            log.info("创建目录失败！");
            return false;
        }
    }

    /**
     * @描述 调用linux的命令复制文件到指定目录下
     * @param filePath（文件全路径）
     * @param targetDirPath（目标文件夹路径，存放复制文件的目录）
     * @author 曾泽亦
     */
    public static String copyFile(String filePath , String targetDirPath) {
        boolean status = createDir(targetDirPath);
        //调用linux的命令复制文件到指定目录下
        String command = "cp "+ filePath+" "+ targetDirPath;
        String msg = Command.exeCommand(command);
        return msg;
    }

    /**
     * @描述 创建文件
     * @author 曾泽亦
     * @param fileName
     * @return
     */
    public static boolean createFile(String fileName)throws Exception{
        File file = new File(fileName);
        boolean flag=false;
        try{
            if(!file.exists()){
                file.createNewFile();
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * @描述 写入内容到txt文件
     * @author 曾泽亦
     * @param fileName
     * @return
     */
    public static boolean writeTxtFile(String content,String  fileName)throws Exception{
        RandomAccessFile mm=null;
        boolean flag=false;
        FileOutputStream o=null;
        try {
            File file = new File(fileName);
            o = new FileOutputStream(fileName);
            o.write(content.getBytes("UTF-8"));
            o.close();
//            mm=new RandomAccessFile(fileName,"rw");
//            mm.writeBytes(content);
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(mm!=null){
                mm.close();
            }
        }
        return flag;
    }

    /**
     * @描述 调用linux命令，复制文件夹下的所有文件和文件夹到另一个文件夹中（用正常的字节流写入写出太慢了）
     * @author 曾泽亦
     * @param oldPath
     * @param newPath
     * @注意 两个参数（文件路径）最后都不带"/"的
     * @throws IOException
     */
    public static String copyDir(String oldPath, String newPath) throws IOException {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }
        String command = "cp -R "+oldPath+"/. "+ newPath;
        Command.exeCommand(command);
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //输出程序运行时间
        String time =(endTime-startTime)/1000+"s";
//        String time = (endTime-startTime)+"ms";
        log.info("程序运行时间："+(endTime-startTime)/1000+"s");
        return time;
    }

    /**
     * @描述 删除指定文件夹下所有文件
     * @author 曾泽亦
     * @param path
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

    /**
     * @描述 删除文件夹
     * @author 曾泽亦
     * @param folderPath  文件夹完整绝对路径
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @描述 删除文件
     * @author 曾泽亦
     * @param filePath 文件的完整路径
     */
    public static void delFile(String filePath){
        File file=new File(filePath);
        if(file.exists()&&file.isFile())
            file.delete();
    }

    /**
     * @描述 读写前端的js全局配置文件（使用临时文件是为了清空源文件的缓存）
     * @author 曾泽亦
     * @throws Exception
     */
    public static String readJSConfig(String companyName,String oldPort,String newPort) throws Exception {
        String fileName = "/usr/local/nginx/html/"+companyName+"/public/config.js";
        //先写到临时文件再写回来
        String temp = "/usr/local/nginx/html/"+companyName+"/public/temp.js";
        //创建临时文件
        createFile(temp);
        //读取文件到临时文件
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while((line= br.readLine()) != null) {
            //判断文件的某一行是否有"'"这个符号
            if(line.indexOf("'")!=-1){
                String[] strings = line.split("'");
                if(!("http://192.168.0.192:"+oldPort).trim().equals(strings[1].trim()) &&
                        !("http://192.168.0.251:"+oldPort).trim().equals(strings[1].trim()) &&
                        !("http://1388w.cn:"+oldPort).trim().equals(strings[1].trim())){
                    sb.append(line);
                    sb.append("\r\n");
                }else{
                    sb.append(strings[0]+"'http://192.168.0.201:"+newPort+"'"+";");
                    sb.append("\r\n");
                }
            }
        }
        String jsConfig = sb.toString();
        //写回去
        RandomAccessFile mm = new RandomAccessFile(temp, "rw");
        mm.writeBytes(jsConfig);
        mm.close();
        //删除源文件（js全局配置文件）
        delFile(fileName);
        //新建js全局配置文件（目的是清空了文件所有缓存）
        createFile(fileName);
        //将临时文件的内容读取到目标文件（新的全局配置文件）
        BufferedReader tempBr = new BufferedReader(new FileReader(temp));
        StringBuffer sb2 = new StringBuffer();
        while((line= tempBr.readLine()) != null) {
            sb2.append(line);
            sb2.append("\r\n");
        }
        String jsConfig2 = sb2.toString();
        //先写到临时文件
        RandomAccessFile mm2 = new RandomAccessFile(fileName, "rw");
        mm2.writeBytes(sb2.toString());
        mm2.close();
        //删除临时文件
        delFile(temp);
        return jsConfig2;
    }

    /**
     * @描述 读写新建的jar包在linux下的启动脚本
     * @author 曾泽亦
     * @throws IOException
     */
    public static String readJarStartupScripts(String companyName) throws Exception {
        //获取开始时间
        long startTime = System.currentTimeMillis();
//        String fileName = "/root/"+companyName+"/start.sh";
        String fileName = PathConstants.THIS_ROOT_ATALOGUE+companyName+"/start.sh";
        //先写到临时文件再写回来
        String temp = "/usr/local/nginx/html/"+companyName+"/public/temp.js";
        //创建临时文件
        createFile(temp);
        //读取文件到临时文件
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while((line= br.readLine()) != null) {
            if(("fileName=\"jar\";").trim().equals(line.trim())){
                //修改启动文件里的jar包路径
                sb.append("fileName=\""+companyName+"\";");
                sb.append("\r\n");
            }else if(("fileName2=\"java\";").trim().equals(line.trim())){
                //修改启动文件里的jar包路径
                sb.append("fileName2=\""+companyName+"/pageDesignService\";");
                sb.append("\r\n");
            }else{
                sb.append(line);
                sb.append("\r\n");
            }
        }
        String startupScripts = sb.toString();
        //先写到临时文件
        RandomAccessFile mm = new RandomAccessFile(temp, "rw");
        mm.writeBytes(startupScripts);
        mm.close();
        //删除源文件（js全局配置文件）
        delFile(fileName);
        //新建js全局配置文件（目的是清空了文件所有缓存）
        createFile(fileName);
        //将临时文件的内容读取到目标文件（新的全局配置文件）
        BufferedReader tempBr = new BufferedReader(new FileReader(temp));
        StringBuffer sb2 = new StringBuffer();
        while((line= tempBr.readLine()) != null) {
            sb2.append(line);
            sb2.append("\r\n");
        }
        String jsConfig2 = sb2.toString();
        //写回去
        RandomAccessFile mm2 = new RandomAccessFile(fileName, "rw");
        mm2.writeBytes(jsConfig2);
        mm2.close();
        //删除临时文件
        delFile(temp);
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //计算程序运行的时间
        String time =(endTime-startTime)/1000+"s";
        log.info("程序运行时间："+time);
        return time;
    }

    /**
     * @描述 读写新建的jar包在linux下的停止脚本
     * @author 曾泽亦
     * @throws IOException
     */
    public static String readJarStoppedScripts(String companyName) throws Exception {
        //获取开始时间
        long startTime = System.currentTimeMillis();
//        String fileName = "/root/"+companyName+"/stop.sh";
        String fileName = PathConstants.THIS_ROOT_ATALOGUE+companyName+"/stop.sh";
        //先写到临时文件再写回来
        String temp = "/usr/local/nginx/html/"+companyName+"/public/temp.js";
        //创建临时文件
        createFile(temp);
        //读取文件到临时文件
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while((line= br.readLine()) != null) {
            if(("fileName=\"jar\";").trim().equals(line.trim())) {
                //修改启动文件里的jar包路径
                sb.append("fileName=\"" + companyName + "\";");
                sb.append("\r\n");
            }else{
                sb.append(line);
                sb.append("\r\n");
            }
        }
        String stopupScripts = sb.toString();
        //先写到临时文件
        RandomAccessFile mm = new RandomAccessFile(temp, "rw");
        mm.writeBytes(stopupScripts);
        mm.close();
        //删除源文件（js全局配置文件）
        delFile(fileName);
        //新建js全局配置文件（目的是清空了文件所有缓存）
        createFile(fileName);
        //将临时文件的内容读取到目标文件（新的全局配置文件）
        BufferedReader tempBr = new BufferedReader(new FileReader(temp));
        StringBuffer sb2 = new StringBuffer();
        while((line= tempBr.readLine()) != null) {
            sb2.append(line);
            sb2.append("\r\n");
        }
        String jsConfig2 = sb2.toString();
        //写回去
        RandomAccessFile mm2 = new RandomAccessFile(fileName, "rw");
        mm2.writeBytes(jsConfig2);
        mm2.close();
        //删除临时文件
        delFile(temp);
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //计算程序运行的时间
        String time =(endTime-startTime)/1000+"s";
        log.info("程序运行时间："+time);
        return time;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        delAllFile("D:\\测试");
        long endTime = System.currentTimeMillis();    //获取结束时间
        log.info("程序运行时间：" + (endTime - startTime) + "ms");      //输出程序运行时间
    }

}
