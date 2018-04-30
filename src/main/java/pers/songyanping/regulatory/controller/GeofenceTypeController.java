package pers.songyanping.regulatory.controller;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.GeofenceTypeData;
import pers.songyanping.regulatory.service.GeofenceTypeService;
import pers.songyanping.regulatory.controller.CookieUtils;
import pers.songyanping.regulatory.controller.IsLogin;
import pers.songyanping.regulatory.controller.IsAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")
public class GeofenceTypeController {
    @Autowired
    private GeofenceTypeService geofenceTypeService;


    @RequestMapping("/queryFenceType")
    @ResponseBody
    public Result<List<GeofenceTypeData>> queryFenceType(
            HttpServletRequest request,HttpServletResponse response
    ) {
        List<GeofenceTypeData> list = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1,2};

        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<List<GeofenceTypeData>>builder().code(201).message("还没有登录，请先登录再操作哦！").data(list).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<List<GeofenceTypeData>>builder().code(201).message("你没有权限进行操作！").data(list).totalRecords(0).build();
            }else {
                list = geofenceTypeService.queryFenceType();
                return Result.<List<GeofenceTypeData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<GeofenceTypeData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addFenceType")
    @ResponseBody
    public Result<Integer> addFenceType(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody GeofenceTypeData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1,3};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                List<GeofenceTypeData> list = geofenceTypeService.queryFenceType();
                for (GeofenceTypeData item : list) {
                    if (test.getFencingTypeId().equals(item.getFencingTypeId())) {
                        return Result.<Integer>builder().code(202).message("该围栏Id已经存在，不能重复插入！").data(count).totalRecords(0).build();
                    }
                }
                count = geofenceTypeService.addFenceType(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateFenceType")
    @ResponseBody
    public Result<Integer> updateFenceType(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody GeofenceTypeData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1,3};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                count = geofenceTypeService.updateFenceType(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/delFenceType")
    @ResponseBody
    public Result<Integer> delFenceType(
            HttpServletRequest request,
            HttpServletResponse response,
            Integer fencingTypeId
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1,3};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                count = geofenceTypeService.delFenceType(fencingTypeId);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/queryFenceTypeById")
    @ResponseBody
    public Result<GeofenceTypeData> queryFenceTypeById(
            Integer fencingTypeId,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        GeofenceTypeData data = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);
            if (!isLogin) {
                response.setStatus(110);
                return Result.<GeofenceTypeData>builder().code(201).message("还没有登录，请先登录再操作哦！").data(data).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<GeofenceTypeData>builder().code(201).message("你没有权限进行操作！").data(data).totalRecords(0).build();
            }else {
                data = geofenceTypeService.queryFenceTypeById(fencingTypeId);
                return Result.<GeofenceTypeData>builder().code(200).message("成功").data(data).totalRecords(1).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<GeofenceTypeData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }
}
