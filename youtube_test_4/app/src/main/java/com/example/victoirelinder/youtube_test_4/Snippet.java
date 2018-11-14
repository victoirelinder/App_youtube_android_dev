package com.example.victoirelinder.youtube_test_4;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by victoirelinder on 17/03/2018.
 */

public class Snippet implements Serializable, Parcelable  // // additional text that's displayed below the title.
{
    //videos infos
    @SerializedName("publishedAt")
    @Expose
    public String publishedAt;
    @SerializedName("channelId")
    @Expose
    public String channelId;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("thumbnails")
    @Expose
    public Thumbnails thumbnails;
    @SerializedName("channelTitle")
    @Expose
    public String channelTitle;
    @SerializedName("liveBroadcastContent")
    @Expose
    public String liveBroadcastContent;
    public final static Parcelable.Creator<Snippet> CREATOR = new Creator<Snippet>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Snippet createFromParcel(Parcel in) {
            Snippet instance = new Snippet();
            instance.publishedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.channelId = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumbnails = ((Thumbnails) in.readValue((Thumbnails.class.getClassLoader())));
            instance.channelTitle = ((String) in.readValue((String.class.getClassLoader())));
            instance.liveBroadcastContent = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Snippet[] newArray(int size) {
            return (new Snippet[size]);
        }

    }
            ;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(publishedAt);
        dest.writeValue(channelId);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(thumbnails);
        dest.writeValue(channelTitle);
        dest.writeValue(liveBroadcastContent);
    }

    public int describeContents() {
        return  0;
    }

}
