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

public class fragmentPoetry extends Fragment {
    private RecyclerView recyclerView;
    private VPStoryAdapter adapter;

    // Realm instance
    private Realm realm;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public fragmentPoetry() {
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

        // Clear all existing stories (optional)
        clearAllStory();

        // Initialize data (optional)
        simpanDataStoryPoetry("Where the Sidewalk Ends", "You'll meet a boy who turns into a TV set, and a girl who eats a whale. The Unicorn and the Bloath live there, and so does Sarah Cynthia Sylvia Stout who will not take the garbage out. It is a place where you wash your shadow and plant diamond gardens, a place where shoes fly, sisters are auctioned off, and crocodiles go to the dentist.", R.drawable.buku_wherethesidewalkends);
        simpanDataStoryPoetry("A Light in the Attic", "Here in the attic you will find Backward Bill, Sour Face Ann, the Meehoo with an Exactlywatt, and the Polar Bear in the Frigidaire. You will talk with Broiled Face, and find out what happens when Somebody steals your knees, you get caught by the Quick-Digesting Gink, a Mountain snores, and They Put a Brassiere on the Camel.", R.drawable.buku_alightintheattic);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education_list, container, false);

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
    private void simpanDataStoryPoetry(final String namaStory, final String descStory, final int gambarStory) {
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
