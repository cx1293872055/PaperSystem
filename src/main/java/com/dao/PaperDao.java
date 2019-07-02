package com.dao;

import com.pojo.Paper;
import com.util.Page;

import java.util.List;



public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);

    List<Paper> queryAllPaper();

    List<Paper> queryAllPaper(Page page);

    int total();


}