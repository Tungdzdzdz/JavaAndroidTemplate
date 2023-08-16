package com.hfad.templateapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationListener extends RecyclerView.OnScrollListener {
    private LinearLayoutManager layout;
    public PaginationListener(LinearLayoutManager layout)
    {
        this.layout = layout;
    }
    public abstract void loadMorePage();
    public abstract boolean isLoading();
    public abstract boolean isLastPage();
}
