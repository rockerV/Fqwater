package com.example.l.fqwarter.myutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by L on 2017/9/24.
 */

public class StorageData {

    private static final String TAG = "StorageData";

    public final static String FQ_SHARE_PREFERENCES = "com.example.l.fqwarter.myutils.StorageData.FQ_SHARE_PREFERENCES";

    public final static String KEY_WORK_PIC_STATUS = "com.example.l.fqwarter.myutils.StorageData.KEY_WORK_PIC_STATUS";

    public final static int NOT_INIT_VAL_INT = -1;
    public final static String NOT_INIT_VAL_STRING = "Default";



    private Context mContex;
    private SharedPreferences mSharepref;

    public StorageData(Context context){
        mContex = context;
        mSharepref = mContex.getSharedPreferences(FQ_SHARE_PREFERENCES,Context.MODE_PRIVATE);
    }

    public void WriteString(String key, String val){
        SharedPreferences.Editor editor = mSharepref.edit();
        editor.putString(key, val);
        editor.commit();
    }

    public String ReadString(String key){
        return mSharepref.getString(key, NOT_INIT_VAL_STRING);
    }


    public void WriteInt(String key, int val){
        SharedPreferences.Editor editor = mSharepref.edit();
        editor.putInt(key, val);
        editor.commit();
        Log.i(TAG, "write key=" + key + ",  val=" + val);
    }

    public int ReadInt(String key){

        int val = mSharepref.getInt(key, NOT_INIT_VAL_INT);
        Log.i(TAG,"read key="+key+", --- val="+val);
        return val;
    }


    public void RemoveItem(String key){
        SharedPreferences.Editor editor = mSharepref.edit();
        editor.remove(key);
        editor.commit();
    }


}
