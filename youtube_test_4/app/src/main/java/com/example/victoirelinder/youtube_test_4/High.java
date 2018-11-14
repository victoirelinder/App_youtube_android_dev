package com.example.victoirelinder.youtube_test_4;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by victoirelinder on 17/03/2018.
 */

public class High implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    public String url;
    public final static Parcelable.Creator<High> CREATOR = new Creator<High>() {
 //Create a new instance of the Parcelable class, instantiating it from the given Parcel

        @SuppressWarnings({
                "unchecked"
        })
        public High createFromParcel(Parcel in) {
            High instance = new High();
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public High[] newArray(int size) {
            return (new High[size]);
        }

    }
            ;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
    }  // Flatten this object in to a Parcel.

    public int describeContents() {
        return  0;
    }

}
