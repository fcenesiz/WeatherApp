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

    Service service;
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

        service = new Service(this);
    }

    @Override
    public void onClick(View view) {
        String data = editTextCityIdOrName.getText().toString();
        switch (view.getId()) {
            case R.id.btn_getCityId:
                service.getCityId(data);
                break;
            case R.id.btn_getWeatherByCityId:
                service.getWeatherBy(QueryType.ID, data);
                break;
            case R.id.btn_getWeatherByCityName:
                service.getWeatherBy(QueryType.NAME, data);
                break;
        }
    }

}