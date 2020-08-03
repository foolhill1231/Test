package com.example.takeapicture;

import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView
			implements SurfaceHolder.Callback,Camera.PictureCallback{
    private SurfaceHolder mHolder;
    private Camera mCamera;

    // コンストラクタ
    public CameraView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
        mHolder = getHolder();
        mHolder.addCallback(this);
        // SurfaceViewのタイプをプッシュバッファにする
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

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
	public void takeAPicture() {
        try {
        	mCamera.takePicture(null,null,null,this);
        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	public void onPictureTaken(byte[] data, Camera camera) {
		// TODO 自動生成されたメソッド・スタブ
		 try {
	            //String path=Environment.getExternalStorageDirectory()+ "/data/" + System.currentTimeMillis()+ ".jpg";
	            String path=Environment.getExternalStorageDirectory()+ "/Android/data/" + System.currentTimeMillis()+ ".jpg";
	            Log.v("path:",path);
	            data2file(data,path);
	        } catch (Exception e) {
				e.printStackTrace();
	        }

	}
	//バイトデータ→ファイル
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
