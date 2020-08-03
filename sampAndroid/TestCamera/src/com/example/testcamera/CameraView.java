package com.example.testcamera;

import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView
		implements SurfaceHolder.Callback,Camera.PictureCallback {

	private SurfaceHolder mHolder;
    private Camera        mCamera;

    public CameraView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
        mHolder = getHolder();
        mHolder.addCallback(this);
        // SurfaceViewのタイプをプッシュバッファにする
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);	// NORMALだとコケる

	}
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			// カメラをオープン
			mCamera = Camera.open();
	        // プレビューディスプレイ（表示先）を設定
			mCamera.setPreviewDisplay(mHolder);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO 自動生成されたメソッド・スタブ
		mCamera.startPreview();

	}
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
		// プレビューを停止
        mCamera.stopPreview();
        // カメラをリリース
        mCamera.release();
        mCamera=null;
	}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            mCamera.takePicture(null,null,null,this);
        }
        return true;
    }

	public void onPictureTaken(byte[] data, Camera camera) {
		// TODO 自動生成されたメソッド・スタブ
		 try {
			 	//String path=Environment.getExternalStorageDirectory()+ "/data/" + System.currentTimeMillis()+ ".jpg";
	            String path=Environment.getExternalStorageDirectory()+ "/Android/data/" + System.currentTimeMillis()+ ".jpg";
	            data2file(data,path);
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	        //プレビュー再開
	        camera.startPreview();
	}
    private void data2file(byte[] data,String fileName) throws Exception {
        FileOutputStream out=null;
        try {
            out=new FileOutputStream(fileName);
            out.write(data);
            out.close();
        } catch (Exception e) {
            if (out!=null) {
            	out.close();
            }
            throw e;
        }
    }
}
