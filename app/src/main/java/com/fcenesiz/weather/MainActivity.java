package com.fcenesiz.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_getCityId:
                Toast.makeText(
                        MainActivity.this,
                        "You clicked me 1!",
                        Toast.LENGTH_SHORT
                ).show();
                break;
            case R.id.btn_getWeatherByCityId:
                Toast.makeText(
                        MainActivity.this,
                        "You clicked me 2!",
                        Toast.LENGTH_SHORT
                ).show();
                break;
            case R.id.btn_getWeatherByCityName:
                Toast.makeText(
                        MainActivity.this,
                        "You clicked me 3!",
                        Toast.LENGTH_SHORT
                ).show();
                break;
        }
    }
}