package com.example.vasuki.ownerinfojson;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        String URI ="http://serviceapi.skholingua.com/open-feeds/complex_json.php";
    ArrayList<DataModel> dataModel;
    ListView listView;
    CustomAdapter adapter;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataModel = new ArrayList<DataModel>();
        listView = (ListView) findViewById(R.id.list_item);
        textView1 =(TextView)findViewById(R.id.ownerName);
        textView2=(TextView) findViewById(R.id.DOB);
        textView3 =(TextView)findViewById(R.id.gender);
        textView4=(TextView)findViewById(R.id.website);
        adapter = new CustomAdapter(MainActivity.this, 0);
        new AsynTas().execute();


    }


    public class CustomAdapter extends ArrayAdapter {
        TextView content, webpage;


        public CustomAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return dataModel.size();
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                convertView = inflater.inflate(R.layout.row_items, null);
                content = (TextView) convertView.findViewById(R.id.content);
                webpage = (TextView) convertView.findViewById(R.id.webpage);
            }
            content.setText(dataModel.get(position).getConent());
            webpage.setText(dataModel.get(position).getWebpage());

            return convertView;
        }
    }

    public class AsynTas extends AsyncTask {
        ProgressDialog progressDialog;
        String name,dob,gender,website;
        @Override
        protected void onPreExecute() {
            progressDialog= new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String data = HttConnection.getData(URI);
            JSONObject jsonObject=null;

            try {
                jsonObject = new JSONObject(data);
                JSONObject jsonObject1= jsonObject.getJSONObject("Owner Info");
                 name = jsonObject1.getString("Name");
                 dob = jsonObject1.getString("DOB");
                 gender = jsonObject1.getString("Gender");
                 website = jsonObject.getString("Website");
                JSONArray jsonArray = jsonObject.getJSONArray("Content");
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                    String content=jsonObject2.getString("content");
                    String webpage = jsonObject2.getString("webpage");
                    DataModel ds = new DataModel(content,webpage);
                    dataModel.add(ds);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressDialog.dismiss();
            try {

                textView1.setText(name);
                textView2.setText(dob);
                textView3.setText(gender);
                textView4.setText(website);
                listView.setAdapter(adapter);

            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
