package com.graduationproject.moham.pharmacy.Screens.Screens.Home;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eslamwael4 on 5/18/2018.
 * Email: eslamwael74@outlook.com.
 */
public class Medicine implements Parcelable {

    int id;

    String name;

    String description;

    int photo;

    String price;

    public Medicine(int id, String name, String description, int photo, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoto() {
        return photo;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.photo);
        dest.writeString(this.price);
    }


    protected Medicine(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.photo = in.readInt();
        this.price = in.readString();
    }

    public static final Creator<Medicine> CREATOR = new Creator<Medicine>() {
        @Override
        public Medicine createFromParcel(Parcel source) {
            return new Medicine(source);
        }

        @Override
        public Medicine[] newArray(int size) {
            return new Medicine[size];
        }
    };
}
