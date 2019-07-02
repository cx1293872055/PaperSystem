package com.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND ,reason = "找不到角色信息异常")
public class PaperException extends RuntimeException {
    private static final Long serialVersionUID = 5040949196309781680L;

}
