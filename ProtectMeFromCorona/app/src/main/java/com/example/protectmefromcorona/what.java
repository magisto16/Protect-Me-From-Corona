package com.example.protectmefromcorona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class what extends AppCompatActivity {

    RecyclerView recyclerView;

    List<whatDetail> descList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what);

        recyclerView = findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        whatAdapter whatAdapter = new whatAdapter(descList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(whatAdapter);
    }

    private void initData() {

        descList = new ArrayList<>();
        descList.add(new whatDetail(getString(R.string.title1), (getString(R.string.desc1))));
        descList.add(new whatDetail(getString(R.string.title2), (getString(R.string.desc2))));
        descList.add(new whatDetail(getString(R.string.title3), (getString(R.string.desc3))));
    }

}
