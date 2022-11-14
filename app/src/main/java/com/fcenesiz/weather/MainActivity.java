package com.fcenesiz.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

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
        String text = editTextCityIdOrName.getText().toString();
        switch (view.getId()) {
            case R.id.btn_getCityId:
                service.getCityId(text, new Service.OnResponseCityIdListener() {
                    @Override
                    public void onResponse(String cityId) {
                        Toast.makeText(
                                MainActivity.this,
                                "cityId:" + cityId,
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(
                                MainActivity.this,
                                "error:" + message,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                });
                break;
            case R.id.btn_getWeatherByCityId:
                // daily forecast is paid, can not implemented!
                // for more information, visit api.openweathermap.org
                service.getWeatherByCity(QueryType.ID, text, new Service.OnResponseWeatherByCityListener() {
                    @Override
                    public void onResponse(List<WeatherModel> report) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                });
                break;
            case R.id.btn_getWeatherByCityName:
                // daily forecast is paid, can not implemented!
                // for more information, visit api.openweathermap.org
                service.getWeatherByCity(QueryType.NAME, text, new Service.OnResponseWeatherByCityListener() {
                    @Override
                    public void onResponse(List<WeatherModel> report) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                });
                break;
        }
    }

}