package com.example.connectnxt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
//import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.UUID;

public class BTCommunicator extends Thread {
    public static final int MOTOR_A = 0;
    public static final int MOTOR_B = 1;
    public static final int MOTOR_C = 2;
    //public static final int MOTOR_B_ACTION = 40;
    //public static final int MOTOR_RESET = 10;
    public static final int DO_BEEP = 51;
    //public static final int READ_MOTOR_STATE = 60;
    //public static final int GET_FIRMWARE_VERSION = 70;
    public static final int DISCONNECT = 99;

    public static final int DISPLAY_TOAST = 1000;
    public static final int STATE_CONNECTED = 1001;
    public static final int STATE_CONNECTERROR = 1002;
    public static final int MOTOR_STATE = 1003;
    public static final int STATE_RECEIVEERROR = 1004;
    public static final int STATE_SENDERROR = 1005;
    //public static final int FIRMWARE_VERSION = 1006;
    //public static final int FIND_FILES = 1007;
    //public static final int START_PROGRAM = 1008;
    //public static final int STOP_PROGRAM = 1009;
    //public static final int GET_PROGRAM_NAME = 1010;
    //public static final int PROGRAM_NAME = 1011;

    public static final int NO_DELAY = 0;

    private static final UUID SERIAL_PORT_SERVICE_CLASS_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // this is the only OUI registered by LEGO, see http://standards.ieee.org/regauth/oui/index.shtml
    public static final String OUI_LEGO = "00:16:53";

    BluetoothAdapter btAdapter;
    private BluetoothSocket nxtBTsocket = null;
    private DataOutputStream nxtDos = null;
    //private DataInputStream nxtDin = null;
    private boolean connected = false;

    private Handler uiHandler;
    private String mMACaddress;
    private ConnectNXT myConNxt;

    //private byte[] returnMessage;

    public BTCommunicator(ConnectNXT myConNxt, Handler uiHandler, BluetoothAdapter btAdapter) {
        this.myConNxt = myConNxt;
        this.uiHandler = uiHandler;
        this.btAdapter = btAdapter;
    }

    public Handler getHandler() {
        return myHandler;
    }

    public boolean isBTAdapterEnabled() {
        return (btAdapter == null) ? false : btAdapter.isEnabled();
    }

    @Override
    public void run() {

        createNXTconnection();

        while (connected) {
        	// 入力ストリームの処理
        }

    }
    private void createNXTconnection() {
        try {

            BluetoothSocket nxtBTsocketTEMPORARY;
            BluetoothDevice nxtDevice = null;
            // Get a BluetoothDevice object for the given Bluetooth hardware address.
            nxtDevice = btAdapter.getRemoteDevice(mMACaddress);

            if (nxtDevice == null) {
                sendToast(myConNxt.getResources().getString(R.string.no_paired_nxt));
                sendState(STATE_CONNECTERROR);
                return;
            }

            // Create an RFCOMM BluetoothSocket ready to start a secure outgoing connection to this remote device using SDP lookup of uuid.

            nxtBTsocketTEMPORARY = nxtDevice.createRfcommSocketToServiceRecord(SERIAL_PORT_SERVICE_CLASS_UUID);
            nxtBTsocketTEMPORARY.connect(); // Attempt to connect to a remote device.
            nxtBTsocket = nxtBTsocketTEMPORARY;

            //nxtDin = new DataInputStream(nxtBTsocket.getInputStream());
            nxtDos = new DataOutputStream(nxtBTsocket.getOutputStream());

            connected = true;

        } catch (IOException e) {
            Log.d("BTCommuicator", "error createNXTConnection()", e);
            if (myConNxt.newDevice) {
                sendToast(myConNxt.getResources().getString(R.string.pairing_message));
                sendState(STATE_CONNECTERROR);

            } else {
                sendState(STATE_CONNECTERROR);
            }

            return;
        }

        sendState(STATE_CONNECTED);
    }
    private void destroyNXTconnection() {
        try {
            if (nxtBTsocket != null) {
                // send stop messages before closing
            	// 以下2行追加
                changeMotorSpeed(MOTOR_B, 0);
                changeMotorSpeed(MOTOR_C, 0);
                waitSomeTime(1000);
                connected = false;
                nxtBTsocket.close();
                nxtBTsocket = null;
            }

            //nxtDin = null;
            nxtDos = null;

        } catch (IOException e) {
            sendToast(myConNxt.getResources().getString(R.string.problem_at_closing));
        }
    }
    private void doBeepBT(int frequency, int duration) {

	    byte[] message = new byte[6];

	    // Direct command telegram, no response
	    message[0] = (byte) 0x80;
	    message[1] = (byte) 0x03;
	    // Frequency for the tone, Hz (UWORD); Range: 200-14000 Hz
	    message[2] = (byte) frequency;				// 下位
	    message[3] = (byte) (frequency >> 8);		// 上位
	    // Duration of the tone, ms (UWORD)
	    message[4] = (byte) duration;
	    message[5] = (byte) (duration >> 8);
        sendMessage(message);

        waitSomeTime(duration);

    }
    // Motor
    private void changeMotorSpeed(int motor, int speed) {
        byte[] message = new byte[12];

    	if (speed > 100)
            speed = 100;

        else if (speed < -100)
            speed = -100;

    	// Direct command telegram, no response
        message[0] = (byte) 0x80;
        message[1] = (byte) 0x04;
        // Output port
        message[2] = (byte) motor;

        if (speed == 0) {
            message[3] = 0;
            message[4] = 0;
            message[5] = 0;
            message[6] = 0;
            message[7] = 0;

        } else {
            // Power set option (Range: -100 - 100)
            message[3] = (byte) speed;
            // Mode byte (Bit-field): MOTORON + BREAK
            message[4] = 0x03;
            // Regulation mode: REGULATION_MODE_MOTOR_SPEED
            message[5] = 0x01;
            // Turn Ratio (SBYTE; -100 - 100)
            message[6] = 0x00;
            // RunState: MOTOR_RUN_STATE_RUNNING
            message[7] = 0x20;
        }

        // TachoLimit: run forever
        message[8] = 0;
        message[9] = 0;
        message[10] = 0;
        message[11] = 0;

        sendMessage(message);
    }
    private boolean sendMessage(byte[] message) {
        if (nxtDos == null) {
            return false;
        }

        try {

        	Log.v("sendMessage","message="+ byteToStr(message));
            // send message length
            int messageLength = message.length;
            nxtDos.writeByte(messageLength);
            nxtDos.writeByte(messageLength >> 8);
            nxtDos.write(message, 0, message.length);
            nxtDos.flush();
            return true;

        } catch (IOException ioe) {
            sendState(STATE_SENDERROR);
            return false;
        }
    }
    private String byteToStr(byte[] mess) {
    	StringBuffer strbuf = new StringBuffer();
    	for(int i=0;i<mess.length;i++) {
    		strbuf.append(String.format("%02x", (mess[i])));
    	}
    	return strbuf.toString();

    }

    private void waitSomeTime(int millis) {
        try {
            Thread.sleep(millis);

        } catch (InterruptedException e) {
        }
    }

    private void sendToast(String toastText) {
        Bundle myBundle = new Bundle();
        myBundle.putInt("message", DISPLAY_TOAST);
        myBundle.putString("toastText", toastText);
        sendBundle(myBundle);
    }
    private void sendState(int message) {
        Bundle myBundle = new Bundle();
        myBundle.putInt("message", message);
        sendBundle(myBundle);
    }
    private void sendBundle(Bundle myBundle) {
        Message myMessage = myHandler.obtainMessage();  // Returns a new Message from the global message pool.
        myMessage.setData(myBundle);
        uiHandler.sendMessage(myMessage);
    }

    // receive messages from the UI
    final Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message myMessage) {

            int message;

            switch (message = myMessage.getData().getInt("message")) {
            	// 追加
            	case MOTOR_A:
                case MOTOR_B:
                case MOTOR_C:
                    changeMotorSpeed(message, myMessage.getData().getInt("value1"));
                    break;
                case DO_BEEP:
                    doBeepBT(myMessage.getData().getInt("value1"), myMessage.getData().getInt("value2"));
                    break;
                case DISCONNECT:
                    destroyNXTconnection();
                    break;
            }
        }
    };

    public void setMACAddress(String mMACaddress) {
        this.mMACaddress = mMACaddress;
    }

}
