package org.example.retrofit;

import org.example.retrofit.domain.Contributor;
import org.example.retrofit.domain.Post;
import org.example.retrofit.service.CustomService;
import org.example.retrofit.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private SimpleService simpleService;

    @Autowired
    private CustomService customService;

    @Test
    public void testSimpleService() throws IOException {
        Call<List<Contributor>> call = simpleService.contributors("square", "retrofit");
        Response<List<Contributor>> response = call.execute();
        List<Contributor> contributors = response.body();
        if (!CollectionUtils.isEmpty(contributors)) {
            for (Contributor contributor : contributors) {
                System.out.println(contributor.login + " (" + contributor.contributions + ")");
            }
        }
    }

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
        Call<Post> call = customService.update(1L, post);
        Response<Post> response = call.execute();
        System.out.println(response.body());
    }

}
