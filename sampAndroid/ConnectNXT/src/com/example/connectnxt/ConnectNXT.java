package com.example.connectnxt;

//import java.util.ArrayList;
//import java.util.List;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

public class ConnectNXT extends Activity {
	private static final int REQUEST_CONNECT_DEVICE = 1000;
    private static final int REQUEST_ENABLE_BT = 2000;
    public static final int MENU_TOGGLE_CONNECT = Menu.FIRST;
    public static final int MENU_QUIT = Menu.FIRST + 1;

    private Activity thisActivity;
    private Handler btcHandler;
    private BTCommunicator myBTCommunicator = null;
    private Toast mLongToast;
    private Toast mShortToast;
    boolean newDevice;
    private ProgressDialog connectingProgressDialog;
    private boolean connected = false;
    private boolean bt_error_pending = false;
    private MotorView mView;
    int motorLeft;
    int motorRight;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = this;

        // surfaceView
        mView = new MotorView(getApplicationContext(),this);
        setContentView(mView);

        // 画面のロックを防ぐ
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        // Toastは面倒なので，少し使いやすいする
        mLongToast = Toast.makeText(this, "", Toast.LENGTH_LONG);
        mShortToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

        motorLeft = BTCommunicator.MOTOR_C;
        motorRight = BTCommunicator.MOTOR_B;

    }
    @Override
    protected void onStart() {
        super.onStart();
        //	Return
        //	the default local adapter, or null if Bluetooth is not supported on this hardware platform

        if(!BluetoothAdapter.getDefaultAdapter().equals(null)){
            //Bluetooth対応端末の場合の処理
            Log.v("Bluetooth","Bluetooth is supported");
        }else{
            //Bluetooth非対応端末の場合の処理
            Log.v("Bluetooth","Bluetooth is not supported");
            finish();
        }
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
        	 showToastShort(getResources().getString(R.string.wait_till_bt_on));
            //Intent enableIntent = new Intent(this, EnableBT.class);
            // 	Activity Action: Show a system activity that allows the user to turn on Bluetooth.
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);

        } else {
            Log.v("Bluetooth","Bluetooth is On");
            selectNXT();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        // sensor
        mView.registerListener();
    }
    @Override
    public void onPause() {
    	// sensor
        mView.unregisterListener();
        destroyBTCommunicator();
        super.onStop();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
	        case REQUEST_CONNECT_DEVICE:

	            // When DeviceListActivity returns with a device to connect
	            if (resultCode == Activity.RESULT_OK) {
	                // Get the device MAC address
	                String address = data.getExtras().getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
	                newDevice = data.getExtras().getBoolean(DeviceListActivity.PAIRING);
	                if (newDevice==true) {
	                	enDiscoverable();
	                }
	                startBTCommunicator(address);
	            }
	            break;
            case REQUEST_ENABLE_BT:

                switch (resultCode) {
                    case Activity.RESULT_OK:
                        selectNXT();
                        break;
                    case Activity.RESULT_CANCELED:
                        showToastShort(getResources().getString(R.string.bt_needs_to_be_enabled));
                        finish();
                        break;
                    default:
                        showToastShort(getResources().getString(R.string.problem_at_connecting));
                        finish();
                        break;
                }
        }
    }
    private void enDiscoverable() {

    	Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
    	discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 120);
    	startActivity(discoverableIntent);
    }

    void selectNXT() {
        Intent serverIntent = new Intent(this, DeviceListActivity.class);
        startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
    }
    public void startBTCommunicator(String mac_address) {

        connectingProgressDialog = ProgressDialog.show(this, "", getResources().getString(R.string.connecting_please_wait), true);

        if (myBTCommunicator == null) {
            createBTCommunicator();
        }

        switch (((Thread) myBTCommunicator).getState()) {
        	/*
        	 * Thread.getState() Therad.isAlive()
        	 * スレッドの状態を返します。
        	 * 		NEW				false
        	 * 		RUNNABLE		true
        	 */
            case NEW:
                myBTCommunicator.setMACAddress(mac_address);
                myBTCommunicator.start();
                break;
            default:
                connected=false;
                myBTCommunicator = null;
                createBTCommunicator();
                myBTCommunicator.setMACAddress(mac_address);
                myBTCommunicator.start();
                break;
        }
        // optionMenu
        updateButtonsAndMenu();

    }
    public void createBTCommunicator() {
        // interestingly BT adapter needs to be obtained by the UI thread - so we pass it in in the constructor
        myBTCommunicator = new BTCommunicator(this, myHandler, BluetoothAdapter.getDefaultAdapter());
        btcHandler = myBTCommunicator.getHandler();
    }
    // receive messages from the BTCommunicator
    final Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message myMessage) {
            switch (myMessage.getData().getInt("message")) {
                case BTCommunicator.STATE_CONNECTED:
                    connected = true;
                    connectingProgressDialog.dismiss();
                    // optionMenu
                    updateButtonsAndMenu();
                    doBeep(440,500);
                    // 接続した
                    showToastLong(getResources().getString(R.string.connected));
                    break;
                case BTCommunicator.STATE_CONNECTERROR:
                    connectingProgressDialog.dismiss();
                case BTCommunicator.STATE_RECEIVEERROR:
                case BTCommunicator.STATE_SENDERROR:
                    destroyBTCommunicator();

                    if (bt_error_pending == false) {
                        bt_error_pending = true;
                        // inform the user of the error with an AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                        builder.setTitle(getResources().getString(R.string.bt_error_dialog_title))
                        .setMessage(getResources().getString(R.string.bt_error_dialog_message)).setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            //@Override
                            public void onClick(DialogInterface dialog, int id) {
                                bt_error_pending = false;
                                dialog.cancel();
                                selectNXT();
                            }
                        });
                        builder.create().show();
                    }

                    break;
            }
        }
    };

    private void doBeep(int frequency, int duration){
    	sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.DO_BEEP, frequency, duration);
    }
    //  motor
    public void updateMotorControl(int left, int right) {

        if (myBTCommunicator != null) {
            // send messages via the handler
            sendBTCmessage(BTCommunicator.NO_DELAY, motorLeft, left , 0);
            sendBTCmessage(BTCommunicator.NO_DELAY, motorRight, right , 0);
        }
    }

    void sendBTCmessage(int delay, int message, int value1, int value2) {
        Bundle myBundle = new Bundle();
        myBundle.putInt("message", message);
        myBundle.putInt("value1", value1);
        myBundle.putInt("value2", value2);
        Message myMessage = myHandler.obtainMessage();
        myMessage.setData(myBundle);

        if (delay == 0)
            btcHandler.sendMessage(myMessage);

        else
            btcHandler.sendMessageDelayed(myMessage, delay);
    }
    public void destroyBTCommunicator() {

        if (myBTCommunicator != null) {
            sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.DISCONNECT, 0, 0);
            myBTCommunicator = null;
        }

        connected = false;
        // 追加
        updateButtonsAndMenu();
    }

    private void showToastShort(String textToShow) {
    	mShortToast.setText(textToShow);
    	mShortToast.show();
    }
    private void showToastLong(String textToShow) {
    	mLongToast.setText(textToShow);
    	mLongToast.show();
    }
    // Menu
    private Menu myMenu;
    /**
     * Creates the menu items
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        myMenu = menu;
        myMenu.add(0,MENU_TOGGLE_CONNECT,1,getResources().getString(R.string.connect));
        myMenu.add(0,MENU_QUIT,2,getResources().getString(R.string.quit));

        updateButtonsAndMenu();
        return true;
    }

    /**
     * Handles item selections
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_TOGGLE_CONNECT:

                if (myBTCommunicator == null || connected == false) {
                    selectNXT();

                } else {
                    destroyBTCommunicator();
                    updateButtonsAndMenu();
                }

                return true;
            case MENU_QUIT:
                destroyBTCommunicator();
                finish();


                return true;
        }

        return false;
    }
    // 追加
    private void updateButtonsAndMenu()	{
	    if (myMenu == null) return;
	    myMenu.removeItem(MENU_TOGGLE_CONNECT);

	    if (connected) {
	        myMenu.add(0, MENU_TOGGLE_CONNECT, 1, getResources().getString(R.string.disconnect));
	    } else {
	        myMenu.add(0, MENU_TOGGLE_CONNECT, 1, getResources().getString(R.string.connect));
	    }
    }
    // 追加
    public boolean isConnected() {
        return connected;
    }
}