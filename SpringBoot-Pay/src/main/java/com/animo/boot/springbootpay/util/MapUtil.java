package com.animo.boot.springbootpay.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 刘金泳
 * @Date 2019/8/6
 */
public class MapUtil {

    /**
     * 根据request.getParameterMap()封装的Map
     * @param request
     * @return
     */
    public static Map<String,String> getRequestMap(HttpServletRequest request){
        Map<String,String> params = new HashMap(16);
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iterator = requestParams.keySet().iterator(); iterator.hasNext();) {
            String name = iterator.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        return params;
    }

}
