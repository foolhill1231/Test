package com.example.connectnxt;

// このファイルを追加

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MotorView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
	private SurfaceHolder mHolder;
    private Thread	thread;

    private int mLeftPower = 0; // -100 ～ 100
    private int mRightPower = 0;	// -100 ～ 100
    private float mCenterX =0.0f;
    private float mCenterY =0.0f;

	private ConnectNXT mActivity;
	private SensorManager mSensorManager;

    // 引数二つのコンストラクタ
    public MotorView(Context context, ConnectNXT uiActivity) {
		super(context);

		mActivity=uiActivity;

		// サーフェイスフォルダの取得
        mHolder = getHolder();
        // サーフェイスイベントの通知先の指定（自身のクラス）
        mHolder.addCallback(this);
        mHolder.setFixedSize(getWidth(), getHeight());

        mSensorManager = (SensorManager) mActivity.getSystemService(Context.SENSOR_SERVICE);
	}
	public void registerListener() {
        // センサーの取得
		List<Sensor> sensorList;
		// register orientation sensor
		sensorList = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
		mSensorManager.registerListener(mSensorAccelerometer, sensorList.get(0), SensorManager.SENSOR_DELAY_GAME);
	}
	public void unregisterListener() {
		mSensorManager.unregisterListener(mSensorAccelerometer);

	}
	private float[] values = new float[2];
	private final SensorEventListener mSensorAccelerometer = new SensorEventListener() {

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub

		}

		public void onSensorChanged(SensorEvent event) {
			values[0] = event.values[SensorManager.DATA_X];
			values[1] = event.values[SensorManager.DATA_Y];
		}

	};

	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

        Log.v("SurfaceView","Width"+getWidth());		// 480
        Log.v("SurfaceView","Height"+getHeight());		// 778

        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;
        thread = new Thread(this);
        thread.start();


	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
		thread = null;
	}
	// スレッドの処理
	public void run() {
		Canvas canvas;
	    Paint paintLine = new Paint();
	    paintLine.setColor(Color.LTGRAY);

	    Paint paintRect = new Paint();
	    paintRect.setColor(Color.RED);

	    float margin = 80.0f;
	    float padding = 40.0f;
	    float rectWidth = 70.0f;

		while (thread!=null) {
	        try {
	        	Thread.sleep(100);
	        } catch (Exception e) {
	        }

	        if (mActivity.isConnected()){
	        	calcPower();
	        	canvas = getHolder().lockCanvas();

				canvas.drawColor(Color.BLACK);
		        // 基準線を描画する
		        canvas.drawLine(margin, mCenterY,getWidth() - margin , mCenterY,paintLine);

		        // モータのパワーを矩形で表現
		        paintRect.setStyle(Paint.Style.FILL);
		        canvas.drawRect(mCenterX - (rectWidth + padding), mCenterY - (mLeftPower * 3),
		        				mCenterX - padding, mCenterY, paintRect);
		        // canvas.drawRect(x1,y1,x2,y2)
		        canvas.drawRect(mCenterX + padding, mCenterY - (mRightPower * 3),
		        				mCenterX + (padding + rectWidth), mCenterY, paintRect);

		        getHolder().unlockCanvasAndPost(canvas);

		        mActivity.updateMotorControl(mLeftPower, mRightPower);
	        }
		}
	}

	private void calcPower() {
		float powerLeft = -1 * values[SensorManager.DATA_Y] ;
		float powerRight = -1 * values[SensorManager.DATA_Y] ;

		if (values[SensorManager.DATA_X]  > 0 ) {
			if (powerLeft > 0 ) {
				powerLeft -= values[SensorManager.DATA_X];
			} else {
				powerRight -= values[SensorManager.DATA_X];
			}
		} else {
			if (powerRight > 0) {
				powerRight += values[SensorManager.DATA_X];
			} else {
				powerLeft += values[SensorManager.DATA_X];
			}
		}

		powerLeft *= 10;
		powerRight *= 10;

		mLeftPower= (int)powerLeft;
		mRightPower= (int)powerRight;
		if (mLeftPower > 100) {
			mLeftPower=100;
		} else if (mLeftPower < -100) {
			mLeftPower= -100;
		}
		if (mRightPower > 100) {
			mRightPower=100;
		} else if (mRightPower < -100) {
			mRightPower= -100;
		}
		Log.v("mLeftPower","mLeftPower" + mLeftPower + "\n");
		Log.v("mRightPower","mRightPower" + mRightPower + "\n");
	}

}
