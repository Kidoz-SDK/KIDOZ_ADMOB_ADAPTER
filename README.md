# KIDOZ_ADMOB_ADAPTER
Kidoz adMob medidation adapter

##KIDOZ Interstitial Event Adapter
</br>
**To use the KIDOZ Interstitial adMob adapter do the following steps:**

* Include `KidozAdMobMediationInterstitial.java` file in your project

* Define Interstitial Custom event as explained [HERE](https://support.google.com/admob/answer/3083407):
 
* Set the full path of the file in your project in the `Class Name` field

</br>
<a href="url"><img src="https://s3.amazonaws.com/kidoz-cdn/sdk/GitHub_Tutorial_Img/custom_event_tut.JPG" align="left" height="234" width="600" ></a>

</br> 
</br>

-- Lounch your Admob intersitial code
```javascript

 	/** Initiate Kidoz SDK by creating an SdkControler instance
	 * 
	 * @throws RuntimeException in case of invalid or missing publisher_id or security token
	 *  */
	 InterstitialAd mInterstitialAd;
	 
	   mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("YOUR-UNIT-ID");
        mInterstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed()
            {
            }

            @Override
            public void onAdLoaded()
            {
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int i)
            {
            }
        });
        
        adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
```


 
