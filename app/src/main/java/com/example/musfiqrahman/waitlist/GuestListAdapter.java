package com.example.musfiqrahman.waitlist;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by musfiqrahman on 2018-01-09.
 */

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.NumberViewHolder>  {

    private int mNumberItems;

    public GuestListAdapter(int mNumberItems, Cursor cursor) {
        this.mNumberItems = mNumberItems;
    }

    public NumberViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){

        LayoutInflater myInflater = LayoutInflater.from(parent.getContext());

        View thisItemsView = myInflater.inflate(R.layout.guest_item_list, parent, false);



        return new NumberViewHolder(thisItemsView);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
    try {
        Cursor cursor = MainActivity.myDB.getAllRows();
        cursor.move(position);
        String name = cursor.getString(cursor.getColumnIndex(MainActivity.myDB.KEY_NAME));
        int partySize = cursor.getInt(cursor.getColumnIndex(MainActivity.myDB.KEY_PARTYSIZE));
        holder.bind(name, partySize);
    }catch(Exception e){
        e.printStackTrace();
    }

    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    private static final String TAG = GuestListAdapter.class.getSimpleName();


    class NumberViewHolder extends RecyclerView.ViewHolder{
        TextView listNumberView;
        TextView partyTextView;
        public NumberViewHolder(View itemView) {
            super(itemView);
            listNumberView = (TextView) itemView.findViewById(R.id.name_text_view);
            partyTextView = (TextView) itemView.findViewById(R.id.party_size_text_view);
        }

        void bind(String str, int size){
            listNumberView.setText(str);
            partyTextView.setText(size + "");
        }
    }


}
