package com.bi.spider.dao;

import java.util.List;

public interface Comment {

    public void insert(com.bi.spider.domain.entity.Comment comment);

    //todo
    public com.bi.spider.domain.entity.Comment findDABAOCommentById(int id);
    //todo
    public List<com.bi.spider.domain.entity.Comment> findAllDABAOComment();
}
