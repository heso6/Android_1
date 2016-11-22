package farkowski.konrad.repositories;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RepositoriesAdapter.RepositoryClickAction {
    @BindView(R.id.activity_main)
    protected RecyclerView mRepoList;


    private RepositoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Tworzymy obiekt adaptera, żeby uzupełnić go za chwilę danymi i przekazać do RecyclerView
        // w celu wyświetlenia listy
        mAdapter = new RepositoriesAdapter();
        // mowi adapterowi e biezacy obiekt (this) reaguje na zdarzenia klikniecia.
        mAdapter.setClickListener(this);


        // Mówimy dla RecyclerView w jakis sposób mają być umieszczone elementy na liście :
        // tutaj używamy klas z Androida, nie musimy implementować własnych
        // (najczęściej LinearLayoutManager - pionowy układ)
        mRepoList.setLayoutManager(new LinearLayoutManager(this));
        // Ustawiamy Adapter na RecyclerView, żeby wiedział co ma wyświetlić.
        mRepoList.setAdapter(mAdapter);

        GitHubApi api = GitubApiFactory.getApi();
        api.listRepositories("octocat").enqueue(new Callback<List<GitHubRepository>>() {
            @Override
            public void onResponse(Call<List<GitHubRepository>> call,
                                   Response<List<GitHubRepository>> response) {
                List<GitHubRepository> repos = response.body();
                mAdapter.setmData(repos);
            }

            @Override
            public void onFailure(Call<List<GitHubRepository>> call, Throwable t) {
            t.printStackTrace();
            }
        });
    }

    @Override
    public void onClick(GitHubRepository repository){
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse( repository.getHtmlUrl()));
        startActivity(websiteIntent);
    }
}
