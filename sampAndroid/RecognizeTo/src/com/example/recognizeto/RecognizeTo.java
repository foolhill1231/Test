package com.example.recognizeto;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
//import android.widget.TextView;
import android.widget.Toast;

public class RecognizeTo extends Activity
	implements View.OnClickListener {
	    private static final int REQUEST_CODE = 0;
	    private Button	btnStart;
	    private Button	btnSend;
	    private EditText editTxt;
	    private ScrollView scView;
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

	        btnSend=new Button(this);
	        btnSend.setText("転送");
	        btnSend.setOnClickListener(this);
	        btnSend.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.FILL_PARENT,
	                LinearLayout.LayoutParams.WRAP_CONTENT));
	        layout.addView(btnSend);

	        scView=new ScrollView(this);
	        scView.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.FILL_PARENT,
	                LinearLayout.LayoutParams.WRAP_CONTENT));
	        layout.addView(scView);
	        editTxt=new EditText(this);
	        editTxt.setText("");
	        editTxt.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.FILL_PARENT,
	                LinearLayout.LayoutParams.WRAP_CONTENT));
	        scView.addView(editTxt);
	        //layout.addView(editTxt);

	    }
	    public void onClick(View v) {
	        if (v==btnStart) {

		        try {
		            // インテント作成
		            Intent intent = new Intent(
		            		// Web検索はACTION_WEB_SEARCH
		                    //RecognizerIntent.ACTION_WEB_SEARCH);
		                    RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		            intent.putExtra(
		                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
		                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		            intent.putExtra(
		                    RecognizerIntent.EXTRA_PROMPT,
		                    "音声認識");
		            intent.putExtra(
		                    RecognizerIntent.EXTRA_MAX_RESULTS ,1);

		            // インテント発行
		            startActivityForResult(intent, REQUEST_CODE);
		        } catch (ActivityNotFoundException e) {
		            // このインテントに応答できるアクティビティがインストールされていない場合
		            Toast.makeText(RecognizeTo.this,
		                e.getMessage(), Toast.LENGTH_LONG).show();
		        }
	        } else  if (v==btnSend) {
	            Intent intent = new Intent(Intent.ACTION_SEND);
	            intent.setType("text/plain");
	            intent.putExtra(Intent.EXTRA_TEXT, editTxt.getText().toString());
	            // toString()なしで，エディタやGmailには転送できるが，twiccaにはtoString()が必要。
	            // ないとnullになる。
	            startActivity(intent);
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
	            editTxt.setText(editTxt.getText() + resStr);

	        }

	        super.onActivityResult(requestCode, resultCode, data);
	    }


}