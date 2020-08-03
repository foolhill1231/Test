package com.example.ballaccel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BallSurFaceView extends SurfaceView
				implements SurfaceHolder.Callback  {
	private int mCircleX =0;
    private int mCircleY =0;
   //private double mRatio =0;

    private SurfaceHolder mHolder;
    private Canvas mCanvas =null;
    private Paint mPaint = null;
    private float mBallSize = 10.0f;

    public BallSurFaceView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
		// サーフェイスフォルダの取得
        mHolder = getHolder();
        // サーフェイスイベントの通知先の指定（自身のクラス）
        mHolder.addCallback(this);

        mHolder.setFixedSize(getWidth(), getHeight());

	}

	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);

        Log.v("SurfaceView","Width"+getWidth());		// 480
        Log.v("SurfaceView","Height"+getHeight());		// 778

        mCircleX = getWidth() / 2;
        mCircleY = getHeight() / 2;
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}
	public void drawBall(int x,int y) {
        mCircleX -= x*2;
        mCircleY += y*2;

        if (mCircleX>getWidth() ) {
        	mCircleX = 10;
        	// (10 * (int)mBallSize) / 10;
        	newBall();
        }
        if (mCircleY>getHeight()) {
        	mCircleY=10;
        	//mCircleY= mCircleY - (10 * (int)mBallSize) / 10;

        	newBall();
        }
        if (mCircleX<0 ) {
        	mCircleX = getWidth() - 10;
        	newBall();
        }
        if (mCircleY<0) {
        	mCircleY = getHeight() - 10;
        	newBall();
        }
		try {
        	mCanvas = getHolder().lockCanvas();

	        // 円を描画する
            mCanvas.drawColor(Color.LTGRAY);
        	mCanvas.drawCircle(mCircleX, mCircleY, mBallSize, mPaint);
            getHolder().unlockCanvasAndPost(mCanvas);
        } catch (Exception e) {
        	//Exceptionクラスのメソッドで例外の詳細を出力するメソッドを実行
        	e.printStackTrace();
        }
	}
	private void newBall() {
    	mBallSize *=1.1f;
	}

}
