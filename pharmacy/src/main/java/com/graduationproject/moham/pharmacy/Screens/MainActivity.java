package com.graduationproject.moham.pharmacy.Screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.graduationproject.moham.pharmacy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.recylerview)
    RecyclerView recylerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    MainAdapter mainAdapter;
    ArrayList<Medicine> medicines = new ArrayList<>();

    void init() {
        toolbarText.setText("Medicines");

        medicines.add(new Medicine(1, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(2, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(3, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(4, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(5, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(6, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(7, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(8, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(9, "Panadol", "description description description ", R.drawable.medicine1));
        medicines.add(new Medicine(10, "Panadol", "description description description ", R.drawable.medicine1));

        mainAdapter = new MainAdapter(medicines, this);
        recylerview.setLayoutManager(new GridLayoutManager(this, 2));
        recylerview.setHasFixedSize(true);
        recylerview.setAdapter(mainAdapter);
    }

    @OnClick(R.id.imgAdd)
    public void onViewClicked() {
        Toast.makeText(this, "Add new medicne", Toast.LENGTH_SHORT).show();
    }
}
