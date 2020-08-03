package com.example.testcamera;

import android.app.Activity;
import android.os.Bundle;

public class TestCamera extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new CameraView(this));
    }
}