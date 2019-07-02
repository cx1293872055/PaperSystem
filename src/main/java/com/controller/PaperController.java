package com.controller;

import com.pojo.Paper;
import com.service.PaperService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    @RequestMapping("/allPaper")
    public String list(Model model) {
        List<Paper> list = paperService.queryAllPaper();
        model.addAttribute("list", list);
        return "allPaper";
    }


    @RequestMapping("/listPaper")
    public String list(Model model, Page page) {

        int tatol = paperService.total();
        if (page.getPage() < 1) {
            page.setPage(1);
        }
        page.caculateLast(tatol);
        if (page.getPage() > page.getLast()) {
            page.setPage(page.getLast());
        }
        int pp = page.getPage();
        page.caculatePage();
        List<Paper> list = paperService.queryAllPaper(page);
        page.setPage(pp);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        return "listPaper";
    }


    @RequestMapping("toAddPaper")
    public String toAddPaper(Model model,@RequestParam(required = false) Integer num) {
        if(num !=null){
            model.addAttribute("num",num);
            return "addPaper";
        }
        model.addAttribute("num",0);
        return "addPaper";
    }

    @RequestMapping("/addPaper")
    public String addPaper(Paper paper,@RequestParam(required = false) Integer num) {
        paperService.addPaper(paper);
        if (num != null) {
            return "redirect:/paper/listPaper";
        }
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") Long id,@RequestParam(required = false) Integer num) {
        paperService.deletePaperById(id);
        if (num != null) {
            return "redirect:/paper/listPaper";
        }
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("toUpdatePaper")
    public String toUpdatePaper(Model model,Long id,@RequestParam(required = false) Integer num) {
        model.addAttribute("paper", paperService.queryById(id));
        if(num !=null){
            model.addAttribute("num", num);
            return "updatePaper";
        }
        model.addAttribute("num",0);
        return "updatePaper";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(Paper paper,@RequestParam(required = false) Integer num) {

        paperService.updatePaper(paper);
        if (num != null) {
            return "redirect:/paper/listPaper";
        }
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/getPaper")
    public ModelAndView getPaper(@RequestParam int  id) {
        Paper paper = paperService.queryById(id);
        System.out.println(paper);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("PaperDetails");
        mv.addObject("paper",paper);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }


}