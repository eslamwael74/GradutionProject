package com.graduationproject.moham.pharmacy.Screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.graduationproject.moham.pharmacy.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MedicineActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.btnEdit)
    Button btnEdit;
    @BindView(R.id.btnHide)
    Button btnHide;
    @BindView(R.id.btnDelete)
    Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        ButterKnife.bind(this);
        init();
    }

    Medicine medicine;

    void init() {
        if (getIntent() != null) {
            medicine = getIntent().getParcelableExtra("medicine");

            tvName.setText(medicine.getName());
            tvDescription.setText(medicine.getDescription());

            Picasso.with(this)
                    .load(medicine.getPhoto())
                    .fit()
                    .centerCrop()
                    .error(R.drawable.border_black_btn)
                    .placeholder(R.drawable.border_black_btn)
                    .into(image);
        } else
            finish();
    }

    @OnClick({R.id.btnEdit, R.id.btnHide, R.id.btnDelete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnEdit:
                Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnHide:
                Toast.makeText(this, "Hide", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDelete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
