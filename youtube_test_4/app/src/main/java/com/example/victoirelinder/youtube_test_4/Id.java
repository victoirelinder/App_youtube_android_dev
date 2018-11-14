package com.example.victoirelinder.youtube_test_4;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by victoirelinder on 17/03/2018.
 */

public class Id implements Serializable, Parcelable
{

    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("channelId")
    @Expose
    public String channelId;
    @SerializedName("videoId")
    @Expose
    public String videoId;
    public final static Parcelable.Creator<Id> CREATOR = new Creator<Id>() {


        public Id createFromParcel(Parcel in) {
            Id instance = new Id();
            instance.kind = ((String) in.readValue((String.class.getClassLoader())));
            instance.channelId = ((String) in.readValue((String.class.getClassLoader())));
            instance.videoId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Id[] newArray(int size) {
            return (new Id[size]);
        }

    }
            ;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeValue(channelId);
        dest.writeValue(videoId);
    }

    public int describeContents() {
        return 0;
    }

}