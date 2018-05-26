package com.graduationproject.moham.pharmacy.Screens.Screens.Order;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.NewOrder;
import com.graduationproject.moham.pharmacy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    Activity activity;
    ArrayList<NewOrder> orders;



    public OrderAdapter(ArrayList<NewOrder> orders,Activity activity) {
        this.activity = activity;
        this.orders = orders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.order_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvUserName.setText(orders.get(position).getUserName());
        holder.tvOrder.setText(orders.get(position).getMedicineName());
        holder.tvPrice.setText(orders.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return orders != null ? orders.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvUserName)
        TextView tvUserName;
        @BindView(R.id.tvOrder)
        TextView tvOrder;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.card)
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
