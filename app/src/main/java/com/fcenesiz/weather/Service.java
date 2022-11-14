package com.fcenesiz.weather;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;

public class Service {

    private static final String API_KEY = "ab52ec803d37e6ef4358282152bf33fa";
    private Context ctx;

    public Service(Context ctx) {
        this.ctx = ctx;
    }

    public void getCityId(String id) {

        String url = "https://api.openweathermap.org/data/2.5/" +
                "weather?q=" + id +
                "&appid=" + API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        Toast.makeText(ctx, response.get("id").toString(), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(ctx, error.toString(), Toast.LENGTH_SHORT).show();
                }
        );

        RequestSingleton.getInstance(ctx).addToRequestQueue(request);
    }

    public void getWeatherBy(QueryType queryType, String data){

        String query = "";
        switch (queryType){
            case ID:
                query = "id";
                break;
            case NAME:
                query = "q";
                break;
        }

        String url = "https://api.openweathermap.org/data/2.5/" +
                "weather?"+ query +"=" + data +
                "&appid=" + API_KEY;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    Toast.makeText(
                            ctx,
                            response,
                            Toast.LENGTH_SHORT
                    ).show();
                },
                error -> {
                    //Toast.makeText(
                    //        ctx,
                    //        error.getMessage(),
                    //        Toast.LENGTH_SHORT
                    //).show();
                }
        );

        RequestSingleton.getInstance(ctx).addToRequestQueue(stringRequest);
    }

}
