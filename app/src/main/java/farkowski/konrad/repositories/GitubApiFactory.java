package farkowski.konrad.repositories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gosc on 22.11.2016.
 */

public final class GitubApiFactory {
    private GitubApiFactory() {

    }


    public static GitHubApi getApi() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       return retrofit.create(GitHubApi.class);
    }
}



