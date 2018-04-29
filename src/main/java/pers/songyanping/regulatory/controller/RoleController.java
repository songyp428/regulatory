package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.RoleData;
import pers.songyanping.regulatory.service.RoleService;

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
    public Result<List<RoleData>> queryRoleList() {
        List<RoleData> list = null;
        try {
            list = roleService.queryRoleList();
            return Result.<List<RoleData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<RoleData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addRoleManagement")
    @ResponseBody
    public Result<Integer> addRole(
            @RequestBody RoleData test
    ) {
        Integer count = null;
        try {
            System.out.println(test);
            List<RoleData> list = roleService.queryRoleList();
            for(RoleData item : list) {
                if (test.getName().equals(item.getName())) {
                    return Result.<Integer>builder().code(202).message("该角色已经存在，不能重复插入！").data(count).totalRecords(0).build();
                }
            }
            count = roleService.addRole(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateRoleManagement")
    @ResponseBody
    public Result<Integer> updateRole(
            @RequestBody RoleData test
    ) {
        Integer count = null;
        try {
            count = roleService.updateRole(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteRoleManagement")
    @ResponseBody
    public Result<Integer> deleteRole(
            Integer id
    ) {
        Integer count = null;
        try {
            count = roleService.deleteRole(id);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/getRoleManagementById")
    @ResponseBody
    public Result<RoleData> queryRoleById(Integer id) {
        RoleData data = null;
        try {
            data = roleService.queryRoleById(id);

            return Result.<RoleData>builder().code(200).message("成功").data(data).totalRecords(1).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<RoleData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }
}
