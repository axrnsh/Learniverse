package com.example.learniverse.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learniverse.Model.Story;
import com.example.learniverse.R;

import java.util.ArrayList;

public class StoryAdapter extends ArrayAdapter<Story> {

    private ArrayList<Story> storyArrayList;
    Context context;

    public StoryAdapter(ArrayList<Story> storyArrayList, Context context) {
        super(context, R.layout.list_story_layout,storyArrayList);
        this.storyArrayList = storyArrayList;
        this.context = context;
    }

    private static class MyViewHolder {
        ImageView imageStory;
        TextView txtStoryTitle;
        TextView txtStoryDesc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Story story = getItem(position);
        final View result;

        MyViewHolder myViewHolder;

        if (convertView==null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_story_layout, parent, false);

            myViewHolder.imageStory = (ImageView) convertView.findViewById(R.id.imageStory);
            myViewHolder.txtStoryTitle = (TextView) convertView.findViewById(R.id.txtStoryTitle);
            myViewHolder.txtStoryDesc = (TextView) convertView.findViewById(R.id.txtStoryDesc);

            convertView.setTag(myViewHolder);
        }
        else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        result = convertView;
        myViewHolder.imageStory.setImageResource(story.getGambarStory());
        myViewHolder.txtStoryTitle.setText(story.getNamaStory());
        myViewHolder.txtStoryDesc.setText(story.getDescStory());
        return result;
    }
}
