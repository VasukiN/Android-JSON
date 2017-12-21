package com.example.vasuki.androidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Vasuki on 12/10/2017.
 */

 class HttConnection {
    public static String getData(String uri) {
        BufferedReader reader = null;
        HttpURLConnection httpURLConnection=null;
        try {
            URL url = new URL(uri);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setReadTimeout(1000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(1000);
            InputStream is = httpURLConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String data=null;
            String web="";
            while ((data=reader.readLine())!=null)
            {
                web += data +"\n";
            }
            return web;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return  null;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
        finally {
            if(reader!=null)
                try{

                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            httpURLConnection.disconnect();
        }

    }

}