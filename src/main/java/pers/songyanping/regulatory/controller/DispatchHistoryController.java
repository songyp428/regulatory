package pers.songyanping.regulatory.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.DispatchHistoryData;
import pers.songyanping.regulatory.service.DispatchHistoryService;
import pers.songyanping.regulatory.controller.IsLogin;
import pers.songyanping.regulatory.controller.IsAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")
public class DispatchHistoryController {
    @Autowired
    private DispatchHistoryService dispatchHistoryService;

    @RequestMapping("/queryHistoryList")
    @ResponseBody
    public Result<List<DispatchHistoryData>> queryDispatchList(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        List<DispatchHistoryData> list = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1,4};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<List<DispatchHistoryData>>builder().code(201).message("还没有登录，请先登录再操作哦！").data(list).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<List<DispatchHistoryData>>builder().code(201).message("你没有权限进行操作！").data(list).totalRecords(0).build();
            }else {
                list = dispatchHistoryService.queryDispatchList();
                return Result.<List<DispatchHistoryData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<DispatchHistoryData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/manualDispatch")
    @ResponseBody
    public Result<Integer> manualDispatch(
            @RequestBody DispatchHistoryData test,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1,4};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                count = dispatchHistoryService.manualDispatch(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteHistoryList")
    @ResponseBody
    public Result<Integer> deleteDispatch(
            Integer id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Integer count = null;
        Boolean isLogin = false;
        Boolean isAuthority = false;
        Integer[] roleIdList = {1,4};
        try {
            isLogin = IsLogin.isLogin(request);
            isAuthority = IsAuthority.isAuthority(request,roleIdList);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else if (!isAuthority) {
                return Result.<Integer>builder().code(201).message("你没有权限进行操作！").data(count).totalRecords(0).build();
            }else {
                count = dispatchHistoryService.deleteDispatch(id);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }
}
