package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.EnterpriseViolationDao;
import pers.songyanping.regulatory.model.EnterpriseViolationData;
import pers.songyanping.regulatory.model.EnterpriseBaseInfoData;

import java.util.List;
@Service
public class EnterpriseViolationService {
    @Autowired
    EnterpriseViolationDao enterpriseViolationDao;

    public Integer addEnterpriseViolation(EnterpriseViolationData test){
        return enterpriseViolationDao.insert(test);
    }

    public List<EnterpriseViolationData> queryEnterpriseViolationList(){
        return enterpriseViolationDao.list();
    }

    public Integer deleteEnterpriseViolation(Integer id){
        return enterpriseViolationDao.delete(id);
    }

    public Integer updateEnterpriseViolation(EnterpriseViolationData test){
        return enterpriseViolationDao.update(test);
    }

    public EnterpriseBaseInfoData queryEnterpriseBaseInfoById(Integer id){
        return enterpriseViolationDao.getBaseOne(id);
    }

    public Integer updateEnterpriseBaseInfo(EnterpriseBaseInfoData infoOne){
        return enterpriseViolationDao.updateBaseInfo(infoOne);
    }

    public EnterpriseViolationData getEnterpriseViolationById(Integer id){
        return enterpriseViolationDao.getOne(id);
    }
}
