package com.example.l.fqwarter.serialport;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.example.l.fqwarter.protocol.CmdSerialInfo;
import com.example.l.fqwarter.protocol.ProtocolDeal;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialPortService extends Service {

    private final static String TAG = "SerialPortService";

    public final static String ACTION_MAIN_UPDATA = "com.example.l.fqwarter.ACTION_MAIN_UPDATA";
    public final static String ACTION_MAIN_UPDATA_PIC = "com.example.l.fqwarter.ACTION_MAIN_UPDATA_PIC";

    public final static int MSG_SERIAL_UPDATA_INITIAL = 1;
    public final static int MSG_SERIAL_UPDATA_PIC = 2;

    private SerialPortSubThread mSerialPortSubThread;
    private SerialPortSubHandler mSerialPortSubHandler;

    private SerialPort mSerialPort;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    private ReadThread mReadThread;

    private ProtocolDeal mProtocolDeal;

    private class ReadThread extends Thread {

        @Override
        public void run() {
            super.run();
            mProtocolDeal = new ProtocolDeal();
            while(!isInterrupted()) {
                int size;
                try {
                    byte[] buffer = new byte[64];
                    if (mInputStream == null) return;
                    size = mInputStream.read(buffer);
                    if (size > 0) {
                        //onDataReceived(buffer, size);
                        Log.i(TAG, "ReadThread---run--- buffer:" + buffer + ",size=" + size);
                        mProtocolDeal.setCmdBytes(buffer, size);
                        CmdSerialInfo cmdSerialInfo = mProtocolDeal.outputCmdInfoNear();
                        Log.i(TAG, (cmdSerialInfo==null ? "cmdSerialInfo == null" : ""+cmdSerialInfo.toString()));
                        broadcastUpdate(ACTION_MAIN_UPDATA, cmdSerialInfo);
                        while (cmdSerialInfo != null){
                            //get all infomation in the
                            cmdSerialInfo = mProtocolDeal.outputCmdInfoNear();
                            broadcastUpdate(ACTION_MAIN_UPDATA, cmdSerialInfo);
                            Log.i(TAG, (cmdSerialInfo==null ? "cmdSerialInfo2 == null" : ""+cmdSerialInfo.toString()));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

    }

    public SerialPortService() throws SecurityException, IOException {
        Log.i(TAG, "--------SerialPortService()");
        mSerialPort = new SerialPort(new File("/dev/ttyS2"), 19200, 0);
        mInputStream = mSerialPort.getInputStream();
        mOutputStream = mSerialPort.getOutputStream();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "--------onCreate()");

        mSerialPortSubThread = new SerialPortSubThread();
        mSerialPortSubThread.start();

        mReadThread = new ReadThread();
        mReadThread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mReadThread != null && mReadThread.isAlive()){
            mReadThread.interrupt();
        }

        if(mSerialPortSubHandler != null) {
            mSerialPortSubHandler.getLooper().quit();
        }
    }

    /*-------------------------------------------------
            sub thread and handler  --------start
        -------------------------------------------------*/
    private class SerialPortSubThread extends Thread{
        @Override
        public void run() {
            Looper.prepare();
            mSerialPortSubHandler = new SerialPortSubHandler(Looper.myLooper());
            SerialPortSubHandlerSendMsg(MSG_SERIAL_UPDATA_INITIAL, 1000);
            Looper.loop();
        }
    }
    private class SerialPortSubHandler extends Handler{
        public SerialPortSubHandler(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case MSG_SERIAL_UPDATA_INITIAL:
                    broadcastUpdate(ACTION_MAIN_UPDATA_PIC, 0);
                    //SerialPortSubHandlerSendMsg(MSG_SERIAL_UPDATA_INITIAL, 1000);
                    break;
            }
        }
    }
    public void SerialPortSubHandlerSendMsg(int msgwhat, int msgDelay){
        Message msgMain = mSerialPortSubHandler.obtainMessage();
        msgMain.what = msgwhat;
        if (msgDelay == 0) {
            mSerialPortSubHandler.sendMessage(msgMain);
        } else {
            mSerialPortSubHandler.sendMessageDelayed(msgMain, msgDelay);
        }
    }
    /////////////////////////////////////////////////----end

    /*-------------------------------------------------
        sendBroadcast  --------start
    -------------------------------------------------*/
    private void broadcastUpdate(final String action, int data) {
        Intent intent = new Intent(action);
        sendBroadcast(intent);
    }

    private void broadcastUpdate(final String action,CmdSerialInfo cmdSerialInfo) {
        Intent intent = new Intent(action);
        intent.putExtra(ProtocolDeal.CMD_SERIAL_INFO_KEY, cmdSerialInfo);
        sendBroadcast(intent);
    }
    /////////////////////////////////////////////////----end

    /*-------------------------------------------------
        binder  --------start
    -------------------------------------------------*/
    public class LocalBinder extends Binder {
        public SerialPortService getService() {
            return SerialPortService.this;
        }
    }
    private final IBinder mBinder = new LocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG, "--------onBind()");
        return mBinder;
//        throw new UnsupportedOperationException("Not yet implemented");
    }
    /////////////////////////////////////////////////----end
}
