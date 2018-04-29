package pers.songyanping.regulatory.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.DispatchHistoryDao;
import pers.songyanping.regulatory.model.DispatchHistoryData;

import javax.management.relation.Role;
import java.util.List;
@Service
public class DispatchHistoryService {
    @Autowired

    DispatchHistoryDao dispatchHistoryDao;
    public Integer manualDispatch(DispatchHistoryData test){
        return dispatchHistoryDao.insert(test);
    }

    public List<DispatchHistoryData> queryDispatchList(){
        return dispatchHistoryDao.list();
    }

    public Integer deleteDispatch(Integer id){
        return dispatchHistoryDao.delete(id);
    }

    public Integer updateManualDispatch(DispatchHistoryData test){
        return dispatchHistoryDao.update(test);
    }

    public DispatchHistoryData queryDispatchById(Integer id){
        return dispatchHistoryDao.getOne(id);
    }
}
