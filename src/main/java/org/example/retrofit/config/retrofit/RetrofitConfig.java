package org.example.retrofit.config.retrofit;

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

}
