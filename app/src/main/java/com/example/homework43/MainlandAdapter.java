package com.example.homework43;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homework43.databinding.ItemBinding;

import java.util.ArrayList;

public class MainlandAdapter extends RecyclerView.Adapter<MainlandAdapter.MainlandHolder> {
    private ArrayList<Mainlands> mainlands;
    private Context context;
    private OnItemClick itemClick;
    private ArrayList<Mainlands> countries;

    public MainlandAdapter(ArrayList<Mainlands> mainlands, Context context,OnItemClick itemClick) {
        this.mainlands = mainlands;
        this.context = context;
        itemClick = itemClick;
    }

    public MainlandAdapter(ArrayList <Mainlands> countries) {
        this.countries = countries;
    }


    @NonNull
    @Override
    public MainlandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainlandHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainlandHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(mainlands.get(position),context);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
itemClick.onItemClick(mainlands.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainlands.size() ;
    }

    class MainlandHolder extends RecyclerView.ViewHolder {
        private final ItemBinding binding;

        public MainlandHolder( ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Mainlands mainlands, Context context) {
           binding.tetxview.setText(mainlands.getName());
           binding.textView.setText(mainlands.getCapital());
            Glide.with(MainlandAdapter.this.context).load(R.drawable.class).into(binding.imageView);
        }
    }
}
