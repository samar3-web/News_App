package com.samar.newsapp;

import com.samar.newsapp.models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {

    void onFetchData(List<NewsHeadlines> list, String message);
    void  onError(String message);
}

