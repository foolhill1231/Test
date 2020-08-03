package com.example.walkintracker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class PosOverlay extends Overlay {
	private final Bitmap bmp;

	private double mCurLat;
	private double mCurLon;

	public PosOverlay(Bitmap bitmap){
		bmp=bitmap;
	}
	// 緯度，経度を設定する
	public void setCurLocation(double lat,double lon) {
		mCurLat = lat;
		mCurLon = lon;
	}
	@Override
	public void draw(Canvas canvas, MapView view, boolean shadow) {
		super.draw(canvas, view, shadow);

		if (shadow==false) {
			// GeoPoint作成
	        GeoPoint p = new GeoPoint((int) (mCurLat * 1E6), (int) (mCurLon* 1E6));
	        // Projection
	        Projection projection = view.getProjection();
	        // 描画位置
	        Point point = new Point();
	        // 描画位置の変換
	        projection.toPixels(p, point);
	        // pointをx1,y1としてbitmapを描こうとするので調整する
	        canvas.drawBitmap(bmp,point.x-bmp.getWidth()/2,point.y-bmp.getHeight()/2,null);
		}
	}
}
