package com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.Interactor;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class NewOrderInteractorImpl implements NewOrderInteractor {

    @Override
    public void sendOrderToUser(String nameOfMedicine, OrderListener orderListener) {
        orderListener.onOrderSent(nameOfMedicine);
    }

}
