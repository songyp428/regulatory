package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.VehicleData;
import pers.songyanping.regulatory.service.VehicleManagementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")
public class VehicleManagementController {
    @Autowired
    private VehicleManagementService vehicleManagementService;

    @RequestMapping("/queryVehicleList")
    @ResponseBody
    public Result<List<VehicleData>> queryVehicleList() {
        List<VehicleData> list = null;
        try {
            list = vehicleManagementService.queryVehicleList();
            return Result.<List<VehicleData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<VehicleData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }

    }

    @RequestMapping("/addVehicle")
    @ResponseBody
    public Result<Integer> addVehicle(
            @RequestBody VehicleData test
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.addVehicle(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateVehicle")
    @ResponseBody
    public Result<Integer> updateVehicle(
            @RequestBody VehicleData test
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.updateVehicle(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteVehicle")
    @ResponseBody
    public Result<Integer> deleteVehicle(
             String bikeId
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.deleteVehicle(bikeId);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

}






