package com.example.vasuki.firstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_display);
        ListView lv = (ListView)findViewById(R.id.listview);
        String[] ArrayObject = {"Moto","Iphone","Lava","one+One","MI","Vievo"};
        ArrayAdapter adapter = new ArrayAdapter<String>(ViewDisplay.this,android.R.layout.simple_list_item_1,ArrayObject);
        lv.setAdapter(adapter);
    }
}
