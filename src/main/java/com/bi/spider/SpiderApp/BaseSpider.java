package com.bi.spider.SpiderApp;

import com.bi.spider.utils.GenerateSite;
import com.bi.spider.utils.MyBatisSessionFactory;
import com.bi.spider.utils.PageStore;
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

    public String targetUrl = null;
    public String product = null;
    public int currentPage = 0;
    public static SqlSession sqlSession = MyBatisSessionFactory.getSessionFactory().openSession();
    public static String prePage = null;

    //get the comment url
    @Override
    public void process(Page page) {
        PageStore.prePage = page.getHtml().toString();
    }

    @Override
    public Site getSite() {
        return GenerateSite.baseSite();
    }
}
