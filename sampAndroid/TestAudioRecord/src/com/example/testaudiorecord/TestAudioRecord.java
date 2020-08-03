package com.example.testaudiorecord;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TestAudioRecord extends Activity
		implements View.OnClickListener {

	private LoudNess mLoudNess;

	private Handler mHandler = new Handler();
	public short sVolume;

	private Button	btnStart;
	private Button	btnEnd;
    private TextView txtView;
    private ScrollView scView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        btnStart=new Button(this);
        btnStart.setText("音量感知の開始");
        btnStart.setOnClickListener(this);
        btnStart.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(btnStart);

        btnEnd=new Button(this);
        btnEnd.setText("音量感知の 終了");
        btnEnd.setOnClickListener(this);
        btnEnd.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(btnEnd);

        scView=new ScrollView(this);
        scView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(scView);
        txtView=new TextView(this);
        txtView.setText("");
        txtView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        scView.addView(txtView);

    }

	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
        if (v==btnStart) {
        	startRecord();

        } else  if (v==btnEnd) {
        	if (mLoudNess != null) {
        		mLoudNess.stop();
        	}
        }
	}
	private void startRecord() {

		mLoudNess = new LoudNess();
		mLoudNess.setOnReachedVolumeListener(
			new	LoudNess.OnReachedVolumeListener() {
				// public void onReachedVolume(final short volume,final int size) {
				public void onReachedVolume(final short volume) {
					// TODO 自動生成されたメソッド・スタブ
					mHandler.post(new Runnable() {
						public void run() {
							//sVolume=volume;
							appendTextView(volume);
						}
					});
				}
			});
		new Thread(mLoudNess).start();
	}
	private void appendTextView(short volume) {
		txtView.append("Value:" + volume + "\n");
	}
}