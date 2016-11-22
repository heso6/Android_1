package farkowski.konrad.repositories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gosc on 22.11.2016.
 */

public interface GitHubApi {
    @GET("users/{user}/repos")
    Call<List<GitHubRepository>> listRepositories(@Path("user") String user);


    }

