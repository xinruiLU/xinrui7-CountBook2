/*
 *Class Name: CounterList
 *
 *Version: Version1.0
 *
 * Date: October,1, 2017
 *
 * Copyright (c) xinrui7, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditionsof the Code of Students Behavior at University of Alberta.
 */

package com.example.xinrui7_countbook;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Al on 2017-09-30.
 */

/**
 * Represent CounterList
 * a list that shows name,date and value of all the existing counters
 */

public class CounterList {
    ArrayList<Counter> counterlist = new ArrayList<>();
    private static final String FILENAME = "file.sav";//save all data in a file to prevent data lost

    public CounterList(){
        this.counterlist = new ArrayList<Counter>();
    }

    /**
     *
     * @return counterlist
     */
    public ArrayList<Counter> getCounterlist(){
        return counterlist;
    }

    /**
     *
     * @param c add counters
     */
    public void addCounter(Counter c){
        counterlist.add(c);
    }

    /**
     *
     * @param i remove counters from counter list use its index
     */
    public void remove(int i){
        counterlist.remove(i);

    }

    /**
     * edit counter and set the value to new values
     *
     * @param i
     * @param name
     * @param c_value
     * @param i_value
     * @param comment
     */
    public void editCounter(int i, String name, int c_value, int i_value, String comment ){
        Date date = new Date();
        Counter tmp_counter = new Counter(name, date, c_value, i_value, comment);
        counterlist.set(i,tmp_counter );
    }



    //todo save and load methods

    /**
     *
     * @param context
     */
    public void save(Context context){
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,
                    0);
            OutputStreamWriter writer= new OutputStreamWriter(fos);
            Gson gson =new Gson();
            gson.toJson(this.counterlist, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param context
     */
    public void load(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Counter>>() {
            }.getType();
            counterlist = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            counterlist = new ArrayList<Counter>();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);


        }
    }
}
