package com.example.l.fqwarter.protocol;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.l.fqwarter.R;

/**
 * Created by L on 2017/7/13.
 */

public class CmdExcute {

    private final static String TAG = "CmdExcute";

//    main layout
    private FrameLayout mMainAtyLayout;
//    background layout
    private RelativeLayout mLayoutBackground;
    private ImageView mCommon1ImgBlueBackground;
    private ImageView mCommon1ImgWaterAnim;
    private ImageView mCommon1SettingImgBackground;

    private TextView mCommon1TxtTime;


    private Context mContext;
    public CmdExcute(Context context){
        mContext = context;

    }

    public void CmdDeal(CmdSerialInfo cmdSerialInfo, Context context){
        switch (cmdSerialInfo.getHeader()){
            case ProtocolDeal.CHANGE_PIC_HEAD:
                DoPicChange(cmdSerialInfo, context);
                break;
        }
    }

    private void DoPicChange(CmdSerialInfo cmdSerialInfo, Context context){

        mContext = context;
        mMainAtyLayout = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.activity_main,null);
        mLayoutBackground = (RelativeLayout) mMainAtyLayout.findViewById(R.id.layoutWorkBackground);
        mCommon1ImgBlueBackground = (ImageView) mMainAtyLayout.findViewById(R.id.common1ImgBlueBackground);
        mCommon1TxtTime = (TextView) mMainAtyLayout.findViewById(R.id.common1TxtTime);

        Log.d(TAG, "DoPicChange cmdSerialInfo.getHeader()=" + String.format("%04x", cmdSerialInfo.getHeader()));
        mLayoutBackground.setVisibility(View.INVISIBLE);
        mCommon1ImgBlueBackground.setVisibility(View.INVISIBLE);
        mCommon1TxtTime.setVisibility(View.INVISIBLE);

        mCommon1TxtTime.setText("sdf");
    }

    private Drawable GetBackgroundDrawable(int picNum){

        String imgName = "" + picNum;
        int resId = mContext.getResources().getIdentifier(imgName, "drawable", mContext.getPackageName());
        Drawable drawable = mContext.getResources().getDrawable(resId);

        return drawable;
    }
}
