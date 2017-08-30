package com.example.linhou.testdome.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Lin.Hou on 2017/8/28.
 */

public interface IRetrofit {
    @GET("ams/pcb/inventory/ongoing")
    Call<RetrofitBean> listRepos();
}
