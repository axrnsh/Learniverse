package com.example.learniverse;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.learniverse.Adapter.VPStoryAdapter;
import com.example.learniverse.Model.Story;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.util.ArrayList;
import io.realm.RealmResults;

public class fragmentFantasy extends Fragment {
    private RecyclerView recyclerView;
    private VPStoryAdapter adapter;

    // Realm instance
    private Realm realm;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public fragmentFantasy() {
    }

    @SuppressWarnings("unused")
    public static fragmentEducation newInstance(int columnCount) {
        fragmentEducation fragment = new fragmentEducation();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        // Initialize Realm
        Realm.init(getContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .build();

        Realm.setDefaultConfiguration(config);
        // Open the Realm instance
        realm = Realm.getDefaultInstance();

        // Initialize data (optional)
        simpanDataStoryFantasy("Harry Potter and the Sorcerer's Stone", "Harry Potter has no idea how famous he is. That's because he's being raised by his miserable aunt and uncle who are terrified Harry will learn that he's really a wizard, just as his parents were. But everything changes when Harry is summoned to attend an infamous school for wizards, and he begins to discover some clues about his illustrious birthright.", R.drawable.buku_harrypotter);
        simpanDataStoryFantasy("The Chronicles of Narnia: The Lion, the Witch and the Wardrobe", "our adventurous siblings—Peter, Susan, Edmund, and Lucy Pevensie—step through a wardrobe door and into the land of Narnia, a land frozen in eternal winter and enslaved by the power of the White Witch. But when almost all hope is lost, the return of the Great Lion, Aslan, signals a great change . . . and a great sacrifice.", R.drawable.buku_narnia);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fantasy_list, container, false);

        // Set up RecyclerView
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // Load stories from Realm and pass them to the adapter
            ArrayList<Story> stories = getAllStory();
            recyclerView.setAdapter(new VPStoryAdapter(stories));
        }
        return view;
    }

    // Method to save a new story to Realm
    private void simpanDataStoryFantasy(final String namaStory, final String descStory, final int gambarStory) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Story story = realm.createObject(Story.class);
                story.setNamaStory(namaStory);
                story.setDescStory(descStory);
                story.setGambarStory(gambarStory);
            }
        });
    }

    // Method to retrieve all stories from Realm
    private ArrayList<Story> getAllStory() {
        RealmResults<Story> stories = realm.where(Story.class).findAll();
        return new ArrayList<>(stories);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Close the Realm instance when the fragment is destroyed
        if (realm != null) {
            realm.close();
        }
    }

    // Method to clear all stories from Realm
    private void clearAllStory() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
    }
}
