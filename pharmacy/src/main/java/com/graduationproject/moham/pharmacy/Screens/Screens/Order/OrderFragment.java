package com.graduationproject.moham.pharmacy.Screens.Screens.Order;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.NewOrder;
import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.View.NewOrderDialog;
import com.graduationproject.moham.pharmacy.R;
import com.graduationproject.moham.pharmacy.Screens.Main.RootFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class OrderFragment extends RootFragment {


    @BindView(R.id.recylerview)
    RecyclerView recylerview;
    Unbinder unbinder;

    public static OrderFragment newInstance() {
        OrderFragment homeFragment = new OrderFragment();


        return homeFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders, container, false);


        unbinder = ButterKnife.bind(this, view);

        init();

        return view;
    }

    ArrayList<NewOrder> orders = new ArrayList<>();
    OrderAdapter orderAdapter;


    void init() {
        orders.add(new NewOrder("EslamWael", "Panadol", "74.5",R.drawable.medicine1));
        orders.add(new NewOrder("Es", "Panadol", "74.5", R.drawable.medicine1));


        orderAdapter = new OrderAdapter(orders, getActivity());
        recylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recylerview.setHasFixedSize(true);
        recylerview.setAdapter(orderAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        NewOrder newOrder = orders.get(0);
        newOrder.setUserComment("Please i need it :s");
        NewOrderDialog newOrderDialog = new NewOrderDialog(getContext(), newOrder);
        newOrderDialog.show();
    }
}
