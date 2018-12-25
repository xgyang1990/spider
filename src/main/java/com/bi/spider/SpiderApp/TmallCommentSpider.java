package com.bi.spider.SpiderApp;

import com.alibaba.fastjson.JSON;
import com.bi.spider.domain.entity.Comment;
import com.bi.spider.domain.pojo.comment.Tmall.RateList;
import com.bi.spider.domain.pojo.comment.Tmall.TMallRate;
import com.bi.spider.utils.GenerateSite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
//需要访问商品页
public class TmallCommentSpider extends BaseSpider implements PageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(TmallCommentSpider.class);

    private int index = 0;
    @Override
    public void process(Page page) {
            try{
                String jsonStr = page.getJson().get();
                int start = jsonStr.indexOf("{");
                int end = jsonStr.lastIndexOf("}")+1;
                TMallRate tMallRate = JSON.parseObject(jsonStr.substring(start,end),TMallRate.class);
                //this is just for one page
                logger.info("JSON result:{}",tMallRate.getRateDetail().getRateList().size());
                if(tMallRate.getRateDetail().getRateList().size() >0){
                    //parse comment
                    for(RateList rateList: tMallRate.getRateDetail().getRateList()) {
                        //generate Comment object
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
                        com.bi.spider.dao.Comment comment = sqlSession.getMapper(com.bi.spider.dao.Comment.class);
                        comment.insert(new Comment(id,formatdate,content,appendContent,cmsSource,sellerid,product));
                        sqlSession.commit();
                    }
                    //generate next page url
                    if(currentPage<99){
                        currentPage++;
                        page.addTargetRequest(targetUrl+currentPage);
                    }
                }

            }catch(Exception e){
                e.printStackTrace();
            }

    }


    @Override
    public Site getSite() {
        return GenerateSite.tmallSite();
    }
}
