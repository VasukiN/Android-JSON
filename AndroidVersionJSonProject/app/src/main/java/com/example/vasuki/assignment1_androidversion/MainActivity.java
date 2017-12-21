package com.example.vasuki.assignment1_androidversion;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String URI="http://serviceapi.skholingua.com/open-feeds/list_multipletext_json.php";
    ArrayList<DataModel> dataModel;
    ListView listView;
    CustAdapter adapter;
    String name,version,api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataModel = new ArrayList<DataModel>();
        listView = (ListView) findViewById(R.id.versionlist);
        adapter = new CustAdapter(MainActivity.this, 0);
        new AsynTask().execute();

    }
    class CustAdapter extends ArrayAdapter {
        TextView name, type, versionNumber, feature;

        public CustAdapter(Context context, int resource) {
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
                convertView = inflater.inflate(R.layout.row_count, null);
                name = (TextView) convertView.findViewById(R.id.name);
                type = (TextView) convertView.findViewById((R.id.Version));
                versionNumber = (TextView) convertView.findViewById(R.id.apilevel);
                //feature = (TextView) convertView.findViewById(R.id.feature);
            }
            name.setText(dataModel.get(position).getName());
            type.setText(dataModel.get(position).getVersion());
            versionNumber.setText(dataModel.get(position).getApi());
            //feature.setText(dataModel.get(position).feature());
            return convertView;

        }
    }
    public  class  AsynTask extends AsyncTask {
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
                JSONArray array = obj.getJSONArray("Android Version List");
                for (int i=0;i<array.length();i++) {
                    JSONObject obj1 = array.getJSONObject(i);
                    name = obj1.getString("Version Name");
                    version =obj1.getString("Version No");
                    api =obj1.getString("API Level");
                    DataModel js1 = new DataModel(name,version, api);
                    dataModel.add(js1);
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
            listView.setAdapter(adapter);


        }
    }
}

