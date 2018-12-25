package com.bi.spider.SpiderApp;

import com.bi.spider.utils.GenerateSite;
import com.bi.spider.utils.UrlUtil;
import com.alibaba.fastjson.JSON;
import com.bi.spider.domain.entity.Comment;
import com.bi.spider.domain.pojo.comment.JD.JDComments;
import com.bi.spider.domain.pojo.comment.JD.JDRate;
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
public class JDCommentSpider extends BaseSpider implements PageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(JDCommentSpider.class);

    @Override
    public void process(Page page) {
        //for the first time, need to get itemid and sellerid to generate the comment url
            try{
                //System.out.println("JSON result:"+page.getJson().get());
                String jsonStr = page.getJson().get();
                JDRate jdRate = JSON.parseObject(jsonStr,JDRate.class);
                //this is just for one page
                logger.info("JSON result:{}",jdRate.getComments().size());
                if(jdRate.getComments().size() >0){
                    //parse comment
                    for(JDComments jdComments : jdRate.getComments()) {
                        //generate Comment object
                        long id = jdComments.getId();
                        Date date = jdComments.getCreationTime();
                        String formatdate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
                        String content = jdComments.getContent().trim();
                        String appendContent = null;
                        String cmsSource = "JD";
                        String sellerid = "";
                        com.bi.spider.dao.Comment comment = sqlSession.getMapper(com.bi.spider.dao.Comment.class);
                        comment.insert(new Comment(id,formatdate,content,appendContent,cmsSource,sellerid,product));
                        sqlSession.commit();
                    }
                    //generate next page url
                    currentPage++;
                    page.addTargetRequest(targetUrl+currentPage);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
    }

    @Override
    public Site getSite() {
        return GenerateSite.jdSite();
    }

    public String setTargetUrl(String target){
        targetUrl = UrlUtil.generateJDUrls(target);
        return targetUrl;
    }
}
