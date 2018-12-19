package com.bi.spider.service;

import com.bi.spider.SpiderApp.JDSpider;
import com.bi.spider.SpiderApp.TmallSpider;
import com.bi.spider.constants.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
public class SpiderService {

    @Autowired
    public JDSpider jdSpider;

    @Autowired
    public TmallSpider tmallSpider;

    public void startTmall() {
        Spider.create(tmallSpider).addUrl(Target.TMALL_DABAO)
                .thread(1).run();
    }

    public void startJD() {
        Spider.create(jdSpider).addUrl(jdSpider.setTargetUrl() + jdSpider.currentPage)
                .thread(1).run();
    }
}
