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
    private Cursor cursor;

    public GuestListAdapter(int mNumberItems, Cursor cursor) {
        this.mNumberItems = mNumberItems;
        this.cursor = cursor;
    }

    public NumberViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){

        LayoutInflater myInflater = LayoutInflater.from(parent.getContext());

        View thisItemsView = myInflater.inflate(R.layout.guest_item_list, parent, false);



        return new NumberViewHolder(thisItemsView, cursor);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    private static final String TAG = GuestListAdapter.class.getSimpleName();


    class NumberViewHolder extends RecyclerView.ViewHolder{
        TextView listNumberView;
        TextView partySizeView;
        Cursor cursor;
        public NumberViewHolder(View itemView, Cursor cursor) {
            super(itemView);
            listNumberView = (TextView) itemView.findViewById(R.id.name_text_view);
            partySizeView = (TextView) itemView.findViewById(R.id.party_size_text_view);
            this.cursor = cursor;
        }

        void bind(int index){
            cursor.move(index);
            listNumberView.setText(cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_NAME)));
            partySizeView.setText(cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_PARTYSIZE)));
        }
    }


}
