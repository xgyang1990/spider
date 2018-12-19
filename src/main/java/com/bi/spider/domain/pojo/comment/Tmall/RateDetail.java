/**
  * Copyright 2018 bejson.com 
  */
package com.bi.spider.domain.pojo.comment.Tmall;
import java.util.List;

/**
 * Auto-generated: 2018-12-14 13:45:51
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RateDetail {

    private RateCount rateCount;
    private RateDanceInfo rateDanceInfo;
    private List<RateList> rateList;
    private String searchinfo;
    private String from;
    private Paginator paginator;
    private List<String> tags;
    public void setRateCount(RateCount rateCount) {
         this.rateCount = rateCount;
     }
     public RateCount getRateCount() {
         return rateCount;
     }

    public void setRateDanceInfo(RateDanceInfo rateDanceInfo) {
         this.rateDanceInfo = rateDanceInfo;
     }
     public RateDanceInfo getRateDanceInfo() {
         return rateDanceInfo;
     }

    public void setRateList(List<RateList> rateList) {
         this.rateList = rateList;
     }
     public List<RateList> getRateList() {
         return rateList;
     }

    public void setSearchinfo(String searchinfo) {
         this.searchinfo = searchinfo;
     }
     public String getSearchinfo() {
         return searchinfo;
     }

    public void setFrom(String from) {
         this.from = from;
     }
     public String getFrom() {
         return from;
     }

    public void setPaginator(Paginator paginator) {
         this.paginator = paginator;
     }
     public Paginator getPaginator() {
         return paginator;
     }

    public void setTags(List<String> tags) {
         this.tags = tags;
     }
     public List<String> getTags() {
         return tags;
     }

}