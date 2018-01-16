package com.example.musfiqrahman.waitlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_GUESTS = 100;

    GuestListAdapter mAdapter;

    RecyclerView mGuestList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGuestList = (RecyclerView) findViewById(R.id.all_guest_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mGuestList.setLayoutManager(layoutManager);

        mGuestList.setHasFixedSize(true);

        mAdapter = new GuestListAdapter(NUM_GUESTS);

        mGuestList.setAdapter(mAdapter);


    }

    public void addToWaitlist(View view) {
    }
}
