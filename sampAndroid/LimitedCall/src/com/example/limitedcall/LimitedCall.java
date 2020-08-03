package com.example.limitedcall;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LimitedCall extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // レイアウトの作成
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        // テキストビューの作成
        TextView txtView=new TextView(this);
        txtView.setText("0766-26-1850");
        txtView.setTextSize(30.0f);
        //txtView.setTextColor(Color.rgb(0,0,0));
        txtView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        layout.addView(txtView);

        // ボタンの生成
        Button btn=new Button(this);
        btn.setText("このボタンを押すと電話をかける");
        btn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Uri uri = Uri.parse("tel:0766261850");
        		Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        		//Intent intent = new Intent(Intent.ACTION_CALL,uri);
              	startActivity(intent);
        	}
        });

        btn.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(btn);
    }
}