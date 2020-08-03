package com.example.testaccelerometer;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TestAccelerometer extends Activity
							implements SensorEventListener {
    private ScrollView scView;
    private TextView txtView;
	// センサーマネージャ
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private float[] nValues = new float[3];
	private float[] oValues = new float[3];
	private TickHandler tickHandler;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
/*
        scView=new ScrollView(this);
        scView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(scView);
*/
        txtView=new TextView(this);
        txtView.setText("");
        txtView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        //scView.addView(txtView);
        layout.addView(txtView);
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
    		mSensorManager.registerListener(this, mAccelerometer,SensorManager.SENSOR_DELAY_UI);
    	}
        //定期処理ハンドラの生成と実行
        tickHandler=new TickHandler();
        tickHandler.sleep(0);
    }
    public void onStop() {
    	super.onStop();
		mSensorManager.unregisterListener(this);
		//定期処理ハンドラの停止
		tickHandler=null;
    }

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ

		if (event.sensor.getType()!= Sensor.TYPE_ACCELEROMETER) {
			return;
		}
		oValues[0] = nValues[0];
		oValues[1] = nValues[1];
		oValues[2] = nValues[2];
		nValues[0] = event.values[SensorManager.DATA_X];
		nValues[1] = event.values[SensorManager.DATA_Y];
		nValues[2] = event.values[SensorManager.DATA_Z];
	}
	public class TickHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			StringBuffer bufStr = new StringBuffer();

			bufStr.append("新 value[0]: meams X軸" + nValues[0] + "\n");
			bufStr.append("新 value[1]: meams Y軸" + nValues[1] + "\n");
			bufStr.append("新 value[2]: meams Z軸" + nValues[2] + "\n");
			bufStr.append("=================================\n");
			bufStr.append("旧 value[0]: meams X軸" + oValues[0] + "\n");
			bufStr.append("旧 value[1]: meams Y軸" + oValues[1] + "\n");
			bufStr.append("旧 value[2]: meams Z軸" + oValues[2] + "\n");

	    	txtView.setText(bufStr.toString());
	    	if (tickHandler!=null) tickHandler.sleep(2000);
		}
		public void sleep(long delayMills) {
			removeMessages(0);	//使用済みのメッセージの削除
			/*
			 * obtainMessageはグローバル・メッセージ・プールにある
			 * インスタンスを使用することを指示する
			 */
			sendMessageDelayed(obtainMessage(0),delayMills);
		}
	}

}