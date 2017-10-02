/*
 *Class Name: Counter
 *
 *Version: Version1.0
 *
 * Date: October,1, 2017
 *
 * Copyright (c) xinrui7, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditionsof the Code of Students Behavior at University of Alberta.
 */

package com.example.xinrui7_countbook;

import java.util.Date;

/**
 * Created by Al on 2017-09-30.
 */

/**
 * Repersents a Counter
 * a counter class which include all the properties of counter, include getters and setters
 */

public class Counter {
    private String name;
    private Date date;
    private Integer c_value;
    private Integer i_value;
    private String comment;

    /**
     *
     * @param name
     * @param date
     * @param c_value
     * @param i_value
     * @param comment
     */
    public Counter(String name, Date date, int c_value, int i_value, String comment){
        this.name = name;
        this.date = date;

        this.c_value = c_value;
        this.i_value = i_value;
        this.comment = comment;


    }

    /**
     *
     * @return name
     */
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @return date
     */
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    /**
     *
     * @return c_value current value
     */
    public Integer getC_value(){
        return c_value;

    }
    public void setC_value(int c_value){
        this.c_value = c_value;
    }

    /**
     *
     * @return i_value initial value
     */
    public Integer getI_value(){
        return i_value;

    }
    public void setI_value(int i_value){
        this.i_value = i_value;
    }

    /**
     *
     * @return comment
     */
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }

    /**
     * set decrease value by 1, increase value by 1,and reset value
     */
    public void increC_value(){
        this.c_value += 1;
    }
    public void decreC_value(){
        this.c_value -= 1;
    }
    public void resetC_value(){
        this.c_value = i_value;
    }



}
