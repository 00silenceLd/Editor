package swtech.facade.pageDesign.util.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SSHUtil {

	public boolean moveTo(String filePath, String target) {
		List<String> cmd = new ArrayList<String>();
		cmd.add("mv");
		cmd.add(filePath);
		cmd.add(target);
		int chmod = startCmd(cmd);
		if (chmod == 0) {
			return true;
		}
		return false;
	}

	public boolean createNewFolder(String filePath) {
		List<String> cmd = new ArrayList<String>();
		cmd.add("mkdir");
		cmd.add(filePath);
		int chmod = startCmd(cmd);
		if (chmod == 0) {
			return true;
		}
		return false;
	}
	public static boolean copyToFile(String origpath, String destpath, String filename) throws Exception{  
	    String osName = System.getProperty("os.name");  
	    boolean flag = false;  
	    /*系统命令支持的操作系统Windows XP, 2000 2003 7*/  
	    if(!(osName.equalsIgnoreCase("windows XP") || osName.equalsIgnoreCase("windows 2000") || osName.equalsIgnoreCase("windows 2003") || osName.equalsIgnoreCase("windows 7"))){  
	        return flag;  
	    }  
	    Runtime rt = Runtime.getRuntime();  
	    Process p = null;  
	    File f = new File(destpath);  
	    if(!f.exists()){  
	        f.mkdirs();  
	    }  
	    int exitVal;  
	    p = rt.exec("cmd exe /c copy " + origpath+filename+" "+destpath);  
	    // 进程的出口值。根据惯例，0 表示正常终止。   
	    exitVal = p.waitFor();  
	    if(exitVal == 0){  
	        flag = true;  
	    }else{  
	        flag = false;  
	    }  
	    return flag;      
	      
	}  

	public boolean deleteFile(String filePath) throws IOException, InterruptedException {
	    boolean flag = false;  
	    Map<Object, Object> map = System.getProperties();

        Set<Object> keySet = map.keySet();
        for (Object str:keySet){
            System.out.println("key: "+str.toString()+" value: "+map.get(str));
        }

		if(System.getProperty("os.name").equals("Windows 10")){
			System.out.print("当前是windows系统");
			Runtime rt = Runtime.getRuntime();  
		    Process p = null;  
		    int exitVal;  
		    p = rt.exec("cmd exe /c delete " + filePath);  
		    // 进程的出口值。根据惯例，0 表示正常终止。   
		    exitVal = p.waitFor();  
		    if(exitVal == 0){  
		    	System.out.print("删除文件"+filePath+"成功！！！");
		        flag = true;  
		    }else{  
		    	System.out.print("删除文件"+filePath+"失败！！！");
		        flag = false;  
		    }   
		}
		else{
			List<String> cmd = new ArrayList<String>();
			cmd.add("rm -rf");
			cmd.add(filePath);
			int chmod = startCmd(cmd);
			if (chmod == 0) {
				return true;
			}			
		}
		return false;
	}

	public boolean copyFile(String filePath, String targetPath,String cmd) {
		List<String> comCopy = new ArrayList<String>();
		comCopy.add("cp");
		comCopy.add(cmd);
		comCopy.add(filePath);
		comCopy.add(targetPath);
		int copy = startCmd(comCopy);
		if (copy == 0) {
			comCopy.clear();
			comCopy.add("chmod");
			comCopy.add("777");
			comCopy.add(targetPath);
			int chmod = startCmd(comCopy);
			if (chmod == 0) {
				return true;
			}
		}
		return false;
	}

	public Integer startCmd(List<String> commend) {
		Integer exitValue = null;
		StringBuffer test = new StringBuffer();

		for (int i = 0; i < commend.size(); i++)
			test.append(commend.get(i) + " ");

		try {
			Runtime rt = Runtime.getRuntime();
			System.out.println(test.toString());
			byte[] b = test.toString().getBytes();
			String com = new String(b, "utf8");

			Process proc = rt.exec(com.split(" "));

			InputStreamReader in = new InputStreamReader(proc.getInputStream());
			BufferedReader success = new BufferedReader(in);
			String line_1 = null;
			while ((line_1 = success.readLine()) != null) {
			}
			InputStreamReader errIn = new InputStreamReader(
					proc.getErrorStream());
			BufferedReader err = new BufferedReader(errIn);
			String line_2 = null;
			while ((line_2 = err.readLine()) != null) {
			}
			try {
				exitValue = proc.waitFor();
				System.out.println("输出返回值：" + exitValue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return exitValue;
	}
	
	
	public Object exec(String cmd) {  
        try {  
            String[] cmdA = { "/bin/sh", "-c", cmd };  
            Process process = Runtime.getRuntime().exec(cmdA);  
            LineNumberReader br = new LineNumberReader(new InputStreamReader(  
                    process.getInputStream()));  
            StringBuffer sb = new StringBuffer();  
            String line;  
         while ((line = br.readLine()) != null) {  
                System.out.println(line);  
                sb.append(line).append("\n");  
            }  
            return sb.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
}
