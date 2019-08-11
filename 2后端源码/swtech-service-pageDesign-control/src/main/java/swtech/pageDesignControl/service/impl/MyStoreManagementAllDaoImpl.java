package swtech.pageDesignControl.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.MyBeautyCommodity;
import swtech.pageDesignControl.entity.MyReservation;
import swtech.pageDesignControl.entity.MyStoreManagement;
import swtech.pageDesignControl.mapper.MyBeautyCommodityMapper;
import swtech.pageDesignControl.mapper.MyReservationMapper;
import swtech.pageDesignControl.mapper.MyStoreManagementMapper;
import swtech.pageDesignControl.service.MyStoreManagementAllDao;
import com.sun.jmx.snmp.Timestamp;

import java.util.*;

@Service
public class MyStoreManagementAllDaoImpl implements MyStoreManagementAllDao {

    //	 定义一个静态的日志器变量
    private static final Logger logger = LogManager.getLogger(MyStoreManagementAllDaoImpl.class);

    @Autowired
    private MyBeautyCommodityMapper myBeautyCommodityMapper;

    @Autowired
    private MyStoreManagementMapper myStoreManagementMapper ;

    @Autowired
    private MyReservationMapper myReservationMapper ;


    @Override
    @Transactional
    public ReturnMsg insertMyStoreManagement(MyStoreManagement myStoreManagement) {
        ReturnMsg msg = new ReturnMsg();

        if(myStoreManagement==null)throw new ServiceException("参数不能为空");

        int i = myStoreManagementMapper.insertMyStoreManagement(myStoreManagement);

        if(myStoreManagement.getSmId()==null)throw new ServiceException("myStoreManagement.getSmId()获取不到");



        if(i==0)throw new ServiceException("操作失败");

		if(i!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
            msg.setMsg(myStoreManagement.getSmId());
		}

        return msg;
    }

    @Override
    public ReturnMsg selectMsmAll() {
        ReturnMsg msg = new ReturnMsg();

        List<MyStoreManagementMapper> msmall = myStoreManagementMapper.selectMsmAll();
        if(msmall==null)throw new ServiceException("数据查询操作失败");
        if(msmall!=null) {
            msg.setStatus("200");
            msg.setStatusMsg("操作成功");
            msg.setMsg(msmall);
        }
        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity) {

        ReturnMsg msg = new ReturnMsg();

        if(myBeautyCommodity==null)throw new ServiceException("参数不能为空");

        int i = myBeautyCommodityMapper.insertMyBeautyCommodity(myBeautyCommodity);


		if(i==0)throw new ServiceException("操作失败");

		if(i!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
            msg.setMsg(i);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg selectAll(String nodeIdqwe) {
        ReturnMsg msg = new ReturnMsg();
        if(nodeIdqwe==null)throw new ServiceException("参数不能为空");

        int smId= Integer.parseInt(nodeIdqwe.split(",")[1]);
        if(smId<=0)throw new ServiceException("参数转化错误");
        System.out.println(smId);
        System.out.println(smId);
        System.out.println(smId);

        Map<String,Object> all= new HashMap<>();

        MyStoreManagement selectSm = myStoreManagementMapper.selectSm(smId);
        List<MyBeautyCommodity> selectAll = myBeautyCommodityMapper.selectAll(smId);
        all.put("msm", selectSm);
        all.put("mbc", selectAll);


		if(all==null)throw new ServiceException("操作失败");

		if(all!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(all);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity) {
        ReturnMsg msg = new ReturnMsg();

        if(myBeautyCommodity==null)throw new ServiceException("参数不能为空");

        int i = myBeautyCommodityMapper.updateByPrimaryKeySelective(myBeautyCommodity);


		if(i==0)throw new ServiceException("操作失败");

		if(i!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
            msg.setMsg(i);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg selectByPrimaryKey(Integer bcId) {
        ReturnMsg msg = new ReturnMsg();

        if(bcId==null)throw new ServiceException("参数不能为空");

        MyBeautyCommodity myBeautyCommodity = myBeautyCommodityMapper.selectByPrimaryKeyBeautyCommodity(bcId);


		if(myBeautyCommodity==null)throw new ServiceException("操作失败");

		if(myBeautyCommodity!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(myBeautyCommodity);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg deleteByPrimaryKeyCommodity(Integer bcId) {
        ReturnMsg msg = new ReturnMsg();

        if(bcId==null)throw new ServiceException("参数不能为空");

        int i = myBeautyCommodityMapper.deleteByPrimaryKeyCommodity(bcId);


		if(i==0)throw new ServiceException("操作失败");

		if(i!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
            msg.setMsg(i);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity myBeautyCommodity) {
        ReturnMsg msg = new ReturnMsg();

        if(myBeautyCommodity==null)throw new ServiceException("参数不能为空");

        int i = myBeautyCommodityMapper.updateByPrimaryKeySelectiveCommodity(myBeautyCommodity);


		if(i==0)throw new ServiceException("操作失败");

		if(i!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
            msg.setMsg(i);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg insertSelectiveMyReservation(MyReservation record) {
        ReturnMsg msg = new ReturnMsg();

        if(record==null)throw new ServiceException("参数不能为空");
        int machineId=1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV<0) {
            hashCodeV = - hashCodeV;
        }
        Timestamp nowTimestamp = new Timestamp(new Date().getTime());

        System.out.println(nowTimestamp);


        System.out.println(hashCodeV);
        String orderid=machineId+String.format("%015d", hashCodeV);
        int MrAuthCode = 0;
        List<Integer> useTheCode = myReservationMapper.mrAuthCode();
        if(useTheCode.size()>0) {
            for(int i=0;i<useTheCode.size();i++) {
                int useThe=(int)((Math.random()*9+1)*100000);
                if(useThe!=useTheCode.get(i)) {
                    MrAuthCode=useThe;
                    break;
                }
            }
        }else {
            MrAuthCode=(int)((Math.random()*9+1)*100000);
        }


        record.setMrAuthCode(MrAuthCode);
        record.setMrOrderNumber(orderid);

        int i = myReservationMapper.insertSelectiveMyReservation(record);

		if(i==0)throw new ServiceException("操作失败");

		if(i!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
            msg.setMsg(i);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg selectReserva(Integer mrStatus) {
        ReturnMsg msg = new ReturnMsg();

        if(mrStatus==null)throw new ServiceException("参数不能为空");

        List<MyReservation> myReservations = myReservationMapper.selectReserva(mrStatus);


		if(myReservations==null)throw new ServiceException("操作失败");

		if(myReservations!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(myReservations);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg updReserva(MyReservation record) {
        ReturnMsg msg = new ReturnMsg();

        if(record==null)throw new ServiceException("参数不能为空");

        int i = myReservationMapper.updReserva(record);


		if(i==0)throw new ServiceException("操作失败");

		if(i!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
            msg.setMsg(i);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg selectCode(Integer Code) {
        ReturnMsg msg = new ReturnMsg();

        if(Code==null)throw new ServiceException("参数不能为空");

        MyReservation myReservation = myReservationMapper.selectCode(Code);


		if(myReservation==null)throw new ServiceException("操作失败");

		if(myReservation!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(myReservation);
		}

        return msg;
    }

    @Override
    @Transactional
    public ReturnMsg selectMrRid(Integer mrRid) {
        ReturnMsg msg = new ReturnMsg();

        if(mrRid==null)throw new ServiceException("参数不能为空");


        MyReservation myReservation = myReservationMapper.selectMrRid(mrRid);
		if(myReservation==null)throw new ServiceException("操作失败");

		if(myReservation!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(myReservation);
		}

        return msg;
    }
}
