package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.VehicleMamageDao;
import pers.songyanping.regulatory.model.VehicleDamageData;

import java.util.List;
@Service

public class VehicleDamageService {
    @Autowired
    VehicleMamageDao VehicleMamageDao;

    public Integer addVehicleDamage(VehicleData test){
        return VehicleMamageDao.insert(test);
    }

    public List<VehicleData> queryVehicleMamageList(){
        return VehicleMamageDao.list();
    }

    public Integer deleteVehicleMamage(String bikeId){
        return VehicleMamageDao.delete(bikeId);
    }

    public Integer updateVehicleMamage(VehicleData test){
        return VehicleMamageDao.update(test);
    }

    public VehicleData getVehicleMamageById(String bikeId){
        return VehicleMamageDao.getOne(bikeId);
    }
}
