package com.bi.spider.dao;

import com.bi.spider.domain.*;
import com.bi.spider.domain.entity.DABAOComment;

import java.util.List;

public interface DABAOdao {

    public void insert(DABAOComment dabaoComment);

    //todo
    public DABAOComment findDABAOCommentById(int id);

    public List<DABAOComment> findAllDABAOComment();
}
