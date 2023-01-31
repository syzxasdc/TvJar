package com.github.catvod.spider;

import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.RC;
import com.github.catvod.spider.merge.Tc;
import com.github.catvod.spider.merge.Vf;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class Nbys extends Spider {
    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> hashMap) {
        String str3 = "class";
        String str4 = "year";
        String str5 = "lang";
        String str6 = "area";
        String str7 = "by";
        String str8 = "";
        try {
            int i = 1;
            if (!TextUtils.isEmpty(str2) && Integer.parseInt(str2.trim()) > 1) {
                i = Integer.parseInt(str2.trim());
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("id", str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str8);
            stringBuilder.append(i);
            hashMap2.put("pg", stringBuilder.toString());
            if (hashMap != null && hashMap.size() > 0) {
                hashMap2.putAll(hashMap);
            }
            if (hashMap2.get(str7) == null || str8.equals(hashMap2.get(str7))) {
                hashMap2.put(str7, "1");
            }
            String str9 = "0";
            if (hashMap2.get(str6) == null || str8.equals(hashMap2.get(str6))) {
                hashMap2.put(str6, str9);
            }
            if (hashMap2.get(str5) == null || str8.equals(hashMap2.get(str5))) {
                hashMap2.put(str5, str9);
            }
            if (hashMap2.get(str4) == null || str8.equals(hashMap2.get(str4))) {
                hashMap2.put(str4, str8);
            }
            if (hashMap2.get(str3) == null || str8.equals(hashMap2.get(str3))) {
                hashMap2.put(str3, str9);
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put("sort_by", (String) hashMap2.get(str7));
            treeMap.put("channel_id", str);
            treeMap.put("show_type_id", (String) hashMap2.get(str3));
            treeMap.put("region_id", (String) hashMap2.get(str6));
            treeMap.put("lang_id", (String) hashMap2.get(str5));
            treeMap.put("year_range", (String) hashMap2.get(str4));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((i - 1) * 10);
            stringBuilder2.append(str8);
            treeMap.put("start", stringBuilder2.toString());
            JSONObject jSONObject = new JSONObject();
            Vf.w(Vf.B(), genUrl("https://api.mudvod.tv/show/filter/WEB/3.0", treeMap), treeMap, g("https://m.nbys.tv/"), new 3(this, jSONObject));
            jSONObject.put("page", i);
            jSONObject.put("pagecount", 9999);
            jSONObject.put("limit", 36);
            jSONObject.put("total", 359964);
            return jSONObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
            return str8;
        }
    }

    public String genUrl(String str, Map<String, String> map) {
        String str2;
        String str3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Date().getTime() - 600000);
        String str4 = "";
        stringBuilder.append(str4);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("_");
        stringBuilder3.append("AABBCC");
        stringBuilder2 = Tc.dV(stringBuilder3.toString(), "diao.com");
        TreeMap treeMap = new TreeMap();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(new Date().getTime());
        stringBuilder4.append(str4);
        String str5 = "_ts";
        treeMap.put(str5, stringBuilder4.toString());
        String str6 = "app_version";
        treeMap.put(str6, "1.0");
        String str7 = "platform";
        treeMap.put(str7, "3");
        String str8 = "market_id";
        treeMap.put(str8, "web_default");
        String str9 = "device_code";
        treeMap.put(str9, "web");
        String str10 = "versioncode";
        treeMap.put(str10, "1");
        String str11 = "oid";
        treeMap.put(str11, stringBuilder2);
        stringBuilder = new StringBuilder("__QUERY::");
        Iterator it = treeMap.entrySet().iterator();
        while (true) {
            str2 = "&";
            str3 = "=";
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            if (!((String) entry.getValue()).equals(str4)) {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append(str3);
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append(str2);
            }
        }
        StringBuilder stringBuilder5 = new StringBuilder("__BODY::");
        for (Entry entry2 : map.entrySet()) {
            if (!((String) entry2.getValue()).equals(str4)) {
                stringBuilder5.append((String) entry2.getKey());
                stringBuilder5.append(str3);
                stringBuilder5.append((String) entry2.getValue());
                stringBuilder5.append(str2);
            }
        }
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(stringBuilder);
        stringBuilder6.append(stringBuilder5.toString());
        stringBuilder6.append("__KEY::");
        stringBuilder6.append("2x_Give_it_a_shot");
        stringBuilder2 = RC.ue(stringBuilder6.toString(), Charset.defaultCharset());
        stringBuilder6 = new StringBuilder();
        stringBuilder6.append(str);
        stringBuilder6.append("?_ts=");
        stringBuilder6.append((String) treeMap.get(str5));
        stringBuilder6.append("&app_version=");
        stringBuilder6.append((String) treeMap.get(str6));
        stringBuilder6.append("&platform=");
        stringBuilder6.append((String) treeMap.get(str7));
        stringBuilder6.append("&market_id=");
        stringBuilder6.append((String) treeMap.get(str8));
        stringBuilder6.append("&device_code=");
        stringBuilder6.append((String) treeMap.get(str9));
        stringBuilder6.append("&versioncode=");
        stringBuilder6.append((String) treeMap.get(str10));
        stringBuilder6.append("&oid=");
        stringBuilder6.append((String) treeMap.get(str11));
        stringBuilder6.append("&sign=");
        stringBuilder6.append(stringBuilder2);
        return stringBuilder6.toString();
    }

    public String playerContent(String str, String str2, List<String> list) {
        str = "";
        try {
            String[] split = str2.split("_");
            JSONObject jSONObject = new JSONObject();
            TreeMap treeMap = new TreeMap();
            treeMap.put("show_id_code", split[0]);
            treeMap.put("play_id_code", split[1]);
            treeMap.put("oid", "1");
            Vf.w(Vf.B(), genUrl("https://api.mudvod.tv/show/play/info/WEB/3.0", treeMap), treeMap, g("https://m.nbys.tv/"), new 3(this, jSONObject));
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", " Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36");
            jSONObject.put("header", new JSONObject(hashMap).toString());
            jSONObject.put("parse", "0");
            jSONObject.put("playUrl", str);
            str = jSONObject.toString();
            return str;
        } catch (Exception e) {
            SpiderDebug.log(e);
            return str;
        }
    }

    public String searchContent(String str, boolean z) {
        String str2 = "0";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            TreeMap treeMap = new TreeMap();
            treeMap.put("keyword", str);
            treeMap.put("start", str2);
            treeMap.put("cat_id", "1");
            treeMap.put("keyword_type", str2);
            Vf.w(Vf.B(), genUrl("https://api.mudvod.tv/show/search/WEB/3.0", treeMap), treeMap, g("https://m.nbys.tv/"), new 1(this, jSONArray));
            jSONObject.put("list", jSONArray);
            return jSONObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
            return "";
        }
    }

    public String detailContent(List<String> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("list", jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject2);
            TreeMap treeMap = new TreeMap();
            treeMap.put("show_id_code", (String) list.get(0));
            Vf.w(Vf.B(), genUrl("https://api.mudvod.tv/show/detail/WEB/3.0", treeMap), treeMap, g("https://m.nbys.tv/"), new 3(this, jSONObject2));
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return jSONObject.toString();
    }

    public String homeContent(boolean z) {
        String str = "https://m.nbys.tv/";
        try {
            JSONArray jSONArray = new JSONArray();
            Vf.w(Vf.B(), genUrl("https://api.mudvod.tv/show/channel/list/WEB/3.0", new HashMap()), new HashMap(), g(str), new 1(this, jSONArray));
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put("filters", new StringBuilder("{\"1\":[{\"name\":\"剧情\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"喜剧\",\"n\":\"喜剧\"},{\"v\":\"爱情\",\"n\":\"爱情\"},{\"v\":\"恐怖\",\"n\":\"恐怖\"},{\"v\":\"动作\",\"n\":\"动作\"},{\"v\":\"科幻\",\"n\":\"科幻\"},{\"v\":\"剧情\",\"n\":\"剧情\"},{\"v\":\"战争\",\"n\":\"战争\"},{\"v\":\"警匪\",\"n\":\"警匪\"},{\"v\":\"犯罪\",\"n\":\"犯罪\"},{\"v\":\"动画\",\"n\":\"动画\"},{\"v\":\"奇幻\",\"n\":\"奇幻\"},{\"v\":\"冒险\",\"n\":\"冒险\"}],\"key\":\"class\"},{\"name\":\"地区\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"大陆\",\"n\":\"大陆\"},{\"v\":\"香港\",\"n\":\"香港\"},{\"v\":\"欧美\",\"n\":\"欧美\"},{\"v\":\"台湾\",\"n\":\"台湾\"},{\"v\":\"韩国\",\"n\":\"韩国\"},{\"v\":\"日本\",\"n\":\"日本\"},{\"v\":\"泰国\",\"n\":\"泰国\"},{\"v\":\"印度\",\"n\":\"印度\"},{\"v\":\"俄罗斯\",\"n\":\"俄罗斯\"},{\"v\":\"其它\",\"n\":\"其它\"}],\"key\":\"area\"},{\"name\":\"年份\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"2022\",\"n\":\"2022\"},{\"v\":\"2021\",\"n\":\"2021\"},{\"v\":\"2020\",\"n\":\"2020\"},{\"v\":\"2019\",\"n\":\"2019\"},{\"v\":\"2018\",\"n\":\"2018\"},{\"v\":\"2017\",\"n\":\"2017\"},{\"v\":\"2016\",\"n\":\"2016\"},{\"v\":\"2015\",\"n\":\"2015\"},{\"v\":\"2014\",\"n\":\"2014\"},{\"v\":\"2013\",\"n\":\"2013\"},{\"v\":\"2012\",\"n\":\"2012\"},{\"v\":\"2011\",\"n\":\"2011\"},{\"v\":\"2010\",\"n\":\"2010\"},{\"v\":\"2009\",\"n\":\"2009\"},{\"v\":\"2008\",\"n\":\"2008\"},{\"v\":\"2007\",\"n\":\"2007\"},{\"v\":\"2006\",\"n\":\"2006\"},{\"v\":\"2005\",\"n\":\"2005\"},{\"v\":\"2004\",\"n\":\"2004\"},{\"v\":\"2003\",\"n\":\"2003\"},{\"v\":\"2002\",\"n\":\"2002\"},{\"v\":\"2001\",\"n\":\"2001\"},{\"v\":\"2000\",\"n\":\"2000\"}],\"key\":\"year\"},{\"name\":\"排序\",\"value\":[{\"v\":\"time\",\"n\":\"时间\"},{\"v\":\"hits\",\"n\":\"人气\"},{\"v\":\"score\",\"n\":\"评分\"}],\"key\":\"by\"}],\"2\":[{\"name\":\"剧情\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"喜剧\",\"n\":\"喜剧\"},{\"v\":\"爱情\",\"n\":\"爱情\"},{\"v\":\"恐怖\",\"n\":\"恐怖\"},{\"v\":\"动作\",\"n\":\"动作\"},{\"v\":\"科幻\",\"n\":\"科幻\"},{\"v\":\"剧情\",\"n\":\"剧情\"},{\"v\":\"战争\",\"n\":\"战争\"},{\"v\":\"警匪\",\"n\":\"警匪\"},{\"v\":\"犯罪\",\"n\":\"犯罪\"},{\"v\":\"动画\",\"n\":\"动画\"},{\"v\":\"奇幻\",\"n\":\"奇幻\"},{\"v\":\"冒险\",\"n\":\"冒险\"}],\"key\":\"class\"},{\"name\":\"地区\",\"value\":[{\"v\":\"欧美\",\"n\":\"欧美\"}],\"key\":\"area\"},{\"name\":\"年份\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"2022\",\"n\":\"2022\"},{\"v\":\"2021\",\"n\":\"2021\"},{\"v\":\"2020\",\"n\":\"2020\"},{\"v\":\"2019\",\"n\":\"2019\"},{\"v\":\"2018\",\"n\":\"2018\"},{\"v\":\"2017\",\"n\":\"2017\"},{\"v\":\"2016\",\"n\":\"2016\"},{\"v\":\"2015\",\"n\":\"2015\"},{\"v\":\"2014\",\"n\":\"2014\"},{\"v\":\"2013\",\"n\":\"2013\"},{\"v\":\"2012\",\"n\":\"2012\"},{\"v\":\"2011\",\"n\":\"2011\"},{\"v\":\"2010\",\"n\":\"2010\"},{\"v\":\"2009\",\"n\":\"2009\"},{\"v\":\"2008\",\"n\":\"2008\"},{\"v\":\"2007\",\"n\":\"2007\"},{\"v\":\"2006\",\"n\":\"2006\"},{\"v\":\"2005\",\"n\":\"2005\"},{\"v\":\"2004\",\"n\":\"2004\"},{\"v\":\"2003\",\"n\":\"2003\"},{\"v\":\"2002\",\"n\":\"2002\"},{\"v\":\"2001\",\"n\":\"2001\"},{\"v\":\"2000\",\"n\":\"2000\"}],\"key\":\"year\"},{\"name\":\"排序\",\"value\":[{\"v\":\"time\",\"n\":\"时间\"},{\"v\":\"hits\",\"n\":\"人气\"},{\"v\":\"score\",\"n\":\"评分\"}],\"key\":\"by\"}],\"3\":[{\"name\":\"剧情\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"喜剧\",\"n\":\"喜剧\"},{\"v\":\"爱情\",\"n\":\"爱情\"},{\"v\":\"恐怖\",\"n\":\"恐怖\"},{\"v\":\"动作\",\"n\":\"动作\"},{\"v\":\"科幻\",\"n\":\"科幻\"},{\"v\":\"剧情\",\"n\":\"剧情\"},{\"v\":\"战争\",\"n\":\"战争\"},{\"v\":\"警匪\",\"n\":\"警匪\"},{\"v\":\"犯罪\",\"n\":\"犯罪\"},{\"v\":\"动画\",\"n\":\"动画\"},{\"v\":\"奇幻\",\"n\":\"奇幻\"},{\"v\":\"冒险\",\"n\":\"冒险\"}],\"key\":\"class\"},{\"name\":\"地区\",\"value\":[{\"v\":\"韩国\",\"n\":\"韩国\"}],\"key\":\"area\"},{\"name\":\"年份\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"2022\",\"n\":\"2022\"},{\"v\":\"2021\",\"n\":\"2021\"},{\"v\":\"2020\",\"n\":\"2020\"},{\"v\":\"2019\",\"n\":\"2019\"},{\"v\":\"2018\",\"n\":\"2018\"},{\"v\":\"2017\",\"n\":\"2017\"},{\"v\":\"2016\",\"n\":\"2016\"},{\"v\":\"2015\",\"n\":\"2015\"},{\"v\":\"2014\",\"n\":\"2014\"},{\"v\":\"2013\",\"n\":\"2013\"},{\"v\":\"2012\",\"n\":\"2012\"},{\"v\":\"2011\",\"n\":\"2011\"},{\"v\":\"2010\",\"n\":\"2010\"},{\"v\":\"2009\",\"n\":\"2009\"},{\"v\":\"2008\",\"n\":\"2008\"},{\"v\":\"2007\",\"n\":\"2007\"},{\"v\":\"2006\",\"n\":\"2006\"},{\"v\":\"2005\",\"n\":\"2005\"},{\"v\":\"2004\",\"n\":\"2004\"},{\"v\":\"2003\",\"n\":\"2003\"},{\"v\":\"2002\",\"n\":\"2002\"},{\"v\":\"2001\",\"n\":\"2001\"},{\"v\":\"2000\",\"n\":\"2000\"}],\"key\":\"year\"},{\"name\":\"排序\",\"value\":[{\"v\":\"time\",\"n\":\"时间\"},{\"v\":\"hits\",\"n\":\"人气\"},{\"v\":\"score\",\"n\":\"评分\"}],\"key\":\"by\"}],\"4\":[{\"name\":\"剧情\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"喜剧\",\"n\":\"喜剧\"},{\"v\":\"爱情\",\"n\":\"爱情\"},{\"v\":\"恐怖\",\"n\":\"恐怖\"},{\"v\":\"动作\",\"n\":\"动作\"},{\"v\":\"科幻\",\"n\":\"科幻\"},{\"v\":\"剧情\",\"n\":\"剧情\"},{\"v\":\"战争\",\"n\":\"战争\"},{\"v\":\"警匪\",\"n\":\"警匪\"},{\"v\":\"犯罪\",\"n\":\"犯罪\"},{\"v\":\"动画\",\"n\":\"动画\"},{\"v\":\"奇幻\",\"n\":\"奇幻\"},{\"v\":\"冒险\",\"n\":\"冒险\"}],\"key\":\"class\"},{\"name\":\"地区\",\"value\":[{\"v\":\"日本\",\"n\":\"日本\"}],\"key\":\"area\"},{\"name\":\"年份\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"2022\",\"n\":\"2022\"},{\"v\":\"2021\",\"n\":\"2021\"},{\"v\":\"2020\",\"n\":\"2020\"},{\"v\":\"2019\",\"n\":\"2019\"},{\"v\":\"2018\",\"n\":\"2018\"},{\"v\":\"2017\",\"n\":\"2017\"},{\"v\":\"2016\",\"n\":\"2016\"},{\"v\":\"2015\",\"n\":\"2015\"},{\"v\":\"2014\",\"n\":\"2014\"},{\"v\":\"2013\",\"n\":\"2013\"},{\"v\":\"2012\",\"n\":\"2012\"},{\"v\":\"2011\",\"n\":\"2011\"},{\"v\":\"2010\",\"n\":\"2010\"},{\"v\":\"2009\",\"n\":\"2009\"},{\"v\":\"2008\",\"n\":\"2008\"},{\"v\":\"2007\",\"n\":\"2007\"},{\"v\":\"2006\",\"n\":\"2006\"},{\"v\":\"2005\",\"n\":\"2005\"},{\"v\":\"2004\",\"n\":\"2004\"},{\"v\":\"2003\",\"n\":\"2003\"},{\"v\":\"2002\",\"n\":\"2002\"},{\"v\":\"2001\",\"n\":\"2001\"},{\"v\":\"2000\",\"n\":\"2000\"}],\"key\":\"year\"},{\"name\":\"排序\",\"value\":[{\"v\":\"time\",\"n\":\"时间\"},{\"v\":\"hits\",\"n\":\"人气\"},{\"v\":\"score\",\"n\":\"评分\"}],\"key\":\"by\"}],\"5\":[{\"name\":\"剧情\",\"value\":[{\"v\":\"\",\"n\":\"全部\"}],\"key\":\"class\"},{\"name\":\"地区\",\"value\":[],\"key\":\"area\"},{\"name\":\"年份\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"2022\",\"n\":\"2022\"},{\"v\":\"2021\",\"n\":\"2021\"},{\"v\":\"2020\",\"n\":\"2020\"},{\"v\":\"2019\",\"n\":\"2019\"},{\"v\":\"2018\",\"n\":\"2018\"},{\"v\":\"2017\",\"n\":\"2017\"},{\"v\":\"2016\",\"n\":\"2016\"},{\"v\":\"2015\",\"n\":\"2015\"},{\"v\":\"2014\",\"n\":\"2014\"},{\"v\":\"2013\",\"n\":\"2013\"},{\"v\":\"2012\",\"n\":\"2012\"},{\"v\":\"2011\",\"n\":\"2011\"},{\"v\":\"2010\",\"n\":\"2010\"},{\"v\":\"2009\",\"n\":\"2009\"},{\"v\":\"2008\",\"n\":\"2008\"},{\"v\":\"2007\",\"n\":\"2007\"},{\"v\":\"2006\",\"n\":\"2006\"},{\"v\":\"2005\",\"n\":\"2005\"},{\"v\":\"2004\",\"n\":\"2004\"},{\"v\":\"2003\",\"n\":\"2003\"},{\"v\":\"2002\",\"n\":\"2002\"},{\"v\":\"2001\",\"n\":\"2001\"},{\"v\":\"2000\",\"n\":\"2000\"}],\"key\":\"year\"},{\"name\":\"排序\",\"value\":[{\"v\":\"time\",\"n\":\"时间\"},{\"v\":\"hits\",\"n\":\"人气\"},{\"v\":\"score\",\"n\":\"评分\"}],\"key\":\"by\"}],\"6\":[{\"name\":\"剧情\",\"value\":[{\"v\":\"\",\"n\":\"全部\"}],\"key\":\"class\"},{\"name\":\"地区\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"国产\",\"n\":\"国产\"},{\"v\":\"欧美\",\"n\":\"欧美\"},{\"v\":\"日本\",\"n\":\"日本\"},{\"v\":\"其他\",\"n\":\"其他\"}],\"key\":\"area\"},{\"name\":\"年份\",\"value\":[{\"v\":\"\",\"n\":\"全部\"},{\"v\":\"2022\",\"n\":\"2022\"},{\"v\":\"2021\",\"n\":\"2021\"},{\"v\":\"2020\",\"n\":\"2020\"},{\"v\":\"2019\",\"n\":\"2019\"},{\"v\":\"2018\",\"n\":\"2018\"},{\"v\":\"2017\",\"n\":\"2017\"},{\"v\":\"2016\",\"n\":\"2016\"},{\"v\":\"2015\",\"n\":\"2015\"},{\"v\":\"2014\",\"n\":\"2014\"},{\"v\":\"2013\",\"n\":\"2013\"},{\"v\":\"2012\",\"n\":\"2012\"},{\"v\":\"2011\",\"n\":\"2011\"},{\"v\":\"2010\",\"n\":\"2010\"},{\"v\":\"2009\",\"n\":\"2009\"},{\"v\":\"2008\",\"n\":\"2008\"},{\"v\":\"2007\",\"n\":\"2007\"},{\"v\":\"2006\",\"n\":\"2006\"},{\"v\":\"2005\",\"n\":\"2005\"},{\"v\":\"2004\",\"n\":\"2004\"},{\"v\":\"2003\",\"n\":\"2003\"},{\"v\":\"2002\",\"n\":\"2002\"},{\"v\":\"2001\",\"n\":\"2001\"},{\"v\":\"2000\",\"n\":\"2000\"}],\"key\":\"year\"},{\"name\":\"排序\",\"value\":[{\"v\":\"time\",\"n\":\"时间\"},{\"v\":\"hits\",\"n\":\"人气\"},{\"v\":\"score\",\"n\":\"评分\"}],\"key\":\"by\"}]}"));
            }
            jSONObject.put("class", jSONArray);
            Vf.w(Vf.B(), genUrl("https://api.mudvod.tv/index/ranking/list/WEB/3.0", new HashMap()), new HashMap(), g(str), new 3(this, jSONObject));
            return jSONObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
            return "";
        }
    }

    protected HashMap<String, String> g(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("Referer", str);
        }
        hashMap.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36");
        return hashMap;
    }
}