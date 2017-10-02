/**
 * Class Name: MainActivity
 *
 *Version: Version1.0
 *
 * Date: October,1, 2017
 *
 * Copyright (c) xinrui7, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditionsof the Code of Students Behavior at University of Alberta.
 */

package com.example.xinrui7_countbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;

import static com.example.xinrui7_countbook.R.id.counterlist;

/**
 * Represent MainActivity
 *
 */

public class MainActivity extends AppCompatActivity {

    private CounterList clist = new CounterList();

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //clist load from file
        //press button to add a new counter
        Button add =(Button)findViewById(R.id.add);
        //a text view that shows the number of counters that exist
        TextView summary = (TextView)findViewById(R.id.summary);
        clist.load(MainActivity.this);
        summary.setText("Total number of counter:" + String.valueOf(clist.getCounterlist().size()));
        //ListView lv = (ListView)findViewById(R.id.counterlist);
        //clist.load(MainActivity.this);
        populate();




        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, NewCounterActivity.class);
                startActivity(intent);
            }
        });

    }


    private void populate(){
        Date ddd = new Date();
        clist.load(MainActivity.this);
        final TextView summary = (TextView)findViewById(R.id.summary);
        //String[] mystrings = {"dhfhjsdhf","sgdjahsgdhasd","sgdjhasgdasd"};
        ListView lv = (ListView)findViewById(counterlist);
        final CounterAdapter adapter = new CounterAdapter(MainActivity.this, clist);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> adapterView, View view, int position_val, long l) {

                                          Intent intent = new Intent(MainActivity.this, EditCounter.class);
                                          intent.putExtra("position", position_val);
                                          startActivity(intent);

                                      }
                                  }


        );

        /**
         * long click a counter pop out a alert dialog that could increase value, decrease value and reset value
         */
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int pos, long id) {
                // TODO Auto-generated method stub

                AlertDialog.Builder ValueChangeAlert = new AlertDialog.Builder(MainActivity.this);
                ValueChangeAlert.setMessage("Press plus to add one,press minus to decrease one,press reset to rest. to cancel press back");
                //set plus one button
                ValueChangeAlert.setPositiveButton("+1", new DialogInterface.OnClickListener() {
                    /**
                     *
                     * @param dialogInterface
                     * @param i
                     */
                    @Override

                    public void onClick(DialogInterface dialogInterface, int i) {
                        clist.getCounterlist().get(pos).increC_value();
                        //save
                        clist.save(MainActivity.this);
                        adapter.notifyDataSetChanged();
                        dialogInterface.dismiss();
                    }
                });
                //set reset button

                ValueChangeAlert.setNeutralButton("reset", new DialogInterface.OnClickListener() {
                    /**
                     *
                     * @param dialogInterface
                     * @param i
                     */
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        clist.getCounterlist().get(pos).resetC_value();
                        clist.save(MainActivity.this);
                        adapter.notifyDataSetChanged();
                        dialogInterface.dismiss();
                    }
                });
                //set minus one button
                ValueChangeAlert.setNegativeButton("-1", new DialogInterface.OnClickListener() {
                    /**
                     *
                     * @param dialogInterface
                     * @param i
                     */
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        clist.getCounterlist().get(pos).decreC_value();
                        //save
                        clist.save(MainActivity.this);
                        adapter.notifyDataSetChanged();
                        dialogInterface.dismiss();
                    }
                });
                ValueChangeAlert.show();

                return true;
            }
        });


    }
}
