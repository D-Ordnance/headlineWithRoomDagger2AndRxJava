package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deeosoft.headlinewithrxjavaanddagger2.R;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.feature.HeadLineModel;

import java.util.List;

public class HeadLineAdapter(Context context, List<HeadLineModel> headLineModels) extends RecyclerView.Adapter<HeadLineAdapter.HeadLineViewHolder> {

    @NonNull
    @Override
    public HeadLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.headline_item_view, parent, false);
        return new HeadLineViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull HeadLineViewHolder holder, int position) {

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
