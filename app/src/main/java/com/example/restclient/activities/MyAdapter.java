package com.example.restclient.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.restclient.ListItem;
import com.example.restclient.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.textViewBeerName.setText(listItem.getBeerName());
        holder.textViewFactory.setText(listItem.getFactory());
        holder.textViewPrice.setText(listItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewBeerName;
        public TextView textViewFactory;
        public TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewBeerName = itemView.findViewById(R.id.textViewBeerName);
            textViewFactory = itemView.findViewById(R.id.textViewFactory);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
