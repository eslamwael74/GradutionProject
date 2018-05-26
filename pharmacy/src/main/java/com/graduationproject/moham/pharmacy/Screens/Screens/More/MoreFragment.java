package com.graduationproject.moham.pharmacy.Screens.Screens.More;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.graduationproject.moham.pharmacy.R;
import com.graduationproject.moham.pharmacy.Screens.Main.RootFragment;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class MoreFragment extends RootFragment {


    public static MoreFragment newInstance() {
        MoreFragment homeFragment = new MoreFragment();


        return homeFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);


        return view;
    }



}
