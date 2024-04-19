package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learniverse.Adapter.StoryAdapter;
import com.example.learniverse.Model.Story;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class StoryTaleActivity extends AppCompatActivity {
    ImageView backButton;
    TextView txtStoryReading;
    ListView liststory;
    ArrayList<Story> storyArrayList;
    private static StoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_tale);

        // transition
        backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryTaleActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        txtStoryReading = findViewById(R.id.txtStoryReading);
        txtStoryReading.setText("Story Reading");

        TextPaint paint = txtStoryReading.getPaint();
        float width = paint.measureText("Story Reading");

        Shader txtShader = new LinearGradient(0, 0, 0, 20,
                new int[]{
                        Color.parseColor("#A8CFC5"),
                        Color.parseColor("#586955"),
                }, null, Shader.TileMode.CLAMP);
        txtStoryReading.getPaint().setShader(txtShader);

        initRealm();

        liststory = (ListView) findViewById(R.id.listStory);
        storyArrayList = new ArrayList<>();
        storyArrayList = getAllStory();

        adapter = new StoryAdapter(storyArrayList, getApplicationContext());
        liststory.setAdapter(adapter);


        liststory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        StoryTaleActivity.this,
                        adapter.getItem(i).getNamaStory() + " has been choosen.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initRealm(){
        //konfigurasi realm
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(config);

        clearAllStory();
        //init data
        simpanDataStory("Story Title", "Story desc...", R.drawable.gambar1);
    }

    public void simpanDataStory(String namaStory, String descStory, int gambarStory){
        Realm realm = Realm.getDefaultInstance();

        //menyimpan data
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Story story = realm.createObject(Story.class);
                story.setNamaStory(namaStory);
                story.setDescStory(descStory);
                story.setGambarStory(gambarStory);
            }
        });

        //tutup koneksi ke dalam database
        realm.close();
    }

    public ArrayList<Story> getAllStory(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Story> stories = realm.where(Story.class).findAll();
        ArrayList<Story> storyList = new ArrayList<>(stories);
        return storyList;
    }

    public void clearAllStory(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        realm.close();
    }
}