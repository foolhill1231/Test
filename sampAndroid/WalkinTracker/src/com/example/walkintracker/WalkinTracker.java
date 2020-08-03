package com.example.walkintracker;

import java.text.SimpleDateFormat;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WalkinTracker extends MapActivity
							implements LocationListener{

    private MapView mapView;
    private LocationManager lcMg;
    private PosOverlay pOverlay;
    private LineOverlay lOverlay;

    private Chronometer chrono;

    private long mStartTimeMillis;

    private double mKMeter;
    private boolean started =false;
    private boolean first = true;

    private String eltext=null;

    private static final int INTERVAL =20;
    public static final int MENU_LIST = Menu.FIRST;
    public static final int MENU_QUIT = Menu.FIRST + 1;

	// Database Helper
    private DatabaseHelper dbhelper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mapView =(MapView)findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        MapController mpc = mapView.getController();
        mpc.setZoom(19);

        lcMg = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

   	 	// 画像を地図上に配置するオーバーレイ
   	 	Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.kakasi);
   	 	pOverlay = new PosOverlay(bmp);
   	 	mapView.getOverlays().add(pOverlay);
   	 	lOverlay = new LineOverlay();
   	 	mapView.getOverlays().add(lOverlay);

        mapView.invalidate();

        startGPS();

        // DatabaseHelperの生成
   	 	dbhelper = new DatabaseHelper(this);

        ToggleButton tb = (ToggleButton) findViewById(R.id.ToggleButton);
        tb.setChecked(false);       //OFFへ変更

        //ToggleのCheckが変更したタイミングで呼び出されるリスナー
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //トグルキーが変更された際に呼び出される
                if (isChecked) {
                	reStartGPS(INTERVAL);
                	startChmeter();
                	started=true;
                	first=true;
                	mKMeter=0.0;
                	lOverlay.clearPoint();
                } else {
                	stopChmeter();
                	createDialog();
                	started=false;

                }
            }
        });
    }
    private void startGPS() {
    	lcMg.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 2, this);
    	// 前回実行で所得した場所
    	// getLastKnownLocation アプリケーションで取得した最後の位置情報を取り出す
    	Location location = lcMg.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    	if (location != null) {
            double lat = location.getLatitude();
            double lon = location.getLongitude();
            Log.v("Last Lat",":"+(int) (lat * 1E6));
            Log.v("LAst Lon",":"+(int) (lon * 1E6));
            setPosition(lat, lon);
    	}
    }
    private void reStartGPS(int intval) {
    	lcMg.removeUpdates(this);
    	// 距離にだけ反応するように設定。誤差はどれくらいだろか（？
    	lcMg.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, intval, this);
    	TextView disText = (TextView) findViewById(R.id.disText);
    	disText.setText("");
    }

    private void createDialog() {

    	new AlertDialog.Builder(this)
    	.setIcon(android.R.drawable.ic_menu_save)
    	.setTitle(getResources().getString(R.string.save))
    	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int whichButton) {
    	    	saveWalkin();
    	    }
    	})
    	.setNegativeButton("No", new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int whichButton) {
    	    }
    	})
    	.show();

    }
    private void saveWalkin(){
    	SQLiteDatabase db = dbhelper.getWritableDatabase();

    	String strDate = new SimpleDateFormat("yyyy/MM/dd").format(mStartTimeMillis);

		double dblDistance = mKMeter;

		TextView txtAddress = (TextView)findViewById(R.id.address);
		String strPlace = txtAddress.getText().toString();

		ContentValues values = new ContentValues();
		values.put("date", strDate);
		values.put("eltime", eltext);
		values.put("distance", dblDistance);
		values.put("place", strPlace);
		try {
			db.insert("walkin", null, values);
		} catch (Exception e) {
			Toast.makeText(this, "データの保存に失敗しました", Toast.LENGTH_SHORT).show();
		} finally {
			db.close();
		}
    }

    @Override
    public void onStop() {
    	super.onStop();
    	stopGPS();
    }
    private void startChmeter() {
        chrono = (Chronometer) findViewById(R.id.chronometer);
        				// 電源ON時からの経過時間の値をベースに
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.start();
    	mStartTimeMillis=System.currentTimeMillis();
    }
    private void stopChmeter() {
    	chrono.stop();
    	eltext=chrono.getText().toString();

    }
    private void stopGPS() {
    	lcMg.removeUpdates(this);
    }
	@Override
	protected boolean isRouteDisplayed() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public void onLocationChanged(Location location) {
		// TODO 自動生成されたメソッド・スタブ
        double lat = location.getLatitude();
        double lon = location.getLongitude();
        Log.v("Lat",":"+(int) (lat * 1E6));
        Log.v("Lon",":"+(int) (lon * 1E6));
        setPosition(lat, lon);

	}
    public void setPosition(double lat, double lon) {

        MapController mpc = mapView.getController();
        GeoPoint p = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));
        mpc.animateTo(p);

        // pOverlayの現在地更新
        pOverlay.setCurLocation(lat, lon);
        if (started) {
        	if (!first) {
	        	// アプリ起動後の最初の一回は捨てる　
	        	mKMeter+=INTERVAL * 0.001;
	        	TextView disText = (TextView) findViewById(R.id.disText);
	        	disText.setText(String.format("%.2f"+" km", mKMeter));
        	} else {
        		getAddress(lat, lon);
        		first =(!first);
        	}
        	// lOverlayにポイント追加
        	lOverlay.add(p);
        }
    }
    private void getAddress(double lat, double lon) {
    	new AddressTask(this).execute(lat, lon);
    }


    public void onProviderDisabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void onProviderEnabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO 自動生成されたメソッド・スタブ

	}
    private Menu myMenu;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        myMenu = menu;
        //	groupId,itemId,order,title
        myMenu.add(0,MENU_LIST,1,getResources().getString(R.string.list))
        	.setIcon( android.R.drawable.ic_menu_view);
        myMenu.add(0,MENU_QUIT,2,getResources().getString(R.string.quit))
        	.setIcon( android.R.drawable.ic_menu_close_clear_cancel);

        return true;
    }

    /**
     * Handles item selections
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_LIST:
        		Intent intent = new Intent(WalkinTracker.this, WalkinView.class);
              	startActivity(intent);
                return true;
            case MENU_QUIT:
            	stopGPS();
                finish();
                return true;
        }
        return false;
    }
}