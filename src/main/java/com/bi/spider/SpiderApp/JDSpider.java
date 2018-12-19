package com.bi.spider.SpiderApp;

import com.bi.spider.utils.UrlUtil;
import com.alibaba.fastjson.JSON;
import com.bi.spider.constants.Target;
import com.bi.spider.dao.DABAOdao;
import com.bi.spider.domain.entity.DABAOComment;
import com.bi.spider.domain.pojo.comment.JD.Comments;
import com.bi.spider.domain.pojo.comment.JD.JDRate;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
//需要访问商品页
public class JDSpider extends BaseSpider implements PageProcessor {

    @Override
    public void process(Page page) {
        //for the first time, need to get itemid and sellerid to generate the comment url
            try{
                String jsonStr = page.getJson().get();
                JDRate jdRate = JSON.parseObject(jsonStr,JDRate.class);
                //this is just for one page
                System.out.println("JSON result:"+jdRate.getComments().size());
                logger.info("JSON result:{}",jdRate.getComments().size());
                if(jdRate.getComments().size() >0){
                    //parse comment
                    for(Comments comments: jdRate.getComments()) {
                        //generate DABAOComment object
                        long id = comments.getId();
                        Date date = comments.getCreationTime();
                        String formatdate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
                        String content = comments.getContent().trim();
                        String appendContent = null;
                        String cmsSource = "JD";
                        String sellerid = "";
                        DABAOdao DABAOdao = sqlSession.getMapper(DABAOdao.class);
                        DABAOdao.insert(new DABAOComment(id,formatdate,content,appendContent,cmsSource,sellerid));
                        sqlSession.commit();
                    }
                    //generate next page url
                    currentPage++;
                    page.addTargetRequest(targetUrl+currentPage);
                }

            }catch(Exception e){
                e.printStackTrace();
                if(e.getMessage().contains("Duplicate entry")){
                    System.out.println("Duplicate entry on page "+ currentPage+". Exit normally! ");

                }
            }
    }
    public static String setTargetUrl(){
        targetUrl = UrlUtil.generateJDUrls(Target.JD_DABAO);
        return targetUrl;
    }
}
