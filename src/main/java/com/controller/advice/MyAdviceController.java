package com.controller.advice;


import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/advice")
public class MyAdviceController {

    /**
     *
     * @param date
     * @param amount
     * @param model
     * @return
     *
     *
     * 注意导入
     * <dependency>
     * <groupId>org.apache.ant</groupId>
     * <artifactId>ant</artifactId>
     * <version>1.10.5</version>
     * </dependency>
     * 依赖!!!!!!
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> testAdvice(Date date, @NumberFormat(pattern = "##,####.00") BigDecimal amount, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("project_name", model.asMap().get("projectName"));
        map.put("date", DateUtils.format(date,"yyyy-MM-dd'T'HH:mm:ss"));
        //因为源码中时区为GMT，所以会少八个小时
        map.put("amount", amount);
        return map;
    }


    @RequestMapping("/exception")
    public void exception() {
        throw new RuntimeException("测试异常跳转");
    }

}
