package com.example.vasuki.ownerinfojson;

/**
 * Created by Vasuki on 12/10/2017.
 */

public class DataModel {
    public String conent;
    public String webpage;
    public DataModel(String conent,String webpage)
    {
        this.conent=conent;
        this.webpage=webpage;
    }
    public  String getConent(){return conent;}
    public String getWebpage(){return  webpage;}

}
