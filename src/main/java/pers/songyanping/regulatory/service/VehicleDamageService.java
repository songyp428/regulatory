package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.VehicleDamageDao;
import pers.songyanping.regulatory.model.VehicleDamageData;

import java.util.List;
@Service

public class VehicleDamageService {
    @Autowired

    VehicleDamageDao vehicleDamageDao;

    public Integer addVehicleDamage(VehicleDamageData test){
        return vehicleDamageDao.insert(test);
    }

    public List<VehicleDamageData> queryVehicleDamageList(){
        return vehicleDamageDao.list();
    }

    public Integer deleteVehicleMamage(String bikeId){
        return vehicleDamageDao.delete(bikeId);
    }

    public Integer updateVehicleMamage(VehicleDamageData test){
        return vehicleDamageDao.update(test);
    }

    public VehicleDamageData getVehicleMamageById(String bikeId){
        return vehicleDamageDao.getOne(bikeId);
    }
}
