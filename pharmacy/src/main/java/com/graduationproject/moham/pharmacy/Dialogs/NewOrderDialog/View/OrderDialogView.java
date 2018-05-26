package com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.View;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public interface OrderDialogView {

    void initDialog();

    void showProgressbar();

    void hideProgressbar();

    void serverError();

    void onOrderSent();

}
