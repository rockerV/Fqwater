package com.example.l.fqwarter;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.l.fqwarter.myutils.FullScreenVideoView;
import com.example.l.fqwarter.myutils.MyAnimationDrawable;
import com.example.l.fqwarter.protocol.CmdSerialInfo;
import com.example.l.fqwarter.protocol.FqWaterInfo;
import com.example.l.fqwarter.protocol.ProtocolDeal;

import org.w3c.dom.Text;

/**
 * Created by L on 2017/8/27.
 */

public class MyViewManager {
    View mView;
    Context mContext;

    int mPicNum;
    FqWaterInfo mFqWaterInfo;

    private FullScreenVideoView mVideoView;
    private Uri mUri;

    TextView mTvTst;

//    <!--background layout-->
    RelativeLayout mRlBackground;
    ImageView mCommon1BlueBackground;
    ImageView mCommon1WarterAni;
    ImageView mCommon1SettingBackground;

//    <!--All common use(work and setting) layout=============-->
    RelativeLayout mRlCommonAll;
    TextView mcommon1TxtTime;
    ImageView mcommon1ImgWifiStatus;
    ImageView mcommon1ImgVolStatus;
    ImageView mcommon1ImgMute;
    ImageView mcommon1ImgSplit;
    ImageView common1ImgLogo;

//    <!--work mode common use layout=============-->=======================================================================
    RelativeLayout mRlWorkHolder;
//    <!--common 1 use-->
    ImageView mcommon1ImgWaterSpeed;
    ImageView mcommon1ImgWaterBackground;
    ImageView mcommon1ImgWaterRoll;
    ImageView mcommon1ImgWaterMan;
//    <!--common 2 use=================-->
    TextView mcommon2TxtPH;
    TextView mcommon2TxtWaterSpeedTitle;
    TextView mcommon2TxtORP;
    TextView mcommon2TxtAge;
    TextView mcommon2TxtWaterSpeedVal;
//    <!--common 3 use=================-->
    TextView mcommon3TxtAge1Title;
    TextView mcommon3TxtAge2Title;
    TextView mcommon3TxtAge3Title;
    ImageView common3ImgAge1;
    ImageView mcommon3ImgAge2;
    ImageView mcommon3ImgAge3;
    TextView mcommon3TxtAge1Val;
    TextView mcommon3TxtAge2Val;
    TextView mcommon3TxtAge3Val;

//    <!--outside water layout-->
    RelativeLayout mRlOutsideWater;
    TextView moutsideWaterTxtTitle;
    ImageView moutsideWaterImgMain;
    ImageView moutsideWaterImgBeauty;
    ImageView moutsideWaterImgWashCup;
    TextView moutsideWaterTxtBeauty;
    TextView moutsideWaterTxtWashCup;

//    <!--reduce water layout-->
    RelativeLayout mRlReduceWater;
    TextView mreduceWaterTxtTitle;
    ImageView mreduceWaterImgMain;
//    <!--strong-->
    RelativeLayout mlayoutReduceWaterStrong;
    ImageView mreduceWaterStrongImgCookRice;
    ImageView mreduceWaterStrongImgCookSoup;
    ImageView mreduceWaterStrongImgCooking;
    ImageView mreduceWaterStrongImgWashFruit;
    TextView mreduceWaterStrongTxtCookRice;
    TextView mreduceWaterStrongTxtCookSoup;
    TextView mreduceWaterStrongTxtCooking;
    TextView mreduceWaterStrongTxtWashFruit;
    ImageView mreduceWaterStrongImgLevWeakNotSel;
    ImageView mreduceWaterStrongImgLevNormalNotSel;
    ImageView mreduceWaterStrongImgLevStrongSel;
//    <!--weak-->
    RelativeLayout mlayoutReduceWaterWeak;
    ImageView mreduceWaterWeakImgDrink;
    TextView mreduceWaterWeakTxtDrink;
    ImageView mreduceWaterWeakImgLevWeakSel;
    ImageView mreduceWaterWeakImgLevNormalNotSel;
    ImageView mreduceWaterWeakImgLevStrongNotSel;
//    <!--normal-->
    RelativeLayout mlayoutReduceWaterNormal;
    ImageView mreduceWaterNormalImgDrink;
    ImageView mreduceWaterNormalImgWine;
    ImageView mreduceWaterNormalImgTea;
    TextView mreduceWaterNormalTxtDrink;
    TextView mreduceWaterNormalTxtWine;
    TextView mreduceWaterNormalTxtTea;
    ImageView mreduceWaterNormalImgLevWeakNotSel;
    ImageView mreduceWaterNormalImgLevNormalSel;
    ImageView mreduceWaterNormalImgLevStrongNotSel;

//    <!--clean water-->
    RelativeLayout mRlCleanWater;
    TextView mcleanWaterTxtTitle;
    ImageView mcleanWaterImgMain;
    ImageView mcleanWaterImgMilk;
    ImageView mcleanWaterImgMedicine;
    TextView mcleanWaterTxtMilk;
    TextView mcleanWaterTxtMedicine;

//    <!--wash water-->
    RelativeLayout mRlWashWater;
    TextView mwashWaterTxtTitle;
    ImageView mwashWaterImgMain;
    TextView mwashWaterTxtSecVal;
    TextView mwashWaterTxtSecTitle;

//    <!--simple water-->
    RelativeLayout mRlSimpleWater;
    TextView msimpleWaterTxtTitle;
    ImageView msimpleWaterImgMain;
    ImageView msimpleWaterImgDrink;
    ImageView msimpleWaterImgH2;
    ImageView msimpleWaterImgSupplyWater;
    TextView msimpleWaterTxtDrink;
    TextView msimpleWaterTxtH2;
    TextView msimpleWaterTxtSupplyWater;

//    <!--setting Holder-->=======================================================================
    RelativeLayout mRlSettingHolder;

//    <!--setting common-->
    RelativeLayout mlayoutSettingCommon;
    ImageView msettingCommonImgMain;
    ImageView msettingCommonImgSplit;
    ImageView msettingCommonImgClickIcon;
    TextView msettingCommonTxtPress;
    ImageView msettingCommonImgFuncWater;
    ImageView msettingCommonImgFuncVol;
    ImageView msettingCommonImgFuncLight;
    ImageView msettingCommonImgFuncAdvert;
    ImageView msettingCommonImgFuncStrong;
    ImageView msettingCommonImgFuncReset;

//    <!--setting 1 water-->
    RelativeLayout mlayoutSetting1Water;
    ImageView msetting1WaterImgMain;
    ImageView msetting1WaterImgFuncSel;
    ImageView msetting1WaterImg10sNotSel;
    ImageView msetting1WaterImg10sSel;
    ImageView msetting1WaterImg30sNotSel;
    ImageView msetting1WaterImg30sSel;
    ImageView msetting1WaterImg1minNotSel;
    ImageView msetting1WaterImg1minSel;
    ImageView msetting1WaterImg30minNotSel;
    ImageView msetting1WaterImg30minSel;

//    <!--setting 2 vol-->
    RelativeLayout mlayoutSetting2Vol;
    ImageView msetting2VolImgMain;
    ImageView msetting2VolImgFuncSel;
    ImageView msetting2VolMuteImg;
    ImageView msetting2VolMaxImg;
    TextView msetting2VolTxtMute;
    TextView msetting2VolTxtMax;

//    <!--setting 3 light-->
    RelativeLayout mlayoutSetting3Light;
    ImageView msetting3LightImgMain;
    ImageView msetting3LightImgFuncSel;
    ImageView msetting3LightMinImg;
    ImageView msetting3LightMaxImg;
    TextView msetting3LightTxtMin;
    TextView msetting3LightTxtMax;

//    <!--setting 4 advert-->
    RelativeLayout mlayoutSetting4Advert;
    ImageView msetting4AdvertImgMain;
    ImageView msetting4AdvertImgFuncSel;
    ImageView msetting4AdvertImgOpenNotSel;
    ImageView msetting4AdvertImgOpenSel;
    ImageView msetting4AdvertImgCloseNotSel;
    ImageView msetting4AdvertImgCloseSel;

//    <!--setting 5 strong-->
    RelativeLayout mlayoutSetting5Strong;
    ImageView msetting5StrongImgMain;
    ImageView msetting5StrongImgFuncSel;
    ImageView msetting5StrongImgWeakNotSel;
    ImageView msetting5StrongImgWeakSel;
    ImageView msetting5StrongImgMidNotSel;
    ImageView msetting5StrongImgMidSel;
    ImageView msetting5StrongImgStrongNotSel;
    ImageView msetting5StrongImgStrongSel;

//    <!--setting 6 reset-->
    RelativeLayout mlayoutSetting6Reset;
    ImageView msetting6ResetImgMain;
    ImageView msetting6ResetImgFuncSel;
    ImageView msetting6ResetImgLittleSel;
    ImageView msetting6ResetImgMidSel;
    ImageView msetting6ResetImgFullSel;
    TextView msetting6ResetTxtLittleNum;
    TextView msetting6ResetTxtMidNum;
    TextView msetting6ResetTxtFullNum;
    TextView msetting6ResetTxtLittleContent;
    TextView msetting6ResetTxtMidContent;
    TextView msetting6ResetTxtFullContent;
    ImageView msetting6ResetImgLittle;
    ImageView msetting6ResetImgMid;
    ImageView msetting6ResetImgFull;

    public MyViewManager(View view, Context context)
    {
        mView = view;
        mContext = context;

        mFqWaterInfo = new FqWaterInfo(context);

        mTvTst = (TextView) view.findViewById(R.id.common1TxtTime);


        //    <!--background layout-->
        mRlBackground = (RelativeLayout) view.findViewById(R.id.layoutBackground);
        mCommon1BlueBackground = (ImageView) view.findViewById(R.id.common1ImgBlueBackground);
        mCommon1WarterAni = (ImageView) view.findViewById(R.id.common1ImgWaterAnim);
//        mCommon1SettingBackground = (ImageView) view.findViewById(R.id.common1SettingImgBackground);
        MyAnimationDrawable.animateRawManuallyFromXML(R.drawable.circle_back, mCommon1WarterAni, new Runnable() {
            @Override
            public void run() {
                // TODO onStart
                // 动画开始时回调
                Log.d("", "===========================start===========");
            }
        }, new Runnable() {
            @Override
            public void run() {
                // TODO onComplete
                // 动画结束时回调
                Log.d("","=--------------------------end -----=");
            }
        });



//    <!--All common use(work and setting) layout=============-->
        mRlCommonAll = (RelativeLayout) view.findViewById(R.id.layoutCommonAll);
        mcommon1TxtTime = (TextView) view.findViewById(R.id.common1TxtTime);
        mcommon1ImgWifiStatus = (ImageView) view.findViewById(R.id.common1ImgWifiStatus);
        mcommon1ImgVolStatus = (ImageView) view.findViewById(R.id.common1ImgVolStatus);
        mcommon1ImgMute = (ImageView) view.findViewById(R.id.common1ImgMute);
        mcommon1ImgSplit = (ImageView) view.findViewById(R.id.common1ImgSplit);
        common1ImgLogo = (ImageView) view.findViewById(R.id.common1ImgLogo);

//    <!--work mode common use layout=============-->=======================================================================
        mRlWorkHolder = (RelativeLayout) view.findViewById(R.id.layoutWorkHolder);
//    <!--common 1 use-->
        mcommon1ImgWaterSpeed = (ImageView) view.findViewById(R.id.common1ImgWaterSpeed);
        mcommon1ImgWaterBackground = (ImageView) view.findViewById(R.id.common1ImgWaterBackground);
        mcommon1ImgWaterRoll = (ImageView) view.findViewById(R.id.common1ImgWaterRoll);
        mcommon1ImgWaterMan = (ImageView) view.findViewById(R.id.common1ImgWaterMan);
//    <!--common 2 use=================-->
        mcommon2TxtPH = (TextView) view.findViewById(R.id.common2TxtPH);
        mcommon2TxtWaterSpeedTitle = (TextView) view.findViewById(R.id.common2TxtWaterSpeedTitle);
        mcommon2TxtORP = (TextView) view.findViewById(R.id.common2TxtORP);
        mcommon2TxtAge = (TextView) view.findViewById(R.id.common2TxtAge);
        mcommon2TxtWaterSpeedVal = (TextView) view.findViewById(R.id.common2TxtWaterSpeedVal);
//    <!--common 3 use=================-->
        mcommon3TxtAge1Title = (TextView) view.findViewById(R.id.common3TxtAge1Title);
        mcommon3TxtAge2Title = (TextView) view.findViewById(R.id.common3TxtAge2Title);
        mcommon3TxtAge3Title = (TextView) view.findViewById(R.id.common3TxtAge3Title);
        common3ImgAge1 = (ImageView) view.findViewById(R.id.common3ImgAge1);
        mcommon3ImgAge2 = (ImageView) view.findViewById(R.id.common3ImgAge2);
        mcommon3ImgAge3 = (ImageView) view.findViewById(R.id.common3ImgAge3);
        mcommon3TxtAge1Val = (TextView) view.findViewById(R.id.common3TxtAge1Val);
        mcommon3TxtAge2Val = (TextView) view.findViewById(R.id.common3TxtAge2Val);
        mcommon3TxtAge3Val = (TextView) view.findViewById(R.id.common3TxtAge3Val);

        //    <!--outside water layout-->
        mRlOutsideWater = (RelativeLayout) view.findViewById(R.id.layoutOutsideWater);
        moutsideWaterTxtTitle = (TextView) view.findViewById(R.id.outsideWaterTxtTitle);
        moutsideWaterImgMain = (ImageView) view.findViewById(R.id.outsideWaterImgMain);
        moutsideWaterImgBeauty = (ImageView) view.findViewById(R.id.outsideWaterImgBeauty);
        moutsideWaterImgWashCup = (ImageView) view.findViewById(R.id.outsideWaterImgWashCup);
        moutsideWaterTxtBeauty = (TextView) view.findViewById(R.id.outsideWaterTxtBeauty);
        moutsideWaterTxtWashCup = (TextView) view.findViewById(R.id.outsideWaterTxtWashCup);

//    <!--reduce water layout-->
        mRlReduceWater = (RelativeLayout) view.findViewById(R.id.layoutReduceWater);
        mreduceWaterTxtTitle = (TextView) view.findViewById(R.id.reduceWaterTxtTitle);
        mreduceWaterImgMain = (ImageView) view.findViewById(R.id.reduceWaterImgMain);
//    <!--strong-->
        mlayoutReduceWaterStrong = (RelativeLayout) view.findViewById(R.id.layoutReduceWaterStrong);
        mreduceWaterStrongImgCookRice = (ImageView) view.findViewById(R.id.reduceWaterStrongImgCookRice);
        mreduceWaterStrongImgCookSoup = (ImageView) view.findViewById(R.id.reduceWaterStrongImgCookSoup);
        mreduceWaterStrongImgCooking = (ImageView) view.findViewById(R.id.reduceWaterStrongImgCooking);
        mreduceWaterStrongImgWashFruit = (ImageView) view.findViewById(R.id.reduceWaterStrongImgWashFruit);
        mreduceWaterStrongTxtCookRice = (TextView) view.findViewById(R.id.reduceWaterStrongTxtCookRice);
        mreduceWaterStrongTxtCookSoup = (TextView) view.findViewById(R.id.reduceWaterStrongTxtCookSoup);
        mreduceWaterStrongTxtCooking = (TextView) view.findViewById(R.id.reduceWaterStrongTxtCooking);
        mreduceWaterStrongTxtWashFruit = (TextView) view.findViewById(R.id.reduceWaterStrongTxtWashFruit);
        mreduceWaterStrongImgLevWeakNotSel = (ImageView) view.findViewById(R.id.reduceWaterStrongImgLevWeakNotSel);
        mreduceWaterStrongImgLevNormalNotSel = (ImageView) view.findViewById(R.id.reduceWaterStrongImgLevNormalNotSel);
        mreduceWaterStrongImgLevStrongSel = (ImageView) view.findViewById(R.id.reduceWaterStrongImgLevStrongSel);
//    <!--weak-->
        mlayoutReduceWaterWeak = (RelativeLayout) view.findViewById(R.id.layoutReduceWaterWeak);
        mreduceWaterWeakImgDrink = (ImageView) view.findViewById(R.id.reduceWaterWeakImgDrink);
        mreduceWaterWeakTxtDrink = (TextView) view.findViewById(R.id.reduceWaterWeakTxtDrink);
        mreduceWaterWeakImgLevWeakSel = (ImageView) view.findViewById(R.id.reduceWaterWeakImgLevWeakSel);
        mreduceWaterWeakImgLevNormalNotSel = (ImageView) view.findViewById(R.id.reduceWaterWeakImgLevNormalNotSel);
        mreduceWaterWeakImgLevStrongNotSel = (ImageView) view.findViewById(R.id.reduceWaterWeakImgLevStrongNotSel);
//    <!--normal-->
        mlayoutReduceWaterNormal = (RelativeLayout) view.findViewById(R.id.layoutReduceWaterNormal);
        mreduceWaterNormalImgDrink = (ImageView) view.findViewById(R.id.reduceWaterNormalImgDrink);
        mreduceWaterNormalImgWine = (ImageView) view.findViewById(R.id.reduceWaterNormalImgWine);
        mreduceWaterNormalImgTea = (ImageView) view.findViewById(R.id.reduceWaterNormalImgTea);
        mreduceWaterNormalTxtDrink = (TextView) view.findViewById(R.id.reduceWaterNormalTxtDrink);
        mreduceWaterNormalTxtWine = (TextView) view.findViewById(R.id.reduceWaterNormalTxtWine);
        mreduceWaterNormalTxtTea = (TextView) view.findViewById(R.id.reduceWaterNormalTxtTea);
        mreduceWaterNormalImgLevWeakNotSel = (ImageView) view.findViewById(R.id.reduceWaterNormalImgLevWeakNotSel);
        mreduceWaterNormalImgLevNormalSel = (ImageView) view.findViewById(R.id.reduceWaterNormalImgLevNormalSel);
        mreduceWaterNormalImgLevStrongNotSel = (ImageView) view.findViewById(R.id.reduceWaterNormalImgLevStrongNotSel);

//    <!--clean water-->
        mRlCleanWater = (RelativeLayout) view.findViewById(R.id.layoutCleanWater);
        mcleanWaterTxtTitle = (TextView) view.findViewById(R.id.cleanWaterTxtTitle);
        mcleanWaterImgMain = (ImageView) view.findViewById(R.id.cleanWaterImgMain);
        mcleanWaterImgMilk = (ImageView) view.findViewById(R.id.cleanWaterImgMilk);
        mcleanWaterImgMedicine = (ImageView) view.findViewById(R.id.cleanWaterImgMedicine);
        mcleanWaterTxtMilk = (TextView) view.findViewById(R.id.cleanWaterTxtMilk);
        mcleanWaterTxtMedicine = (TextView) view.findViewById(R.id.cleanWaterTxtMedicine);

//    <!--wash water-->
        mRlWashWater = (RelativeLayout) view.findViewById(R.id.layoutWashWater);
        mwashWaterTxtTitle = (TextView) view.findViewById(R.id.washWaterTxtTitle);
        mwashWaterImgMain = (ImageView) view.findViewById(R.id.washWaterImgMain );
        mwashWaterTxtSecVal = (TextView) view.findViewById(R.id.washWaterTxtSecVal);
        mwashWaterTxtSecTitle = (TextView) view.findViewById(R.id.washWaterTxtSecTitle);

//    <!--simple water-->
        mRlSimpleWater = (RelativeLayout) view.findViewById(R.id.layoutSimpleWater);
        msimpleWaterTxtTitle = (TextView) view.findViewById(R.id.simpleWaterTxtTitle);
        msimpleWaterImgMain = (ImageView) view.findViewById(R.id.simpleWaterImgMain);
        msimpleWaterImgDrink = (ImageView) view.findViewById(R.id.simpleWaterImgDrink);
        msimpleWaterImgH2 = (ImageView) view.findViewById(R.id.simpleWaterImgH2);
        msimpleWaterImgSupplyWater = (ImageView) view.findViewById(R.id.simpleWaterImgSupplyWater);
        msimpleWaterTxtDrink = (TextView) view.findViewById(R.id.simpleWaterTxtDrink);
        msimpleWaterTxtH2 = (TextView) view.findViewById(R.id.simpleWaterTxtH2);
        msimpleWaterTxtSupplyWater = (TextView) view.findViewById(R.id.simpleWaterTxtSupplyWater);


//    <!--setting Holder-->=======================================================================
        mRlSettingHolder = (RelativeLayout) view.findViewById(R.id.layoutSettingHolder);

//    <!--setting common-->
        mlayoutSettingCommon = (RelativeLayout) view.findViewById(R.id.layoutSettingCommon);
        msettingCommonImgMain = (ImageView) view.findViewById(R.id.settingCommonImgMain);
        msettingCommonImgSplit = (ImageView) view.findViewById(R.id.settingCommonImgSplit);
        msettingCommonImgClickIcon = (ImageView) view.findViewById(R.id.settingCommonImgClickIcon);
        msettingCommonTxtPress = (TextView) view.findViewById(R.id.settingCommonTxtPress);
        msettingCommonImgFuncWater = (ImageView) view.findViewById(R.id.settingCommonImgFuncWater);
        msettingCommonImgFuncVol = (ImageView) view.findViewById(R.id.settingCommonImgFuncVol);
        msettingCommonImgFuncLight = (ImageView) view.findViewById(R.id.settingCommonImgFuncLight);
        msettingCommonImgFuncAdvert = (ImageView) view.findViewById(R.id.settingCommonImgFuncAdvert);
        msettingCommonImgFuncStrong = (ImageView) view.findViewById(R.id.settingCommonImgFuncStrong);
        msettingCommonImgFuncReset = (ImageView) view.findViewById(R.id.settingCommonImgFuncReset);

//    <!--setting 1 water-->
        mlayoutSetting1Water = (RelativeLayout) view.findViewById(R.id.layoutSetting1Water);
        msetting1WaterImgMain = (ImageView) view.findViewById(R.id.setting1WaterImgMain);
        msetting1WaterImgFuncSel = (ImageView) view.findViewById(R.id.setting1WaterImgFuncSel);
        msetting1WaterImg10sNotSel = (ImageView) view.findViewById(R.id.setting1WaterImg10sNotSel);
        msetting1WaterImg10sSel = (ImageView) view.findViewById(R.id.setting1WaterImg10sSel);
        msetting1WaterImg30sNotSel = (ImageView) view.findViewById(R.id.setting1WaterImg30sNotSel);
        msetting1WaterImg30sSel = (ImageView) view.findViewById(R.id.setting1WaterImg30sSel);
        msetting1WaterImg1minNotSel = (ImageView) view.findViewById(R.id.setting1WaterImg1minNotSel);
        msetting1WaterImg1minSel = (ImageView) view.findViewById(R.id.setting1WaterImg1minSel);
        msetting1WaterImg30minNotSel = (ImageView) view.findViewById(R.id.setting1WaterImg30minNotSel);
        msetting1WaterImg30minSel = (ImageView) view.findViewById(R.id.setting1WaterImg30minSel);

//    <!--setting 2 vol-->
        mlayoutSetting2Vol = (RelativeLayout) view.findViewById(R.id.layoutSetting2Vol);
        msetting2VolImgMain = (ImageView) view.findViewById(R.id.setting2VolImgMain);
        msetting2VolImgFuncSel = (ImageView) view.findViewById(R.id.setting2VolImgFuncSel);
        msetting2VolMuteImg = (ImageView) view.findViewById(R.id.setting2VolMuteImg);
        msetting2VolMaxImg = (ImageView) view.findViewById(R.id.setting2VolMaxImg);
        msetting2VolTxtMute = (TextView) view.findViewById(R.id.setting2VolTxtMute);
        msetting2VolTxtMax = (TextView) view.findViewById(R.id.setting2VolTxtMax);

//    <!--setting 3 light-->
        mlayoutSetting3Light = (RelativeLayout) view.findViewById(R.id.layoutSetting3Light);
        msetting3LightImgMain = (ImageView) view.findViewById(R.id.setting3LightImgMain);
        msetting3LightImgFuncSel = (ImageView) view.findViewById(R.id.setting3LightImgFuncSel);
        msetting3LightMinImg = (ImageView) view.findViewById(R.id.setting3LightMinImg);
        msetting3LightMaxImg = (ImageView) view.findViewById(R.id.setting3LightMaxImg);
        msetting3LightTxtMin = (TextView) view.findViewById(R.id.setting3LightTxtMin);
        msetting3LightTxtMax = (TextView) view.findViewById(R.id.setting3LightTxtMax);

//    <!--setting 4 adbert-->
        mlayoutSetting4Advert = (RelativeLayout) view.findViewById(R.id.layoutSetting4Advert);
        msetting4AdvertImgMain = (ImageView) view.findViewById(R.id.setting4AdvertImgMain);
        msetting4AdvertImgFuncSel = (ImageView) view.findViewById(R.id.setting4AdvertImgFuncSel);
        msetting4AdvertImgOpenNotSel = (ImageView) view.findViewById(R.id.setting4AdvertImgOpenNotSel);
        msetting4AdvertImgOpenSel = (ImageView) view.findViewById(R.id.setting4AdvertImgOpenSel);
        msetting4AdvertImgCloseNotSel = (ImageView) view.findViewById(R.id.setting4AdvertImgCloseNotSel);
        msetting4AdvertImgCloseSel = (ImageView) view.findViewById(R.id.setting4AdvertImgCloseSel);

//    <!--setting 5 strong-->
        mlayoutSetting5Strong = (RelativeLayout) view.findViewById(R.id.layoutSetting5Strong);
        msetting5StrongImgMain = (ImageView) view.findViewById(R.id.setting5StrongImgMain);
        msetting5StrongImgFuncSel = (ImageView) view.findViewById(R.id.setting5StrongImgFuncSel);
        msetting5StrongImgWeakNotSel = (ImageView) view.findViewById(R.id.setting5StrongImgWeakNotSel);
        msetting5StrongImgWeakSel = (ImageView) view.findViewById(R.id.setting5StrongImgWeakSel);
        msetting5StrongImgMidNotSel = (ImageView) view.findViewById(R.id.setting5StrongImgMidNotSel);
        msetting5StrongImgMidSel = (ImageView) view.findViewById(R.id.setting5StrongImgMidSel);
        msetting5StrongImgStrongNotSel = (ImageView) view.findViewById(R.id.setting5StrongImgStrongNotSel);
        msetting5StrongImgStrongSel = (ImageView) view.findViewById(R.id.setting5StrongImgStrongSel);

//    <!--setting 6 reset-->
        mlayoutSetting6Reset = (RelativeLayout) view.findViewById(R.id.layoutSetting6Reset);
        msetting6ResetImgMain = (ImageView) view.findViewById(R.id.setting6ResetImgMain);
        msetting6ResetImgFuncSel = (ImageView) view.findViewById(R.id.setting6ResetImgFuncSel);
        msetting6ResetImgLittleSel = (ImageView) view.findViewById(R.id.setting6ResetImgLittleSel);
        msetting6ResetImgMidSel = (ImageView) view.findViewById(R.id.setting6ResetImgMidSel);
        msetting6ResetImgFullSel = (ImageView) view.findViewById(R.id.setting6ResetImgFullSel);
        msetting6ResetTxtLittleNum = (TextView) view.findViewById(R.id.setting6ResetTxtLittleNum);
        msetting6ResetTxtMidNum = (TextView) view.findViewById(R.id.setting6ResetTxtMidNum);
        msetting6ResetTxtFullNum = (TextView) view.findViewById(R.id.setting6ResetTxtFullNum);
        msetting6ResetTxtLittleContent = (TextView) view.findViewById(R.id.setting6ResetTxtLittleContent);
        msetting6ResetTxtMidContent = (TextView) view.findViewById(R.id.setting6ResetTxtMidContent);
        msetting6ResetTxtFullContent = (TextView) view.findViewById(R.id.setting6ResetTxtFullContent);
        msetting6ResetImgLittle = (ImageView) view.findViewById(R.id.setting6ResetImgLittle);
        msetting6ResetImgMid = (ImageView) view.findViewById(R.id.setting6ResetImgMid);
        msetting6ResetImgFull = (ImageView) view.findViewById(R.id.setting6ResetImgFull);

        mVideoView = (FullScreenVideoView) mView.findViewById(R.id.videoView);

        mPicNum = ProtocolDeal.CHANGE_PIC_DATA2_1_SIMPLE_WATER;
        InitView();

    }

    public void InitView() {

        //mRlBackground.setVisibility(View.INVISIBLE);
        //mRlCommonAll.setVisibility(View.INVISIBLE);
        mRlWorkHolder.setVisibility(View.INVISIBLE);
        mRlOutsideWater.setVisibility(View.INVISIBLE);
        mRlReduceWater.setVisibility(View.INVISIBLE);
        mRlCleanWater.setVisibility(View.INVISIBLE);
        mRlWashWater.setVisibility(View.INVISIBLE);
        mRlSimpleWater.setVisibility(View.INVISIBLE);
        mRlSettingHolder.setVisibility(View.INVISIBLE);

        //TODO: 要把这个地方放到正确的位置
        mcommon1ImgMute.setVisibility(View.INVISIBLE);

        mVideoView.setVisibility(View.INVISIBLE);

        //TODO: 暂时默认使用第一个图
        ChangePic(mPicNum);
    }

    public void HideWorkSettingView() {

        mRlBackground.setVisibility(View.INVISIBLE);
        mRlCommonAll.setVisibility(View.INVISIBLE);
        mRlWorkHolder.setVisibility(View.INVISIBLE);
        mRlOutsideWater.setVisibility(View.INVISIBLE);
        mRlReduceWater.setVisibility(View.INVISIBLE);
        mRlCleanWater.setVisibility(View.INVISIBLE);
        mRlWashWater.setVisibility(View.INVISIBLE);
        mRlSimpleWater.setVisibility(View.INVISIBLE);
        mRlSettingHolder.setVisibility(View.INVISIBLE);
    }

    public void BackgroundShow(){
        mRlBackground.setVisibility(View.VISIBLE);
    }
    public void BackgroundHide(){
        mRlBackground.setVisibility(View.INVISIBLE);
    }
    public void CommonShow(){
        mRlCommonAll.setVisibility(View.VISIBLE);
    }
    public void CommonHide(){
        mRlCommonAll.setVisibility(View.INVISIBLE);
    }
    public void WorkShow(){
        mRlWorkHolder.setVisibility(View.VISIBLE);
    }
    public void WorkHide(){
        mRlWorkHolder.setVisibility(View.INVISIBLE);
    }
    public void WorkOutsideWaterShow(){
        mRlOutsideWater.setVisibility(View.VISIBLE);
    }
    public void WorkOutsideWaterHide(){
        mRlOutsideWater.setVisibility(View.INVISIBLE);
    }
    public void WorkReduceWaterShow(){
        mRlReduceWater.setVisibility(View.VISIBLE);
    }
    public void WorkReduceWaterHide(){
        mRlReduceWater.setVisibility(View.INVISIBLE);
    }
    public void WorkReduceWaterStrongShow(){
        mlayoutReduceWaterStrong.setVisibility(View.VISIBLE);
    }
    public void WorkReduceWaterStrongHide(){
        mlayoutReduceWaterStrong.setVisibility(View.INVISIBLE);
    }
    public void WorkReduceWaterWeakShow(){
        mlayoutReduceWaterWeak.setVisibility(View.VISIBLE);
    }
    public void WorkReduceWaterWeakHide(){
        mlayoutReduceWaterWeak.setVisibility(View.INVISIBLE);
    }
    public void WorkReduceWaterNormalShow(){
        mlayoutReduceWaterNormal.setVisibility(View.VISIBLE);
    }
    public void WorkReduceWaterNormalHide(){
        mlayoutReduceWaterNormal.setVisibility(View.INVISIBLE);
    }
    public void WorkCleanWaterShow(){
        mRlCleanWater.setVisibility(View.VISIBLE);
    }
    public void WorkCleanWaterHide(){
        mRlCleanWater.setVisibility(View.INVISIBLE);
    }
    public void WorkWashWaterShow(){
        mRlWashWater.setVisibility(View.VISIBLE);
    }
    public void WorkWashWaterHide(){
        mRlWashWater.setVisibility(View.INVISIBLE);
    }
    public void WorkSimpleWaterShow(){
        mRlSimpleWater.setVisibility(View.VISIBLE);
    }
    public void WorkSimpleWaterHide(){
        mRlSimpleWater.setVisibility(View.INVISIBLE);
    }

    public void SettingShow(){
        mRlSettingHolder.setVisibility(View.VISIBLE);
    }
    public void SettingHide(){
        mRlSettingHolder.setVisibility(View.INVISIBLE);
    }
    public void SettingCommonShow(){
        mlayoutSettingCommon.setVisibility(View.VISIBLE);
    }
    public void SettingCommonHide(){
        mlayoutSettingCommon.setVisibility(View.INVISIBLE);
    }
    public void Setting1WaterShow(){
        mlayoutSetting1Water.setVisibility(View.VISIBLE);
    }
    public void Setting1WaterHide(){
        mlayoutSetting1Water.setVisibility(View.INVISIBLE);
    }
    public void Setting2VolShow(){
        mlayoutSetting2Vol.setVisibility(View.VISIBLE);
    }
    public void Setting2VolHide(){
        mlayoutSetting2Vol.setVisibility(View.INVISIBLE);
    }
    public void Setting3LightShow(){
        mlayoutSetting3Light.setVisibility(View.VISIBLE);
    }
    public void Setting3LightHide(){
        mlayoutSetting3Light.setVisibility(View.INVISIBLE);
    }
    public void Setting4AdvertShow(){
        mlayoutSetting4Advert.setVisibility(View.VISIBLE);
    }
    public void Setting4AdvertHide(){
        mlayoutSetting4Advert.setVisibility(View.INVISIBLE);
    }
    public void Setting5StrongShow(){
        mlayoutSetting5Strong.setVisibility(View.VISIBLE);
    }
    public void Setting5StrongHide(){
        mlayoutSetting5Strong.setVisibility(View.INVISIBLE);
    }
    public void Setting6ResetShow(){
        mlayoutSetting6Reset.setVisibility(View.VISIBLE);
    }
    public void Setting6ResetHide(){
        mlayoutSetting6Reset.setVisibility(View.INVISIBLE);
    }


    public void ChangePic(int picNum){
        switch (picNum){
            case ProtocolDeal.CHANGE_PIC_DATA2_1_SIMPLE_WATER:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterShow();
                WorkOutsideWaterHide();
                WorkCleanWaterHide();
                WorkReduceWaterHide();
                WorkWashWaterHide();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_2_CLEAN_WATER:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterHide();
                WorkCleanWaterShow();
                WorkReduceWaterHide();
                WorkWashWaterHide();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_3_OUTSIDE_WATER:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterShow();
                WorkCleanWaterHide();
                WorkReduceWaterHide();
                WorkWashWaterHide();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_4_REDUCE_WATER_WEAK:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterHide();
                WorkCleanWaterHide();
                WorkReduceWaterShow();
                WorkReduceWaterWeakShow();
                WorkReduceWaterNormalHide();
                WorkReduceWaterStrongHide();
                WorkWashWaterHide();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_5_REDUCE_WATER_NORMAL:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterHide();
                WorkCleanWaterHide();
                WorkReduceWaterShow();
                WorkReduceWaterWeakHide();
                WorkReduceWaterNormalShow();
                WorkReduceWaterStrongHide();
                WorkWashWaterHide();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_6_REDUCE_WATER_STRONG:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterHide();
                WorkCleanWaterHide();
                WorkReduceWaterShow();
                WorkReduceWaterWeakHide();
                WorkReduceWaterNormalHide();
                WorkReduceWaterStrongShow();
                WorkWashWaterHide();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_7_SETTING1_WATER:
                BackgroundShow();
                CommonShow();
                WorkHide();
                SettingShow();
                Setting1WaterShow();
                Setting2VolHide();
                Setting3LightHide();
                Setting4AdvertHide();
                Setting5StrongHide();
                Setting6ResetHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_8_SETTING2_VOL:
                BackgroundShow();
                CommonShow();
                WorkHide();
                SettingShow();
                Setting1WaterHide();
                Setting2VolShow();
                Setting3LightHide();
                Setting4AdvertHide();
                Setting5StrongHide();
                Setting6ResetHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_9_WASH_WATER1:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterHide();
                WorkCleanWaterHide();
                WorkReduceWaterHide();
                WorkWashWaterShow();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_10_WASH_WATER2:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterHide();
                WorkCleanWaterHide();
                WorkReduceWaterHide();
                WorkWashWaterShow();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_11_SETTING6_RESET:
                BackgroundShow();
                CommonShow();
                WorkHide();
                SettingShow();
                Setting1WaterHide();
                Setting2VolHide();
                Setting3LightHide();
                Setting4AdvertHide();
                Setting5StrongHide();
                Setting6ResetShow();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_12_SETTING5_STRONG:
                BackgroundShow();
                CommonShow();
                WorkHide();
                SettingShow();
                Setting1WaterHide();
                Setting2VolHide();
                Setting3LightHide();
                Setting4AdvertHide();
                Setting5StrongShow();
                Setting6ResetHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_13_SETTING3_LIGHT:
                BackgroundShow();
                CommonShow();
                WorkHide();
                SettingShow();
                Setting1WaterHide();
                Setting2VolHide();
                Setting3LightShow();
                Setting4AdvertHide();
                Setting5StrongHide();
                Setting6ResetHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_14_WASH_WATER3:
                BackgroundShow();
                CommonShow();
                WorkShow();
                WorkSimpleWaterHide();
                WorkOutsideWaterHide();
                WorkCleanWaterHide();
                WorkReduceWaterHide();
                WorkWashWaterShow();
                SettingHide();
                break;
            case ProtocolDeal.CHANGE_PIC_DATA2_15_SETTING4_ADVERT:
                BackgroundShow();
                CommonShow();
                WorkHide();
                SettingShow();
                Setting1WaterHide();
                Setting2VolHide();
                Setting3LightHide();
                Setting4AdvertShow();
                Setting5StrongHide();
                Setting6ResetHide();
                break;
        }
    }

    public void PlayVideo(CmdSerialInfo cmdSerialInfo){
        if(cmdSerialInfo.getData1() == 1){
            HideWorkSettingView();

            mUri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Movies/" + String.format("%d",cmdSerialInfo.getData2()) + ".mp4");
            mVideoView.setVisibility(View.VISIBLE);
            mVideoView.setMediaController(new MediaController(mContext));
            mVideoView.setVideoURI(mUri);
            mVideoView.start();
            mVideoView.requestFocus();

            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
//                mVideoView.setVideoURI(mUri);
                    mVideoView.start();
//                mVideoView.requestFocus();
                }
            });
        }else{
            if (mVideoView != null){
                mVideoView.stopPlayback();
                mVideoView.setVisibility(View.INVISIBLE);
                ChangePic(mPicNum);
            }
        }
    }

    public void CmdDeal(CmdSerialInfo cmdSerialInfo){
        switch (cmdSerialInfo.getHeader()){
            case ProtocolDeal.CHANGE_PIC_HEAD:
                if (mVideoView != null){
                    if (mVideoView.isActivated())
                    {
                        mVideoView.stopPlayback();
                    }
                    mVideoView.setVisibility(View.INVISIBLE);
                }
                mPicNum = cmdSerialInfo.getData2();
                ChangePic(cmdSerialInfo.getData2());
                break;
            case ProtocolDeal.CHANGE_FLOW_HEAD:

                break;
            case ProtocolDeal.CHANGE_FILTER1_HEAD:

                break;
            case ProtocolDeal.CHANGE_FILTER2_HEAD:

                break;
            case ProtocolDeal.CHANGE_FILTER3_HEAD:

                break;
            case ProtocolDeal.CHANGE_PH_HEAD:

                break;
            case ProtocolDeal.CHANGE_ORP_HEAD:

                break;
            case ProtocolDeal.CHANGE_PLAYER_HEAD:
                PlayVideo(cmdSerialInfo);
                break;
            case ProtocolDeal.CHANGE_SETTING_HEAD:

                break;
            default:

                break;

        }
    }

}
