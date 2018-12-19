/**
  * Copyright 2018 bejson.com 
  */
package com.bi.spider.domain.pojo.comment.JD;
import java.util.List;

/**
 * Auto-generated: 2018-12-19 10:36:14
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JDRate {

    private String productAttr;
    private ProductCommentSummary productCommentSummary;
    private List<HotCommentTagStatistics> hotCommentTagStatistics;
    private String jwotestProduct;
    private int maxPage;
    private String testId;
    private int score;
    private int soType;
    private int imageListCount;
    private String vTagStatistics;
    private String csv;
    private List<Comments> comments;
    public void setProductAttr(String productAttr) {
         this.productAttr = productAttr;
     }
     public String getProductAttr() {
         return productAttr;
     }

    public void setProductCommentSummary(ProductCommentSummary productCommentSummary) {
         this.productCommentSummary = productCommentSummary;
     }
     public ProductCommentSummary getProductCommentSummary() {
         return productCommentSummary;
     }

    public void setHotCommentTagStatistics(List<HotCommentTagStatistics> hotCommentTagStatistics) {
         this.hotCommentTagStatistics = hotCommentTagStatistics;
     }
     public List<HotCommentTagStatistics> getHotCommentTagStatistics() {
         return hotCommentTagStatistics;
     }

    public void setJwotestProduct(String jwotestProduct) {
         this.jwotestProduct = jwotestProduct;
     }
     public String getJwotestProduct() {
         return jwotestProduct;
     }

    public void setMaxPage(int maxPage) {
         this.maxPage = maxPage;
     }
     public int getMaxPage() {
         return maxPage;
     }

    public void setTestId(String testId) {
         this.testId = testId;
     }
     public String getTestId() {
         return testId;
     }

    public void setScore(int score) {
         this.score = score;
     }
     public int getScore() {
         return score;
     }

    public void setSoType(int soType) {
         this.soType = soType;
     }
     public int getSoType() {
         return soType;
     }

    public void setImageListCount(int imageListCount) {
         this.imageListCount = imageListCount;
     }
     public int getImageListCount() {
         return imageListCount;
     }

    public void setVTagStatistics(String vTagStatistics) {
         this.vTagStatistics = vTagStatistics;
     }
     public String getVTagStatistics() {
         return vTagStatistics;
     }

    public void setCsv(String csv) {
         this.csv = csv;
     }
     public String getCsv() {
         return csv;
     }

    public void setComments(List<Comments> comments) {
         this.comments = comments;
     }
     public List<Comments> getComments() {
         return comments;
     }

}