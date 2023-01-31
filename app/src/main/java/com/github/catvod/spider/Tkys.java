package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.RC;
import com.github.catvod.spider.merge.Vf;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class Tkys extends Spider {
    private static final Pattern[] X = new Pattern[]{Pattern.compile("player=new"), Pattern.compile("<div id=\"video\""), Pattern.compile("<div id=\"[^\"]*?player\""), Pattern.compile("//视频链接"), Pattern.compile("HlsJsPlayer\\("), Pattern.compile("<iframe[\\s\\S]*?src=\"[^\"]+?\""), Pattern.compile("<video[\\s\\S]*?src=\"[^\"]+?\"")};
    private final HashMap<String, ArrayList<String>> G = new HashMap();
    protected JSONObject K = new JSONObject();

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String homeContent(boolean z) {
        String str;
        String str2;
        Throwable e;
        String str3 = "v";
        String str4 = "n";
        String str5 = "type_id";
        String str6 = "type_name";
        String str7 = "";
        try {
            String str8 = "https://tkznp.com/xgapp.php/v2/nav?token=";
            JSONArray jSONArray = new JSONObject(Vf.h(str8, K(str8))).getJSONArray("data");
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            while (true) {
                String str9 = "class";
                JSONObject jSONObject2;
                if (i < jSONArray.length()) {
                    boolean z2;
                    jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString(str6);
                    if (string.equals("电视直播")) {
                        str = str5;
                        str2 = str6;
                        z2 = jSONArray;
                    } else {
                        String string2 = jSONObject2.getString(str5);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(str5, string2);
                        jSONObject3.put(str6, string);
                        jSONArray2.put(jSONObject3);
                        try {
                            jSONObject2 = jSONObject2.getJSONObject("type_extend");
                            Iterator keys = jSONObject2.keys();
                            JSONArray jSONArray3 = new JSONArray();
                            while (keys.hasNext()) {
                                int i2;
                                String str10 = (String) keys.next();
                                String str11 = null;
                                z2 = str10.hashCode();
                                str = str5;
                                switch (z2) {
                                    case true:
                                        if (str10.equals("area")) {
                                            i2 = 1;
                                            break;
                                        }
                                    case true:
                                        if (str10.equals("lang")) {
                                            i2 = 2;
                                            break;
                                        }
                                    case true:
                                        if (str10.equals("year")) {
                                            i2 = 3;
                                            break;
                                        }
                                    case true:
                                        try {
                                            z2 = str10.equals(str9);
                                            if (z2) {
                                                i2 = 0;
                                                break;
                                            }
                                            i2 = -1;
                                            break;
                                        } catch (Exception e2) {
                                            e = e2;
                                            str2 = str6;
                                            z2 = jSONArray;
                                            SpiderDebug.log(e);
                                            i++;
                                            str6 = str2;
                                            jSONArray = z2;
                                            str5 = str;
                                        }
                                    default:
                                }
                                i2 = -1;
                                if (i2 != 0) {
                                    str2 = str6;
                                    if (i2 == 1) {
                                        str11 = "地区";
                                    } else if (i2 == 2) {
                                        str11 = "语言";
                                    } else if (i2 == 3) {
                                        try {
                                            str11 = "年代";
                                        } catch (Exception e3) {
                                            e = e3;
                                            z2 = jSONArray;
                                            SpiderDebug.log(e);
                                            i++;
                                            str6 = str2;
                                            jSONArray = z2;
                                            str5 = str;
                                        }
                                    }
                                } else {
                                    str2 = str6;
                                    str11 = "类型";
                                }
                                str5 = str11;
                                if (str5 == null) {
                                    SpiderDebug.log(str10);
                                } else {
                                    str6 = jSONObject2.getString(str10);
                                    if (str6.trim().length() != 0) {
                                        JSONObject jSONObject4 = jSONObject2;
                                        String[] split = str6.split(",");
                                        JSONObject jSONObject5 = new JSONObject();
                                        z2 = jSONArray;
                                        try {
                                            jSONObject5.put("key", str10);
                                            jSONObject5.put("name", str5);
                                            jSONArray = new JSONArray();
                                            JSONObject jSONObject6 = new JSONObject();
                                            jSONObject6.put(str4, "全部");
                                            jSONObject6.put(str3, str7);
                                            jSONArray.put(jSONObject6);
                                            int length = split.length;
                                            int i3 = 0;
                                            while (i3 < length) {
                                                int i4 = length;
                                                Object obj = split[i3];
                                                String[] strArr = split;
                                                if (!str5.equals("伦理")) {
                                                    jSONObject2 = new JSONObject();
                                                    jSONObject2.put(str4, obj);
                                                    jSONObject2.put(str3, obj);
                                                    jSONArray.put(jSONObject2);
                                                }
                                                i3++;
                                                length = i4;
                                                split = strArr;
                                            }
                                            jSONObject5.put("value", jSONArray);
                                            jSONArray3.put(jSONObject5);
                                            jSONObject2 = jSONObject4;
                                            str6 = str2;
                                            jSONArray = z2;
                                            str5 = str;
                                        } catch (Exception e4) {
                                            e = e4;
                                            SpiderDebug.log(e);
                                            i++;
                                            str6 = str2;
                                            jSONArray = z2;
                                            str5 = str;
                                        }
                                    }
                                }
                                str6 = str2;
                                str5 = str;
                            }
                            str = str5;
                            str2 = str6;
                            z2 = jSONArray;
                            jSONObject.put(string2, jSONArray3);
                        } catch (Exception e5) {
                            e = e5;
                            str = str5;
                            str2 = str6;
                            z2 = jSONArray;
                            SpiderDebug.log(e);
                            i++;
                            str6 = str2;
                            jSONArray = z2;
                            str5 = str;
                        }
                    }
                    i++;
                    str6 = str2;
                    jSONArray = z2;
                    str5 = str;
                } else {
                    jSONObject2 = new JSONObject();
                    jSONObject2.put(str9, jSONArray2);
                    if (z) {
                        jSONObject2.put("filters", jSONObject);
                    }
                    return jSONObject2.toString();
                }
            }
        } catch (Exception e6) {
            SpiderDebug.log(e6);
            return str7;
        }
    }

    public String playerContent(String str, String str2, List<String> list) {
        String str3 = "";
        try {
            JSONObject X;
            String str4 = (ArrayList) this.G.get(str);
            if (str4 == null) {
                str4 = new ArrayList();
            }
            if (!str4.isEmpty()) {
                X = X(str, str4, str2);
                if (X != null) {
                    return X.toString();
                }
            }
            HashMap hashMap;
            StringBuilder stringBuilder;
            if (str2.contains("LT-")) {
                hashMap = new HashMap();
                stringBuilder = new StringBuilder();
                stringBuilder.append("https://jf.96ym.cn/api/?key=89lC7jgdlbZV5T1nIy&url=");
                stringBuilder.append(str2);
                return RC.jw(str2, Vf.h(stringBuilder.toString(), hashMap)).toString();
            } else if (str2.contains("renrenmi")) {
                hashMap = new HashMap();
                stringBuilder = new StringBuilder();
                stringBuilder.append("https://kuba.renrenmi.cc:2266/api/?key=a2bSwx5iAGx1g2qn4h&url=");
                stringBuilder.append(str2);
                return RC.jw(str2, Vf.h(stringBuilder.toString(), hashMap)).toString();
            } else {
                str4 = "url";
                String str5 = "parse";
                if (RC.Pd(str2)) {
                    X = new JSONObject();
                    X.put(str5, 0);
                    X.put("playUrl", str3);
                    X.put(str4, str2);
                    return X.toString();
                }
                X = new JSONObject();
                X.put(str5, 1);
                X.put("jx", "1");
                X.put(str4, str2);
                return X.toString();
            }
        } catch (Exception e) {
            SpiderDebug.log(e);
            return str3;
        }
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> hashMap) {
        String str3 = "vod_remarks";
        String str4 = "vod_pic";
        String str5 = "vod_name";
        String str6 = "pagecount";
        String str7 = "total";
        String str8 = "vod_id";
        String str9 = "page";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://tkznp.com/xgapp.php/v2/video?tid=");
            stringBuilder.append(str);
            stringBuilder.append("&pg=");
            stringBuilder.append(str2);
            stringBuilder.append("&token=");
            str = stringBuilder.toString();
            for (String str10 : hashMap.keySet()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("&");
                stringBuilder2.append(str10);
                stringBuilder2.append("=");
                stringBuilder2.append(URLEncoder.encode((String) hashMap.get(str10)));
                str = stringBuilder2.toString();
            }
            JSONObject jSONObject = new JSONObject(Vf.h(str, K(str)));
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(str8, jSONObject2.getString(str8));
                jSONObject3.put(str5, jSONObject2.getString(str5));
                jSONObject3.put(str4, jSONObject2.getString(str4));
                jSONObject3.put(str3, jSONObject2.getString(str3));
                jSONArray2.put(jSONObject3);
            }
            JSONObject jSONObject4 = new JSONObject();
            int i2 = jSONObject.getInt(str9);
            int i3 = jSONObject.getInt(str7);
            int i4 = jSONObject.getInt(str6);
            jSONObject4.put(str9, i2);
            jSONObject4.put(str6, i4);
            jSONObject4.put("limit", 20);
            jSONObject4.put(str7, i3);
            jSONObject4.put("list", jSONArray2);
            return jSONObject4.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
            return "";
        }
    }

    public String homeVideoContent() {
        String str = "vod_remarks";
        String str2 = "vod_pic";
        String str3 = "vod_name";
        String str4 = "vod_id";
        try {
            String str5 = "https://tkznp.com/xgapp.php/v2/index_video?token=";
            JSONArray jSONArray = new JSONObject(Vf.h(str5, K(str5))).getJSONArray("data");
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray3 = jSONArray.getJSONObject(i).getJSONArray("vlist");
                int i2 = 0;
                while (i2 < jSONArray3.length() && i2 < 6) {
                    JSONObject jSONObject = jSONArray3.getJSONObject(i2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(str4, jSONObject.getString(str4));
                    jSONObject2.put(str3, jSONObject.getString(str3));
                    jSONObject2.put(str2, jSONObject.getString(str2));
                    jSONObject2.put(str, jSONObject.getString(str));
                    jSONArray2.put(jSONObject2);
                    i2++;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("list", jSONArray2);
            return jSONObject3.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
            return "";
        }
    }

    public String searchContent(String str, boolean z) {
        String str2 = "vod_remarks";
        String str3 = "vod_pic";
        String str4 = "vod_name";
        String str5 = "vod_id";
        String str6 = "";
        if (z) {
            return str6;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://tkznp.com/xgapp.php/v2/search?text=");
            stringBuilder.append(URLEncoder.encode(str));
            stringBuilder.append("&pg=1");
            str = stringBuilder.toString();
            JSONArray jSONArray = new JSONObject(Vf.h(str, K(str))).getJSONArray("data");
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str5, jSONObject.getString(str5));
                jSONObject2.put(str4, jSONObject.getString(str4));
                jSONObject2.put(str3, jSONObject.getString(str3));
                jSONObject2.put(str2, jSONObject.getString(str2));
                jSONArray2.put(jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("list", jSONArray2);
            return jSONObject3.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
            return str6;
        }
    }

    private JSONObject X(String str, ArrayList<String> arrayList, String str2) {
        Iterator it = arrayList.iterator();
        String str3 = "";
        while (true) {
            String str4 = "url";
            int i = 1;
            JSONObject jSONObject = null;
            if (it.hasNext()) {
                String str5 = (String) it.next();
                if (!str5.isEmpty()) {
                    if (!str5.equals("null")) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str5);
                        stringBuilder.append(str2);
                        String h = Vf.h(stringBuilder.toString(), null);
                        try {
                            jSONObject = RC.jw(str2, h);
                        } catch (Throwable unused) {
                        }
                        if (jSONObject != null && jSONObject.has(str4)) {
                            str4 = "header";
                            if (jSONObject.has(str4)) {
                                jSONObject.put(str4, jSONObject.getJSONObject(str4).toString());
                                return jSONObject;
                            }
                        }
                        if (h.contains("<html")) {
                            for (Pattern matcher : X) {
                                if (matcher.matcher(h).find()) {
                                    break;
                                }
                            }
                            i = 0;
                            if (i != 0) {
                                str3 = str5;
                            }
                        }
                    }
                }
            } else if (str3.isEmpty()) {
                return null;
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("parse", 1);
                jSONObject2.put("playUrl", str3);
                jSONObject2.put(str4, str2);
                return jSONObject2;
            }
        }
    }

    protected HashMap<String, String> K(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", "Lavf/58.12.100");
        return hashMap;
    }

    public void init(Context context) {
        super.init(context);
    }

    public boolean isVideoFormat(String str) {
        return RC.Pd(str);
    }

    /*  JADX ERROR: NullPointerException in pass: BlockSplitter
        java.lang.NullPointerException: Attempt to invoke virtual method 'boolean jadx.core.dex.attributes.AttrNode.contains(jadx.core.dex.attributes.AType)' on a null object reference
        	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.connectExceptionHandlers(Unknown Source)
        	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.setupConnections(Unknown Source)
        	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.splitBasicBlocks(Unknown Source)
        	at jadx.core.dex.visitors.blocksmaker.BlockSplitter.visit(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(Unknown Source)
        	at jadx.core.ProcessClass.process(Unknown Source)
        	at jadx.api.JadxDecompiler.processClass(Unknown Source)
        	at jadx.api.JavaClass.decompile(Unknown Source)
        */
    public java.lang.String detailContent(java.util.List<java.lang.String> r20) {
        /*
        r19 = this;
        r1 = r19;
        r0 = "$$$";
        r2 = "vod_play_url";
        r3 = "\\$\\$\\$";
        r4 = "vod_play_from";
        r5 = "url";
        r6 = "vod_content";
        r7 = "vod_director";
        r8 = "vod_actor";
        r9 = "vod_remarks";
        r10 = "vod_area";
        r11 = "vod_year";
        r12 = "vod_pic";
        r13 = "vod_name";
        r14 = "vod_id";
        r15 = "vod_info";
        r16 = r0;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0176 }
        r0.<init>();	 Catch:{ Exception -> 0x0176 }
        r17 = r2;	 Catch:{ Exception -> 0x0176 }
        r2 = "https://tkznp.com/xgapp.php/v2/video_detail?id=";	 Catch:{ Exception -> 0x0176 }
        r0.append(r2);	 Catch:{ Exception -> 0x0176 }
        r2 = 0;	 Catch:{ Exception -> 0x0176 }
        r18 = r3;	 Catch:{ Exception -> 0x0176 }
        r3 = r20;	 Catch:{ Exception -> 0x0176 }
        r3 = r3.get(r2);	 Catch:{ Exception -> 0x0176 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0176 }
        r0.append(r3);	 Catch:{ Exception -> 0x0176 }
        r3 = "&token=";	 Catch:{ Exception -> 0x0176 }
        r0.append(r3);	 Catch:{ Exception -> 0x0176 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0176 }
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0176 }
        r2 = r1.K(r0);	 Catch:{ Exception -> 0x0176 }
        r0 = com.github.catvod.spider.merge.Vf.h(r0, r2);	 Catch:{ Exception -> 0x0176 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0176 }
        r0 = "data";	 Catch:{ Exception -> 0x0176 }
        r0 = r3.getJSONObject(r0);	 Catch:{ Exception -> 0x0176 }
        r2 = r0.has(r15);	 Catch:{ Exception -> 0x0176 }
        if (r2 == 0) goto L_0x0062;
    L_0x005e:
        r0 = r0.getJSONObject(r15);	 Catch:{ Exception -> 0x0062 }
    L_0x0062:
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = r0.getString(r14);
        r2.put(r14, r3);
        r3 = r0.getString(r13);
        r2.put(r13, r3);
        r3 = r0.getString(r12);
        r2.put(r12, r3);
        r3 = "type_name";
        r12 = "vod_class";
        r12 = r0.getString(r12);
        r2.put(r3, r12);
        r3 = r0.getString(r11);
        r2.put(r11, r3);
        r3 = r0.getString(r10);
        r2.put(r10, r3);
        r3 = r0.getString(r9);
        r2.put(r9, r3);
        r3 = r0.getString(r8);
        r2.put(r8, r3);
        r3 = r0.getString(r7);
        r2.put(r7, r3);
        r3 = r0.getString(r6);
        r2.put(r6, r3);
        r3 = "vod_url_with_player";
        r3 = r0.getJSONArray(r3);
        r6 = new java.util.ArrayList;
        r6.<init>();
        r7 = new java.util.HashMap;
        r7.<init>();
        r8 = 0;
    L_0x00c2:
        r9 = r3.length();
        if (r8 >= r9) goto L_0x00e7;
    L_0x00c8:
        r9 = r3.getJSONObject(r8);
        r10 = "code";
        r10 = r9.getString(r10);
        r11 = r9.getString(r5);
        r7.put(r10, r11);
        r9.remove(r5);
        r11 = r1.K;
        r11.put(r10, r9);
        r6.add(r10);
        r8 = r8 + 1;
        goto L_0x00c2;
    L_0x00e7:
        r3 = new java.util.TreeMap;
        r5 = new com.github.catvod.spider.Tkys$1;
        r5.<init>(r1, r6);
        r3.<init>(r5);
        r5 = r0.getString(r4);
        r6 = r18;
        r5 = r5.split(r6);
        r8 = r17;
        r0 = r0.getString(r8);
        r0 = r0.split(r6);
        r6 = 0;
    L_0x0106:
        r9 = r5.length;
        if (r6 >= r9) goto L_0x0147;
    L_0x0109:
        r9 = r5[r6];
        r10 = r0.length;
        if (r6 >= r10) goto L_0x0123;
    L_0x010e:
        r10 = r0[r6];
        r10 = r10.trim();
        r10 = r10.length();
        if (r10 != 0) goto L_0x011b;
    L_0x011a:
        goto L_0x0123;
    L_0x011b:
        r9 = r5[r6];
        r10 = r0[r6];
        r3.put(r9, r10);
        goto L_0x0144;
    L_0x0123:
        r10 = r7.containsKey(r9);
        if (r10 == 0) goto L_0x0144;
    L_0x0129:
        r10 = r7.get(r9);
        r10 = (java.lang.String) r10;
        r10 = r10.trim();
        r10 = r10.length();
        if (r10 <= 0) goto L_0x0144;
    L_0x0139:
        r10 = r5[r6];
        r9 = r7.get(r9);
        r9 = (java.lang.String) r9;
        r3.put(r10, r9);
    L_0x0144:
        r6 = r6 + 1;
        goto L_0x0106;
    L_0x0147:
        r0 = r3.keySet();
        r5 = r16;
        r0 = android.text.TextUtils.join(r5, r0);
        r3 = r3.values();
        r3 = android.text.TextUtils.join(r5, r3);
        r2.put(r4, r0);
        r2.put(r8, r3);
        r0 = new org.json.JSONObject;
        r0.<init>();
        r3 = new org.json.JSONArray;
        r3.<init>();
        r3.put(r2);
        r2 = "list";
        r0.put(r2, r3);
        r0 = r0.toString();
        return r0;
        r0 = move-exception;
        com.github.catvod.crawler.SpiderDebug.log(r0);
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Tkys.detailContent(java.util.List):java.lang.String");
    }

    public boolean manualVideoCheck() {
        return true;
    }
}