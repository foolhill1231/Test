package com.example.walkintracker;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;

import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.Projection;

public class LineOverlay extends Overlay {
	private Paint linePaint;
    private List<GeoPoint> points;

    public LineOverlay() {

            this.points = new ArrayList<GeoPoint>();

            this.linePaint = new Paint();
            linePaint.setColor(Color.RED);
            linePaint.setStrokeWidth(2.0f);
            linePaint.setDither(true);
            linePaint.setStyle(Style.FILL);		// FILL:塗りつぶし
            linePaint.setAntiAlias(true);		//アンチエイリアス　
            //linePaint.setStrokeJoin(Paint.Join.ROUND);		// つなぎ目を丸く
            //linePaint.setStrokeCap(Paint.Cap.ROUND);		// 端点を丸く
    }

    public void add(GeoPoint p){
            points.add(p);
    }
    public void clearPoint() {
    	points.clear();
    }
    @Override
    public void draw(Canvas canvas, MapView view, boolean shadow){
    		super.draw(canvas, view, shadow);

            if(points.size() < 2) return;
            Point pFrom = new Point();
            Point pTo = new Point();
	        // Projection
	        Projection projection = view.getProjection();
            for(int i = 0; i < points.size()-1; i++){
            		projection.toPixels(points.get(i), pFrom);
            		projection.toPixels(points.get(i+1), pTo);
                    canvas.drawLine(pFrom.x, pFrom.y, pTo.x, pTo.y, linePaint);
            }
    }
    /*
    public int size(){
            return points.size();
    }
    public List<GeoPoint> getPoints(){
            return this.points;
    }
    */
}
