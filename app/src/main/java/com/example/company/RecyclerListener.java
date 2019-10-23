package com.example.company;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerListener extends RecyclerView.OnScrollListener {
    // the minimum of items below ur current position before loading more!
    private int visibleThreshold = 0;
    private OnLoadMore loadMore;
    //
    public RecyclerListener(OnLoadMore loadMore){
        this.loadMore = loadMore;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        LinearLayoutManager layoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
        int totalItems = layoutManager.getItemCount();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();
        int scrolledItem = layoutManager.getChildCount();
        if (!loadMore.isLoading() && !loadMore.isLastPage())
            if ((lastVisiblePosition + scrolledItem + visibleThreshold) > totalItems)
                loadMore.loadMore();
    }
}
