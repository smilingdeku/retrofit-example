package org.example.retrofit.config.retrofit;

import org.springframework.beans.factory.FactoryBean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author linzhaoming
 **/
public class RetrofitFactoryBean<T> implements FactoryBean<T> {

    private Class<?> type;
    private String baseUrl;

    @SuppressWarnings("unchecked")
    @Override
    public T getObject() throws Exception {
        return (T) new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(type);
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
