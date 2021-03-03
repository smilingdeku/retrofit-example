package org.example.retrofit.config.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.example.retrofit.service.CustomService;
import org.example.retrofit.service.SimpleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author linzhaoming
 **/
@Configuration
public class RetrofitConfig {

    public static final String GITHUB_API_URL = "https://api.github.com";

    @Bean
    public SimpleService simpleService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(SimpleService.class);
    }

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Bean
    public CustomService customService() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(chain -> {
                    // 对于一些需要添加请求头的接口，可在此处进行处理
                    Request.Builder builder = chain.request()
                            .newBuilder()
                            .header("Content-type", "application/json; charset=UTF-8");
                    return chain.proceed(builder.build());
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CustomService.class);
    }

}
