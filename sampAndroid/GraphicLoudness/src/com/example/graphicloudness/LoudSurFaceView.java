package com.example.graphicloudness;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LoudSurFaceView extends SurfaceView
		implements SurfaceHolder.Callback  {
    private int mCircleX =0;
    private int mCircleY =0;
    private double mRatio =0;

    private SurfaceHolder mHolder;
    private Canvas mCanvas =null;
    private Paint mPaint = null;

	//private Thread mThread;

	public LoudSurFaceView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ

		// サーフェイスフォルダの取得
        mHolder = getHolder();
        // サーフェイスイベントの通知先の指定（自身のクラス）
        mHolder.addCallback(this);

        mHolder.setFixedSize(getWidth(), getHeight());

	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
        mCanvas = holder.lockCanvas();
        mCanvas.drawColor(Color.BLACK);
        holder.unlockCanvasAndPost(mCanvas);

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);

        Log.v("SurfaceView","Width"+getWidth());
        Log.v("SurfaceView","Height"+getHeight());

        mCircleX = getWidth() / 2;
        mCircleY = getHeight() / 2;
        		 // doubleを返す
        mRatio = Math.min(getWidth(),getHeight()) / 20000.0;
        Log.v("SurfaceView","mCircleX:"+mCircleX);
        Log.v("SurfaceView","mCircleY:"+mCircleY);
        Log.v("SurfaceView","mRatio:"+mRatio);

		//mThread= new Thread(this);
		//mThread.start();
        //short vol=30000;
        //this.drawCircle(vol);
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
		//mThread=null;

	}
	public void drawCircle(short vol) {
        try {
        	mCanvas = getHolder().lockCanvas();
	        //mCanvas.drawColor(Color.RED);
		  	//mCanvas.drawColor(Color.DKGRAY);

	        // 円を描画する
        	//mCanvas.drawCircle(mCircleX, mCircleY, (float) (vol  * mRatio / 2 ), mPaint);
        	// Xperia acro(2.3.3)の場合
            mCanvas.drawCircle(mCircleX, mCircleY, (float) (vol / 2  * mRatio / 2 ), mPaint);
            getHolder().unlockCanvasAndPost(mCanvas);
        } catch (Exception e) {
        	//Exceptionクラスのメソッドで例外の詳細を出力するメソッドを実行
        	e.printStackTrace();
        }

	}
/*
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			Thread.sleep(100);	// staticメソッド
		} catch (Exception e) {
		}

	}
*/
}
