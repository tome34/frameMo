package com.fec.yunmall.projectcore.api;

import com.fec.yunmall.projectcore.base.bean.BaseObj;
import com.fec.yunmall.projectcore.bean.home.TestRankingBean;
import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author tome
 * @date 2019/1/28  17:24
 * @describe ${API}
 */
public interface ApiService {

    //@POST("/api/upload/upload")
    //Observable<BaseEntity<UploadResultBean>> upload(@Body MultipartBody file);

    /**
     * 测试
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("v6/v6_005")
    Observable<BaseObj<TestRankingBean>> getRanking(@FieldMap Map<String, String> map);


}
