package com.example.nevertouchmeservice;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Environment;
import android.util.Log;

public class VoicePlayer implements OnCompletionListener {
	private MediaPlayer mPlayer;
	private String mFilePath;

	public VoicePlayer() {
        mPlayer = new MediaPlayer();
        // Listenerの登録必要です
        mPlayer.setOnCompletionListener(this);
		// SDカードのディレクトリ
		mFilePath = Environment.getExternalStorageDirectory().toString()
    				+ "/RecordVoice/testVoice.3gp";

	}
	public void play() {
        try {
            mPlayer.setDataSource(mFilePath);
            // 準備して
            mPlayer.prepare();
            // 再生スタート！
            mPlayer.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	public void onCompletion(MediaPlayer paraPlayer) {
		// TODO 自動生成されたメソッド・スタブ
        mPlayer.stop();
        //mPlayer.reset();
        //mPlayer.setOnCompletionListener(null);
        mPlayer.release();
        //mPlayer=null;
        Log.v("VoicePlayer", "onCompletion is Called");

	}

}
