package com.graduationproject.moham.pharmacy.Screens.Screens.Home;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.graduationproject.moham.pharmacy.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eslamwael4 on 5/18/2018.
 * Email: eslamwael74@outlook.com.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {


    Activity activity;
    ArrayList<Medicine> medicines;

    public MainAdapter(ArrayList<Medicine> medicines, Activity activity) {
        this.activity = activity;
        this.medicines = medicines;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.home_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(medicines.get(position).getName());

        Picasso.with(activity)
                .load(medicines.get(position).getPhoto())
                .fit()
                .centerCrop()
                .error(R.drawable.border_black_btn)
                .placeholder(R.drawable.border_black_btn)
                .into(holder.imageView);

        holder.mLin.setOnClickListener(v -> {
            Intent intent = new Intent(activity, MedicineActivity.class);
            intent.putExtra("medicine", medicines.get(position));
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return medicines != null ? medicines.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.lin)
        LinearLayout mLin;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
