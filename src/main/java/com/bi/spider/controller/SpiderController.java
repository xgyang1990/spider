package com.bi.spider.controller;

import com.bi.spider.service.SpiderService;
import com.sun.tools.javac.comp.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpiderController {

    @Autowired
    public SpiderService spiderService;

    @RequestMapping("/tmall")
    public void retrieveTmall() {
        spiderService.startTmall();
    }

    @RequestMapping("/jd")
    public void retrieveJD() {
        spiderService.startJD();
    }
}
