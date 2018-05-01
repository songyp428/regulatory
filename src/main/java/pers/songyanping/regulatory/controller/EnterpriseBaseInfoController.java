package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.EnterpriseBaseInfoData;
import pers.songyanping.regulatory.service.EnterpriseBaseInfoService;
import pers.songyanping.regulatory.controller.IsLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")

public class EnterpriseBaseInfoController {
    @Autowired
    private EnterpriseBaseInfoService enterpriseBaseInfoService;

    @RequestMapping("/queryEnterBaseInfoList")
    @ResponseBody
    public Result<List<EnterpriseBaseInfoData>> queryEnterpriseBaseInfoList(
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        List<EnterpriseBaseInfoData> list = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<List<EnterpriseBaseInfoData>>builder().code(201).message("还没有登录，请先登录再操作哦！").data(list).totalRecords(0).build();
            } else {
                list = enterpriseBaseInfoService.queryEnterpriseBaseInfoList();
                return Result.<List<EnterpriseBaseInfoData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<EnterpriseBaseInfoData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addEnterBaseInfo")
    @ResponseBody
    public Result<Integer> addEnterpriseBaseInfo(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody EnterpriseBaseInfoData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        List<EnterpriseBaseInfoData> list = null;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                list = enterpriseBaseInfoService.queryEnterpriseBaseInfoList();
                for (EnterpriseBaseInfoData item : list) {
                    if (test.getName().equals(item.getName())) {
                        return Result.<Integer>builder().code(202).message("该企业已经存在，不能重复插入！").data(count).totalRecords(0).build();
                    }
                }
                count = enterpriseBaseInfoService.addEnterpriseBaseInfo(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateEnterBaseInfo")
    @ResponseBody
    public Result<Integer> updateEnterpriseBaseInfo(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody EnterpriseBaseInfoData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = enterpriseBaseInfoService.updateEnterpriseBaseInfo(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteEnterBaseInfo")
    @ResponseBody
    public Result<Integer> deleteEnterpriseBaseInfo(
            HttpServletRequest request,
            HttpServletResponse response,
            Integer id
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = enterpriseBaseInfoService.deleteEnterpriseBaseInfo(id);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/queryaddEnterBaseInfoById")
    @ResponseBody
    public Result<EnterpriseBaseInfoData> queryEnterpriseBaseInfoById(
            Integer id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        EnterpriseBaseInfoData data = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<EnterpriseBaseInfoData>builder().code(201).message("还没有登录，请先登录再操作哦！").data(data).totalRecords(0).build();
            } else {
                data = enterpriseBaseInfoService.queryEnterpriseBaseInfoById(id);

                return Result.<EnterpriseBaseInfoData>builder().code(200).message("成功").data(data).totalRecords(1).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<EnterpriseBaseInfoData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }
}
