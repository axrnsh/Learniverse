package com.example.learniverse;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learniverse.Adapter.StoryAdapter;
import com.example.learniverse.Model.Story;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListStoryLayout listview;
    ArrayList<Story> produkArrayList;
    private static StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView);
        storyArrayList = new ArrayList<>();

        Story story1 = new Story("Story Title", "Story desc...", R.drawable.GambarStory.GambarStory1);

        produkArrayList.add(story1);

        adapter = new StoryAdapter(storyArrayList, getApplicationContext());
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        adapter.getItem(i).getNamaStory() + "has been choosen",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}