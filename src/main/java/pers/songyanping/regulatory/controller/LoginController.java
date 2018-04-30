package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.dao.UserDao;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.LoginData;
import pers.songyanping.regulatory.model.UserData;
import pers.songyanping.regulatory.service.LoginService;
import pers.songyanping.regulatory.controller.CookieUtils;
import sun.util.resources.cldr.om.CalendarData_om_KE;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody

    public Result<Integer> getAllUser(
            HttpServletResponse response,
            @RequestBody LoginData test
    ) {
        List<UserData> list = null;
        Boolean success = false;
        Integer roleId = null;
        String userName = test.getUserName();
        String passWord = test.getPassword();
        try {
            list = loginService.getAllUser();

            for(UserData item : list) {
                if (userName.equals(item.getUserName()) && passWord.equals(item.getPassword())) {
                    success = true;
                    roleId = item.getRoleId();
                    break;
                }
            }

            if (success) {
                CookieUtils.writeCookie(response, "regulatory_userName",userName,3600);
                CookieUtils.writeCookie(response, "regulatory_roleId",roleId.toString(),3600);
                return Result.<Integer>builder().code(200).message("登录成功！").data(1).totalRecords(1).build();
            } else {
                response.setStatus(400);
                return Result.<Integer>builder().code(201).message("本平台没有该用户，登录失败！").data(0).totalRecords(0).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(110);
            return Result.<Integer>builder().code(201).message("系统内部失败，登录失败！").data(0).totalRecords(0).build();
        }
    }

    @RequestMapping("/logout")
    @ResponseBody

    public Result<Integer> getAllUser(
            HttpServletRequest request,HttpServletResponse response
    ) {
        String userName = null;
        String roleId = null;
        try {
            Cookie[] cookies =  request.getCookies();
            userName = CookieUtils.getCookie(request,"regulatory_userName");
            roleId = CookieUtils.getCookie(request,"regulatory_roleId");
            CookieUtils.writeCookie(response, "regulatory_userName",userName,0);
            CookieUtils.writeCookie(response, "regulatory_roleId",roleId.toString(),0);
            return Result.<Integer>builder().code(200).message("登出成功！").data(1).totalRecords(1).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("系统内部失败，登出失败！").data(0).totalRecords(0).build();
        }
    }
}
