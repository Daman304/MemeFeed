package com.project.memefeed.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.memefeed.R;
import com.project.memefeed.databinding.MemeListItemBinding;
import com.project.memefeed.models.Meme;

import java.util.ArrayList;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.MemeViewHolder> {
    private Context context;
    private ArrayList<Meme> memeArrayList;

    public MemeAdapter(Context context, ArrayList<Meme> memeArrayList) {
        this.context = context;
        this.memeArrayList = memeArrayList;
    }

    @NonNull
    @Override
    public MemeAdapter.MemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MemeListItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.meme_list_item,parent,false);
        return new MemeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MemeAdapter.MemeViewHolder holder, int position) {
        Meme meme =memeArrayList.get(position);
        holder.memeListItemBinding.setMeme(meme);
        holder.memeListItemBinding.memeImage.setOnClickListener(v -> {
            String link=meme.getPostLink();
            Intent intent= new Intent(Intent.ACTION_VIEW,android.net.Uri.parse(link));
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return memeArrayList.size();
    }
    public class MemeViewHolder extends RecyclerView.ViewHolder{
        private MemeListItemBinding memeListItemBinding;

        public MemeViewHolder(MemeListItemBinding memeListItemBinding) {
            super(memeListItemBinding.getRoot());
            this.memeListItemBinding=memeListItemBinding;
            memeListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
