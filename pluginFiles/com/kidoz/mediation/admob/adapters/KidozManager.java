package com.kidoz.mediation.admob.adapters;

import android.app.Activity;

import com.kidoz.sdk.api.KidozInterstitial;
import com.kidoz.sdk.api.KidozSDK;
import com.kidoz.sdk.api.interfaces.SDKEventListener;
import com.kidoz.sdk.api.ui_views.interstitial.BaseInterstitial;

/**
 * Created by orikam on 07/06/2017.
 */

public class KidozManager
{

    private KidozInterstitial mKidozInterstitial;
    private KidozInterstitial mKidozRewarded;

    private static String mKidozPublisherId = "5"; //default (test values)
    private static String mKidozPublisherToken = "i0tnrdwdtq0dm36cqcpg6uyuwupkj76s"; //default (test values)
    private static BaseInterstitial.IOnInterstitialRewardedEventListener mDeveloperRewardedListener;

    /****************************
     *      Developer API       *
     ****************************/
    public static void setKidozPublisherId(String publisherId){
        mKidozPublisherId = publisherId;
    }

    public static void setKidozPublisherToken(String publisherToken){
        mKidozPublisherToken = publisherToken;
    }

    public static void setRewardedEvents(BaseInterstitial.IOnInterstitialRewardedEventListener rewardedListener){
        mDeveloperRewardedListener = rewardedListener;
    }

    /****************************
     *     Adapter Internal     *
     ****************************/
    protected void setupKidozInterstitial(Activity activity, BaseInterstitial.IOnInterstitialEventListener interstitialListener){
        mKidozInterstitial = new KidozInterstitial(activity, KidozInterstitial.AD_TYPE.INTERSTITIAL);
        mKidozInterstitial.setOnInterstitialEventListener(interstitialListener);
    }

    protected void setupKidozRewadrded(Activity activity, BaseInterstitial.IOnInterstitialEventListener interstitialListener, BaseInterstitial.IOnInterstitialRewardedEventListener rewardedListener){
        mKidozRewarded = new KidozInterstitial(activity, KidozInterstitial.AD_TYPE.REWARDED_VIDEO);
        mKidozRewarded.setOnInterstitialEventListener(interstitialListener);
        mKidozRewarded.setOnInterstitialRewardedEventListener(rewardedListener);
    }

    protected void initKidozSDK(Activity activity, SDKEventListener sdkEventsListener)
    {
        KidozSDK.setSDKListener(sdkEventsListener);
        KidozSDK.initialize(activity, mKidozPublisherId, mKidozPublisherToken);
    }

    protected boolean getIsKidozInitialized(){
        return KidozSDK.isInitialised();
    }

    protected KidozInterstitial getInterstitial(){
        return mKidozInterstitial;
    }

    protected KidozInterstitial getRewarded(){
        return mKidozRewarded;
    }

    protected BaseInterstitial.IOnInterstitialRewardedEventListener getDeveloperRewardedListener(){
        return mDeveloperRewardedListener;
    }
}