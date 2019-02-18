package com.fec.yunmall.projectcore.params;

import android.support.annotation.NonNull;
import com.fec.yunmall.core.net.file_upload.RequestMapBuild;
import com.fec.yunmall.core.util.DetectTool;
import com.fec.yunmall.core.util.EncryptUtil;
import com.fec.yunmall.core.util.JsonUtil;
import com.fec.yunmall.projectcore.base.application.BaseApplication;
import com.fec.yunmall.core.util.SPUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author tome
 * @date 2017/9/6  16:20
 * Description : 通用参数工厂
 */

public class RequestMapParams implements RequestMapBuild<Map<String,String>> {
    private Map<String,String> map;
    private Gson mGson;
    String si = null;
    String pa = null;

    public RequestMapParams() {
        map = new TreeMap<>();
    }

    @Override
    public RequestMapParams put(String key, String value) {
        if (value!=null) {
            map.put(key, value);
        }
        return this;
    }

    @Override
    public RequestMapBuild<Map<String, String>> put(String key, Object value) {
        if (value!=null) {
            map.put(key, getGson().toJson(value));
        }
        return this;
    }

    @Override
    public RequestMapBuild<Map<String, String>> put(String key, int value) {
        map.put(key, String.valueOf(value));
        return this;
    }

    @Override
    public RequestMapBuild<Map<String,String>> put(Map<String,String> map) {
        map.putAll(map);
        return this;
    }

    @Override
    public RequestMapBuild<Map<String, String>> put(@NonNull String s, @NonNull String[] arrayOf) {
        map.put(s, getGson().toJson(arrayOf));
        return this;
    }

    private Gson getGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
        return mGson;
    }

    @Override
    public Map<String, String> build() {
        Map<String, String> mapParam = new HashMap<>();
        String ts = DetectTool.getTS();
        map.put("m", DetectTool.getType());
        map.put("u", DetectTool.getToken());
        map.put("v", DetectTool.getVersionName());
        map.put("i", DetectTool.getIMEI(BaseApplication.getApplication()));
        map.put("t", ts);
        map.put("tk", (String)SPUtil.get(BaseApplication.getApplication(), "token", ""));
        try {
            Logger.json(JsonUtil.mapToJsonObj(map).toString());

            si =  DetectTool.getSign(map);
            pa = EncryptUtil.encrypt(JsonUtil.mapToJsonObj(map).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapParam.put("si", si);
        mapParam.put("pa", pa);

        return mapParam;
    }

}
