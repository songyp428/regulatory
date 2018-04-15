package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.EnterpriseViolationData;
import pers.songyanping.regulatory.service.EnterpriseViolationService;
import pers.songyanping.regulatory.service.EnterpriseBaseInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")
public class EnterpriseViolationController {
    @Autowired
    private VehicleManagementService vehicleManagementService;

    @RequestMapping("/queryCorporateCreditList")
    @ResponseBody
    public Result<List<EnterpriseViolationData>> queryEnterpriseViolationList() {
        List<VehicleData> list = null;
        try {
            list = vehicleManagementService.queryEnterpriseViolationList();
            return Result.<List<EnterpriseViolationData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<EnterpriseViolationData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addCorporateCredit")
    @ResponseBody
    public Result<Integer> addEnterpriseViolation(
            @RequestBody EnterpriseViolationData test
    ) {
        Integer count = null;
        try {
            System.out.println(test.getGrade())
            System.out.println(test.getName())

            count = vehicleManagementService.addEnterpriseViolation(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateCorporateCredit")
    @ResponseBody
    public Result<Integer> updateEnterpriseViolation(
            @RequestBody EnterpriseViolationData test
    ) {
        Integer count = null;
        try {
            System.out.println(test.getGrade())
            System.out.println(test.getName())

            count = vehicleManagementService.updateEnterpriseViolation(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteCorporateCredit")
    @ResponseBody
    public Result<Integer> deleteEnterpriseViolation(
            String id
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.deleteEnterpriseViolation(id);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/queryCorporateCreditById")
    @ResponseBody
    public Result<EnterpriseViolationData> getEnterpriseViolationById(String id) {
        VehicleData data = null;
        try {
            data = vehicleManagementService.getEnterpriseViolationById(id);

            return Result.<VehicleData>builder().code(200).message("成功").data(data).totalRecords(1).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<VehicleData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }

}