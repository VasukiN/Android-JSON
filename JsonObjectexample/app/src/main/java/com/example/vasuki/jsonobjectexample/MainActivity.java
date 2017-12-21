package com.example.vasuki.jsonobjectexample;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String URI="http://serviceapi.skholingua.com/open-feeds/simple_json.php";
    String strJson;
    String name,version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         strJson = "{\"Stduent\": [{\"Name\":\"Bhavani\", \"Id\" : 13 ,\"Class\" :\"PUC ||\"}, { \"Name\":\"Raghu\", \"Id\" :14, \"Class\" :\"PUC ||\"} ]}";

    }
    public  void submit(View view)
    {
        new AsynTask().execute();
        try {
            JSONObject obj = new JSONObject(strJson);
            JSONArray array = obj.getJSONArray("Stduent");
            for (int i=0;i<array.length();i++)
            {
                JSONObject obj1=array.getJSONObject(i);
                String name =obj1.getString("Name");
                int id = obj1.getInt("Id");
                String cls = obj1.getString("Class");
                ArrayList<JSon> arrayList = new ArrayList<JSon>();
                JSon js1 = new JSon(name,id,cls);
                arrayList.add(js1);
                Log.e("Name",name);
                Log.e("id",id+"");
                Log.e("Class",cls);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public  class  AsynTask extends AsyncTask{
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading ..");
            progressDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String data = HttpConnection.getData(URI);
            JSONObject obj = null;

            try {

                obj = new JSONObject(data);
                 name = obj.getString("name");
                 version =obj.getString("version");


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressDialog.dismiss();
            Log.e("name",name);
            Log.e("version",version);

        }
    }

}

