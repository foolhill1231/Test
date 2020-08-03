package com.example.pingpongaccel;

import java.util.List;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class SwingListener
				implements SensorEventListener {
    private SensorManager mSensorManager;
    private OnSwingListener mListener;
	private Sensor mAccelerometer;

    private long mPreTime;
	private float[] nValues = new float[3];
	private float[] oValues = {0.0f,0.0f,0.0f};

    private float mSumSpeed=0;
    private int mSwingCount=0;

    private static final int LI_SWING = 50;		// 速度
    private static final int CNT_SWING = 5;		// スイングの長さ（移動距離）

	// コンストラクタ
	public SwingListener(Context context) {
        // SensorManagerのインスタンスを取得
        mSensorManager = (SensorManager)context.getSystemService(
                                              Context.SENSOR_SERVICE);
    }
    public interface OnSwingListener {
        void onSwing(float speed);
    }

    // OnSwingListenerをセット
    public void setOnSwingListener(OnSwingListener listener) {
        mListener = listener;
    }
    public void registSensor() {
        // 加速度センサーを取得
        List<Sensor> list = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        // 取得できなければ何もしない
        if (list.size()>0) {
        	mAccelerometer = list.get(0);
        }
        // 加速度センサーにリスナーを登録
    	if (mAccelerometer!=null) {
    		// SensorEventListenerを登録します
    		mSensorManager.registerListener(this, mAccelerometer,SensorManager.SENSOR_DELAY_GAME);
    	}
    }
    public void unregistSensor() {
    	if (mAccelerometer!=null) {
    		mSensorManager.unregisterListener(this);
    	}
    }

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ
        // センサーのタイプが加速度センサーじゃなかったら何もしない
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER) {
            return;
        }

        long curTime = System.currentTimeMillis();	// ミリ秒
        long diffTime = curTime - mPreTime;
        // 物凄い頻度でイベントが発生するので
        // 100msに1回計算するように間引く
        if (diffTime > 100) {
            // 現在の値をとって
        	nValues[0] = event.values[SensorManager.DATA_X];
        	nValues[1] = event.values[SensorManager.DATA_Y];
        	nValues[2] = event.values[SensorManager.DATA_Z];
            // 前回の値との差からスピードを計算
            float speed = (Math.abs(nValues[0] - oValues[0]) + Math.abs(nValues[1] - oValues[1])
            		+ Math.abs(nValues[2] - oValues[2])) / diffTime * 1000;

            // スピードがLI_SWING以上なら，スイングが始まった
            if (speed > LI_SWING) {
                // スイングカウントをインクリメント
            	mSwingCount++;
            	mSumSpeed +=speed;
                // 5回連続スピードがLI_SWING以上ならスイング
                if (mSwingCount > CNT_SWING) {
                    // リスナーがセットされていれば
                    if (mListener != null) {
                        // onShakeメソッドを呼び出す
                        // デバッグ出力
                        Log.v("listener","Sum speed:"+ mSumSpeed);
                        Log.v("listener","count:"+ mSwingCount);
                        mListener.onSwing(mSumSpeed /mSwingCount);
                    }
                    mSwingCount = 0;
                    mSumSpeed = 0;
                }
            } else {
                // スピードがNG_SWING以下ならリセット
                mSwingCount = 0;
                mSumSpeed = 0;

            }
            // 前回値として保存
            mPreTime = curTime;
            oValues[0]=nValues[0];
            oValues[1]=nValues[1];
            oValues[2]=nValues[2];
        }
	}
}
