package pers.songyanping.regulatory.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.songyanping.regulatory.model.Result;
import pers.songyanping.regulatory.model.Test;
import pers.songyanping.regulatory.service.TestService;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/addTest")
    @ResponseBody
    public Result<Integer> addTest(
            //@RequestBody
            Test test
    ) {
        Integer count = testService.addTest(test);
        return Result.<Integer>builder().code(200).message("成功").data(count).build();
    }

    @RequestMapping("/listTest")
    @ResponseBody
    public Result<List<Test>> listTest(
            //@RequestParam(required=true)
                    String name
    ) {
        List<Test> list = testService.listTest();
        return Result.<List<Test>>builder().code(200).message("成功").data(list).build();
    }

    @RequestMapping("/updateTest")
    @ResponseBody
    public Result<Integer> updateTest(
            //@RequestBody
            Test test
    ) {
        Integer count = testService.updateTest(test);
        return Result.<Integer>builder().code(200).message("成功").data(count).build();
    }

    @RequestMapping("/deleteTest")
    @ResponseBody
    public Result<Integer> deleteTest(
            //@RequestBody
            String id
    ) {
        Integer count = testService.deleteTest(id);
        return Result.<Integer>builder().code(200).message("成功").data(count).build();
    }
}
