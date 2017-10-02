package com.example.l.fqwarter.protocol;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2017/6/30.
 */

public class ProtocolDeal {

    private final static String TAG = "ProtocolDeal";

    private final static int CMD_INDEX_HEAD = 0;
    private final static int CMD_INDEX_DATA1 = 1;
    private final static int CMD_INDEX_DATA2 = 2;
    private final static int CMD_INDEX_CHECKSUM = 3;
    private final static int CMD_INDEX_END = 4;

    private final static int VALID_ONE_CMD_LEN = 5;
    private final static int VALID_CMD_MAX_LEN = 10;
    //change picture
    public final static int CHANGE_PIC_HEAD = 0x89;
    public final static int CHANGE_PIC_END = 0x98;
    public final static int CHANGE_PIC_DATA2_1_SIMPLE_WATER = 1;
    public final static int CHANGE_PIC_DATA2_2_CLEAN_WATER = 2;
    public final static int CHANGE_PIC_DATA2_3_OUTSIDE_WATER = 3;
    public final static int CHANGE_PIC_DATA2_4_REDUCE_WATER_WEAK = 4;
    public final static int CHANGE_PIC_DATA2_5_REDUCE_WATER_NORMAL = 5;
    public final static int CHANGE_PIC_DATA2_6_REDUCE_WATER_STRONG = 6;
    public final static int CHANGE_PIC_DATA2_7_SETTING1_WATER = 7;
    public final static int CHANGE_PIC_DATA2_8_SETTING2_VOL = 8;
    public final static int CHANGE_PIC_DATA2_9_WASH_WATER1 = 9;
    public final static int CHANGE_PIC_DATA2_10_WASH_WATER2 = 10;
    public final static int CHANGE_PIC_DATA2_11_SETTING6_RESET = 11;
    public final static int CHANGE_PIC_DATA2_12_SETTING5_STRONG = 12;
    public final static int CHANGE_PIC_DATA2_13_SETTING3_LIGHT = 13;
    public final static int CHANGE_PIC_DATA2_14_WASH_WATER3 = 14;
    public final static int CHANGE_PIC_DATA2_15_SETTING4_ADVERT = 15;



    //flow data
    public final static int CHANGE_FLOW_HEAD = 0x56;
    public final static int CHANGE_FLOW_END = 0x65;

    //filter1 data
    public final static int CHANGE_FILTER1_HEAD = 0x12;
    public final static int CHANGE_FILTER1_END = 0x21;

    //filter2 data
    public final static int CHANGE_FILTER2_HEAD = 0x23;
    public final static int CHANGE_FILTER2_END = 0x32;

    //filter3 data
    public final static int CHANGE_FILTER3_HEAD = 0x34;
    public final static int CHANGE_FILTER3_END = 0x43;

    //PH data
    public final static int CHANGE_PH_HEAD = 0xa3;
    public final static int CHANGE_PH_END = 0x3a;

    //ORP data
    public final static int CHANGE_ORP_HEAD = 0xba;
    public final static int CHANGE_ORP_END = 0xab;

    //play vedio
    public final static int CHANGE_PLAYER_HEAD = 0xcd;
    public final static int CHANGE_PLAYER_END = 0xdc;

    //setting ----------------------------------------------
    public final static int CHANGE_SETTING_HEAD = 0xde;
    public final static int CHANGE_SETTING_END = 0xed;
    public final static int CHANGE_SETTING_DATA1_WATER = 1;
    public final static int CHANGE_SETTING_DATA1_VOL = 2;
    public final static int CHANGE_SETTING_DATA1_LIGHT = 3;
    public final static int CHANGE_SETTING_DATA1_STRONG = 4;
    public final static int CHANGE_SETTING_DATA1_RESET = 5;





    //host-if data
    public final static String CMD_SERIAL_INFO_KEY = "com.example.l.fqwarter.protocol.CMD_SERIAL_INFO_KEY";

    public static int[] mProtocolHeadGrp = {CHANGE_PIC_HEAD, CHANGE_FLOW_HEAD, CHANGE_FILTER1_HEAD,
            CHANGE_FILTER2_HEAD, CHANGE_FILTER3_HEAD, CHANGE_PH_HEAD, CHANGE_ORP_HEAD, CHANGE_PLAYER_HEAD,
            CHANGE_SETTING_HEAD};
    public static int[] mProtocolEndGrp = {CHANGE_PIC_END, CHANGE_FLOW_END, CHANGE_FILTER1_END,
            CHANGE_FILTER2_END, CHANGE_FILTER3_END, CHANGE_PH_END, CHANGE_ORP_END, CHANGE_PLAYER_END,
            CHANGE_SETTING_END};


    //static method
    private static boolean checkHeader(int val) {
        for(int searchVal:mProtocolHeadGrp){
            if(val == searchVal){
                return true;
            }
        }
        return false;
    }

    private static boolean checkEnd(int val) {
        for(int searchVal:mProtocolEndGrp){
            if(val == searchVal){
                return true;
            }
        }
        return false;
    }

    private static boolean checkHeaderAndEnd(int head, int end) {

        for(int i=0; i<mProtocolHeadGrp.length; i++){
            if(head == mProtocolHeadGrp[i]){
                return (mProtocolEndGrp[i] == end);
            }
        }
        return false;
    }

    private static boolean checkChecksum(List<Integer> listIn, int startIndex, int endIndex) {

        int chksum;

        if (listIn.size() <= startIndex || listIn.size() <= endIndex
                || endIndex <= startIndex) {
            throw new NullPointerException();
        }
        chksum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            chksum += listIn.get(i);
        }
        chksum &= 0xff;
        return (chksum == listIn.get(endIndex));
    }

    private boolean checkCmdAll(List<Integer> listIn, int startIndex, int endIndex) {

        if (!checkHeaderAndEnd(listIn.get(startIndex), listIn.get(endIndex))) {
            return false;
        }

        if (!checkChecksum(listIn, startIndex+1, endIndex - 1)) {
            return false;
        }

        return true;
    }


    private ArrayList<Integer> mArrayListCmd;

    public ProtocolDeal() {
        mArrayListCmd = new ArrayList<Integer>();
    }


    public void setCmdBytes(byte[] buffer, int size) {

        if (mArrayListCmd == null) {
            mArrayListCmd = new ArrayList<Integer>();
        }

        for (int i = 0; i < size; i++) {
            mArrayListCmd.add(new Integer((int) (buffer[i] & 0xff)));
        }
    }

    public CmdSerialInfo outputCmdInfoNear() {

        int i;

        if (mArrayListCmd == null) {
            throw new NullPointerException();
        }

        Log.i(TAG, "outputCmdInfoNear------in:" + mArrayListCmd.toString());

        i = 0;
        while (i < mArrayListCmd.size()) {
            //check end
            if (!checkEnd(mArrayListCmd.get(i))) {
                i++;
                continue;
            }
            //check if endindex is valid
            if (i < VALID_ONE_CMD_LEN - 1) {
                for (int j = 0; j < i + 1; j++) {
                    mArrayListCmd.remove(j);
                }
                i = 0;
                continue;
            }
            //check if all bytes is valid
            if (!checkCmdAll(mArrayListCmd, i + 1 - VALID_ONE_CMD_LEN, i)) {
                i++;
                continue;
            }

            //check ok, get one infomation and return
            CmdSerialInfo cmdSerialInfo = new CmdSerialInfo(mArrayListCmd.get(i + 1 - VALID_ONE_CMD_LEN + CMD_INDEX_HEAD),
                    mArrayListCmd.get(i + 1 - VALID_ONE_CMD_LEN + CMD_INDEX_DATA1),
                    mArrayListCmd.get(i + 1 - VALID_ONE_CMD_LEN + CMD_INDEX_DATA2),
                    mArrayListCmd.get(i + 1 - VALID_ONE_CMD_LEN + CMD_INDEX_CHECKSUM),
                    mArrayListCmd.get(i + 1 - VALID_ONE_CMD_LEN + CMD_INDEX_END));
            for (int j = 0; j < i + 1; j++) {
                mArrayListCmd.remove(0);
            }

            //return OK. Valid info
            Log.i(TAG, "outputCmdInfoNear--ok----out:" + mArrayListCmd.toString());
            Log.i(TAG, String.format("Return OK*****CmdSerialInfo:[0]=%x, [1]=%x, [2]=%x, [3]=%x, [4]=%x",
                    cmdSerialInfo.header, cmdSerialInfo.data1, cmdSerialInfo.data2,
                    cmdSerialInfo.checksum, cmdSerialInfo.end));

            return cmdSerialInfo;

        }

        //if too long, del some
        if (mArrayListCmd.size() > VALID_CMD_MAX_LEN) {
            for (int j = 0; j < VALID_ONE_CMD_LEN; j++) {
                mArrayListCmd.remove(j);
            }
        }

        Log.i(TAG, "outputCmdInfoNear---fail---out:" + mArrayListCmd.toString());
        return null;

    }


}
