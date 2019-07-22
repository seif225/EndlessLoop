package com.example.endlessloop.MainPackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.endlessloop.R;

import java.util.ArrayList;

public class FeedRecyclerView extends RecyclerView.Adapter<FeedRecyclerView.ViewHolder> {
    private View view;
    private Context context;
    private ArrayList<ArticleModel> listOfArticles;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(parent.getContext(), R.layout.main_recycler_view_holder,parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        if (listOfArticles==null) return 0;
        return  listOfArticles.size();

    }

     class ViewHolder extends RecyclerView.ViewHolder {
         ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
