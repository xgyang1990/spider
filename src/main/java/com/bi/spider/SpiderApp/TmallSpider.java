package com.bi.spider.SpiderApp;

import com.alibaba.fastjson.JSON;
import com.bi.spider.constants.Target;
import com.bi.spider.dao.DABAOdao;
import com.bi.spider.domain.entity.DABAOComment;
import com.bi.spider.domain.pojo.comment.Tmall.RateList;
import com.bi.spider.domain.pojo.comment.Tmall.TMallRate;
import com.bi.spider.utils.UrlUtil;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
//需要访问商品页
public class TmallSpider extends BaseSpider implements PageProcessor {

    private static int index = 0;
    @Override
    public void process(Page page) {
        //for the first time, need to get itemid and sellerid to generate the comment url
        if(index == 0){
            String pageText = page.getHtml().toString();
            targetUrl = UrlUtil.generateTmallUrls(pageText);
            page.addTargetRequest(targetUrl+currentPage);
            currentPage++;
            index++;
        }else{
            try{
                String jsonStr = page.getJson().get();
                int start = jsonStr.indexOf("{");
                int end = jsonStr.lastIndexOf("}")+1;
                TMallRate tMallRate = JSON.parseObject(jsonStr.substring(start,end),TMallRate.class);
                //this is just for one page
                System.out.println("JSON result:"+tMallRate.getRateDetail().getRateList().size());
                logger.info("JSON result:{}",tMallRate.getRateDetail().getRateList().size());
                if(tMallRate.getRateDetail().getRateList().size() >0){
                    //parse comment
                    for(RateList rateList: tMallRate.getRateDetail().getRateList()) {
                        //generate DABAOComment object
                        long id = rateList.getId();
                        Date date = rateList.getRateDate();
                        String formatdate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
                        String content = rateList.getRateContent().trim();
                        String appendContent = null;
                        if(rateList.getAppendComment() != null){
                            appendContent = rateList.getAppendComment().getContent().trim();
                        }
                        String cmsSource = rateList.getCmsSource();
                        String sellerid = rateList.getSellerId();
                        DABAOdao DABAOdao = sqlSession.getMapper(DABAOdao.class);
                        DABAOdao.insert(new DABAOComment(id,formatdate,content,appendContent,cmsSource,sellerid));
                        sqlSession.commit();
                    }
                    //generate next page url
                    page.addTargetRequest(targetUrl+currentPage);
                    currentPage++;
                }

            }catch(Exception e){
                e.printStackTrace();
                if(e.getMessage().contains("Duplicate entry")){
                System.out.println("Duplicate entry on page "+ (currentPage-1)+". Exit normally! ");
                }

            }
        }
    }
}
