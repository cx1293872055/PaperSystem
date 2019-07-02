package com.pojo;

import org.springframework.web.multipart.MultipartFile;

public class File {

        private String userName;

        private MultipartFile headimage;//上传文件会自动绑定到该属性

        //省略getter和setter方法


    public MultipartFile getHeadimage() {
        return headimage;
    }

    public void setHeadimage(MultipartFile headimage) {
        this.headimage = headimage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
