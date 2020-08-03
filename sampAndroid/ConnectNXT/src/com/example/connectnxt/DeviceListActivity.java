package com.example.connectnxt;

import java.util.Set;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DeviceListActivity  extends Activity {
    static final String PAIRING = "pairing";

	// Debugging
    private static final String TAG = "DeviceListActivity";
    private static final boolean DEBUG = true;
    // this is the only OUI registered by LEGO, see http://standards.ieee.org/regauth/oui/index.shtml
    public static final String OUI_LEGO = "00:16:53";
    // Return Intent extra
    public static String EXTRA_DEVICE_ADDRESS = "device_address";

    // Member fields
    private BluetoothAdapter mBtAdapter;
    private ArrayAdapter<String> mPairedDevicesArrayAdapter;
    private ArrayAdapter<String> mNewDevicesArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TitleBarにProgressアイコンを表示させる
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.device_list);

        // Set result CANCELED incase the user backs out
        // 戻り値の指定
        setResult(Activity.RESULT_CANCELED); // Constant(public static final int)
        								 	 // RESULT_CANCELED Value: 0(0x00000000)
        									 // RESULT_OK Value: -1 (0xffffffff)
        // デバイスをスキャンボタンが押されたときの処理
        Button scanButton = (Button) findViewById(R.id.button_scan);
        scanButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	// デバイスをスキャンする処理
                doDiscovery();
                v.setVisibility(View.GONE);
            }
        });

        // Initialize array adapters. One for already paired devices and
        // one for newly discovered devices
        mPairedDevicesArrayAdapter = new ArrayAdapter<String>(this, R.layout.device_name);
        mNewDevicesArrayAdapter = new ArrayAdapter<String>(this, R.layout.device_name);

        // Find and set up the ListView for paired devices
        ListView pairedListView = (ListView) findViewById(R.id.paired_devices);
        pairedListView.setAdapter(mPairedDevicesArrayAdapter);
        pairedListView.setOnItemClickListener(mDeviceClickListener);

        // Find and set up the ListView for newly discovered devices
        ListView newDevicesListView = (ListView) findViewById(R.id.new_devices);
        newDevicesListView.setAdapter(mNewDevicesArrayAdapter);
        newDevicesListView.setOnItemClickListener(mDeviceClickListener);

        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothDevice.ACTION_NAME_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);

        // Get the local Bluetooth adapter
        mBtAdapter = BluetoothAdapter.getDefaultAdapter();

        // Get a set of currently paired devices
        // Return the set of BluetoothDevice objects that are bonded (paired) to the local adapter.
        Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();

        // If there are paired devices, add each one to the ArrayAdapter
        boolean legoDevicesFound = false;

        if (pairedDevices.size() > 0) {
            findViewById(R.id.title_paired_devices).setVisibility(View.VISIBLE);
            for (BluetoothDevice device : pairedDevices) {
                // only add LEGO devices
                if (device.getAddress().startsWith(OUI_LEGO)) {	// startsWith "00:16:53"
                	// OUI registered by LEGO
                	// OUI（organizationally unique identifier）とは，
                	// イーサネットLAN内で使われるMAC（medium access control）アドレスの前半部分を指す
                	//

                    legoDevicesFound = true;
                    mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                }
            }
        }

        if (legoDevicesFound == false) {
            String noDevices = getResources().getText(R.string.none_paired).toString();
            mPairedDevicesArrayAdapter.add(noDevices);
        }
    }
    // The on-click listener for all devices in the ListViews
    private OnItemClickListener mDeviceClickListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
            // Cancel discovery because it's costly and we're about to connect
            mBtAdapter.cancelDiscovery();

            // Get the device MAC address, which is the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);

            // Create the result Intent and include the MAC address
            Intent intent = new Intent();
            Bundle data = new Bundle();
            data.putString(EXTRA_DEVICE_ADDRESS, address);
            data.putBoolean(PAIRING,av.getId()==R.id.new_devices);
            intent.putExtras(data);

            // Set result and finish this Activity
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    };		// 呼び出したActivityに返っていきます。

    // The BroadcastReceiver that listens for discovered devices and
    // changes the title when discovery is finished
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String dName = null;

            // When discovery finds a device

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                // 名前不明はまだ登録しない
                if((dName = device.getName()) != null){
                    // If it's already paired, skip it, because it's been listed already
	                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
	                    mNewDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
	                }
                }
            }

            // 名前が検出された
            if (BluetoothDevice.ACTION_NAME_CHANGED.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                // If it's already paired, skip it, because it's been listed already
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    mNewDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                }
            }
            // When discovery is finished, change the Activity title
            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                setProgressBarIndeterminateVisibility(false);
                setTitle(R.string.select_device);
                if (mNewDevicesArrayAdapter.getCount() == 0) {
                    String noDevices = getResources().getText(R.string.none_found).toString();
                    mNewDevicesArrayAdapter.add(noDevices);
                }
            }
        }
    };
    /**
     * Start device discover with the BluetoothAdapter
     */
    private void doDiscovery() {
        if (DEBUG) Log.d(TAG, "doDiscovery()");

        // Indicate scanning in the title
        setProgressBarIndeterminateVisibility(true);
        setTitle(R.string.scanning);

        // Turn on sub-title for new devices
        findViewById(R.id.title_new_devices).setVisibility(View.VISIBLE);

        // If we're already discovering, stop it
        		// Return true if the local Bluetooth adapter is currently in the device discovery process.
        if (mBtAdapter.isDiscovering()) {
            mBtAdapter.cancelDiscovery();	// Cancel the current device discovery process.
        }

        // Request discover from BluetoothAdapter
        mBtAdapter.startDiscovery();	// Start the remote device discovery process.
    }
}
