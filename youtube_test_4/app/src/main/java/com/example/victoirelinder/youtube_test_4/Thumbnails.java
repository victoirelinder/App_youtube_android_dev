
package com.example.victoirelinder.youtube_test_4;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Thumbnails implements Serializable, Parcelable
{

    @SerializedName("default")
    @Expose
    public Default _default;
    @SerializedName("medium")
    @Expose
    public Medium medium;
    @SerializedName("high")
    @Expose
    public High high;
    public final static Creator<Thumbnails> CREATOR = new Creator<Thumbnails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Thumbnails createFromParcel(Parcel in) {
            Thumbnails instance = new Thumbnails();
            instance._default = ((Default) in.readValue((Default.class.getClassLoader())));
            instance.medium = ((Medium) in.readValue((Medium.class.getClassLoader())));
            instance.high = ((High) in.readValue((High.class.getClassLoader())));
            return instance;
        }

        public Thumbnails[] newArray(int size) {
            return (new Thumbnails[size]);
        }

    }
    ;

    public Default getDefault() {
        return _default;
    }

    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_default);
        dest.writeValue(medium);
        dest.writeValue(high);
    }

    public int describeContents() {
        return  0;
    }

}
