package pers.songyanping.regulatory.controller;
import pers.songyanping.regulatory.controller.CookieUtils;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.RoleData;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class IsLogin {

    public static Boolean isLogin(HttpServletRequest request){
        String regulatory_userName = "regulatory_userName";
        String regulatory_roleId = "regulatory_roleId";
        String userName = "";
        String roleId = "";
        Boolean isSuccess = true;

        userName = CookieUtils.getCookie(request,regulatory_userName);
        roleId = CookieUtils.getCookie(request,regulatory_roleId);

        if (userName.equals("") && roleId.equals("")) {
            isSuccess = false;
        }
        return isSuccess;
    }
}
