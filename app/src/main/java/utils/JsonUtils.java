package utils;

import com.google.gson.Gson;

import json.Json;

/**
 * Created by best on 2017/11/23.
 */

public class JsonUtils {
    public Json getJson(String json) {
        Gson gson = new Gson();
        Json json1 = gson.fromJson(json, Json.class);
        return json1;
    }
}
