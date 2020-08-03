package com.example.photoalbum;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class PhotoAlbum extends Activity implements OnItemClickListener {
	private ArrayList<Bitmap> photoList=new ArrayList<Bitmap>();
	private ArrayList<String> fileList = new ArrayList<String>();
	private ArrayList<Long> dateList = new ArrayList<Long>();
	private Gallery gallery;
	private ImageView imgView;
	private TextView txtView;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //レイアウトの生成
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.rgb(0,0,255));
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
        setContentView(layout);


        //ギャラリー写真の取得
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cur= this.managedQuery(uri, null, null, null,null);

        cur.moveToFirst();
        for (int i=0;i<cur.getCount();i++) {
            String path=cur.getString(cur.getColumnIndexOrThrow("_data"));
            long datetaken=cur.getLong(cur.getColumnIndexOrThrow("datetaken"));
            fileList.add(path);
            dateList.add(datetaken);
            photoList.add(file2bmp(path,150,150));

            for (String column:cur.getColumnNames()) {//デバッグ出力
                android.util.Log.v("columnName",column+"="+
                    cur.getString(cur.getColumnIndexOrThrow(column)));
            }
            cur.moveToNext();
        }

        //ギャラリーの生成
        gallery=new Gallery(this);
        gallery.setSpacing(3);
        gallery.setAdapter(new GalleryAdapter());
        gallery.setOnItemClickListener(this);
        gallery.setLayoutParams(new LinearLayout.LayoutParams(
        		LinearLayout.LayoutParams.FILL_PARENT,
        		LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(gallery);

        txtView=new TextView(this);
        txtView.setText("日付を表示");
        txtView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(txtView);

        // ImageViewの生成
        imgView=new ImageView(this);
        //imgView.setImageResource(R.drawable.icon);
        imgView.setLayoutParams(new LinearLayout.LayoutParams(
        		LinearLayout.LayoutParams.FILL_PARENT,
        		LinearLayout.LayoutParams.FILL_PARENT));
        layout.addView(imgView);




    }
    // Arg0:gallery, notice that it is of type AdapterView.
    // Arg1: the view that represents the selected item, in this example it will be a imageView
    // Arg2: the position of the selected item.
    // Arg3: the id of the selected item.
	public void onItemClick(AdapterView<?> adapView, View view, int position, long id) {
		// TODO 自動生成されたメソッド・スタブ
		if(adapView == gallery){
	        android.util.Log.v("position",position+"="+fileList.get(position));
	        Bitmap bigPicture = file2bmp(fileList.get(position), 400,400);
	        imgView.setImageBitmap(bigPicture);
			txtView.setText(DateFormat.format("yyyy-MM-dd kk.mm.ss", dateList.get(position)).toString());
		}
	}
	// use decodeFile,file to Bitmap(最大サイズ指定)
    private Bitmap file2bmp(String path,int maxW,int maxH) {
        BitmapFactory.Options options;
        try {
            //画像サイズの取得
            options=new BitmapFactory.Options();
            options.inJustDecodeBounds=true;
            //Decode an input stream into a bitmap.
            BitmapFactory.decodeFile(path,options);
            int scaleW=options.outWidth/maxW+1;
            int scaleH=options.outHeight/maxH+1;
            int scale =Math.max(scaleW,scaleH);

            //画像の読み込み
            options=new BitmapFactory.Options();
            options.inJustDecodeBounds=false;
            options.inSampleSize=scale;
            Bitmap bmp=BitmapFactory.decodeFile(path,options);
            return bmp;
        } catch (Exception e) {
            return null;
        }
    }

	// use decodeStream,input Stream to Bitmap(最大サイズ指定)
    private Bitmap stream2bmp(String path,int maxW,int maxH) {
        BitmapFactory.Options options;
        InputStream in=null;
        try {
            //画像サイズの取得
            options=new BitmapFactory.Options();
            options.inJustDecodeBounds=true;
            in=new FileInputStream(path);
            //Decode an input stream into a bitmap.
            BitmapFactory.decodeStream(in,null,options);
            in.close();
            int scaleW=options.outWidth/maxW+1;
            int scaleH=options.outHeight/maxH+1;
            int scale =Math.max(scaleW,scaleH);

            //画像の読み込み
            options=new BitmapFactory.Options();
            options.inJustDecodeBounds=false;
            options.inSampleSize=scale;
            in=new FileInputStream(path);
            Bitmap bmp=BitmapFactory.decodeStream(in,null,options);
            in.close();
            return bmp;
        } catch (Exception e) {
            try {
            	if (in!=null) in.close();
            } catch (Exception e2) {
            }
            return null;
        }
    }
    public class GalleryAdapter extends BaseAdapter {
    	// 　以下の三つのgetXXXXは実装しなければならない
    	public int getCount() {
    		// TODO 自動生成されたメソッド・スタブ
    		return photoList.size();
    	}

    	public Object getItem(int position) {
    		// TODO 自動生成されたメソッド・スタブ
    		return position;

    	}

    	public long getItemId(int position) {
    		// TODO 自動生成されたメソッド・スタブ
    		return 0;

    	}
    	public View getView(int position, View convertView, ViewGroup parent) {
    		// TODO 自動生成されたメソッド・スタブ
    		ImageView imageView;
            if (convertView==null) {
                imageView=new ImageView(PhotoAlbum.this);
                imageView.setLayoutParams(new Gallery.LayoutParams(150,150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setBackgroundColor(Color.BLACK);
                BitmapDrawable bd=new BitmapDrawable(photoList.get(position));
                imageView.setImageDrawable(bd);
            } else {
                imageView=(ImageView)convertView;
            }
            return imageView;
        }
    }

}