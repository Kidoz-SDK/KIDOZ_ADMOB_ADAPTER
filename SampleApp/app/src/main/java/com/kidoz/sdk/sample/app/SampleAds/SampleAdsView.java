package com.kidoz.sdk.sample.app.SampleAds;

import android.app.Activity;

/**
 * Created by orikam on 07/06/2017.
 */

public interface SampleAdsView
{
    void showFeedBackText(String text);
    Activity getActivity(); //Specifically, since our mainView here is meant to lead to Activity based SDK actions we require our MainViewImpl to be able to return an Activity
}
