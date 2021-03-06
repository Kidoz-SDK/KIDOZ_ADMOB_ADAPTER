package com.kidoz.sdk.sample.app.SampleAds;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.kidoz.sdk.sample.app.R;

/**
 * Created by KIDOZ.
 */
public class SampleAdsViewActivity extends Activity implements SampleAdsView
{
    private SampleAdsPresenter mMainPresenter;

    private TextView mFeedbackTV;
    private Button mInterstitialLoad;
    private Button mInterstitialShow;
    private Button mRewardedLoad;
    private Button mRewardedShow;
    private Button mBannerLoad;
    private Button mBannerClose;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        setContentView(R.layout.activity_sample);

        findViews();
        setButtons();

        mMainPresenter = new SampleAdsPresenter_Admob_Impl(this);
        mMainPresenter.onCreate();
    }

    private void findViews()
    {
        mFeedbackTV = (TextView) findViewById(R.id.feedback_tv);
        mInterstitialLoad = (Button) findViewById(R.id.interstitial_load);
        mInterstitialShow = (Button) findViewById(R.id.interstitial_show);
        mRewardedLoad = (Button) findViewById(R.id.rewarded_load);
        mRewardedShow = (Button) findViewById(R.id.rewarded_show);
        mBannerLoad = (Button) findViewById(R.id.banner_load);
        mBannerClose = (Button) findViewById(R.id.banner_close);
    }

    private void setButtons()
    {
        mInterstitialLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mMainPresenter.onClick_LoadInterstitial();
            }
        });

        mInterstitialShow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mMainPresenter.onClick_ShowInterstitial();
            }
        });

        mRewardedLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mMainPresenter.onClick_LoadRewarded();
            }
        });

        mRewardedShow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mMainPresenter.onClick_ShowRewarded();
            }
        });

        mBannerLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mMainPresenter.onClick_LoadBanner();
            }
        });

        mBannerClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mMainPresenter.onClick_CloseBanner();
            }
        });

    }

    @Override
    public void showFeedBackText(String text)
    {
        if (!TextUtils.isEmpty(text))
        {
            mFeedbackTV.setText(text);
        }
    }

    @Override
    public Activity getActivity()
    {
        return SampleAdsViewActivity.this;
    }
}
