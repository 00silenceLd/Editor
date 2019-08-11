package Cs;

import java.util.Map;
import Cs.Cs278;
import Cs.Cs278Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import swtech.common.core.dao.BaseDao;

public interface Cs278Mapper extends BaseDao<Cs278> {

public List<Cs278> selectList();

public List<Cs278> searchKey(Cs278 entity);

public List<Cs278> searchAllKey(String str);

public long deleteArray(int[] ids);

public List<Cs278> getQueryPage(Map<String,Object> map);

public long getCount();

public long updateDelete(Map<String, Object> map);

public long isDeleteArray(int[] ids);

public long reNewData(int id);

public long reNewDataArray(int[] ids);

public List<Cs278> getReportForm(String sql);

public List<Cs278> searchIsDelete();

public List<Map<String, String>> getResourceLibrary(String sql);

}