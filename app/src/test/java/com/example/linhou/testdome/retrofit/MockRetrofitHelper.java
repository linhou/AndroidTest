package com.example.linhou.testdome.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lin.Hou on 2017/9/7.
 */

public class MockRetrofitHelper {
//    public <T> T create(Class<T> clazz) {
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new MockInterceptor())
//                .build();
//
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.***.com")
//                .client(client)
//              //  .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        return retrofit.create(clazz);
//    }
//
//    private String path;
//
//    public void setPath(String path) {
//        this.path = path;
//    }

//    private class MockInterceptor implements Interceptor {
//
//        @Override
//        public Response intercept(Chain chain) throws IOException {
            // 模拟网络数据
//            String content = AssestsReader.readFile(path);
//
//            ResponseBody body = ResponseBody.create(MediaType.parse("application/x-www-form-urlencoded"), content);
//
//            Response response = new Response.Builder().request(chain.request())
//                    .protocol(Protocol.HTTP_1_1)
//                    .code(200)
//                    .body(body)
//                    .build();
//            return response;

//        }
//    }


}
