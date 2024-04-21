package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.learniverse.Adapter.VPAdapter;
import com.google.android.material.tabs.TabLayout;

public class StoryTaleActivity extends AppCompatActivity {
    ImageView backButton;
    private TabLayout tabLayoutCategory;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_tale);

        // transition
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryTaleActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        tabLayoutCategory = findViewById(R.id.tabLayoutCategory);
        viewPager = findViewById(R.id.viewPager);

        tabLayoutCategory.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new fragmentEducation(), "Education");
        vpAdapter.addFragment(new fragmentPoetry(), "Poetry");
        vpAdapter.addFragment(new fragmentFantasy(), "Fantasy");
        viewPager.setAdapter(vpAdapter);
    }
}
