package swtech.facade.pageDesign.util.project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import swtech.facade.pageDesign.constants.PathConstants;

/**
 * @描述 jar包操作工具类
 * @author 曾泽亦
 */
public class JarPackageOperationUtil {
	private static final Logger log = LoggerFactory.getLogger(JarPackageOperationUtil.class);
    /**
     * @描述 jar包解压缩
     * @author 曾泽亦
     * @param jarPackagePath（需要解压的jar包路径）
     * @param decompressingFilesPath（解压jar包后的临时文件目录）
     * @linux下解压jar包的命令 unzip jar包全路径（包括jar包名） -d 解压路径
     */
    public static boolean jarPackageDecompression(String jarPackagePath , String decompressingFilesPath) {
        //以最后一个"/"为分隔符截取前面的字符串。
        String jarPath = StringUtils.substringBeforeLast(jarPackagePath , "/");
        //以最后一个"/"为分隔符截取后面的字符串。
        String jarName = StringUtils.substringAfterLast(jarPackagePath , "/");
        //如果解压目录不存在则创建一个新的解压目录
        if (!(new File(decompressingFilesPath)).exists()) {
            (new File(decompressingFilesPath)).mkdir();
        }
        //linux系统必须支持unzip命令，不然会报错
        String command = "unzip "+jarPackagePath+" -d "+decompressingFilesPath;
        log.info("============command1============"+command);
        Command.exeCommand(command);
        return true;
    }

    /**
     * @描述 将指定目录下的所有文件压缩为jar包
     * @author 曾泽亦
     * @param decompressingFilesPath（解压jar包后的临时文件目录）
     * @param newJarPackagePath（生成新jar包的路径）
     * @linux下压缩jar包的命令 jar cvfm 压缩后的jar包全路径（包括jar包名） MANIFEST（主清单文件） -C 需要压缩的文件目录（）
     */
    public static boolean jarPacketCompression(String decompressingFilesPath , String newJarPackagePath){
        String command = "jar cvfm "+newJarPackagePath+" "+decompressingFilesPath+"/META-INF/MANIFEST.MF -C "+decompressingFilesPath +" .";
        log.info("============command2============"+command);
        Command.exeCommand(command);
        return true;
    }

    /**
     * @描述 复制后台项目到新建的公司目录下面
     * @author 曾泽亦
     * @param companyName（公司名称）
     * @return
     */
    public static boolean copyBackgroundProject(String companyName) throws IOException {
        //jar包的新建路径前缀
//        String jarPrefixPath = "/root/"+companyName;
        String jarPrefixPath = PathConstants.THIS_ROOT_ATALOGUE+companyName;
        //复制快速开发平台项目的所有后台jar包到新的目录下
//        FileOperate.copyDir("/root/jar" , jarPrefixPath);
        FileOperate.copyDir(PathConstants.THIS_ROOT_ATALOGUE+"jar" , jarPrefixPath);
        return true;
    }

    /**
     * @描述 复制百度编辑器项目（/root/java目录下的jar包和一些其他文件）到指定位置
     * @author 曾泽亦
     * @param companyName（公司名称）
     * @return
     */
    public static boolean copyPageDesignProject(String companyName) throws IOException {
        //jar包的新建路径前缀
//        String jarPrefixPath = "/root/"+companyName;
        String jarPrefixPath = PathConstants.THIS_ROOT_ATALOGUE+companyName;
        //复制/root/java目录下的百度编辑器的jar包和其他文件到指定目录下
        String targetDirPath = jarPrefixPath+"/pageDesignService";
        //复制百度编辑器jar包到指定目录下
//        String msg = FileOperate.copyFile("/root/java/swtech-service-pageDesign.jar" , targetDirPath);
        String msg = FileOperate.copyFile(PathConstants.THIS_ROOT_ATALOGUE+"java/swtech-service-pageDesign.jar" , targetDirPath);
        //复制lib文件夹到指定目录的lib目录下
//        FileOperate.copyDir("/root/java/lib/" , targetDirPath+"/lib");
        FileOperate.copyDir(PathConstants.THIS_ROOT_ATALOGUE+"java/lib/" , targetDirPath+"/lib");
        //复制配置文件到指定目录下
//        msg = FileOperate.copyFile("/root/java/ConfigFile/config.json" , targetDirPath);//曾智宏
//        msg = FileOperate.copyFile("/root/java/ConfigFile/config.properties" , targetDirPath);//曾智宏
        msg = FileOperate.copyFile(PathConstants.THIS_ROOT_ATALOGUE+"java/ConfigFile/config.json" , targetDirPath);//曾智宏
        msg = FileOperate.copyFile(PathConstants.THIS_ROOT_ATALOGUE+"java/ConfigFile/config.properties" , targetDirPath);//曾智宏
        return true;
    }

    /**
     * @描述 修改指定jar包的数据源和dubbo访问暴露端口
     * @author 曾泽亦
     * @param companyName（公司名称）
     * @param jarSuffixPath（jar包存放在服务器的后缀路径）
     * @param dubboPort（dubbo暴露的访问端口）
     * @return
     * @throws IOException
     */
    public static boolean updateDatasourceAndDubboPort(String companyName,String jarSuffixPath,String dubboPort) throws IOException {
        //jar包的新建路径前缀
//        String jarPrefixPath = "/root/"+companyName;
        String jarPrefixPath = PathConstants.THIS_ROOT_ATALOGUE+companyName;
        //存放jar包解压文件的临时目录
        String tempPath = jarPrefixPath+"/temp";
        //解压指定jar包到临时目录
        JarPackageOperationUtil.jarPackageDecompression(jarPrefixPath+jarSuffixPath,tempPath);
        //修改mybatis配置文件的datasource和dubbo配置文件的访问端口
        String mybatisPath=tempPath+"/spring/spring-mybatis.xml";
        String dubboPath=tempPath+"/spring/spring-dubbo-provider.xml";
        new ReadWriteXMLFileUtil(mybatisPath,companyName,dubboPath,dubboPort);
        //将指定目录下的所有文件压缩为jar包
        JarPackageOperationUtil.jarPacketCompression(tempPath , jarPrefixPath+jarSuffixPath);
        //清空临时目录里的文件
        FileOperate.delAllFile(tempPath);
        return true;
    }
}
