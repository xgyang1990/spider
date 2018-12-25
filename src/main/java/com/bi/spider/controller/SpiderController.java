package com.bi.spider.controller;

import com.bi.spider.constants.Target;
import com.bi.spider.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spider/comment")
public class SpiderController {

    @Autowired
    public SpiderService spiderService;

    @RequestMapping("/tmall")
    public void retrieveTmall(@RequestParam(name = "target",required=false,defaultValue=Target.TMALL_DABAO) String target, @RequestParam(name = "page",required=false,defaultValue="1") int page, @RequestParam(name = "product",required=false,defaultValue=Target.TMALL_DABAO_NAME) String product) {
        spiderService.startTmall(target,page,product);
    }

    @RequestMapping("/jd")
    public void retrieveJD(@RequestParam(name = "target",required=false,defaultValue=Target.JD_DABAO) String target,@RequestParam(name = "page",required=false,defaultValue="1") int page, @RequestParam(name = "product",required=false,defaultValue=Target.JD_DABAO_NAME) String product) {
        spiderService.startJD(target,page,product);
    }
}
