package com.graduationproject.moham.pharmacy.Screens.Screens.Home;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.graduationproject.moham.pharmacy.R;
import com.graduationproject.moham.pharmacy.Screens.Main.RootFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class HomeFragment extends RootFragment {

    @BindView(R.id.recylerview)
    RecyclerView recylerview;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();


        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        init();

        return view;
    }


    MainAdapter mainAdapter;
    ArrayList<Medicine> medicines = new ArrayList<>();

    void init() {

        medicines.add(new Medicine(1, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(2, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(3, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(4, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(5, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(6, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(7, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(8, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
        medicines.add(new Medicine(9, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));
       medicines.add(new Medicine(10, "Panadol", "description description description ", R.drawable.medicine1,"74.1"));

        mainAdapter = new MainAdapter(medicines, getActivity());
        recylerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recylerview.setHasFixedSize(true);
        recylerview.setAdapter(mainAdapter);
    }

    @OnClick(R.id.imgAdd)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "Add new medicne", Toast.LENGTH_SHORT).show();
    }

}
