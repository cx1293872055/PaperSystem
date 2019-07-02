package com.converter;

import com.pojo.Paper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToPaperConverter implements Converter<String, Paper> {


    @Override
    public Paper convert(String s) {

        if (StringUtils.isEmpty(s)) {
            return null;
        }

        if (s.indexOf("-") == -1) {
            return null;
        }

        String []arr = s.split("-");
        if (arr.length != 3) {
            return null;
        }

        Paper paper = new Paper();
        paper.setPaperName(arr[0]);
        paper.setPaperNum(Integer.parseInt(arr[1]));
        paper.setPaperDetail(arr[2]);

        return paper;
    }
}
