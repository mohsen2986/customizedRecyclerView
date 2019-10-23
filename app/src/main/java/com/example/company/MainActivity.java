package com.example.company;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "DDAATTAA";
    private RecyclerView recycler;
    private List<Item> datas =  new ArrayList<>();
    private RecyclerAdapter adapter = new RecyclerAdapter();
    private RecyclerListener recyclerListener;
    private PageInfo pages = new PageInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        provideData();
        initRecycler();
    }
    private void initUi(){
        recycler = findViewById(R.id.ac_main_recycler);
    }
    private void initRecycler(){
        recycler.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        adapter.addItem(datas);
        recycler.setAdapter(adapter);
        recycler.addOnItemTouchListener(new RecyclerViewTouchListener(recycler, this, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Toast.makeText(MainActivity.this, "the item "+ position, Toast.LENGTH_SHORT).show();
            }
        }));
        recyclerListener = new RecyclerListener(new OnLoadMore() {
            @Override
            public Boolean isLoading() {return pages.isLoading();}

            @Override
            public Boolean isLastPage() {return pages.isLastPage();}

            @Override
            public void loadMore() {
                if (!isLoading()){
                    pages.setLoading(true);
                    callApi();
                }
            }
        });
        recycler.addOnScrollListener(recyclerListener);
    }
    private void provideData(){
        Item item = new Item();
        item.name = "mohsen";
        for (int i = 0; i < 40; i++) {
            datas.add(item);
        }

    }
    private void callApi(){
        pages.setCurrentPage((pages.getCurrentPage())+1);
        /*
        *calling api to get datas
        * must set this steps
        * if(pages.currentPage() != pages.Companion.getPAGE_NUMBER() )
        *   recyclerAdapter.removeLoading();
        * recyclerAdapter.addItem(response.body().getItems())
        * if(pages.currentPage < pages.totalPages )
        *   recyclerAdapter.addLoading()
        * else
        *   pages.isLastPage = true
        *
        * pages.isLoading = true
        * pages.currentPage++; -> kotlin // pages.setCurrentPage((pages.getCurrentPage()+1)
        *
        * */
    }
}
