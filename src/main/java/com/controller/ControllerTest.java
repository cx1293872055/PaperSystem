package com.controller;


import com.exception.PaperException;
import com.pojo.FormatPojo;
import com.pojo.Paper;
import com.service.PaperService;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定的转换器
 * 通过在Spring-mvc中注解的方式
 * http://localhost:8080/test/upPaper?chenxin-1-chenxin
 */
@Controller
@RequestMapping("/test")
public class ControllerTest {
    @Autowired
    private PaperService paperService;

    @RequestMapping("/upPaper")
    @ResponseBody
    public Map<String, Object> upPaper(Paper paper) {
        Map<String, Object> result = new HashMap<>();

        boolean upFlag = (paperService.addPaper(paper) == 1);
        result.put("success", upFlag);
        if (upFlag) {
            result.put("msg", "更新成功");
        } else {
            result.put("msg", "更新失败");
        }
        //!!!!!!
        return result;
    }


    @RequestMapping("/format")
    @ResponseBody
    public Map<String,Object> format(@RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                               @RequestParam("amount1") @NumberFormat(pattern = "#,###.##") Double amount) {
        Map<String, Object> map = new HashMap<>();
        map.put("date", DateUtils.format(date,"yyyy-MM-dd"));
        map.put("amount", amount);
        return map;
    }

    @RequestMapping("/formatPojo")
    public ModelAndView formatPojo(FormatPojo pojo) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("date", pojo.getDate1());
        mv.addObject("amount", pojo.getDate1());
        return mv;
    }


    //只针对当前控制器，会在控制器之前执行此方法，查询之后会讲结果存入，键值为“paper”数据模型中
    @ModelAttribute("paper")
    public Paper iniPaper(@RequestParam(value = "id", required = false) Long id) {
        if (id == null || id < 1) {
            return null;
        }
        Paper paper = paperService.queryById(id);
        System.out.println("这里是@ModelAttribute");
        return paper;
    }


    @RequestMapping(value = "getPaperFormModelAttribute")
    @ResponseBody
    //这里的paper只需要使用注解@ModelAttribute即可获得控制器通知查询到的数据
    public Paper getPaperFormModelAttribute(@ModelAttribute("paper") Paper paper) {
        System.out.println("这里是@RequestMapping");
        return paper;
    }

    @RequestMapping("notFound")
    @ResponseBody
    public Paper notFound(Long id) {
        Paper paper = paperService.queryById(id);

        if (paper == null) {
            throw new PaperException();
        }
        return paper;
    }

    @ExceptionHandler(PaperException.class)
    public String HandlePaperException(PaperException e) {
        return "exception";
    }
}
