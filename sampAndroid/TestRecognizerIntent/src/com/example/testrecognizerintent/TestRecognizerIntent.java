package com.example.testrecognizerintent;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TestRecognizerIntent extends Activity
			implements View.OnClickListener {
    private static final int REQUEST_CODE = 0;
    private Button	btnStart;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        btnStart=new Button(this);
        btnStart.setText("開始");
        btnStart.setOnClickListener(this);
        btnStart.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(btnStart);

    }
    public void onClick(View v) {
        try {
            // インテント作成
            Intent intent = new Intent(
            		// Web検索はACTION_WEB_SEARCH
                    //RecognizerIntent.ACTION_WEB_SEARCH);
                    RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    //RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(
                    RecognizerIntent.EXTRA_PROMPT,
                    "音声認識");
            //intent.putExtra(
            //        RecognizerIntent.EXTRA_MAX_RESULTS ,
            //       1);
            // インテント発行
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            // このインテントに応答できるアクティビティがインストールされていない場合
            Toast.makeText(TestRecognizerIntent.this,
                    e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
 // アクティビティ終了時に呼び出される
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 自分が投げたインテントであれば応答する
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String resStr = "";

            // 結果文字列リスト
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);

            for (int i = 0; i< results.size(); i++) {
                // ここでは、文字列が複数あった場合に結合しています
                resStr += results.get(i);
            }

            // トーストを使って結果を表示
            Toast.makeText(this, resStr, Toast.LENGTH_LONG).show();
/*
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, resStr);
            startActivity(intent);
*/
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}