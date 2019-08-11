package swtech.facade.pageDesign.util.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @描述 java调用命令行运行命令工具类
 * @author 曾泽亦
 */
public class Command {
	private static final Logger log = LoggerFactory.getLogger(Command.class);
    /**
     * @描述 java调用命令行运行命令
     * @author 曾泽亦
     */
    public static String exeCommand(String commandStr) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            log.info(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    return sb.toString();
    }
}
