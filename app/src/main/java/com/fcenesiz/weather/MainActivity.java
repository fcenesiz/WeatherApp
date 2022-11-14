package com.fcenesiz.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String API_KEY = "ab52ec803d37e6ef4358282152bf33fa";
    private enum QueryType{ ID, NAME }
    Button btnGetCityId;
    Button btnUseCityId;
    Button btnUseCityName;
    EditText editTextCityIdOrName;
    ListView listViewWeatherReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign views
        btnGetCityId = findViewById(R.id.btn_getCityId);
        btnUseCityId = findViewById(R.id.btn_getWeatherByCityId);
        btnUseCityName = findViewById(R.id.btn_getWeatherByCityName);

        editTextCityIdOrName = findViewById(R.id.editText_cityIdOrName);
        listViewWeatherReport = findViewById(R.id.listView_weatherReport);

        // set listeners
        btnGetCityId.setOnClickListener(this);
        btnUseCityId.setOnClickListener(this);
        btnUseCityName.setOnClickListener(this);

    }

    private void getCityId() {

        String url = "https://api.openweathermap.org/data/2.5/" +
                "weather?q=" + editTextCityIdOrName.getText().toString() +
                "&appid=" + API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        Toast.makeText(MainActivity.this, response.get("id").toString(), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
        );

        RequestSingleton.getInstance(this).addToRequestQueue(request);
    }

    private void getWeatherBy(QueryType queryType, String data){

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
                "weather?"+ query +"=" + editTextCityIdOrName.getText().toString() +
                "&appid=" + API_KEY;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    Toast.makeText(
                            MainActivity.this,
                            response,
                            Toast.LENGTH_SHORT
                    ).show();
                },
                error -> {
                    //Toast.makeText(
                    //        MainActivity.this,
                    //        error.getMessage(),
                    //        Toast.LENGTH_SHORT
                    //).show();
                }
        );

        RequestSingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_getCityId:
                this.getCityId();
                break;
            case R.id.btn_getWeatherByCityId:
                this.getWeatherBy(QueryType.ID, editTextCityIdOrName.getText().toString());
                break;
            case R.id.btn_getWeatherByCityName:
                this.getWeatherBy(QueryType.NAME, editTextCityIdOrName.getText().toString());
                break;
        }
    }
}