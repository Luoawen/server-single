package com.alankin.gateway.web.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * Created by alankin on 2019/3/11.
 */
public class FastJsonUtil {
    public static List<Object> subList(JSONArray jsonArray, int fromIndex, int toIndex) {
        if (jsonArray == null) {
            return null;
        }
        int size = jsonArray.size();
        if (toIndex > size - 1) {
            return jsonArray.subList(fromIndex, size);
        }
        return jsonArray.subList(fromIndex, toIndex);
    }
}
