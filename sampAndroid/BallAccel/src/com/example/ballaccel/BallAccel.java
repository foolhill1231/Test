package com.example.ballaccel;

import java.util.List;

import android.app.Activity;
import android.content.Context;
// import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.WindowManager;


public class BallAccel extends Activity
						implements SensorEventListener {

//	private static final int MENU_ID_ITEM1=Menu.FIRST;

	private SensorManager mSensorManager;
	private Sensor mAccelerometer;

//	private TickHandler tickHandler;
	private BallSurFaceView mSurFaceView;
	private float[] values = new float[2];

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSurFaceView = new BallSurFaceView(this);

        setContentView(mSurFaceView);

        // センサーマネージャのインスタンスを取得
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        // センサーの取得
        List<Sensor> list = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (list.size()>0) {
        	mAccelerometer = list.get(0);
        }

        // 画面のロックを防ぐ
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    @Override
    public void onResume() {
    	super.onResume();
    	if (mAccelerometer!=null) {
    		// SensorEventListenerを登録します
    		mSensorManager.registerListener(this, mAccelerometer,SensorManager.SENSOR_DELAY_GAME);
    	}
    }
    public void onStop() {
    	super.onStop();
		mSensorManager.unregisterListener(this);
    }

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		if (event.sensor.getType()!= Sensor.TYPE_ACCELEROMETER) {
			return;
		}

		values[0] = event.values[SensorManager.DATA_X];
		values[1] = event.values[SensorManager.DATA_Y];

		StringBuffer bufStr = new StringBuffer();

		bufStr.append("value[0]: meams X軸" + values[0] + "\n");
		bufStr.append("value[1]: meams Y軸" + values[1] + "\n");
		Log.v("Accel",bufStr.toString());

		mSurFaceView.drawBall((int)values[0],(int)values[1]);
	}

}