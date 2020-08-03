package com.example.tabtest;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabTest extends TabActivity {
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
        tab1.setIndicator("タブページ１");
        tab1.setContent(R.id.content1);
        tabHost.addTab(tab1);

        // Tab2 設定
        TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("タブページ2");
        tab2.setContent(R.id.content2);
        tabHost.addTab(tab2);

        // 初期表示設定
        //tabHost.setCurrentTab(0);
        tabHost.setCurrentTabByTag("tab1");
    }
}