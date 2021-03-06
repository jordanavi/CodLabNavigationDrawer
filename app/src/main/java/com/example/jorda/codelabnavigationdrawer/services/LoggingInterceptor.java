package com.example.jorda.codelabnavigationdrawer.services;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        MediaType mediaType = MediaType.parse("application/json; charset=iso-8859-1");
        ResponseBody modifiedBody = ResponseBody.create(mediaType, response.body().bytes());
        Response modifiedResponse = response.newBuilder()
                .body(modifiedBody)
                .build();
        return modifiedResponse;
    }
}
