/*
 *Class Name: CounterAdapter
 *
 *Version: Version1.0
 *
 * Date: October,1, 2017
 *
 * Copyright (c) xinrui7, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditionsof the Code of Students Behavior at University of Alberta.
 */


package com.example.xinrui7_countbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Al on 2017-10-01.
 */

/**
 * Repersent  CounterAdapter
 */
public class CounterAdapter extends BaseAdapter {

    CounterList clist;
    Context context;
    static LayoutInflater inflater = null;

    /**
     *
     * @param context
     * @param clist counterlist
     */
    public CounterAdapter(Context context, CounterList clist){
        this.clist = clist;
        this.context = context;

    }

    /**
     *
     * @return clist.getCounterlist().size() number of counters
     */
    @Override
    public int getCount(){

        return clist.getCounterlist().size();

    }

    /**
     *
     * @param position
     * @return getItemId(position) use position to get the id of that item
     */
     @Override
    public Object getItem(int position){


         return getItemId(position);
     }

    /**
     * return the position of that counter
     *
     * @param position
     * @return position
     */
    @Override
    public long getItemId(int position){
        return position;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return row  a counter in the counter list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;

        if(row == null){

            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item, null);


        }
        TextView name = (TextView)row.findViewById(R.id.Name);
        name.setText("Counter Name:" + clist.getCounterlist().get(position).getName());


        TextView cval = (TextView)row.findViewById(R.id.cValue);
        cval.setText("Current Value:" + clist.getCounterlist().get(position).getC_value().toString());
        TextView date = (TextView)row.findViewById(R.id.Date);
        date.setText("Date:" + clist.getCounterlist().get(position).getDate().toString());
        //android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss a", new java.util.Date());

        return row;
    }

    /**
     *
     * @param position
     * @return true
     */
    @Override
    public boolean isEnabled(int position) {
        //Set a Toast or Log over here to check.
        return true;
    }

}
