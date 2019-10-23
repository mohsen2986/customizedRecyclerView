package com.example.company;

public interface  OnLoadMore {
    Boolean isLoading();
    Boolean isLastPage();
    void loadMore();
}
