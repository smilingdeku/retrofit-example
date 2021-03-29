package org.example.retrofit;

import org.example.retrofit.domain.Post;
import org.example.retrofit.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private SimpleService simpleService;

    @Test
    public void testCustomService() throws IOException {
//        Call<Post> call = customService.get(1);
//        Response<Post> response = call.execute();
//        System.out.println(response.body());

//        Call<List<Post>> call = customService.list();
//        Response<List<Post>> response = call.execute();
//        List<Post> posts = response.body();

        Post post = new Post();
        post.setUserId(1L);
        post.setTitle("foo");
        post.setBody("bar");
        Call<Post> call = simpleService.update(1L, post);
        Response<Post> response = call.execute();
        System.out.println(response.body());
    }

}
