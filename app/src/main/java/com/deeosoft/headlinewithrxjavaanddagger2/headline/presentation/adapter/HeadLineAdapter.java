package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.deeosoft.headlinewithrxjavaanddagger2.R;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.feature.HeadLineModel;

import java.util.List;

public class HeadLineAdapter extends RecyclerView.Adapter<HeadLineAdapter.HeadLineViewHolder> {
    Context context;
    List<HeadLineModel> headLineModels;
    public HeadLineAdapter(Context context, List<HeadLineModel> headLineModels){
        this.context = context;
        this.headLineModels = headLineModels;
    }

    @NonNull
    @Override
    public HeadLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.headline_item_view, parent, false);
        return new HeadLineViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return headLineModels.size();
    }

    @Override
    public void onBindViewHolder(@NonNull HeadLineViewHolder holder, int position) {
        holder.title.setText(headLineModels.get(position).title);
        holder.author.setText(headLineModels.get(position).author);
        Glide.with(context)
                .load(headLineModels.get(position).imageSrc)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_fall_back)
                .into(holder.headLineImage);
    }

    class HeadLineViewHolder extends RecyclerView.ViewHolder{
        public ImageView headLineImage;
        public TextView title;
        public TextView author;
        public HeadLineViewHolder(View itemView){
            super(itemView);
            headLineImage = itemView.findViewById(R.id.headLineImage);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
        }
    }
}
