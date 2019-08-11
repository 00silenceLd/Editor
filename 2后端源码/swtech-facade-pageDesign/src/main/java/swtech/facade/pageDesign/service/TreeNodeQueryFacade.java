package swtech.facade.pageDesign.service; 
import swtech.common.entity.ReturnMsg;

public interface TreeNodeQueryFacade {
	public ReturnMsg getPageTree(Long pid);
	public ReturnMsg getLikeName(Long pid,String name);
	
	/**
	 * 查出所有保存表单
	 * */
	public ReturnMsg getPageEditor();
}
