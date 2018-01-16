package com.example.musfiqrahman.waitlist;

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

    public GuestListAdapter(int mNumberItems) {
        this.mNumberItems = mNumberItems;
    }

    public NumberViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){

        LayoutInflater myInflater = LayoutInflater.from(parent.getContext());

        View thisItemsView = myInflater.inflate(R.layout.guest_item_list, parent, false);

        return new NumberViewHolder(thisItemsView);
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
        public NumberViewHolder(View itemView) {
            super(itemView);
            listNumberView = (TextView) itemView.findViewById(R.id.name_text_view);
        }

        void bind(int index){
            listNumberView.setText(index + "");
        }
    }


}
