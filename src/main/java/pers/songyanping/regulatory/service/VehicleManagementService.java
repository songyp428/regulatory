package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.VehicleManagementDao;
import pers.songyanping.regulatory.model.VehicleData;

import java.util.List;
@Service
public class VehicleManagementService {
    @Autowired
    VehicleManagementDao vehicleManagementDao;

    public Integer addVehicle(VehicleData test){
        return vehicleManagementDao.insert(test);
    }

    public List<VehicleData> queryVehicleList(){
        return vehicleManagementDao.list();
    }

    public Integer deleteVehicle(String bikeId){
        return vehicleManagementDao.delete(bikeId);
    }

    public Integer updateVehicle(VehicleData test){
        return vehicleManagementDao.update(test);
    }

    public VehicleData getVehicleById(String bikeId){
        return vehicleManagementDao.getOne(bikeId);
    }

}

