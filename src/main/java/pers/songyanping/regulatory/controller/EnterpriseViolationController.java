package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.songyanping.regulatory.model.EnterpriseBaseInfoData;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.EnterpriseViolationData;
import pers.songyanping.regulatory.model.VehicleData;
import pers.songyanping.regulatory.service.EnterpriseViolationService;
import pers.songyanping.regulatory.controller.IsLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/regulatory")
public class EnterpriseViolationController {
    @Autowired
    private EnterpriseViolationService enterpriseViolationService;

    @RequestMapping("/queryCorporateCreditList")
    @ResponseBody
    public Result<List<EnterpriseViolationData>> queryEnterpriseViolationList(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        List<EnterpriseViolationData> list = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<List<EnterpriseViolationData>>builder().code(201).message("还没有登录，请先登录再操作哦！").data(list).totalRecords(0).build();
            } else {
                list = enterpriseViolationService.queryEnterpriseViolationList();
                return Result.<List<EnterpriseViolationData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<EnterpriseViolationData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/addCorporateCredit")
    @ResponseBody
    public Result<Integer> addEnterpriseViolation(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody EnterpriseViolationData test
    ) {
        Integer count = null;
        EnterpriseBaseInfoData infoOne = null;
        Integer grade = 0;
        Integer id = 0;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = enterpriseViolationService.addEnterpriseViolation(test);
                grade = test.getGrade();
                id = test.getEnterPriseId();
                infoOne = enterpriseViolationService.queryEnterpriseBaseInfoById(id);
                Integer tmpGreade = 0;
                tmpGreade = infoOne.getCredit();
                tmpGreade = tmpGreade - grade * 1;
                infoOne.setCredit(tmpGreade);

                enterpriseViolationService.updateEnterpriseBaseInfo(infoOne);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/queryCorporateCreditById")
    @ResponseBody
    public Result<EnterpriseViolationData> getEnterpriseViolationById(
            Integer id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        EnterpriseViolationData data = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<EnterpriseViolationData>builder().code(201).message("还没有登录，请先登录再操作哦！").data(data).totalRecords(0).build();
            } else {
                data = enterpriseViolationService.getEnterpriseViolationById(id);

                return Result.<EnterpriseViolationData>builder().code(200).message("成功").data(data).totalRecords(1).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<EnterpriseViolationData>builder().code(201).message("失败").data(data).totalRecords(1).build();
        }
    }

    @RequestMapping("/deleteCorporateCredit")
    @ResponseBody
    public Result<Integer> deleteEnterpriseViolation(
            Integer id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Integer count = null;
        Integer grade = 0;
        EnterpriseViolationData  test = null;
        EnterpriseBaseInfoData infoOne = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = enterpriseViolationService.deleteEnterpriseViolation(id);
                test = enterpriseViolationService.getEnterpriseViolationById(id);
                grade = test.getGrade();
                id = test.getEnterPriseId();
                infoOne = enterpriseViolationService.queryEnterpriseBaseInfoById(id);
                //System.out.println(infoOne);
                Integer tmpGreade = 0;
                tmpGreade = infoOne.getCredit();
                tmpGreade = tmpGreade + grade * 1;
                infoOne.setCredit(tmpGreade);
                //System.out.println("========");
                //System.out.println(infoOne);

                enterpriseViolationService.updateEnterpriseBaseInfo(infoOne);

                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/updateCorporateCredit")
    @ResponseBody
    public Result<Integer> updateEnterpriseViolation(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody EnterpriseViolationData test
    ) {
        Integer count = null;
        Boolean isLogin = false;
        try {
            isLogin = IsLogin.isLogin(request);

            if (!isLogin) {
                response.setStatus(110);
                return Result.<Integer>builder().code(201).message("还没有登录，请先登录再操作哦！").data(count).totalRecords(0).build();
            } else {
                count = enterpriseViolationService.updateEnterpriseViolation(test);
                return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }
}
