package org.example.retrofit;

import org.example.retrofit.domain.Contributor;
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

}
