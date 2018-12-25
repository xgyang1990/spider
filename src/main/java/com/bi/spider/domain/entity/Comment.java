package com.bi.spider.domain.entity;

public class Comment {

    public Comment(long id, String date, String content, String appendContent, String cmsSource, String sellerid,String product) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.appendContent = appendContent;
        this.cmsSource = cmsSource;
        this.sellerid = sellerid;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAppendContent() {
        return appendContent;
    }

    public void setAppendContent(String appendContent) {
        this.appendContent = appendContent;
    }

    public String getCmsSource() {
        return cmsSource;
    }

    public void setCmsSource(String cmsSource) {
        this.cmsSource = cmsSource;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    private long id;
    private String date;
    private String content;
    private String appendContent;
    private String cmsSource;
    private String sellerid;
    private String product;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
