package com.fcenesiz.weather;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;

import java.util.List;

public class Service {

    private static final String API_KEY = "ab52ec803d37e6ef4358282152bf33fa";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?";

    private Context ctx;

    public Service(Context ctx) {
        this.ctx = ctx;
    }

    public interface OnResponseCityIdListener {
        void onResponse(String cityId);
        void onError(String message);
    }

    public interface OnResponseWeatherByCityListener {
        void onResponse(List<WeatherModel> report);
        void onError(String message);
    }

    public void getCityId(String id, OnResponseCityIdListener listener) {

        String url = API_URL +
                "q=" + id +
                "&appid=" + API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    String cityId = "";
                    try {
                        cityId = response.get("id").toString();
                        listener.onResponse(cityId);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> listener.onError(error.getMessage())
        );

        RequestSingleton.getInstance(ctx).addToRequestQueue(request);
    }

    public void getWeatherByCity(QueryType queryType, String data, OnResponseWeatherByCityListener listener) {
        // daily forecast is paid, can not implemented!
        // for more information, visit api.openweathermap.org
    }

}
