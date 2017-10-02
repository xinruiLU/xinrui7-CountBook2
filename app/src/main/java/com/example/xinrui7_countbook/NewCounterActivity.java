/*
 *Class Name: NewCounterActivity
 *
 *Version: Version1.0
 *
 * Date: October,1, 2017
 *
 * Copyright (c) xinrui7, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditionsof the Code of Students Behavior at University of Alberta.
 */

package com.example.xinrui7_countbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * Represent NewCounterActivity
 * actions when user add a new counter
 */

public class NewCounterActivity extends AppCompatActivity {
    CounterList clist = new CounterList();
    EditText name;
    EditText c_value;
    EditText i_value;
    EditText comment;
    Date d;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_counter);

        final Button create = (Button)findViewById(R.id.create);
        name = (EditText)findViewById(R.id.Name);
        c_value = (EditText)findViewById(R.id.c_value);
        i_value = (EditText)findViewById(R.id.i_value);
        comment = (EditText)findViewById(R.id.comment);
        clist.load(NewCounterActivity.this);



        create.setOnClickListener(new View.OnClickListener() {
            /**
             *
             *
             * @param v
             */
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //delete from arraylist
                d = new Date();
                Counter tmp = new Counter(name.getText().toString(), d, Integer.parseInt(c_value.getText().toString()),
                        Integer.parseInt(i_value.getText().toString()),
                        comment.getText().toString());

                clist.addCounter(tmp);
                clist.save(NewCounterActivity.this);
                Toast.makeText(getApplicationContext(), name.getText().toString() +
                        " has been added!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(NewCounterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
