package com.bi.spider.utils;

import com.alibaba.fastjson.JSON;
import com.bi.spider.domain.pojo.comment.Tmall.OriginalPage;

import java.util.LinkedList;
import java.util.List;

public class UrlUtil {

    //generate tmall comment url
    public static String generateTmallUrls(String rawText){
        List<String> res = new LinkedList<String>();
        int start = rawText.indexOf("\"rateConfig\"");
        int end = rawText.lastIndexOf(",\"rstShopId\"");
        OriginalPage originalPage = null;
        try{
            originalPage = JSON.parseObject("{"+rawText.substring(start,end)+"}",OriginalPage.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        String itemId =originalPage.getRateConfig().getItemId();
        String sellerId =originalPage.getRateConfig().getSellerId();
        String url;
        url = "https://rate.tmall.com/list_detail_rate.htm?itemId="+itemId+"&sellerId="+sellerId+"&currentPage=";
        return url;
    }

    //generate JD comment url
    //https://item.jd.com/274645.html
    public static String generateJDUrls(String rawUrl){

        String itemId = rawUrl.substring(rawUrl.lastIndexOf('/')+1,rawUrl.indexOf(".html"));
        String res = "https://sclub.jd.com/comment/productPageComments.action?productId=" + itemId + "&score=0&sortType=5&pageSize=10&page=";
        return res;
    }
}
