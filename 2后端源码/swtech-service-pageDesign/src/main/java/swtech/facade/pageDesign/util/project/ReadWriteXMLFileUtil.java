package swtech.facade.pageDesign.util.project;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * @描述 xml文件读写工具类
 * @author 曾泽亦
 */
public class ReadWriteXMLFileUtil {

    /**
     * @描述 使用构造函数传参，调用修改mybatis和dubbo的配置文件的方法
     * @author 曾泽亦
     */
    public ReadWriteXMLFileUtil(String mybatisPath, String datasource, String dubboPath, String dubboPort){
        //修改配置mybatis的xml文件的datasource属性
        modifyXmlDatasource(mybatisPath , datasource);
        //修改配置dubbo的xml文件的接口访问端口
        modifyXmlDubboPort(dubboPath,dubboPort);
    }

   private static Logger logger = Logger.getLogger(ReadWriteXMLFileUtil.class) ;

    /**
     * @描述 根据文件路径读取xml文件,获取根节点
     * @author 曾泽亦
     * @param filePath
     * @return
     */
    public static Element readXml(String filePath){

        InputStream in = null;
        Element root = null;
        // 解析xml文档内容
        try {
            SAXReader reader = new SAXReader();
            in = new FileInputStream(new File(filePath));
            Document doc = reader.read(in);
            //获取根节点
            root = doc.getRootElement();
            logger.debug("XMLUtil.readXml root name:" + root.getName());
        } catch (Exception e) {
            logger.error("XMLUtil.readXml error: "+ e);
            return null;
        }
        finally {
            close(null,null,in);
        }
        return root;
    }

    /**
     * @描述 修改配置mybatis的xml文件的datasource属性
     * @author 曾泽亦
     * @param datasource
     */
    public static boolean modifyXmlDatasource(String filePath , String datasource){
        InputStream in = null;
        try {
            SAXReader reader = new SAXReader();
            in = new FileInputStream(new File(filePath));
            Document doc = reader.read(in);
            //获取根节点
            Element root = doc.getRootElement();
            // 获取bean节点
            List<Element> list = root.elements("bean");
            //遍历获取datasource节点，修改其url属性
            for(Element e : list){
                if("dataSource".equals(e.attributeValue("id"))){
                    List<Element> childrens = e.elements();
                    for(Element children : childrens){
                        if("url".equals(children.attributeValue("name"))){
                           logger.info("==========children========="+children);
                            Attribute attrDate=children.attribute("value");//获取此节点的指定属性
                            attrDate.setValue("jdbc:mysql://192.168.0.22:33060/"+datasource);//更改此属性值
                        }
                    }
                }
            }
            File file = new File(filePath);
            //回写xml
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file), format);
            xmlWriter.write(doc);
            //关闭流
            xmlWriter.close();

        } catch (Exception e) {
            logger.error("XMLUtil.readXml error: "+ e);
            return false;
        } finally {
            close(null,null,in);
        }
        return true;
    }

    /**
     * @描述 修改配置dubbo的xml文件的接口访问端口
     * @author 曾泽亦
     * @param dubboPost
     */
    public static boolean modifyXmlDubboPort(String filePath , String dubboPost){
        InputStream in = null;
        // 解析xml文档内容
        try {
            SAXReader reader = new SAXReader();
            in = new FileInputStream(new File(filePath));
            Document doc = reader.read(in);
            //获取根节点
            Element root = doc.getRootElement();
            // 获取dubbo节点
            logger.info("======root====="+root);
            //所有一级子节点的list
            List<Element> list=root.elements();
//            Element e = root.element("dubboRegistry");

            for(Element e : list){
                if("tomcat".equals(e.attributeValue("server"))){
                    logger.info("======e====="+e);
                    //获取此节点的指定属性
                    Attribute attrDate=e.attribute("port");
                    //更改此属性值
                    attrDate.setValue(dubboPost);
                }
            }
            File file = new File(filePath);
            //回写xml
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file), format);
            xmlWriter.write(doc);
            //关闭流
            xmlWriter.close();
        } catch (Exception e) {
            logger.error("XMLUtil.readXml error: "+ e);
            return false;
        } finally {
            close(null,null,in);
        }
        return true;
    }

    /**
     * 对指定的节点添加子节点和对象的文本内容
     * @author chenleixing
     */
    public static void addNode(Element node,String nodeName,String content){
        Element newNode=node.addElement(nodeName);//对指定的节点node新增子节点,名为nodeName
        newNode.setText(content);//对新增的节点添加文本内容content
    }

    /**
     * 对指定的节点属性进行添加
     * @author chenleixing
     */
    public static void addAttribute(Element root,String nodeName,String attribute,String value){
        //获取指定名字的节点，无此节点的会报NullPointerException,时间问题不做此情况的判断与处理了
        Element node=root.element(nodeName);
        node.addAttribute(attribute,value);//添加的属性
    }

    /**
     * 对指定的节点属性进行修改
     * @author chenleixing
     */
    public static void editAttribute(Element root,String nodeName,String attribute,String value){
        //获取指定名字的节点，无此节点的会报NullPointerException,时间问题不做此情况的判断与处理了
        Element node=root.element(nodeName);
        Attribute attrDate=node.attribute(attribute);//获取此节点的指定属性
        attrDate.setValue(value);//更改此属性值
    }

    /**
     * 对指定的节点属性进行删除
     * @author chenleixing
     */
    public static void deleteAttribute(Element root,String nodeName,String attribute){
        //获取指定名字的节点，无此节点的会报NullPointerException,时间问题不做此情况的判断与处理了
        Element node=root.element(nodeName);
        Attribute attr=node.attribute(attribute);//获取此节点指定的属性,无此节点的会报NullPointerException
        node.remove(attr);//删除此属性
    }

    /**
     * 把改变的domcument对象保存到指定的xml文件中
     * @author chenleixing
     * @throws IOException
     */
    public static void saveDocument(Document document,File xmlFile) throws IOException {
        Writer osWrite = new OutputStreamWriter(new FileOutputStream(xmlFile));//创建输出流
        OutputFormat format = OutputFormat.createPrettyPrint();  //获取输出的指定格式
        format.setEncoding("UTF-8");//设置编码 ，确保解析的xml为UTF-8格式
        XMLWriter writer = new XMLWriter(osWrite, format);//XMLWriter 指定输出文件以及格式
        writer.write(document);//把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)
        writer.flush();
        writer.close();
    }


        /**
         * @描述 关闭各类流对象
         * @author 曾泽亦
         * @param xmlWriter
         * @param outputStream
         * @param inputStream
         */
    public static void close(XMLWriter xmlWriter, OutputStream outputStream, InputStream inputStream){

        if (xmlWriter != null){
            try{
                xmlWriter.close();
            } catch (IOException e) {
                logger.error("XMLUtil.close error: "+ e);
            }
            xmlWriter = null;
        }

        if (outputStream != null){
            try{
                outputStream.close();
            } catch (IOException e) {
                logger.error("XMLUtil.close error: "+ e);
            }
            outputStream = null;
        }

        if (inputStream != null){
            try{
                inputStream.close();
            } catch (IOException e) {
                logger.error("XMLUtil.close error: "+ e);
            }
            inputStream = null;
        }
    }

    public static void main(String[] args){
        String mybatisPath="D:\\Company-Workplace\\jarService\\swtech-service-jarService\\target\\spring-mybatis.xml";
//        ReadWriteXMLFileUtil.modifyXmlDatasource(mybatisPath , "hbsxt");
        String dubboPath="D:\\Company-Workplace\\jarService\\swtech-service-jarService\\target\\spring-dubbo-provider.xml";
//        ReadWriteXMLFileUtil.modifyXmlDubboPort(dubboPath , "20925");
        new ReadWriteXMLFileUtil(mybatisPath,"hbsxt",dubboPath,"20928");
    }

}
