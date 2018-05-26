package com.graduationproject.moham.pharmacy.Dialogs.NewOrderDialog;

import android.support.annotation.IdRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;

/**
 * Created by EslamWael74 on 5/26/2018.
 * Email: eslamwael74@outlook.com
 */
public class NewOrder {

    String userName;

    String medicineName;

    String price;

    String userComment;

    int image;


    public NewOrder(String userName, String medicineName, String price, String userComment,@StringRes int image) {
        this.userName = userName;
        this.medicineName = medicineName;
        this.price = price;
        this.userComment = userComment;
        this.image = image;
    }

    public NewOrder(String userName, String medicineName, String price, int image) {
        this.userName = userName;
        this.medicineName = medicineName;
        this.price = price;
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getPrice() {
        return price;
    }

    public String getUserComment() {
        return userComment;
    }

    public int getImage() {
        return image;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
