/**
 * Class Name: EditCounter
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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * Repersent EditCounter
 * change the values of an existing counter, save the new values in file and load new value to main activity page
 */

public class EditCounter extends AppCompatActivity {
    private CounterList c_list = new CounterList();
    EditText e_name;
    EditText eC_value;
    EditText eI_value;
    EditText eComment;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_counter);
        c_list.load(EditCounter.this);
        //load CounterList from file
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        final Integer position = (int)extras.get("position");


        final Button delete = (Button)findViewById(R.id.delete);
        final Button save = (Button)findViewById(R.id.save);
        e_name = (EditText)findViewById(R.id.e_name);
        eC_value = (EditText)findViewById(R.id.eC_value);
        eI_value = (EditText)findViewById(R.id.eI_value);
        eComment = (EditText)findViewById(R.id.eComment);
        /**
         * get properties of the counter and display them use setText
         */
        e_name.setText(c_list.getCounterlist().get(position).getName().toString());
        eC_value.setText(c_list.getCounterlist().get(position).getC_value().toString());
        eI_value.setText(c_list.getCounterlist().get(position).getI_value().toString());
        eComment.setText(c_list.getCounterlist().get(position).getComment().toString());
        /**
         * set delete OnClickListener
         * jump to MainActivity and load new data that without the counter that has been deleted
         */
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //delete from arraylist
                c_list.remove(position);
                //save to file
                Toast.makeText(getApplicationContext(), e_name.getText().toString() +
                        " has been deleted!", Toast.LENGTH_SHORT).show();
                c_list.save(EditCounter.this);
                Intent intent = new Intent(EditCounter.this, MainActivity.class);
                startActivity(intent);
            }
        });
        /**
         * set save OnClickListener
         * jump to MainActivity and load new data
         */
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //save from arraylist
                //
                Date d = new Date();

                c_list.getCounterlist().get(position).setName(e_name.getText().toString());
                c_list.getCounterlist().get(position).setC_value(Integer.parseInt(eC_value.getText().toString()));
                c_list.getCounterlist().get(position).setComment(eComment.getText().toString());
                c_list.getCounterlist().get(position).setI_value(Integer.parseInt(eI_value.getText().toString()));
                c_list.getCounterlist().get(position).setDate(d);

                Toast.makeText(getApplicationContext(), e_name.getText().toString() +
                        " has been edit!", Toast.LENGTH_SHORT).show();
                c_list.save(EditCounter.this);
                Intent intent = new Intent(EditCounter.this, MainActivity.class);
                startActivity(intent);
            }
        });

        e_name.addTextChangedListener(new TextWatcher() {
            /**
             *
             * @param s
             * @param start
             * @param count
             * @param after
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            /**
             *
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                save.setEnabled(!e_name.getText().toString().trim().isEmpty());
            }

            /**
             *
             * @param s
             */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
