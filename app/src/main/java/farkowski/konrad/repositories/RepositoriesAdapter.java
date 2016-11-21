package farkowski.konrad.repositories;

import android.support.v4.widget.ViewDragHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


// Ta klasa odpowiada dla widoku listy (RecyclerView) na pytania :
// - ile elementów (getItemCount)
// - jak mają wyglądać (onCreateViewHolder) ?
// - jakie dane mają zawierać (onBindViewHolder) ?
// Jej metody nie są wołane bezpośrednio przez nas, tylko przez komponenty systemu !
public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.RepositoriesViewHolder> {

    // Zmienna w ktorej otrzymamy zbior obiektow, ktore chcemy wyswietlic na ekranie w postaci listy.
    private List<GitHubRepository> mData;

    // w zwiazku z tym ze mData jest prywatne - dodalismy metode setData, pozwalajaca na ustawienie
    // danych do wyswietlenia.
    public void setmData(List<GitHubRepository> mData) {
        this.mData = mData;
    }
    // Ta funkcja ma za zadanie stworzyc  obiekt widoku pojedynczego wiersza, czyli odpowiedz
    // dla RecyclerView na pytanie jak maja wygladac jego elementy!
    // pytanie : jak wyglada ?
    @Override
    public RepositoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // LayoutInflater - komponent do tworzenia obiektow View na podstawie plikow XML (R.layout.XXX)
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // Metoda inflate tworzy obiekt View na podstawie podanego pliku XML
        // Drugi jej parametr to kontener wzgledem ktorego ma wymiarowac nowo tworozny widok
        // trzeci parametr mowi czy chemy nowo tworozny widok dodac od razu do parent.
        View rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RepositoriesViewHolder(rowView);
    }

    // Funkcja ma za zadanie wypełnić pojedyńczy utworzony wcześniej wiersz na liście
    // danymi na podstawie parametru (int position).
    // Pytanie : jakie dane ?
    @Override
    public void onBindViewHolder(RepositoriesViewHolder holder, int position) {
        // 1. Pobierz dane z zadanej pozycji (parametr position)
        GitHubRepository repository = mData.get(position);

        // 2. Uzupelnij widok wiersza (parametr holder) danymi
        holder.mLabel.setText(repository.getName());
    }

    // Mowi dla RecycleView ile elementow ma zostac wyswietlone dla uzytkownika na ekranie.
    // pytanie : ile elementow / wierszy?
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // ViewHolder zapewnia nam możliwość wyszukiwania elementów wiersza na liście, tylko raz
    // podczas tworzenia widoku tego wiersza (onCreateViewHolder), tak żebyśmy nie musieli robić tego
    // za każdym razem w funkcji onBindViewHolder.
    public class RepositoriesViewHolder extends RecyclerView.ViewHolder {
        TextView mLabel;

        public RepositoriesViewHolder(View itemView) {
            super(itemView);
            mLabel = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

}
