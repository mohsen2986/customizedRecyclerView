package com.example.company;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_LOADING = 1;
    private List<Item> datas = new ArrayList<>();

    private LayoutInflater inflater;
    private boolean isLoadig = false;

    public void addItem(List<Item> datas){
        int lastPosition = datas.size();
        this.datas.addAll(datas);
        notifyItemRangeChanged(lastPosition, datas.size());
    }
    @Override
    public int getItemViewType(int position) {
        switch(position){
            case 1: return VIEW_TYPE_ITEM;
        }
        return VIEW_TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (inflater ==  null)
            inflater = LayoutInflater.from(parent.getContext());
        switch(viewType){
            case VIEW_TYPE_ITEM:
                return new ItemRowViewHolder(inflater.inflate(R.layout.row_item, parent , false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = datas.get(position);
        if (item != null && holder instanceof RecyclerAdapter.ItemRowViewHolder){
            ((ItemRowViewHolder) holder).bind(item);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    class ItemRowViewHolder extends RecyclerView.ViewHolder{

        public ItemRowViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(Item item){
            // todo bind data
        }
    }
}

