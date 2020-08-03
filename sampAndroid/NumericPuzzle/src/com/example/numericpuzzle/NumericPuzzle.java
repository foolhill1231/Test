package com.example.numericpuzzle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class NumericPuzzle extends Activity {
    static final int imageButtons[] = {
        R.id.image_button1, R.id.image_button2, R.id.image_button3,R.id.image_button4,
        R.id.image_button5, R.id.image_button6,R.id.image_button7, R.id.image_button8,
        R.id.image_button9,R.id.image_button10,R.id.image_button11,R.id.image_button12,
        R.id.image_button13,R.id.image_button14,R.id.image_button15,R.id.image_button16,
    };

    static final int numImages[] = {
        R.drawable.num1, R.drawable.num2, R.drawable.num3,R.drawable.num4,
        R.drawable.num5, R.drawable.num6, R.drawable.num7, R.drawable.num8,
        R.drawable.num9, R.drawable.num10,R.drawable.num11, R.drawable.num12,
        R.drawable.num13, R.drawable.num14,R.drawable.num15,R.drawable.blank,
    };
    private boolean gameStarted = false;

    OrderController orders[] =
        new OrderController[imageButtons.length];

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        createOrderController();
        setStartButtonListener();

    }
    private void createOrderController() {
        for(int i=0; i<imageButtons.length; ++i) {
             ImageButton imgbtn =
                 (ImageButton)findViewById(imageButtons[i]);
             orders[i]= new OrderController(imgbtn, i,numImages[i]);
         }
     }
    private void startGame() {
        int size = numImages.length;
        for(int i=0; i<size-2; ++i) {
            int swap = (int)(Math.random()*(size-(i+1)));
            orders[i].swapImage(orders[i+swap]);
        }
        gameStarted = true;
    }
    private boolean isCompleted() {
    	if (!(gameStarted)) {
    		return false;
    	}
        for(int i=0; i<numImages.length; ++i) {
            if (numImages[i] != orders[i].getImageRes())
                return false;
        }
        return true;
    }
    private void startChronometer() {
        Chronometer chrono =
            (Chronometer)findViewById(R.id.chronometer);
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.start();
    }
    private long stopChronometer() {
        Chronometer chrono =
            (Chronometer)findViewById(R.id.chronometer);
        chrono.stop();
        return SystemClock.elapsedRealtime() - chrono.getBase();
    }

    private void setStartButtonListener() {
        Button btn = (Button)findViewById(R.id.start_button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startGame();
                startChronometer();
            }});
    }

    private void complete() {
        long msec = stopChronometer();
        AlertDialog.Builder alertDlgBld = new AlertDialog.Builder(this);
        alertDlgBld.setTitle(R.string.complete_title);
        alertDlgBld.setMessage(msec/1000 + " 秒");
        alertDlgBld.setPositiveButton(
            R.string.complete_button,
            new DialogInterface.OnClickListener(){
                // ボタンが押されたらダイアログを閉じる
                public void onClick(DialogInterface dialog,int which) {
                    dialog.dismiss();
                }
            });
        alertDlgBld.show();
    }
    private void searchDir(int idx) {
        boolean searchRight = true;
        boolean searchLeft = true;
        boolean searchUp = true;
        boolean searchDown = true;
        if (idx < 4) {
        	searchUp=false;
        }
        if (idx > 11) {
        	searchDown=false;
        }
        if ((idx % 4) ==0) {
        	searchLeft=false;
        }
        if ((idx % 4) ==3) {
        	searchRight=false;
        }
        if (searchUp) {
        	if (searchUp(idx)) {
        		return;
        	}
        }
        if (searchDown) {
        	if (searchDown(idx)) {
        		return;
        	}
        }
        if (searchLeft) {
        	if (searchLeft(idx)) {
        		return;
        	}
        }
        if (searchRight) {
        	if (searchRight(idx)) {
        		return;
        	}
        }
    }
    private boolean searchUp(int idx) {
    	int distance =0;
        //Log.v("SearchUp","idx=" + idx);
        for(int i=idx - 4  ; i> -1 ; i-=4) {
        	distance--;
        	if (orders[i].getImageRes()==R.drawable.blank) {
        		swapUp(idx,distance);
        		return true;
        	}
        }
        return false;
    }
    private boolean searchDown(int idx) {
    	int distance =0;
        //Log.v("SearchDown","idx=" + idx);
        for(int i=idx + 4  ; i< 16 ;  i+=4) {
        	distance++;
        	if (orders[i].getImageRes()==R.drawable.blank) {
        		swapDown(idx,distance);
        		return true;
        	}
        }
        return false;
    }
    private boolean searchLeft(int idx) {
    	int distance =0;
    	int min =0;
        //Log.v("SearchLeft","idx=" + idx);
        min = idx - (idx % 4);
        for(int i=idx - 1  ; i>= min  ; i--) {
        	distance--;
        	if (orders[i].getImageRes()==R.drawable.blank) {
        		swapLeft(idx,distance);
        		return true;
        	}
        }
        return false;
    }
    private boolean searchRight(int idx) {
    	int distance =0;
    	int max =15;
    	//Log.v("SearchRight","idx=" + idx);
        max = (idx+ 4) - (idx + 4) % 4 ;
        for(int i=idx + 1  ; i< max ; i++) {
        	distance++;
        	if (orders[i].getImageRes()==R.drawable.blank) {
        		swapRight(idx,distance);
        		return true;
        	}
        }
        return false;
    }
	private void swapUp(int idx, int distance) {
        for(int i=idx+(distance * 4); i<idx; i+=4) {
            orders[i].swapImage(orders[i+4]);
        }
	}
	private void swapDown(int idx, int distance) {
        for(int i=idx+(distance * 4); i>idx; i-=4) {
            orders[i].swapImage(orders[i-4]);
        }
	}
	private void swapLeft(int idx, int distance) {
        for(int i=idx+distance; i<idx; i++) {
            orders[i].swapImage(orders[i+1]);
        }
	}
	private void swapRight(int idx, int distance) {
        for(int i=idx+distance; i>idx; i--) {
            orders[i].swapImage(orders[i-1]);
        }
	}
    class OrderController implements View.OnClickListener {
        ImageButton imgBtn;
        int idx = 0;
        int curImageId = 0;

        public OrderController(ImageButton ibtn,int i,int resid)	{
        	imgBtn = ibtn;
        	idx = i;
            setImageRes(resid);
            imgBtn.setOnClickListener(this);
        }

        public int setImageRes(int resid) {
            int old = curImageId;
            curImageId = resid;
            imgBtn.setImageResource(resid);
            return old;
        }
        public int getImageRes() {
            return curImageId;
        }
        public void onClick(View v) {
        	if (curImageId == R.drawable.blank) {
        		return;
        	}
            searchDir(idx);

            if (isCompleted())
                complete();
        }
        public void swapImage(OrderController other) {
            int previous = other.setImageRes(curImageId);
            setImageRes(previous);
        }
	}
}