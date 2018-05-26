package com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog.Interactor;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public interface NewOrderInteractor {

    interface OrderListener{
        void onOrderSent(String nameOfMedicine);

        void serverError();
    }

    void sendOrderToUser(String nameOfMedicine,OrderListener orderListener);

}
