package com.example.pingpongaccel;



import android.app.TabActivity;

import android.os.Bundle;
//import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class PingPong extends TabActivity {

    private SwingListener mSwingListener;
    private int mExcellent;
    private int mGood;
    private int mNoGood;

    // Xperiaのとき，3
    //private static final int DIV_KEISU = 3;
    // Xperia acro,Xperia arcのとき，5
    private static final int DIV_KEISU = 5;


	//private Handler mHandler = new Handler();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // TabHostオブジェクト取得
        TabHost tabHost = getTabHost();

        // Tab1 設定
        TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("スイング");
        tab1.setContent(R.id.content1);
        tabHost.addTab(tab1);

        // Tab2 設定
        TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("トータル");
        tab2.setContent(R.id.content2);
        tabHost.addTab(tab2);

        // 初期表示設定
        tabHost.setCurrentTab(0);

        // SwingListenerのインスタンスを作って
        mSwingListener = new SwingListener(this);
        // リスナーをセット
        mSwingListener.setOnSwingListener(new SwingListener.OnSwingListener() {
            // スイングを検知するとonSwingメソッドが呼び出されます。
            public void onSwing(final float speed) {
				// TODO 自動生成されたメソッド・スタブ
                int avg = (int)speed / DIV_KEISU;

	            TextView txtView =
	                 (TextView)findViewById(R.id.content1).findViewById(R.id.txtView);
	    		txtView.append("スイングスピード: " + avg + "\n");
	    		if (avg > 99) {
	    			mExcellent++;
	    		}
	    		else if (avg > 79) {
	    			mGood++;
	    		}
	    		else {
	    			mNoGood++;
	    		}
	    		txtView = (TextView)findViewById(R.id.content2).findViewById(R.id.txtView1);
	    		txtView.setText(String.valueOf(mExcellent));
	            txtView = (TextView)findViewById(R.id.content2).findViewById(R.id.txtView2);
	    		txtView.setText(String.valueOf(mGood));
	            txtView = (TextView)findViewById(R.id.content2).findViewById(R.id.txtView3);
	    		txtView.setText(""+mNoGood);

            }
        });

    }
    public void btnStartClick(View view) {
        TextView txtView =
            (TextView)findViewById(R.id.content1).findViewById(R.id.txtView);
		txtView.setText("");

		txtView = (TextView)findViewById(R.id.content2).findViewById(R.id.txtView1);
		txtView.setText("0");
        txtView = (TextView)findViewById(R.id.content2).findViewById(R.id.txtView2);
		txtView.setText("0");
        txtView = (TextView)findViewById(R.id.content2).findViewById(R.id.txtView3);
		txtView.setText("0");

		mExcellent=0;
	    mGood=0;
	    mNoGood=0;

    	mSwingListener.registSensor();

    }
    public void btnEndClick(View view) {
    	mSwingListener.unregistSensor();
    	mSwingListener=null;
    	finish();
    }

}