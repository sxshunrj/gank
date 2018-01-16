package com.sxshunrj.netty.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.sxshunrj.netty.http.business.param.ARequestParam;
import com.sxshunrj.netty.http.util.CommonUtil;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2018/1/16 17:23
 * Desc：
 */
public class MTest {
    public static void main(String[] args) {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("age", 1);
//        map.put("name", "name1");
//        map.put("address", "aaa");
//
//        ARequestParam aRequestParam = CommonUtil.mapToBean(map, new ARequestParam());
//
//        System.out.println("map:"+ JSON.toJSONString(map));
//        System.out.println("bean:"+JSON.toJSONString(aRequestParam));

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("age", 1);
//        jsonObject.put("name", "name1");
//        String jsonStr = jsonObject.toJSONString();
//
//        System.out.println("jsonStr:"+jsonStr);
//
//        ARequestParam aRequestParam = CommonUtil.jsonToBean(jsonStr, ARequestParam.class);
//        System.out.println("bean:"+JSON.toJSONString(aRequestParam));

//        String uriStr = "http://127.0.0.1:8000/projectName/clazzName/methodName";
//        uriStr = uriStr.replace("http://", "");
//        String[] ps = uriStr.split("/");
//
//        System.out.println("1:"+ps[0]);
//        System.out.println("2:"+ps[1]);
//        System.out.println("3:"+ps[2]);
//        System.out.println("4:"+ps[3]);

        System.out.println(CommonUtil.captureName("aqq"));

    }
}
