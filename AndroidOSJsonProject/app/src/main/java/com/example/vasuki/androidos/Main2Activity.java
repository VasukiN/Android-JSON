package com.example.vasuki.androidos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    String URI = "http://serviceapi.skholingua.com/open-feeds/simplelist_json.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public class asyntask extends AsyncTask
    {

        @Override
        protected Object doInBackground(Object[] objects) {
            String data = HttConnection.getData(URI);

            return null;
        }
    }
}
