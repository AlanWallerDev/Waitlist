package com.example.musfiqrahman.waitlist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    public static DBAdapter myDB;

    private static int NUM_GUESTS = 0;

    GuestListAdapter mAdapter;

    RecyclerView mGuestList;
    TextView nameView;
    TextView sizeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGuestList = (RecyclerView) findViewById(R.id.all_guest_list_view);
        myDB = new DBAdapter(this);
        myDB.open();
        Cursor cursor = myDB.getAllRows();
        if(cursor.moveToFirst()) cursor.moveToFirst();
        try {
            do {
                NUM_GUESTS++;
                String n = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_NAME));
                int size = cursor.getInt(cursor.getColumnIndex(DBAdapter.KEY_PARTYSIZE));
                GuestInfo g = new GuestInfo(n, size);
                updateGuests(g);
            } while (cursor.moveToNext());
        }catch(Exception e){
            e.printStackTrace();
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mGuestList.setLayoutManager(layoutManager);

        mGuestList.setHasFixedSize(true);

        mAdapter = new GuestListAdapter(NUM_GUESTS, cursor);

        mGuestList.setAdapter(mAdapter);


        nameView = (TextView) findViewById(R.id.guest_name);
        sizeView = (TextView) findViewById(R.id.num_of_guest);





    }

    public void addToWaitlist(View view) {
        int partySize = Integer.parseInt(sizeView.getText().toString());
        String partyName = nameView.getText().toString();
        myDB.insertRow(partyName, partySize);

        Cursor cursor = myDB.getAllRows();
        if(cursor.moveToFirst())
            cursor.moveToFirst();
        do{
            String n = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_NAME));
            int size = cursor.getInt(cursor.getColumnIndex(DBAdapter.KEY_PARTYSIZE));
        }while(cursor.moveToNext());

        finish();
        startActivity(getIntent());

    }

    public void updateGuests(GuestInfo guest){

    }
}
