package com.controller.advice;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

//标识控制器通知，并且指定对应的包
@ControllerAdvice(basePackages = {"com.controller.advice"})
public class CommonControllerAdvice {

//定义HTTP对应参数处理规则
    @InitBinder
    public void iniBinder(WebDataBinder binder) {
        //针对日期类型的格式化，期中CustomDateEditor是客户端自定义编辑器
        //它的boolean参数标识是否允许为空
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));

    }


    //在这个通知类上加了@ControllerAdvice注解之后，此通知只会对此注解中指定的包内的控制器通知
    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("projectName", "chapter16");
    }

    @ExceptionHandler(Exception.class)
    public String exception(){
            return "exception";
    }
}
