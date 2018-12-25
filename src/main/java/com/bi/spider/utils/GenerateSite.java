package com.bi.spider.utils;

import us.codecraft.webmagic.Site;

public class GenerateSite {

    public static Site tmallSite(){
        Site site = Site.me().setSleepTime(2000)
                 .setCharset("UTF-8")
                .addHeader(":authority","detail.tmall.com")
                .addHeader(":method","GET")
              //  .addHeader(":path","/list_detail_rate.htm?itemId=556249592456&sellerId=500327991&currentPage=1")
                .addHeader(":scheme","https")
                .addHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("accept-encoding","gzip, deflate, br")
                .addHeader("accept-language","en,de;q=0.9,es;q=0.8,en-GB;q=0.7,en-US;q=0.6,pt-BR;q=0.5,pt;q=0.4,af;q=0.3,zh-CN;q=0.2,zh;q=0.1")
                .addHeader("cache-control","no-cache")
                // .addHeader("referer","https://detail.tmall.com/item.htm?id=7391833431&ali_refid=a3_430583_1006:1103036695:N:%E5%A4%A7%E5%AE%9D:ee632e36ec4bf7ce5993f3fe4eb16aa7&ali_trackid=1_ee632e36ec4bf7ce5993f3fe4eb16aa7&spm=a230r.1.14.1")
                .addHeader("cookie","cna=Z/WDE33PNgICAZSxAdN/WAii; tk_trace=1; t=6487a6955943048e28703ad5d8196279; _tb_token_=f133b5553733e; cookie2=14a7247e975a018e0e0ba0e8d073c6d7; dnk=%5Cu9762%5Cu5305%5Cu5305%5Cu5305414; uc1=cookie16=UIHiLt3xCS3yM2h4eKHS9lpEOw%3D%3D&cookie21=WqG3DMC9Fb5mPLIQo9kR&cookie15=VFC%2FuZ9ayeYq2g%3D%3D&existShop=false&pas=0&cookie14=UoTYNO8RzgfOgg%3D%3D&tag=8&lng=zh_CN; uc3=vt3=F8dByR%2FPtXjIpR1y5SU%3D&id2=Uoe8idPMidOpeg%3D%3D&nk2=oFytSloyAsIzOqg%3D&lg2=WqG3DMC9VAQiUQ%3D%3D; tracknick=%5Cu9762%5Cu5305%5Cu5305%5Cu5305414; lid=%E9%9D%A2%E5%8C%85%E5%8C%85%E5%8C%85414; lgc=%5Cu9762%5Cu5305%5Cu5305%5Cu5305414; csg=51bca448; enc=cm7kNui6%2Fk54a%2Be8HLlKc10aKRCI42HHYPyzGL6hS6nlRv3%2FSVOayKPlJiYoFB6oG77HMHc2U3BCHXszNRAVmQ%3D%3D; sm4=110100; _m_h5_tk=31f240f841b7eb4de96af2104baa2dff_1545631529078; _m_h5_tk_enc=e5d4e3b36aafa2484afbc7acdfac6503; isg=BDg4UHtHkLvFKvriKR_FwNsmCeBmsh7m-p-t3nKp9XMqjdp3GrBZupjkQc2Y3VQD; l=aBV3ePWZyHrCTysBCMa2AS6MSOq36x5zDIyY1Maydi74XoB7PiyAKV-kNMzPK_0qiMSydw1C1UEw.; x5sec=7b22726174656d616e616765723b32223a223261303438656231376362663932346639373638623463363837303864626331434f505867654546455032377263506b317072413377453d227d")
                .addHeader("upgrade-insecure-requests","1")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        return site;
    }

    public static Site jdSite(){
        Site site = Site.me().setSleepTime(2000)
        //  .addHeader("referer","https://rate.tmall.com/list_detail_rate.htm?itemId=556249592456&sellerId=500327991&currentPage=1")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        return site;
    }

    public static Site baseSite(){
        Site site = Site.me().setSleepTime(2000)
                //  .addHeader("referer","https://rate.tmall.com/list_detail_rate.htm?itemId=556249592456&sellerId=500327991&currentPage=1")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        return site;
    }

}
