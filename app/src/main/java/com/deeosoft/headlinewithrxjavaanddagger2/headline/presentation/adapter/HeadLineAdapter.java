package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.deeosoft.headlinewithrxjavaanddagger2.R;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;

import java.util.List;

public class HeadLineAdapter extends RecyclerView.Adapter<HeadLineAdapter.HeadLineViewHolder> {
    Context context;
    List<HeadLineDomainModel> headLineModels;
    OnHeadLineCardClickListener listener;
    public HeadLineAdapter(Context context, OnHeadLineCardClickListener listener){
        this.context = context;
        this.listener = listener;
    }

    public void addHeadLineList(List<HeadLineDomainModel> headLineModels){
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
        return this.headLineModels != null ? headLineModels.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull HeadLineViewHolder holder, int position) {
        if(headLineModels != null) {
            holder.title.setText(headLineModels.get(position).title);
            holder.author.setText(headLineModels.get(position).author);
            Log.d("TAG", "onBindViewHolder: " + headLineModels.get(position).imageSrc);
            Glide.with(context)
                    .load(headLineModels.get(position).imageSrc)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_fall_back)
                    .into(holder.headLineImage);
            holder.headLineCard.setOnClickListener(
                    v -> listener.onHeadLineCardClick(headLineModels.get(position).url)
            );
        }
    }

    class HeadLineViewHolder extends RecyclerView.ViewHolder{
        public ConstraintLayout headLineCard;
        public ImageView headLineImage;
        public TextView title;
        public TextView author;
        public HeadLineViewHolder(View itemView){
            super(itemView);
            headLineCard = itemView.findViewById(R.id.headLineCard);
            headLineImage = itemView.findViewById(R.id.headLineImage);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);

        }
    }

    public interface OnHeadLineCardClickListener{
        void onHeadLineCardClick(String url);
    }
}
