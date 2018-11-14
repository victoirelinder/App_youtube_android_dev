package com.example.victoirelinder.youtube_test_4;

import android.graphics.pdf.PdfDocument;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by victoirelinder on 17/03/2018.
 */

public class SearchResult implements Serializable, Parcelable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;
    @SerializedName("pageInfo")
    @Expose
    private PdfDocument.PageInfo pageInfo;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    public final static Parcelable.Creator<SearchResult> CREATOR = new Creator<SearchResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResult createFromParcel(Parcel in) {
            SearchResult instance = new SearchResult();
            instance.kind = ((String) in.readValue((String.class.getClassLoader())));
            instance.etag = ((String) in.readValue((String.class.getClassLoader())));
            instance.nextPageToken = ((String) in.readValue((String.class.getClassLoader())));
            instance.regionCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.pageInfo = ((PdfDocument.PageInfo) in.readValue((PdfDocument.PageInfo.class.getClassLoader())));
            in.readList(instance.items, (Item.class.getClassLoader()));
            return instance;
        }

        public SearchResult[] newArray(int size) {
            return (new SearchResult[size]);
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

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public PdfDocument.PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PdfDocument.PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeValue(etag);
        dest.writeValue(nextPageToken);
        dest.writeValue(regionCode);
        dest.writeValue(pageInfo);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
