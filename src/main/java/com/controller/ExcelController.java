package com.controller;


import com.pojo.Paper;
import com.service.PaperService;
import com.view.impl.ExcelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExcelController {
    @Autowired
    private PaperService paperService;

    ExcelImpl excel = new ExcelImpl();

    @RequestMapping("/download_excel")
    public @ResponseBody
    String down(HttpServletResponse response, @RequestParam(value = "id",required = false) String id, @RequestParam("name") String name) {
        response.setContentType("application/binary;charset=UTF-8");
        try {
            ServletOutputStream out = response.getOutputStream();
            try {
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name + ".xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            String[] titles = {"用户ID", "作品名称", "作品编号", "作品介绍"};
            List<Paper> list = paperService.queryAllPaper();
            excel.export(titles,list,out);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "导出信息失败";
        }
    }
}
