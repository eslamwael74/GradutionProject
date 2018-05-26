package com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.Presenter;

import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.Interactor.NewOrderInteractor;
import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.Interactor.NewOrderInteractorImpl;
import com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.View.OrderDialogView;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class NewOrderPresenterImpl implements NewOrderPresenter, NewOrderInteractor.OrderListener {

    OrderDialogView dialogView;
    NewOrderInteractor orderInteractor;

    public NewOrderPresenterImpl(OrderDialogView dialogView) {
        this.dialogView = dialogView;
        orderInteractor = new NewOrderInteractorImpl();
    }

    @Override
    public void onOrderSent(String nameOfMedicine) {
        if (dialogView != null){
            dialogView.hideProgressbar();
            dialogView.onOrderSent();
        }
    }

    @Override
    public void serverError() {
        if (dialogView != null){
            dialogView.hideProgressbar();
            dialogView.serverError();
        }
    }

    @Override
    public void sendSuggestionOrder(String NameOfMedicine) {
        dialogView.showProgressbar();
        orderInteractor.sendOrderToUser(NameOfMedicine, this);
    }
}
