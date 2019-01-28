package com.wincest.animedb;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ApiConnector
{
    public JSONArray getAllAnimes()
    {
        JSONArray jsonArray = null;

        try
        {
            String link = "https://reptiloid-ice.000webhostapp.com/getAllAnimes.php";

            URL url = new URL(link);
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));

            HttpResponse response = httpClient.execute(request);
            jsonArray = new JSONArray(response.getEntity());

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return jsonArray;
    }
}
