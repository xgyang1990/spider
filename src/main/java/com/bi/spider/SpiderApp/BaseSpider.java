package com.bi.spider.SpiderApp;

import com.bi.spider.utils.MyBatisSessionFactory;
import com.bi.spider.utils.UrlUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class BaseSpider implements PageProcessor {

    public static int currentPage = 39;
    public static String targetUrl = null;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    public Site site = Site.me().setSleepTime(1300)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.2987.133 Safari/537.36");

    public static SqlSession sqlSession = MyBatisSessionFactory.getSessionFactory().openSession();

    //get the comment url
    @Override
    public void process(Page page) {
        String pageText = page.getHtml().toString();
        targetUrl = UrlUtil.generateTmallUrls(pageText);
        page.addTargetRequest(targetUrl+currentPage);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
