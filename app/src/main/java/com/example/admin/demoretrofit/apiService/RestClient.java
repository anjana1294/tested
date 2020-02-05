package com.example.admin.demoretrofit.apiService;

import com.example.admin.demoretrofit.util.Constants;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
public class RestClient {

    public static ApiService apiService;
    public static Retrofit client;
    private static String baseUrl = Constants.BASE_URL;

    public static ApiService getClient() {
        if (apiService == null) {

           OkHttpClient okClient = new OkHttpClient();
            okClient.setReadTimeout(120, TimeUnit.SECONDS);
            okClient.setConnectTimeout(120, TimeUnit.SECONDS);

            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request original = chain.request();
                    Request request = original.newBuilder().method(original.method(), original.body()).build();

                    return chain.proceed(request);
                }
            });
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okClient.interceptors().add(interceptor);

      client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = client.create(ApiService.class);
        }
        return apiService;
    }

}
