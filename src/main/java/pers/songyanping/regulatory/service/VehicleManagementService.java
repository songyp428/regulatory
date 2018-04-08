package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.VehicleManagementDao;
import pers.songyanping.regulatory.model.VehicleData;

import java.util.List;

@Service
public class VehicleManagement {

    @Autowired
    VehicleManagementDao vehicleManagementDao;

    public Integer addVehicle(VehicleData test){
        return vehicleManagementDao.insert(test);
    }

    public List<Test> queryVehicleList(){
        return vehicleManagementDao.list();
    }

    public Integer deleteTest(String bikeId){
        return vehicleManagementDao.delete(bikeId);
    }

    public Integer updateTest(VehicleData test){
        return vehicleManagementDao.update(test);
    }
}
