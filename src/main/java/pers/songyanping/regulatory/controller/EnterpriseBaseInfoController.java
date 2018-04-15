package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.EnterpriseBaseInfoData;
import pers.songyanping.regulatory.service.EnterpriseBaseInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")

public class EnterpriseBaseInfoController {
    @Autowired
    private EnterpriseBaseInfoService enterpriseBaseInfoService;

    @RequestMapping("/queryEnterBaseInfoList")
    @ResponseBody
    public Result<List<EnterpriseBaseInfoData>> queryEnterpriseBaseInfoList() {
        List<EnterpriseBaseInfoData> list = null;
        try {
            list = enterpriseBaseInfoService.queryEnterpriseBaseInfoList();
            return Result.<List<EnterpriseBaseInfoData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<EnterpriseBaseInfoData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addEnterBaseInfo")
    @ResponseBody
    public Result<Integer> addEnterpriseBaseInfo(
            @RequestBody EnterpriseBaseInfoData test
    ) {
        Integer count = null;
        try {
            System.out.println(test);
            List<EnterpriseBaseInfoData> list = vehicleManagementService.queryEnterpriseBaseInfoList();
            for(EnterpriseBaseInfoData item : list) {
                if (test.getName().equals(item.getName())) {
                    return Result.<Integer>builder().code(202).message("该企业已经存在，不能重复插入！").data(count).totalRecords(0).build();
                }
            }
            count = vehicleManagementService.addEnterpriseBaseInfo(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateEnterBaseInfo")
    @ResponseBody
    public Result<Integer> updateEnterpriseBaseInfo(
            @RequestBody EnterpriseBaseInfoData test
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.updateEnterpriseBaseInfo(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteEnterBaseInfo")
    @ResponseBody
    public Result<Integer> deleteEnterpriseBaseInfo(
            String id
    ) {
        Integer count = null;
        try {
            count = vehicleManagementService.deleteEnterpriseBaseInfo(id);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/queryaddEnterBaseInfoById")
    @ResponseBody
    public Result<VehicleData> queryEnterpriseBaseInfoById(String id) {
        EnterpriseBaseInfoData data = null;
        try {
            data = vehicleManagementService.queryEnterpriseBaseInfoById(id);

            return Result.<VehicleData>builder().code(200).message("成功").data(data).totalRecords(1).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<VehicleData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }
}
