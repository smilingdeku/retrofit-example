package org.example.retrofit.service;

import org.example.retrofit.domain.Post;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * https://jsonplaceholder.typicode.com/guide/
 */
public interface CustomService {

    @GET("/posts/{id}")
    Call<Post> get(@Path(value = "id") long id);

    @GET("/posts")
    Call<List<Post>> list();

    @POST("/posts")
    Call<Post> create(@Body Post post);

    @PUT("/posts/{id}")
    Call<Post> update(@Path(value = "id") long id, @Body Post post);

    @DELETE("/posts/{id}")
    Call<Void> delete(@Path(value = "id") long id);

    @GET("/posts/{id}")
    Call<Post> getByUserId(@Path(value = "id") long id, @Query(value = "userId") long userId);

}
