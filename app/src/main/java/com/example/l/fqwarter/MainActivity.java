package com.example.l.fqwarter;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.l.fqwarter.protocol.CmdExcute;
import com.example.l.fqwarter.protocol.CmdSerialInfo;
import com.example.l.fqwarter.protocol.ProtocolDeal;
import com.example.l.fqwarter.serialport.SerialPortService;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    private static final int MSG_NOTIFY_UPDATA_PIC = 1;

    private int testi=0;
    private View mLayout;
    private int mPicNum;
    private CmdExcute mCmdExcute;
    private Context mContext;

    private TextView mTvtst;
    private MyViewManager mMyViewManager;

    private View mMainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
/*
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        */
        //隐藏底部虚拟按键
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        mContext = this;

        mLayout = findViewById(R.id.mainAtyLayout);
        mLayout.setBackground(getResources().getDrawable(R.drawable.bluepic));

        //new view deal proc class
        mMyViewManager = new MyViewManager(mLayout, this, this);


        mTvtst = (TextView) findViewById(R.id.common1TxtTime);

        //initial para
        mPicNum = 0;
        mCmdExcute = new CmdExcute(this);

        // Example of a call to a native method
//    TextView tv = (TextView) findViewById(R.id.sample_text);
//    tv.setText(stringFromJNI());

        //TODO: for debug, mask this code when emulator
    //start and bind service
        Intent serialSvIntent = new Intent();
        serialSvIntent.setAction("com.example.l.fqwarter.serialport.SerialPortService");
        serialSvIntent.setPackage("com.example.l.fqwarter");
        startService(serialSvIntent);
        bindService(serialSvIntent, mServiceConnection, BIND_AUTO_CREATE);
        Log.i(TAG, "startService(serialSvIntent);*******************");

        //register receiver and set intent
        registerReceiver(mMainAtyReceiver, serialSrvFilter());


    }



    /*-------------------------------------------------
        UI Handler --------start
    -------------------------------------------------*/
    public Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            testi++;
            Log.i(TAG, "handleMessage-------MSG_NOTIFY_UPDATA_PIC" + testi);
            switch (msg.what)
            {
                case MSG_NOTIFY_UPDATA_PIC:
/*
                    CmdSerialInfo cmdSerialInfo =  msg.getData().getParcelable(ProtocolDeal.CMD_SERIAL_INFO_KEY);
                    if (cmdSerialInfo != null){
                        Log.i(TAG, "handleMessage-------MSG_NOTIFY_UPDATA_PIC  cmdSerialInfo.getHeader=" + cmdSerialInfo.getHeader());
                        mCmdExcute.CmdDeal(cmdSerialInfo, mContext);
                    }
                    */
                    break;
            }
        }
    };
    /////////////////////////////////////////////////----end




    /*-------------------------------------------------
        BroadcastReceiver --------start
    -------------------------------------------------*/
    private static IntentFilter serialSrvFilter() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SerialPortService.ACTION_MAIN_UPDATA_PIC);
        intentFilter.addAction(SerialPortService.ACTION_MAIN_UPDATA);
        return intentFilter;
    }
    private final BroadcastReceiver mMainAtyReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (SerialPortService.ACTION_MAIN_UPDATA_PIC.equals(action)) {
                sendMsgToMainHandler(MSG_NOTIFY_UPDATA_PIC, 0);
                Log.i(TAG, "----mMainAtyReceiver   SerialPortService.ACTION_MAIN_UPDATA_PIC");
            } else if (SerialPortService.ACTION_MAIN_UPDATA.equals(action)) {
                Log.i(TAG, "----mMainAtyReceiver   SerialPortService.ACTION_MAIN_UPDATA");

                CmdSerialInfo cmdSerialInfo = intent.getParcelableExtra(ProtocolDeal.CMD_SERIAL_INFO_KEY);
                if (cmdSerialInfo != null){
                    //mCmdExcute.CmdDeal(cmdSerialInfo, context);
                    Log.i(TAG, "----mMainAtyReceiver   SerialPortService.ACTION_MAIN_UPDATA-----cmdSerialInfo");
                    mMyViewManager.CmdDeal(cmdSerialInfo);
                }



//                ************************
//                mTvtst.setText("TSTi="+testi);//if mod by this way, is sucess.
//                ************************

//                sendMsgToMainHandler(MSG_NOTIFY_UPDATA_PIC, cmdSerialInfo, 0);

            }
        }
    };
    /////////////////////////////////////////////////----end




    /*-------------------------------------------------
        bind SerialPortService --------start
    -------------------------------------------------*/
    private SerialPortService mSerialPortService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "-----------------onServiceConnected--*********************");

            mSerialPortService = ((SerialPortService.LocalBinder) service).getService();
            if(mSerialPortService != null){
                Log.i(TAG, "---------SerialPortService  ok- ");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mSerialPortService = null;
        }
    };
    /////////////////////////////////////////////////----end





    /*-------------------------------------------------
        ui thread handler function, send msg to ui thread --------start
    -------------------------------------------------*/
    private void sendMsgToMainHandler(int msgwhat, int msgDelay) {

        Message msgMain = mHandler.obtainMessage();
        msgMain.what = msgwhat;
        if (msgDelay == 0) {
            mHandler.sendMessage(msgMain);
        } else {
            mHandler.sendMessageDelayed(msgMain, msgDelay);
        }
    }
    private void sendMsgToMainHandler(int msgwhat, CmdSerialInfo msgCmdSerialInfo, int msgDelay) {
        Message msgMain = mHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ProtocolDeal.CMD_SERIAL_INFO_KEY,msgCmdSerialInfo);
        msgMain.setData(bundle);
        msgMain.what = msgwhat;
        if (msgDelay == 0) {
            mHandler.sendMessage(msgMain);
        } else {
            mHandler.sendMessageDelayed(msgMain, msgDelay);
        }
    }
    /////////////////////////////////////////////////----end




    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
        mSerialPortService = null;

        if (mMainAtyReceiver != null){
            unregisterReceiver(mMainAtyReceiver);
        }
/*
        if(mHandler != null) {
            mHandler.getLooper().quit();
        }
*/

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
//
//    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
}
