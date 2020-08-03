package com.example.graphicloudness;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class GraphicLoudActivity extends Activity {

	private LoudNess mLoudNess;
	private LoudSurFaceView mSurFaceView;
	//private TestSurFaceView mSurFaceView;

	//private Handler mHandler = new Handler();
	public short sVolume;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSurFaceView = new LoudSurFaceView(this);

        setContentView(mSurFaceView);

        // 画面のロックを防ぐ
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    @Override
    public void onResume() {
    	super.onResume();
		mLoudNess = new LoudNess();
		mLoudNess.setOnReachedVolumeListener(
			new	LoudNess.OnReachedVolumeListener() {
				public void onReachedVolume(final short volume) {
					// TODO 自動生成されたメソッド・スタブ
					//（訂正後）SurFaceViewはマルチスレッド対応だから
					mSurFaceView.drawCircle(volume);
				}
			});
		new Thread(mLoudNess).start();

	}
    @Override
    public void onStop() {
    	super.onStop();
    	mLoudNess.stop();
    }
}