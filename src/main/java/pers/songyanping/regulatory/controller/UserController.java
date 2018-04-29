package pers.songyanping.regulatory.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.UserData;
import pers.songyanping.regulatory.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserList")
    @ResponseBody
    public Result<List<UserData>> queryUserList() {
        List<UserData> list = null;
        try {
            list = userService.queryUserList();
            return Result.<List<UserData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<UserData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Result<Integer> addUser(
            @RequestBody UserData test
    ) {
        Integer count = null;
        try {
            System.out.println(test);
            List<UserData> list = userService.queryUserList();
            count = userService.addUser(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Result<Integer> updateUser(
            @RequestBody UserData test
    ) {
        Integer count = null;
        try {
            count = userService.updateUser(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Result<Integer> deleteUser(
            Integer id
    ) {
        Integer count = null;
        try {
            count = userService.deleteUser(id);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/queryUserById")
    @ResponseBody
    public Result<UserData> queryUserById(Integer id) {
        UserData data = null;
        try {
            data = userService.queryUserById(id);

            return Result.<UserData>builder().code(200).message("成功").data(data).totalRecords(1).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<UserData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }
}
