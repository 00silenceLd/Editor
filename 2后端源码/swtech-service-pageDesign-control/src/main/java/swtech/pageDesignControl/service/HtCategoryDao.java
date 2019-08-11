package swtech.pageDesignControl.service;



import swtech.pageDesignControl.common.vo.ReturnMsg;


public interface HtCategoryDao {

    ReturnMsg insertSelectiveIn(String record);

    ReturnMsg all();
}