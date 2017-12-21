package com.example.vasuki.androidos;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    String URI = "http://serviceapi.skholingua.com/open-feeds/simplelist_json.php";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
//        ArrayList<String> stringArray = new ArrayList<String>();
//        JSONArray jsonArray = new JSONArray();
//        for (int i = 0; i < jsonArray.length(); i++) {
//            try {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                stringArray.add(jsonObject.toString());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray);
     new Asyntas().execute();


    }


    public class Asyntas extends AsyncTask {
        ProgressDialog progressDialog;
        String data;
        ArrayList<String> stringArray = new ArrayList<String>();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading . .");
            progressDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            data = HttConnection.getData(URI);

            JSONObject jsonObject = null;
            String name;

            try {
                jsonObject = new JSONObject(data);
                JSONArray jsonArray = jsonObject.getJSONArray("Android_OS");
                for (int i = 0; i < jsonArray.length(); i++) {
                    //JSONObject jsonObject2 = jsonArray.getJSONObject(i);
//                    String eclair = jsonObject2.getString("Eclair");
//                    String froyo = jsonObject2.getString("Froyo");
//                    String gingerbread = jsonObject2.getString("Gingerbread");
//                    String honeyComb = jsonObject2.getString("HoneyComb");
//                    String icecreamSandwich = jsonObject2.getString("Ice-cream Sandwich");
//                    String jellyBean = jsonObject2.getString("JellyBean");
//                    String kitKat = jsonObject2.getString("KitKat");
//                    String lolliPop = jsonObject2.getString("LolliPop");

                    String names=jsonArray.get(i).toString();
                    Log.e("Names",""+names);
                    stringArray.add(names);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            ArrayAdapter<String> adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringArray);
            progressDialog.dismiss();
            listView.setAdapter(adapter);

        }
    }
}
