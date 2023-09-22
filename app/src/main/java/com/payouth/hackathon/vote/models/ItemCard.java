package com.payouth.hackathon.vote.models;

public class ItemCard {

    private String mTitle;
    private String mDescription;
    private String mThumbnailUrl;
    private String mSummaryText;

    private int mImageRecourse;

    public ItemCard(String mTitle, String mDescription, String mThumbnailUrl, String mSummaryText, int mImageRecourse) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mThumbnailUrl = mThumbnailUrl;
        this.mSummaryText = mSummaryText;
        this.mImageRecourse = mImageRecourse;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public String getSummaryText() {
        return mSummaryText;
    }

    public int getImageRecourse() {
        return mImageRecourse;
    }

}
