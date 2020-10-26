package com.css.thread.entity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author chenshanshan
 * @time 2019/7/1 13:21
 */
public interface Api {
    @GET("uni")
    Call<Repo> getNews(@Query("dtype")String dtype, @Query("key")String key);
}
