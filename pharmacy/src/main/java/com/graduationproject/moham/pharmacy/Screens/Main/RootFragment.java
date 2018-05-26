package com.graduationproject.moham.pharmacy.Screens.Main;

import android.support.v4.app.Fragment;

import com.graduationproject.moham.pharmacy.BackListener.BackPressedImpl;
import com.graduationproject.moham.pharmacy.BackListener.BackPressedListener;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class RootFragment extends Fragment implements BackPressedListener {


    @Override
    public boolean onBackPressed() {
        return new BackPressedImpl(this).onBackPressed();

    }
}
