package com.example.testaudiorecord;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

public class LoudNess implements Runnable {

	private OnReachedVolumeListener mListener;

	private boolean isRecording = true;
	// Xperia(2.1-update1)	8000Hz
	//private static final int SAMPLE_RATE = 8000;
	private static final int SAMPLE_RATE = 44100;
	// Xperia(2.1-update1)	500 when 8000Hz
	//private short mBorderVolume = 500;
	// Xperia arc(2.3.2)
	//private short mBorderVolume = 2000;
	// Xperia acro(2.3.3)
	private short mBorderVolume = 5000;

	public void stop() {
		isRecording=false;
	}

	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_URGENT_AUDIO);

		int bufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE,
				AudioFormat.CHANNEL_IN_MONO,
				AudioFormat.ENCODING_PCM_16BIT);
		AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
				SAMPLE_RATE,
				AudioFormat.CHANNEL_IN_MONO,
				AudioFormat.ENCODING_PCM_16BIT, bufferSize);
		short[] buffer = new short[bufferSize];
		audioRecord.startRecording();
		while(isRecording){
            audioRecord.read(buffer, 0, bufferSize);
            short max = 0;
			for (int i=0; i <bufferSize; i++) {
				max = (short)Math.max(max,buffer[i]);
			}
			if (max > mBorderVolume) {
				if (mListener !=null) {
					mListener.onReachedVolume(max);
					//mListener.onReachedVolume(max,bufferSize);
					//break;
				}
			}
			// 少し間隔を開ける
			try {
				Thread.sleep(100);		// 100じゃないといけない。
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		// 停止
		audioRecord.stop();
		// 解放
		audioRecord.release();
	}

	public interface OnReachedVolumeListener {
		// 音量がボーダーを超えたときに呼び出されるメソッド
		void onReachedVolume(short volume);

	}
	public void setOnReachedVolumeListener(
			OnReachedVolumeListener listener) {
		mListener = listener;
	}
}
