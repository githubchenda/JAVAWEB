package com.example.testone.demo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")

public class Job implements Serializable {

    private String name;
    private String number;
    private String date;


    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }


    public String getNumber(){
        return number;
    }


    public void setNumber(String number){
        this.number =number;
    }


    public String getDate(){
        return date;
    }


    public void setDate(String date){
        this.date =date;
    }



}
