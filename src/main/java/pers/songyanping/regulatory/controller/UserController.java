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
import pers.songyanping.regulatory.controller.IsLogin;

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
    public Result<List<UserData>> queryUserList(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        List<UserData> list = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<List<UserData>>builder().code(201).message("还没有登录，请先登录再操作哦！").data(list).totalRecords(0).build();
            } else {
                list = userService.queryUserList();
                return Result.<List<UserData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<UserData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Result<Integer> addUser(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody UserData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                List<UserData> list = userService.queryUserList();
                count = userService.addUser(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Result<Integer> updateUser(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody UserData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = userService.updateUser(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Result<Integer> deleteUser(
            Integer id,
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
                count = userService.deleteUser(id);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/queryUserById")
    @ResponseBody
    public Result<UserData> queryUserById(
            Integer id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        UserData data = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<UserData>builder().code(201).message("还没有登录，请先登录再操作哦！").data(data).totalRecords(0).build();
            } else {
                data = userService.queryUserById(id);

                return Result.<UserData>builder().code(200).message("成功").data(data).totalRecords(1).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<UserData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }
}
