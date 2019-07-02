package com.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file)throws IOException {

        String path="D:/上传的文件/"+file.getOriginalFilename();
        File newFile=new File(path);
        if(!newFile.exists())
        file.transferTo(newFile);
        else{
            return "redirect:/file/FileExplorer?flag=1";
        }
        return "redirect:/file/FileExplorer?flag=0";
    }


    @RequestMapping("/FileExplorer")
    public String toExplorer(Model model, @RequestParam(required = false) Integer flag) {
        File file = new File("D:\\上传的文件");
        File a[] = file.listFiles();
        model.addAttribute("FileList", a);
        if(flag!=null){
            model.addAttribute("flag", flag);
        }
        System.out.println(flag);
        return "FileExplorer";
    }

    @RequestMapping("/uploadPart")
    public ModelAndView uploadPart(@RequestParam("file") Part file) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        String fileName = file.getSubmittedFileName();
        File dest = new File(fileName);
        try {
            file.write("D:/上传的文件/" + fileName);
            mv.addObject("success", true);
            mv.addObject("msg", "上传文件成功");

        } catch (IllegalStateException | IOException e) {
            mv.addObject("success", false);
            mv.addObject("msg", "上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value="/download",method= RequestMethod.GET) //匹配的是href中的download请求
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename,
                                           Model model) throws IOException{

        //从我们的上传文件夹中去取
        String downloadFilePath="D:\\上传的文件\\";
        //新建一个文件
        File file = new File(downloadFilePath+File.separator+filename);
        if (file.isDirectory()) {

        }
        //http头信息
        HttpHeaders headers = new HttpHeaders();
        //设置编码
        String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("filename") String fileName) {

        String path = "D:/上传的文件/" + fileName;
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        return "redirect:/file/FileExplorer";
    }

}
