package com.hfad.templateapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {
    List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ItemRecyclerViewAdapter itemRecyclerViewAdapter;
    private LinearLayoutManager layout;
    private int currentPage = 0, totalPage = 5;
    private boolean loading, lastPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = getListBook();

        recyclerView = findViewById(R.id.recyclerview_id);
        progressBar = findViewById(R.id.progress_bar_id);

        layout = new LinearLayoutManager(this);

        itemRecyclerViewAdapter = new ItemRecyclerViewAdapter(bookList);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_decoration));

        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(itemRecyclerViewAdapter);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.addOnScrollListener(new PaginationListener(layout) {
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPostion = layout.findLastVisibleItemPosition();
                if(isLastPage() || isLoading())
                    return;
                if(lastVisibleItemPostion+1 == (currentPage+1)*10)
                {
                    loadMorePage();
                }
            }
            @Override
            public void loadMorePage() {
                currentPage++;
                loading = true;
                progressBar.setVisibility(View.VISIBLE);
                getLoadMorePage();
            }

            @Override
            public boolean isLoading() {
                return loading;
            }

            @Override
            public boolean isLastPage() {
                return lastPage;
            }
        });
    }
    private List<Book> getListBook(){
        List<Book> list = new ArrayList<>();
        for(int i = 1; i <= 10; i++)
            list.add(new Book(String.format("Book %d", currentPage*10+i), R.drawable.sach1));
        return list;
    }
    private void getLoadMorePage()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bookList.addAll(getListBook());
                itemRecyclerViewAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                loading = false;
                if (currentPage == totalPage)
                {
                    lastPage = true;
                }
            }
        }, 2000);
    }
}