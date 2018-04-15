package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.EnterpriseBaseInfoDao;
import pers.songyanping.regulatory.model.EnterpriseBaseInfoData;

import java.util.List;
@Service

public class EnterpriseBaseInfoService {
    @Autowired
    EnterpriseBaseInfoDao enterpriseBaseInfoDao;

    public Integer addEnterpriseBaseInfo(EnterpriseBaseInfoData test){
        return enterpriseBaseInfoDao.insert(test);
    }

    public List<EnterpriseBaseInfoData> queryEnterpriseBaseInfoList(){
        return enterpriseBaseInfoDao.list();
    }

    public Integer deleteEnterpriseBaseInfo(String id){
        return enterpriseBaseInfoDao.delete(id);
    }

    public Integer updateEnterpriseBaseInfo(EnterpriseBaseInfoData test){
        return enterpriseBaseInfoDao.update(test);
    }

    public VehicleData queryEnterpriseBaseInfoById(String id){
        return enterpriseBaseInfoDao.getOne(id);
    }

    public VehicleData queryEnterpriseBaseInfoByName(String name){
        return enterpriseBaseInfoDao.queryByName(name);
    }
}
