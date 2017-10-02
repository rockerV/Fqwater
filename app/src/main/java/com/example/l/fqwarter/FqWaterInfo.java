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

    public final static String SETTINGS_SETTING_NUM = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_NUM";

    public final static String SETTINGS_SETTING_WATER = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_WATER";
    public final static String SETTINGS_SETTING_VOL = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_VOL";
    public final static String SETTINGS_SETTING_LIGHT = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_LIGHT";
    public final static String SETTINGS_SETTING_STRONG = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_STRONG";
    public final static String SETTINGS_SETTING_RESET = "com.example.l.fqwarter.FqWaterInfo.SETTINGS_SETTING_RESET";



    public final static int VAL_DEFAULT_PIC_NUM = 1;
    public final static int VAL_DEFAULTDATA = 0;

    public final static int VAL_DEFAULT_SETTING_NUM = 1;
    public final static int VAL_DEFAULT_SETTING_DATA = 1;


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
    public int val_setting5_reset;


    public FqWaterInfo(Context context){
        mContext = context;
        mStorageDataFq = new StorageData(context);

        val_pic_num = getInitialIntMembers(SETTINGS_PIC, VAL_DEFAULT_PIC_NUM);
        val_flow_data1 = getInitialIntMembers(SETTINGS_FLOW_DATA1, VAL_DEFAULTDATA);
        val_flow_data2 = getInitialIntMembers(SETTINGS_FLOW_DATA2, VAL_DEFAULTDATA);

        val_filter1_data1 = getInitialIntMembers(SETTINGS_FILTER1_DATA1, VAL_DEFAULTDATA);
        val_filter1_data2 = getInitialIntMembers(SETTINGS_FILTER1_DATA2, VAL_DEFAULTDATA);

        val_filter2_data1 = getInitialIntMembers(SETTINGS_FILTER2_DATA1, VAL_DEFAULTDATA);
        val_filter2_data2 = getInitialIntMembers(SETTINGS_FILTER2_DATA2, VAL_DEFAULTDATA);

        val_filter3_data1 = getInitialIntMembers(SETTINGS_FILTER3_DATA1, VAL_DEFAULTDATA);
        val_filter3_data2 = getInitialIntMembers(SETTINGS_FILTER3_DATA2, VAL_DEFAULTDATA);

        val_ph_data1 = getInitialIntMembers(SETTINGS_PH_DATA1, VAL_DEFAULTDATA);
        val_ph_data2 = getInitialIntMembers(SETTINGS_PH_DATA2, VAL_DEFAULTDATA);

        val_orp_data1 = getInitialIntMembers(SETTINGS_ORP_DATA1, VAL_DEFAULTDATA);
        val_orp_data2 = getInitialIntMembers(SETTINGS_ORP_DATA2, VAL_DEFAULTDATA);

        val_setting_num = getInitialIntMembers(SETTINGS_SETTING_NUM, VAL_DEFAULT_SETTING_NUM);
        val_setting1_water = getInitialIntMembers(SETTINGS_SETTING_WATER, VAL_DEFAULT_SETTING_DATA);
        val_setting2_vol = getInitialIntMembers(SETTINGS_SETTING_VOL, VAL_DEFAULT_SETTING_DATA);
        val_setting3_light = getInitialIntMembers(SETTINGS_SETTING_LIGHT, VAL_DEFAULT_SETTING_DATA);
        val_setting4_strong = getInitialIntMembers(SETTINGS_SETTING_STRONG, VAL_DEFAULT_SETTING_DATA);
        val_setting5_reset = getInitialIntMembers(SETTINGS_SETTING_RESET, VAL_DEFAULT_SETTING_DATA);
    }

    private int getInitialIntMembers(String key, int valDefault){
        int val;
        val = mStorageDataFq.ReadInt(key);
        if (val == mStorageDataFq.NOT_INIT_VAL_INT){
            val = valDefault;
            mStorageDataFq.WriteInt(key, val);
        }
        return val;
    }

    public int getVal_pic_num() {
        return val_pic_num;
    }

    public int getVal_flow_data1() {
        return val_flow_data1;
    }

    public int getVal_flow_data2() {
        return val_flow_data2;
    }

    public int getVal_filter1_data1() {
        return val_filter1_data1;
    }

    public int getVal_filter1_data2() {
        return val_filter1_data2;
    }

    public int getVal_filter2_data1() {
        return val_filter2_data1;
    }

    public int getVal_filter2_data2() {
        return val_filter2_data2;
    }

    public int getVal_filter3_data1() {
        return val_filter3_data1;
    }

    public int getVal_filter3_data2() {
        return val_filter3_data2;
    }

    public int getVal_ph_data1() {
        return val_ph_data1;
    }

    public int getVal_ph_data2() {
        return val_ph_data2;
    }

    public int getVal_orp_data1() {
        return val_orp_data1;
    }

    public int getVal_orp_data2() {
        return val_orp_data2;
    }

    public int getVal_setting_num() {
        return val_setting_num;
    }

    public int getVal_setting1_water() {
        return val_setting1_water;
    }

    public int getVal_setting2_vol() {
        return val_setting2_vol;
    }

    public int getVal_setting3_light() {
        return val_setting3_light;
    }

    public int getVal_setting4_strong() {
        return val_setting4_strong;
    }

    public int getVal_setting5_reset() {
        return val_setting5_reset;
    }

    public void setVal_pic_num(int val_pic_num) {
        this.val_pic_num = val_pic_num;
        mStorageDataFq.WriteInt(SETTINGS_PIC, val_pic_num);
    }

    public void setVal_flow_data1(int val_flow_data1) {
        this.val_flow_data1 = val_flow_data1;
        mStorageDataFq.WriteInt(SETTINGS_FLOW_DATA1, val_flow_data1);
    }

    public void setVal_flow_data2(int val_flow_data2) {
        this.val_flow_data2 = val_flow_data2;
        mStorageDataFq.WriteInt(SETTINGS_FLOW_DATA2, val_flow_data2);
    }

    public void setVal_filter1_data1(int val_filter1_data1) {
        this.val_filter1_data1 = val_filter1_data1;
        mStorageDataFq.WriteInt(SETTINGS_FILTER1_DATA1, val_filter1_data1);
    }

    public void setVal_filter1_data2(int val_filter1_data2) {
        this.val_filter1_data2 = val_filter1_data2;
        mStorageDataFq.WriteInt(SETTINGS_FILTER1_DATA2, val_filter1_data2);
    }

    public void setVal_filter2_data1(int val_filter2_data1) {
        this.val_filter2_data1 = val_filter2_data1;
        mStorageDataFq.WriteInt(SETTINGS_FILTER2_DATA1, val_filter2_data1);
    }

    public void setVal_filter2_data2(int val_filter2_data2) {
        this.val_filter2_data2 = val_filter2_data2;
        mStorageDataFq.WriteInt(SETTINGS_FILTER2_DATA2, val_filter2_data2);
    }

    public void setVal_filter3_data1(int val_filter3_data1) {
        this.val_filter3_data1 = val_filter3_data1;
        mStorageDataFq.WriteInt(SETTINGS_FILTER3_DATA1, val_filter3_data1);
    }

    public void setVal_filter3_data2(int val_filter3_data2) {
        this.val_filter3_data2 = val_filter3_data2;
        mStorageDataFq.WriteInt(SETTINGS_FILTER3_DATA2, val_filter3_data2);
    }

    public void setVal_ph_data1(int val_ph_data1) {
        this.val_ph_data1 = val_ph_data1;
        mStorageDataFq.WriteInt(SETTINGS_PH_DATA1, val_ph_data1);
    }

    public void setVal_ph_data2(int val_ph_data2) {
        this.val_ph_data2 = val_ph_data2;
        mStorageDataFq.WriteInt(SETTINGS_PH_DATA2, val_ph_data2);
    }

    public void setVal_orp_data1(int val_orp_data1) {
        this.val_orp_data1 = val_orp_data1;
        mStorageDataFq.WriteInt(SETTINGS_ORP_DATA1, val_orp_data1);
    }

    public void setVal_orp_data2(int val_orp_data2) {
        this.val_orp_data2 = val_orp_data2;
        mStorageDataFq.WriteInt(SETTINGS_ORP_DATA2, val_orp_data2);
    }

    public void setVal_setting_num(int val_setting_num) {
        this.val_setting_num = val_setting_num;
        mStorageDataFq.WriteInt(SETTINGS_SETTING_NUM, val_setting_num);
    }

    public void setVal_setting1_water(int val_setting1_water) {
        this.val_setting1_water = val_setting1_water;
        mStorageDataFq.WriteInt(SETTINGS_SETTING_WATER, val_setting1_water);
    }

    public void setVal_setting2_vol(int val_setting2_vol) {
        this.val_setting2_vol = val_setting2_vol;
        mStorageDataFq.WriteInt(SETTINGS_SETTING_VOL, val_setting2_vol);
    }

    public void setVal_setting3_light(int val_setting3_light) {
        this.val_setting3_light = val_setting3_light;
        mStorageDataFq.WriteInt(SETTINGS_SETTING_LIGHT, val_setting3_light);
    }

    public void setVal_setting4_strong(int val_setting4_strong) {
        this.val_setting4_strong = val_setting4_strong;
        mStorageDataFq.WriteInt(SETTINGS_SETTING_STRONG, val_setting4_strong);
    }

    public void setVal_setting5_reset(int val_setting5_reset) {
        this.val_setting5_reset = val_setting5_reset;
        mStorageDataFq.WriteInt(SETTINGS_SETTING_RESET, val_setting5_reset);
    }
}
