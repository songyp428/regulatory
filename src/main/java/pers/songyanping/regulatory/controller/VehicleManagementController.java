package pers.songyanping.regulatory.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.VehicleData;
import pers.songyanping.regulatory.service.VehicleManagementService;

import java.util.List;

@Controller
@RequestMapping("/regulatory")
public class VehicleManagement {

    @Autowired
    private VehicleManagementService vehicleManagementService;

    @RequestMapping("/queryVehicleList")
    @ResponseBody
    public Result<List<VehicleData>> listTest(
            //@RequestParam(required=true)
            //String bikeId
    ) {
        List<VehicleData> list = vehicleManagementService.listTest();
        system.out.println(test)
        return Result.<List<VehicleData>>builder().code("200").msg("成功").data(list).build();
    }

    @RequestMapping("/addVehicle")
    @ResponseBody
    public Result<Integer> addTest(
            @RequestBody VehicleData test
    ) {
        system.out.println(test)
        Integer count = vehicleManagementService.addTest(test);
        return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(1).build();
    }
}
