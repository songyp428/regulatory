package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.VehicleDamageData;
import pers.songyanping.regulatory.service.VehicleDamageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")

public class VehicleDamageController {
    @Autowired
    private VehicleDamageService VehicleDamageService;

    @RequestMapping("/queryVehicleDamage")
    @ResponseBody
    public Result<List<VehicleData>> queryVehicleMamageList() {
        List<VehicleDamageData> list = null;
        try {
            list = VehicleDamageService.queryVehicleMamageList();
            return Result.<List<VehicleDamageData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<VehicleData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addVehicleDamage")
    @ResponseBody
    public Result<Integer> addVehicleDamage(
            @RequestBody VehicleData test
    ) {
        Integer count = null;
        try {
            System.out.println(test);
            List<VehicleDamageData> list = vehicleManagementService.queryVehicleMamageList();
            for(VehicleData item : list) {
                if (test.getBikeId().equals(item.getBikeId())) {
                    return Result.<Integer>builder().code(202).message("已经存在这个单车编号，不能重复插入！").data(count).totalRecords(0).build();
                }
            }
            count = vehicleManagementService.addVehicleDamage(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateVehicleDamage")
    @ResponseBody
    public Result<Integer> updateVehicleMamage(
            @RequestBody VehicleDamageData test
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.updateVehicleMamage(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteVehicleDamage")
    @ResponseBody
    public Result<Integer> deleteVehicleMamage(
            String bikeId
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.deleteVehicleMamage(bikeId);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/getVehicleDamageById")
    @ResponseBody
    public Result<VehicleData> getVehicleMamageById(String bikeId) {
        VehicleData data = null;
        try {
            data = vehicleManagementService.getVehicleMamageById(bikeId);

            return Result.<VehicleDamageData>builder().code(200).message("成功").data(data).totalRecords(1).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<VehicleDamageData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }

}
