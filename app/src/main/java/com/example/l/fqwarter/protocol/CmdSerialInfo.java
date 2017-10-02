package com.example.l.fqwarter.protocol;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by L on 2017/7/1.
 */

public class CmdSerialInfo implements Parcelable {

    public int header;
    public int data1;
    public int data2;
    public int checksum;
    public int end;

    public CmdSerialInfo(){

    }

    public CmdSerialInfo(int header, int data1, int data2, int checksum, int end) {
        this.header = header;
        this.data1 = data1;
        this.data2 = data2;
        this.checksum = checksum;
        this.end = end;
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    public int getChecksum() {
        return checksum;
    }

    public void setChecksum(int checksum) {
        this.checksum = checksum;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.header);
        dest.writeInt(this.data1);
        dest.writeInt(this.data2);
        dest.writeInt(this.checksum);
        dest.writeInt(this.end);
    }

    protected CmdSerialInfo(Parcel in) {
        this.header = in.readInt();
        this.data1 = in.readInt();
        this.data2 = in.readInt();
        this.checksum = in.readInt();
        this.end = in.readInt();
    }

    public static final Parcelable.Creator<CmdSerialInfo> CREATOR = new Parcelable.Creator<CmdSerialInfo>() {
        @Override
        public CmdSerialInfo createFromParcel(Parcel source) {
            return new CmdSerialInfo(source);
        }

        @Override
        public CmdSerialInfo[] newArray(int size) {
            return new CmdSerialInfo[size];
        }
    };
}
