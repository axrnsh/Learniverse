package com.example.learniverse.Adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.learniverse.Model.Story;
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
