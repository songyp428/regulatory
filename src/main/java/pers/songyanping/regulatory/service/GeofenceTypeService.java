package pers.songyanping.regulatory.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.GeofenceTypeDao;
import pers.songyanping.regulatory.model.GeofenceTypeData;

import javax.management.relation.Role;
import java.util.List;
@Service
public class GeofenceTypeService {

    @Autowired

    GeofenceTypeDao geofenceTypeDao;
    public Integer addFenceType(GeofenceTypeData test){
        return geofenceTypeDao.insert(test);
    }

    public List<GeofenceTypeData> queryFenceType(){
        return geofenceTypeDao.list();
    }

    public Integer delFenceType(Integer fencingTypeId){
        return geofenceTypeDao.delete(fencingTypeId);
    }

    public Integer updateFenceType(GeofenceTypeData test){
        return geofenceTypeDao.update(test);
    }

    public GeofenceTypeData queryFenceTypeById(Integer fencingTypeId){
        return geofenceTypeDao.getOne(fencingTypeId);
    }
}
