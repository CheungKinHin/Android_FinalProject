package com.exmaple2.play_task.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exmaple2.play_task.R;

import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    private List<BillItem> billItems;

    public BillAdapter(List<BillItem> billItems) {
        this.billItems = billItems;
    }
    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
        notifyDataSetChanged(); // 通知数据集变更，刷新列表
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BillItem item = billItems.get(position);
        holder.descriptionTextView.setText(item.getDescription());
        holder.scoreChangeTextView.setText(String.valueOf(item.getScoreChange()));
    }

    @Override
    public int getItemCount() {
        return billItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;
        TextView scoreChangeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.description);
            scoreChangeTextView = itemView.findViewById(R.id.score_change);
        }
    }
}
