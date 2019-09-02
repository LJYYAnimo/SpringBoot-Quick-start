package com.animo.boot.springbootpay.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘金泳
 * @Date 2019/7/24
 */
public class GsonUtil {

    /**
     * Map转Json字符串
     * @param map
     * @param <T>
     * @return
     */
    public static <T> String mapToJson(Map<String, T> map) {
        Gson gson = new GsonBuilder().create();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }

    /**
     * Json字符串转Map
     * @param json
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object> JsonToMap(String json) {
        Gson gson = new GsonBuilder().create();
        //TODO
        Map<String,Object> map = gson.fromJson(json,new TypeToken<HashMap<String,Object>>(){}.getType());
        return map;
    }

    /**
     * 对象转Json字符串
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String objectToJson(Object object){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object,new TypeToken<Object>(){}.getType());
    }
}
