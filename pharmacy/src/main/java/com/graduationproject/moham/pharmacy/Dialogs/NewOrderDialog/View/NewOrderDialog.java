package com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.View;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.NewOrder;
import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.Presenter.NewOrderPresenter;
import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.Presenter.NewOrderPresenterImpl;
import com.graduationproject.moham.pharmacy.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class NewOrderDialog implements OrderDialogView {

    Context context;
    Dialog dialog;
    NewOrderPresenter orderPresenter;
    NewOrder newOrder;


    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.tvUserComment)
    TextView tvUserComment;
    @BindView(R.id.btnSug)
    Button btnSug;
    @BindView(R.id.btnAcc)
    Button btnAcc;
    @BindView(R.id.editTextSugtMedicine)
    EditText editTextSugtMedicine;


    public NewOrderDialog(Context context, NewOrder newOrder) {
        this.context = context;
        this.newOrder = newOrder;
        initDialog();
    }

    @Override
    public void initDialog() {
        orderPresenter = new NewOrderPresenterImpl(this);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.new_order_dialog);
        ButterKnife.bind(this, dialog);
        Window w = dialog.getWindow();
        w.setBackgroundDrawableResource(R.color.transparent);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(w.getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        w.setAttributes(layoutParams);

        dialog.setCanceledOnTouchOutside(false);


        tvUserName.setText(newOrder.getUserName());
        tvName.setText(newOrder.getMedicineName());
        tvPrice.setText(newOrder.getPrice());
        tvUserComment.setText(newOrder.getUserComment());

        Picasso.with(context)
                .load(newOrder.getImage())
                .fit()
                .centerCrop()
                .error(R.drawable.border_black_btn)
                .placeholder(R.drawable.border_black_btn)
                .into(image);
    }

    @Override
    public void showProgressbar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void serverError() {
        Toast.makeText(context, "Please try again later!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOrderSent() {
        Toast.makeText(context, "OrderSent!!", Toast.LENGTH_SHORT).show();
        hide();
    }


    public void show() {
        if (dialog != null)
            dialog.show();
    }

    public void hide() {
        if (dialog != null)
            dialog.hide();
    }

    public void dismiss() {
        if (dialog != null)
            dialog.dismiss();
    }


    @OnClick({R.id.btnSug, R.id.btnAcc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSug:
                if (editTextSugtMedicine.getText().toString().length() != 0)
                    orderPresenter.sendSuggestionOrder(editTextSugtMedicine.getText().toString());
                else
                    Toast.makeText(context, "Please write a suggest medicine", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAcc:
                break;
        }
    }
}
