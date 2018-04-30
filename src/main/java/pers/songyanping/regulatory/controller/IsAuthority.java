package pers.songyanping.regulatory.controller;

import javax.servlet.http.HttpServletRequest;
import pers.songyanping.regulatory.controller.CookieUtils;
import java.util.List;

public class IsAuthority {

    public static Boolean isAuthority(HttpServletRequest request,Integer[] roleIdList) {
        Boolean isAuthority = false;
        String regulatory_roleId = "regulatory_roleId";
        String roleId = "";

        roleId = CookieUtils.getCookie(request,regulatory_roleId);

        for (Integer item : roleIdList) {
            if (roleId.equals(item.toString())) {
                isAuthority = true;
            }
        }

        return isAuthority;
    }
}
