package com.exanple.sensorlist;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorList extends Activity
		implements SensorEventListener {
    private TextView txtView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        txtView=new TextView(this);
        txtView.setText("取得結果をここに表示します");
        txtView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(txtView);

        StringBuffer strBuff = new StringBuffer();
        //int targetSensorType = Sensor.TYPE_ALL;
        SensorManager mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> list = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : list) {
        		// このサンプルではregisterListenerは必須ではない
        		// だから，implements SensorEventListener
               	if (mSensorManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_UI)) {
                    strBuff.append(sensor.getName());
                    strBuff.append(" ");
                    strBuff.append(sensor.getVendor());
                    strBuff.append(" ");
                    strBuff.append(sensor.getResolution());
                    strBuff.append(" ");
                    strBuff.append(sensor.getPower());
                    strBuff.append("\n");
               	}
        }
        txtView.setText(strBuff.toString());
    }

	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}
}