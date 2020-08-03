package com.example.nevertouchmeservice;

import java.util.List;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Vibrator;

public class NeverTouchService extends Service
								implements SensorEventListener {
	// センサーマネージャ
	private SensorManager mSensorManager;
	private Sensor mProximity;

	private  float mPreValue=1;
	@Override
	public void onCreate() {
		super.onCreate();
        // センサーマネージャのインスタンスを取得
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        // センサーの取得
        List<Sensor> list = mSensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if (list.size()>0) {
        	mProximity = list.get(0);
        }
    	mSensorManager.registerListener(this, mProximity,SensorManager.SENSOR_DELAY_UI);
    	showNotification();


	}
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		//showNotification();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mSensorManager.unregisterListener(this);
        NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nManager.cancel(R.string.app_name);


	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}
	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		if (event.sensor.getType()!= Sensor.TYPE_PROXIMITY) {
			return;
		}
		if (event.values[0] < mPreValue) {
			vibrate();
			voice();
		}
		mPreValue = event.values[0];

	}
	private void vibrate () {
    	Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    	long[] pattern = {1000, 1000, 1000, 1000}; // OFF/ON/OFF/ON...
    	vibrator.vibrate(pattern, -1);
	}

	private void voice () {
    	VoicePlayer vplayer = new VoicePlayer();
    	vplayer.play();

	}
	private void showNotification() {
        NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        notification = new Notification(R.drawable.icon, "NeverTouchMeサービスを起動します",
                System.currentTimeMillis());
        notification.flags = Notification.FLAG_ONGOING_EVENT;

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
        						// タップしたときに呼ばれるActivity
                new Intent(this,NeverTouchActivity.class),Intent.FLAG_ACTIVITY_NEW_TASK);
        notification.setLatestEventInfo(this, getString(R.string.app_name),
                "NeverTouchMeサービスを開始しました", contentIntent);
        nManager.notify(R.string.app_name, notification);
	}
}
