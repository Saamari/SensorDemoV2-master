package com.example.kaupp.sensordemo;

import android.app.Service;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class accelerationActivity extends AppCompatActivity implements SensorEventListener {
    TextView textView;
    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleration);


        textView = (TextView) findViewById(R.id.acceleration);

        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener((SensorEventListener) this,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }


    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){

            textView.setText("X   "+ sensorEvent.values[0]+ "Y   " + sensorEvent.values[1] + "Z     " + sensorEvent.values[2]);
        }
    }


    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

