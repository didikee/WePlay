package com.didikee.weplay.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.didikee.weplay.R;

public class ActRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_recycler_view);

        init();
    }

    private void init() {
        mRecyclerView = ((RecyclerView) findViewById(R.id.recyclerView));

    }
}
