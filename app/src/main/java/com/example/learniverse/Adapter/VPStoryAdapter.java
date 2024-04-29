package com.example.learniverse.Adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learniverse.Model.Story;
import com.example.learniverse.ReadStoryActivity;
import com.example.learniverse.databinding.ListStoryLayoutBinding;
import com.example.learniverse.placeholder.PlaceholderContent;

import java.util.List;

public class VPStoryAdapter extends RecyclerView.Adapter<VPStoryAdapter.ViewHolder> {

    private final List<Story> mStories;

    public VPStoryAdapter(List<Story> stories) {
        mStories = stories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListStoryLayoutBinding binding = ListStoryLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Story story = mStories.get(position);
        holder.binding.imageStory.setImageResource(story.getGambarStory());
        holder.binding.txtStoryTitle.setText(story.getNamaStory());
        holder.binding.txtStoryDesc.setText(story.getDescStory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Story clickedStory = mStories.get(holder.getAdapterPosition());
                if (clickedStory.getNamaStory().equals("Harry Potter and the Sorcerer's Stone")) {
                    Intent intent = new Intent(view.getContext(), ReadStoryActivity.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ListStoryLayoutBinding binding;

        public ViewHolder(ListStoryLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
