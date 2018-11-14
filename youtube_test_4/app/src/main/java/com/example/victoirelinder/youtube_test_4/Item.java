package com.example.victoirelinder.youtube_test_4;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by victoirelinder on 17/03/2018.
 */

public class Item implements Serializable, Parcelable  //  classe serialisable car implemente l'interface java.io.Serializable
{

    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("etag")
    @Expose
    public String etag;  // Si la ressource à une URL donnée change, une nouvelle valeur Etag doit être générée.
    @SerializedName("id")
    @Expose
    public Id id;
    @SerializedName("snippet")   // additional text that's displayed below the title.
    @Expose
    public Snippet snippet;
    public final static Parcelable.Creator<Item> CREATOR = new Creator<Item>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Item createFromParcel(Parcel in) {
            Item instance = new Item();
            instance.kind = ((String) in.readValue((String.class.getClassLoader())));
            instance.etag = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((Id) in.readValue((Id.class.getClassLoader())));
            instance.snippet = ((Snippet) in.readValue((Snippet.class.getClassLoader())));
            return instance;
        }

        public Item[] newArray(int size) {
            return (new Item[size]);
        }

    }
            ;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public void writeToParcel(Parcel dest, int flags) { // écrire l'objet dans un Parcel
        dest.writeValue(kind);
        dest.writeValue(etag);
        dest.writeValue(id);
        dest.writeValue(snippet);
    }

    public int describeContents() {
        return  0;
    }

}
