package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.RoleData;
import pers.songyanping.regulatory.service.RoleService;
import pers.songyanping.regulatory.controller.CookieUtils;
import pers.songyanping.regulatory.controller.IsLogin;
import pers.songyanping.regulatory.controller.IsAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")

public class RoleController {
    @Autowired
    private RoleService roleService;


    @RequestMapping("/queryRoleManagement")
    @ResponseBody
    public Result<List<RoleData>> queryRoleList(
            HttpServletRequest request,HttpServletResponse response
    ) {
        List<RoleData> list = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1};

        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<List<RoleData>>builder().code(201).message("还没有登录，请先登录再操作哦！").data(list).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<List<RoleData>>builder().code(201).message("你没有权限进行操作！").data(list).totalRecords(0).build();
            }else {
                list = roleService.queryRoleList();
                return Result.<List<RoleData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<RoleData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addRoleManagement")
    @ResponseBody
    public Result<Integer> addRole(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody RoleData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                List<RoleData> list = roleService.queryRoleList();
                for (RoleData item : list) {
                    if (test.getName().equals(item.getName())) {
                        return Result.<Integer>builder().code(202).message("该角色已经存在，不能重复插入！").data(count).totalRecords(0).build();
                    }
                }
                count = roleService.addRole(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateRoleManagement")
    @ResponseBody
    public Result<Integer> updateRole(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody RoleData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                count = roleService.updateRole(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteRoleManagement")
    @ResponseBody
    public Result<Integer> deleteRole(
            HttpServletRequest request,
            HttpServletResponse response,
            Integer id
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                count = roleService.deleteRole(id);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/getRoleManagementById")
    @ResponseBody
    public Result<RoleData> queryRoleById(
            Integer id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        RoleData data = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);
            if (!isLogin) {
                response.setStatus(110);
                return Result.<RoleData>builder().code(201).message("还没有登录，请先登录再操作哦！").data(data).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<RoleData>builder().code(201).message("你没有权限进行操作！").data(data).totalRecords(0).build();
            }else {
                data = roleService.queryRoleById(id);
                return Result.<RoleData>builder().code(200).message("成功").data(data).totalRecords(1).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<RoleData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }
}
