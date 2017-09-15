package com.example.linhou.testdome.api;


import com.example.linhou.testdome.mvp.entity.Integration;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/3/23.
 */
public interface ApiService {
    @GET("/users/{name}/reports")
    Observable<Integration> getIntegration(@Path("name") String name);
}
