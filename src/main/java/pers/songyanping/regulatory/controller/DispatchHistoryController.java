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
    public Result<List<DispatchHistoryData>> queryDispatchList() {
        List<DispatchHistoryData> list = null;
        try {
            list = dispatchHistoryService.queryDispatchList();
            return Result.<List<DispatchHistoryData>>builder().code(200).message("成功").data(list).totalRecords(list.size()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<List<DispatchHistoryData>>builder().code(201).message("失败").data(list).totalRecords(0).build();
        }
    }

    @RequestMapping("/manualDispatch")
    @ResponseBody
    public Result<Integer> manualDispatch(
            @RequestBody DispatchHistoryData test
    ) {
        Integer count = null;
        try {
            count = dispatchHistoryService.manualDispatch(test);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }

    @RequestMapping("/deleteHistoryList")
    @ResponseBody
    public Result<Integer> deleteDispatch(
            Integer id
    ) {
        Integer count = null;
        try {
            count = dispatchHistoryService.deleteDispatch(id);
            return Result.<Integer>builder().code(200).message("成功").data(count).totalRecords(0).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Integer>builder().code(201).message("失敗").data(count).totalRecords(0).build();
        }
    }
}
