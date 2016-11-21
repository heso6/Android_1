package farkowski.konrad.repositories;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRepoList;
    private RepositoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Tworzymy obiekt adaptera, żeby uzupełnić go za chwilę danymi i przekazać do RecyclerView
        // w celu wyświetlenia listy
        mAdapter = new RepositoriesAdapter();
        // Tworzymy przykładową listę obiektów do pokazania na ekranie
        List<GitHubRepository> repos = new LinkedList<>();
        // Obiekt testowy 1
        GitHubRepository r1 = new GitHubRepository();
        r1.setName("Repo 1");
        repos.add(r1);

        // Obiekt testowy 2
        r1=new GitHubRepository();
        r1.setName("Repo 2");
        repos.add(r1);
        // Przekazujemy listę danych do Adaptera, aby te dane wyświetlić na ekranie !
        mAdapter.setmData(repos);

        // Uzyskujemy dostęp do kontrolki RecyclerView, ponieważ potrzebujemy go skonfigurować
        mRepoList = (RecyclerView) findViewById(R.id.activity_main);
        // Mówimy dla RecyclerView w jakis sposób mają być umieszczone elementy na liście :
        // tutaj używamy klas z Androida, nie musimy implementować własnych
        // (najczęściej LinearLayoutManager - pionowy układ)
        mRepoList.setLayoutManager(new LinearLayoutManager(this));
        // Ustawiamy Adapter na RecyclerView, żeby wiedział co ma wyświetlić.
        mRepoList.setAdapter(mAdapter);
    }
}
