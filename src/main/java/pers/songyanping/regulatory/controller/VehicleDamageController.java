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
import pers.songyanping.regulatory.controller.IsLogin;

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
    public Result<List<VehicleDamageData>> queryVehicleDamageList(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        List<VehicleDamageData> list = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<List<VehicleDamageData>>builder().code(201).message("还没有登录，请先登录再操作哦！").data(list).totalRecords(0).build();
            } else {
                list = VehicleDamageService.queryVehicleDamageList();
                return Result.<List<VehicleDamageData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<VehicleDamageData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addVehicleDamage")
    @ResponseBody
    public Result<Integer> addVehicleDamage(
            @RequestBody VehicleDamageData test,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                List<VehicleDamageData> list = VehicleDamageService.queryVehicleDamageList();
                for (VehicleDamageData item : list) {
                    if (test.getBikeId().equals(item.getBikeId())) {
                        return Result.<Integer>builder().code(202).message("已经存在这个单车编号，不能重复插入！").data(count).totalRecords(0).build();
                    }
                }
                count = VehicleDamageService.addVehicleDamage(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateVehicleDamage")
    @ResponseBody
    public Result<Integer> updateVehicleMamage(
            @RequestBody VehicleDamageData test,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = VehicleDamageService.updateVehicleMamage(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteVehicleDamage")
    @ResponseBody
    public Result<Integer> deleteVehicleMamage(
            String bikeId,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = VehicleDamageService.deleteVehicleMamage(bikeId);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/getVehicleDamageById")
    @ResponseBody
    public Result<VehicleDamageData> getVehicleMamageById(
            String bikeId,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        VehicleDamageData data = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<VehicleDamageData>builder().code(201).message("还没有登录，请先登录再操作哦！").data(data).totalRecords(0).build();
            } else {
                data = VehicleDamageService.getVehicleMamageById(bikeId);

                return Result.<VehicleDamageData>builder().code(200).message("成功").data(data).totalRecords(1).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<VehicleDamageData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }

}
