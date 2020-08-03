package com.example.usemapgps;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.location.LocationManager;
import android.os.Bundle;

public class UseMapGps extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final MapView mapview =(MapView)findViewById(R.id.mapview);
        //mv.setEnabled(true);
        //mv.setClickable(true);	// 地図を移動（パン）させることができる
        							// XMLかコードのいずれかで指定すればよい

        mapview.setBuiltInZoomControls(true);	// コードで表示するしかない


        MapController mpc = mapview.getController();
        mpc.setZoom(19);
        final MyLocationOverlay mloverlay =
            new MyLocationOverlay(getApplicationContext(), mapview);
        mloverlay.onProviderEnabled(LocationManager.GPS_PROVIDER); // GPS を使用する
        mloverlay.enableMyLocation();
        //mloverlay.enableCompass();	// コンパスを表示
        mloverlay.runOnFirstFix(new Runnable() {
            public void run() {
            	mapview.getController().animateTo(
                    mloverlay.getMyLocation()); // 現在位置を自動追尾する
            }
        });
        mapview.getOverlays().add(mloverlay);
        mapview.invalidate();
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}