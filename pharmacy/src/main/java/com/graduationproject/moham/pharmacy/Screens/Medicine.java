package com.graduationproject.moham.pharmacy.Screens;

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


    public Medicine(int id, String name, String description, int photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
    }

    protected Medicine(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Medicine> CREATOR = new Creator<Medicine>() {
        @Override
        public Medicine createFromParcel(Parcel in) {
            return new Medicine(in);
        }

        @Override
        public Medicine[] newArray(int size) {
            return new Medicine[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(photo);
    }
}
