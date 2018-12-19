package com.bi.spider.utils;//package Util;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.sun.deploy.net.HttpUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.message.BasicNameValuePair;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//
//import com.wgyscsf.utils.HttpUtils;
//
//
//public class LoginUtil {
//    static boolean result = false;
//    public static void main(String[] args) {
//
//        loginCsdnPager();
//
//        try {
//            loginedPager();
//        } catch (ClientProtocolException e) {
//
//            e.printStackTrace();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//    }
//
//
//    private static void loginedPager() throws IOException,
//            ClientProtocolException {
//
//        HttpUriRequest httpUriRequest = new HttpPost(
//                "http://blog.csdn.net/wgyscsf");
//
//        httpUriRequest
//                .setHeader("Accept",
//                        "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//        httpUriRequest.setHeader("Accept-Encoding", "gzip,deflate,sdch");
//        httpUriRequest.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
//        httpUriRequest.setHeader("Connection", "keep-alive");
//        // 模拟浏览器，否则CSDN服务器限制访问
//        httpUriRequest
//                .setHeader(
//                        "User-Agent",
//                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36");
//
//        HttpResponse response = HttpUtils.httpClient.execute(httpUriRequest);
//        InputStream content = response.getEntity().getContent();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(content));
//        String line = "";
//        String result = "";
//        while ((line = br.readLine()) != null) {
//            result += line;
//        }
//        br.close();
//
//        System.out.println(result);
//    }
//
//    /**
//     * 登录页面
//     */
//    private static void loginCsdnPager() {
//        String html = HttpUtils
//                .sendGet("https://passport.csdn.net/account/login?ref=toolbar");// 这个是登录的页面
//        Document doc = Jsoup.parse(html);
//        // 获取表单所在的节点
//        Element form = doc.select(".user-pass").get(0);
//
//        String lt = form.select("input[name=lt]").get(0).val();
//        String execution = form.select("input[name=execution]").get(0).val();
//        String _eventId = form.select("input[name=_eventId]").get(0).val();
//
//
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("username", "wgyscsf@163.com"));
//        nvps.add(new BasicNameValuePair("password", "wanggaoyuan"));
//        nvps.add(new BasicNameValuePair("lt", lt));
//        nvps.add(new BasicNameValuePair("execution", execution));
//        nvps.add(new BasicNameValuePair("_eventId", _eventId));
//
//        String ret = HttpUtils.sendPost(
//                "https://passport.csdn.net/account/login?ref=toolbar", nvps);
//
//        if (ret.indexOf("redirect_back") > -1) {
//            System.out.println("登陆成功");
//            result = true;
//        } else if (ret.indexOf("登录太频繁") > -1) {
//            System.out.println("登录太频繁，请稍后再试。。。。。");
//            return;
//        } else {
//            System.out.println("登陆失败。");
//            return;
//        }
//    }
//}
