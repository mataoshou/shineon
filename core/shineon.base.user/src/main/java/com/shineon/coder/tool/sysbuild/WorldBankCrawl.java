package com.shineon.coder.tool.sysbuild;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class WorldBankCrawl {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://mp.weixin.qq.com/mp/readtemplate?t=pages/video_player_tmpl&action=mpvideo&auto=0&vid=wxv_1041263121706516481").get();
        JSONObject jsonParentObject = new JSONObject();
        //JSONArray list = new JSONArray();
        for (Element ele : doc.body().children()) {
            System.out.println(ele.toString());
        }
        System.out.println(jsonParentObject.toString());
    }
}
