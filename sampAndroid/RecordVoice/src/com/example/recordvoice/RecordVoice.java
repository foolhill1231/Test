package com.example.recordvoice;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

public class RecordVoice extends Activity {
    private MediaRecorder mRecorder;

    private TextView txtView;
    private boolean isRecording = false;

   // private final static String dirName = "RecordVoice";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtView = (TextView)findViewById(R.id.txtView01);
    }
    // Startボタンが押されたら呼び出される
    public void onClickStartButton(View view) {
        if (isRecording) return;

        txtView.setText("録音中...");

        // SDカードのディレクトリ
        File dir = Environment.getExternalStorageDirectory();
        // アプリ名で
        File appDir = new File(dir, "RecordVoice");
        // ディレクトリを作る
        if (!appDir.exists()) appDir.mkdir();
        // ファイル名
        //String name = dirName + System.currentTimeMillis() + ".3gp";
        String name = "testVoice" + ".3gp";
        // 出力ファイルのパス
        String path = new File(appDir, name).getAbsolutePath();

        mRecorder = new MediaRecorder();
        // 入力ソースにマイクを指定
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        // 出力フォーマットに3gpを指定
        mRecorder.setOutputFormat(
                MediaRecorder.OutputFormat.THREE_GPP);
        // 音声エンコーダにAMRを指定
        //mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        // AMR_NBとDEFAULTとの違いは
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        // 出力ファイルのパスを指定
        mRecorder.setOutputFile(path);
        try {
            // 準備して
            mRecorder.prepare();
            // 録音スタート！
            mRecorder.start();
            isRecording = true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Stopボタンが押されたら呼び出される
    public void onClickStopButton(View view) {
        if (!isRecording) return;

        txtView.setText("録音しました");

        // 録音を停止して
        mRecorder.stop();
        mRecorder.reset();
        // 解放
        mRecorder.release();
        isRecording = false;
    }

}