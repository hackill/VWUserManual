package com.vm.user.manual.android.dapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vm.user.manual.android.R;
import com.vm.user.manual.android.guide.Item;
import com.vm.user.manual.android.guide.OnItemClickListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemCarAdapter extends RecyclerView.Adapter<ItemCarAdapter.ItemHolder> {

    private List<Item> dataList;
    private OnItemClickListener listener;

    public ItemCarAdapter(List<Item> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item c = dataList.get(position);
        holder.image.setImageDrawable(holder.image.getContext().getResources().getDrawable(c.imageResId, null));
        holder.textView.setText(c.textview);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(c);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView textView;
        View view;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            image = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}