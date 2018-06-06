package cn.com.odin.utils;

import com.google.gson.Gson;

public class JsonUtil {

    private JsonUtil() {}

    public static <T> T getObjectFromJson(String jsonStr, Class<T> cls){
        System.out.println(jsonStr.trim());
        Gson gson = new Gson();
        T t = gson.fromJson(jsonStr.trim(), cls);
        return t;
    }

}

