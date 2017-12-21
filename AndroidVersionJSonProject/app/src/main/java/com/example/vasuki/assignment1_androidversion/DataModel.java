package com.example.vasuki.assignment1_androidversion;

/**
 * Created by Vasuki on 12/9/2017.
 */

public class DataModel {
    String name;
    String version;
    String api;
    public DataModel(String name,String version,String api)
    {
        this.name=name;
        this.version=version;
        this.api=api;
    }
    public String getName(){return name;}
    public String getVersion(){return version;}
    public String getApi(){return api;}
}
