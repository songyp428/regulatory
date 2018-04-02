package pers.songyanping.regulatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.songyanping.regulatory.model.Test;
import pers.songyanping.regulatory.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/addTest")
    @ResponseBody
    public String addTest() {
        Test test = Test.builder().name("abc").build();
        testService.addTest(test);
        System.out.println("test");
        return "0";
    }
}
