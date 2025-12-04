package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import cl.json.RNSharePackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.appdynamics.eum.reactnative.ReactNativeAppdynamicsPackage;
import com.brentvatne.react.ReactVideoPackage;
import com.cisa.RNCisaPackage;
import com.cmcewen.blurview.BlurViewPackage;
import com.contentsquare.rn.ContentsquareModulePackage;
import com.corbt.keepawake.KCKeepAwakePackage;
import com.dlp.fantasiadsmobile.FantasiaDsMobilePackage;
import com.dylanvann.fastimage.FastImageViewPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.github.doomsower.RNStartupTimePackage;
import com.github.wumke.RNExitApp.RNExitAppPackage;
import com.horcrux.svg.SvgPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.levelasquez.androidopensettings.AndroidOpenSettingsPackage;
import com.lugg.ReactNativeConfig.ReactNativeConfigPackage;
import com.masteratul.exceptionhandler.ReactNativeExceptionHandlerPackage;
import com.mrousavy.camera.react.CameraPackage;
import com.ninty.system.setting.SystemSettingPackage;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.oneid.OneidPackage;
import com.proyecto26.inappbrowser.RNInAppBrowserPackage;
import com.pusherman.networkinfo.RNNetworkInfoPackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactlibrary.sqlcipher.SqlcipherPluginPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.clipboard.ClipboardPackage;
import com.reactnativecommunity.geolocation.GeolocationPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativecommunity.viewpager.RNCViewPagerPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativerestart.RestartPackage;
import com.rnfs.RNFSPackage;
import com.rnmaps.maps.MapsPackage;
import com.rumax.reactnative.pdfviewer.PDFViewPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.thewirv.RNWalletPasses.RNWalletPassesPackage;
import com.urbanairship.reactnative.AirshipPackage;
import com.worklets.WorkletsCorePackage;
import com.zoontek.rnlocalize.RNLocalizePackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.devio.rn.splashscreen.SplashScreenReactPackage;
import org.linusu.RNGetRandomValuesPackage;
import org.reactnative.maskedview.RNCMaskedViewPackage;

/* loaded from: classes3.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new ReactNativeAppdynamicsPackage(), new ContentsquareModulePackage(), new FastImageViewPackage(), new FantasiaDsMobilePackage(), new RNCisaPackage(), new SplashScreenReactPackage(), new OneidPackage(), new SqlcipherPluginPackage(), new AsyncStoragePackage(), new ClipboardPackage(), new BlurViewPackage(), new RNDateTimePickerPackage(), new GeolocationPackage(), new NetInfoPackage(), new ReactSliderPackage(), new ReactNativeFirebaseAppPackage(), new RNCMaskedViewPackage(), new AirshipPackage(), new LottiePackage(), new AndroidOpenSettingsPackage(), new BackgroundTimerPackage(), new ReactNativeBlobUtilPackage(), new ReactNativeConfigPackage(), new RNDeviceInfo(), new ReactNativeExceptionHandlerPackage(), new RNExitAppPackage(), new RNFSPackage(), new RNGestureHandlerPackage(), new RNGetRandomValuesPackage(), new RNInAppBrowserPackage(), new KCKeepAwakePackage(), new LinearGradientPackage(), new RNLocalizePackage(), new MapsPackage(), new RNNetworkInfoPackage(), new RNCViewPagerPackage(), new RNPermissionsPackage(), new ReanimatedPackage(), new RestartPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSharePackage(), new RNStartupTimePackage(), new SvgPackage(), new SystemSettingPackage(), new ReactVideoPackage(), new PDFViewPackage(), new CameraPackage(), new RNWalletPassesPackage(), new RNCWebViewPackage(), new WorkletsCorePackage()));
    }
}
