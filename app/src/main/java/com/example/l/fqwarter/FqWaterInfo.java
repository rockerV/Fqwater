package com.example.l.fqwarter;

import android.app.Application;
import android.content.Context;

import com.example.l.fqwarter.myutils.StorageData;

/**
 * Created by L on 2017/9/24.
 */

public class FqWaterInfo extends Application{

    private static final String TAG = "FqWaterInfo";
    private Context mContext;
    private StorageData mStorageDataFq;


    public final static String SETTINGS_PIC = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_PIC";
    public final static String SETTINGS_FLOW_DATA1 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FLOW_DATA1";
    public final static String SETTINGS_FLOW_DATA2 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FLOW_DATA2";
    public final static String SETTINGS_FILTER1_DATA1 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FILTER1_DATA1";
    public final static String SETTINGS_FILTER1_DATA2 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FILTER1_DATA2";
    public final static String SETTINGS_FILTER2_DATA1 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FILTER2_DATA1";
    public final static String SETTINGS_FILTER2_DATA2 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FILTER2_DATA2";
    public final static String SETTINGS_FILTER3_DATA1 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FILTER3_DATA1";
    public final static String SETTINGS_FILTER3_DATA2 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_FILTER3_DATA2";
    public final static String SETTINGS_PH_DATA1 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_PH_DATA1";
    public final static String SETTINGS_PH_DATA2 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_PH_DATA2";
    public final static String SETTINGS_ORP_DATA1 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_ORP_DATA1";
    public final static String SETTINGS_ORP_DATA2 = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_ORP_DATA2";
    public final static String SETTINGS_SETTING_WATER = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_WATER";
    public final static String SETTINGS_SETTING_VOL = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_VOL";
    public final static String SETTINGS_SETTING_LIGHT = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_LIGHT";
    public final static String SETTINGS_SETTING_STRONG = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_STRONG";
    public final static String SETTINGS_SETTING_RESET = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_RESET";



    public final static int VAL_DEFAULT_PIC_NUM = 1;
    public final static int VAL_DEFAULT_FLOW_DATA1 = 0;
    public final static int VAL_DEFAULT_FLOW_DATA2 = 0;
    public final static int VAL_DEFAULT_PH_DATA1 = 0;
    public final static int VAL_DEFAULT_PH_DATA2 = 0;
    public final static int VAL_DEFAULT_ORP_DATA1 = 0;
    public final static int VAL_DEFAULT_ORP_DATA2 = 0;

    public final static int VAL_DEFAULT_SETTING_NUM = 1;
    public final static int VAL_DEFAULT_SETTING1_WATER = 1;
    public final static int VAL_DEFAULT_SETTING2_VOL = 1;
    public final static int VAL_DEFAULT_SETTING3_LIGHT = 1;
    public final static int VAL_DEFAULT_SETTING4_STRONG = 1;
    public final static int VAL_DEFAULT_SETTING5_RESET = 1;


    public int val_pic_num;
    public int val_flow_data1;
    public int val_flow_data2;

    public int val_filter1_data1;
    public int val_filter1_data2;

    public int val_filter2_data1;
    public int val_filter2_data2;

    public int val_filter3_data1;
    public int val_filter3_data2;

    public int val_ph_data1;
    public int val_ph_data2;

    public int val_orp_data1;
    public int val_orp_data2;

    public int val_setting_num;
    public int val_setting1_water;
    public int val_setting2_vol;
    public int val_setting3_light;
    public int val_setting4_strong;
    public int val_setting4_reset;


    public FqWaterInfo(Context context){
        mContext = context;
        mStorageDataFq = new StorageData(context);
    }


}
