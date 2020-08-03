package com.example.takeapicture;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;


public class LoudNess implements Runnable {
	private OnReachedVolumeListener mListener;

	private boolean isRecording = true;
	// Xperia(2.1-update1)	8000Hz
	//private static final int SAMPLE_RATE = 8000;
	private static final int SAMPLE_RATE = 44100;
	// Xperia(2.1-update1)	1000 when 8000Hz
	//private short mShootVolume = 1000;
	// Xperia(2.1-update1)	1000 when 44100Hz
	//private short mShootVolume = 10000;
	// Xperia arc
	//private short mShootVolume = 5000;
	// Xperia acro
	private short mShootVolume = 20000;



	public void stop() {
		if (isRecording==true) {
			isRecording=false;
		}

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
			if (max > mShootVolume) {
				if (mListener !=null) {
					mListener.onReachedVolume(max);
					isRecording=false;
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		audioRecord.stop();
		audioRecord.release();
	}
	public interface OnReachedVolumeListener {
		// 音量がボーダーを超えたときに呼び出されるメソッド
		void onReachedVolume(short volume);

	}
	// OnReachedVolumeListenerをセット
	public void setOnReachedVolumeListener(
			OnReachedVolumeListener listener) {
		mListener = listener;
	}

}
