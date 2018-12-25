package com.bi.spider.service;

import com.bi.spider.SpiderApp.BaseSpider;
import com.bi.spider.SpiderApp.JDCommentSpider;
import com.bi.spider.SpiderApp.TmallCommentSpider;
import com.bi.spider.utils.PageStore;
import com.bi.spider.utils.UrlUtil;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

@Component
public class SpiderService {

    //线程池
    //todo queue
    private ExecutorService executor =  Executors.newCachedThreadPool();

    //todo

    public void startTmall(String target,int page,String product) {
        BaseSpider baseSpider = new BaseSpider();
        TmallCommentSpider tmallCommentSpider = new TmallCommentSpider();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                //for the first time, need to get itemid and sellerid to generate the comment url
                Spider.create(baseSpider).addUrl(target)
                        .thread(1).start();

            }
        });
        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(20000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                //for the first time, need to get itemid and sellerid to generate the comment url
                                tmallCommentSpider.targetUrl = UrlUtil.generateTmallUrls(PageStore.prePage);
                                tmallCommentSpider.currentPage = page;
                                tmallCommentSpider.product = product;
                                Spider.create(tmallCommentSpider).addUrl(tmallCommentSpider.targetUrl+page).thread(1).start();

                            }
        });


    }

    public void startJD(String target,int page, String product) {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                JDCommentSpider jdCommentSpider = new JDCommentSpider();
                jdCommentSpider.currentPage = page;
                jdCommentSpider.product = product;
                Spider.create(jdCommentSpider).addUrl(jdCommentSpider.setTargetUrl(target) + jdCommentSpider.currentPage)
                        .thread(1).run();
            }
        });
    }
}
