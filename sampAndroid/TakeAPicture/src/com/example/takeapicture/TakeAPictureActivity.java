package com.example.takeapicture;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class TakeAPictureActivity extends Activity {
	private LoudNess mLoudNess;
	private CameraView mCameraView;

	public short sVolume;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCameraView = new CameraView(this);

        setContentView(mCameraView);

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
					mCameraView.takeAPicture();

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