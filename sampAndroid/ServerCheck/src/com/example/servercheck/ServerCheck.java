package com.example.servercheck;

//import java.io.InputStream;

import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
//import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

//import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ServerCheck extends Activity
	implements View.OnClickListener {
    private static final int MENU_ID_ITEM1=Menu.FIRST;
    private static final int MENU_ID_ITEM2=Menu.FIRST + 1;

    private static final String DEF_HTTP="http://";

    private EditText edit01;
    private EditText edit02;
    private EditText edit03;
    private TextView txtView;
    private Button	btnConnect;

    private ScrollView scView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        edit01=new EditText(this);
        edit01.setText("");
        edit01.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(edit01);

        edit02=new EditText(this);
        edit02.setText("");
        edit02.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(edit02);

        edit03=new EditText(this);
        edit03.setText("");
        edit03.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(edit03);

        btnConnect=new Button(this);
        btnConnect.setText("接続");
        btnConnect.setOnClickListener(this);
        btnConnect.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(btnConnect);

        scView=new ScrollView(this);
        scView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(scView);

        txtView=new TextView(this);
        txtView.setText("接続結果をここに表示します");
        txtView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        scView.addView(txtView);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item1=menu.add(Menu.NONE, MENU_ID_ITEM1, Menu.NONE, "設定削除");
        item1.setIcon(android.R.drawable.ic_menu_delete);
        MenuItem item2=menu.add(Menu.NONE, MENU_ID_ITEM2, Menu.NONE, "終了");
        item2.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ID_ITEM1:
	            SharedPreferences prefer=getPreferences(MODE_WORLD_READABLE);
	            SharedPreferences.Editor editor=prefer.edit();
	            editor.clear();
	            editor.commit();
	        	getPrefer();
                return true;
            case MENU_ID_ITEM2:
            	//Activity終了
                finish();
                return true;
        }
        return true;
    }

    public void onClick(View v) {
    	String retStr="";
        if (!(DEF_HTTP.equals(edit01.getText().toString()))) {
        	retStr=doGet(edit01.getText().toString());
            txtView.setText(edit01.getText().toString() + " " + retStr);
        }

        if (!(DEF_HTTP.equals(edit02.getText().toString()))) {
        	retStr=doGet(edit02.getText().toString());
            txtView.setText(txtView.getText().toString() + "\n" + edit02.getText().toString()
            		+ " "  + retStr);
        }
        if (!(DEF_HTTP.equals(edit03.getText().toString()))) {
        	retStr=doGet(edit03.getText().toString());
            txtView.setText(txtView.getText().toString() + "\n" + edit03.getText().toString()
            		+ " " + retStr);
        }
   }
    public String doGet(String url)
    {
        try
        {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet method = new HttpGet(url);

            HttpResponse response = client.execute(method);
            int status = response.getStatusLine().getStatusCode();
            return "Status:" +status;

            //return  EntityUtils.toString( response.getEntity(),"UTF-8" );
        }
        catch ( Exception e )
        {
            return "Error:" + e.getMessage();
        }
    }

    @Override
    public void onResume() {
    	super.onResume();
    	// プリファレンスの読込
    	getPrefer();
    }
    @Override
    public void onPause() {
    	super.onPause();
    	// プリファレンスの保存
        SharedPreferences prefer=getPreferences(MODE_WORLD_READABLE);
        SharedPreferences.Editor editor=prefer.edit();
        editor.putString("server1",edit01.getText().toString());
        editor.putString("server2",edit02.getText().toString());
        editor.putString("server3",edit03.getText().toString());
        editor.commit();
    }
    private void getPrefer(){
        SharedPreferences prefer=getPreferences(MODE_WORLD_READABLE);
        edit01.setText(prefer.getString("server1",DEF_HTTP));
        edit02.setText(prefer.getString("server2",DEF_HTTP));
        edit03.setText(prefer.getString("server3",DEF_HTTP));
    }
}