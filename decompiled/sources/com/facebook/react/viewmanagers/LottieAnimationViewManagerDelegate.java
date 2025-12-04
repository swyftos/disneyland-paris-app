package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.LottieAnimationViewManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class LottieAnimationViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & LottieAnimationViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public LottieAnimationViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1931191604:
                if (str.equals("imageAssetsFolder")) {
                    c = 0;
                    break;
                }
                break;
            case -1698420908:
                if (str.equals("sourceURL")) {
                    c = 1;
                    break;
                }
                break;
            case -1620771041:
                if (str.equals("textFiltersIOS")) {
                    c = 2;
                    break;
                }
                break;
            case -1111735389:
                if (str.equals("sourceJson")) {
                    c = 3;
                    break;
                }
                break;
            case -1111633594:
                if (str.equals("sourceName")) {
                    c = 4;
                    break;
                }
                break;
            case -1073046328:
                if (str.equals("cacheComposition")) {
                    c = 5;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 6;
                    break;
                }
                break;
            case -413415295:
                if (str.equals("textFiltersAndroid")) {
                    c = 7;
                    break;
                }
                break;
            case -204076609:
                if (str.equals("sourceDotLottieURI")) {
                    c = '\b';
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c = '\t';
                    break;
                }
                break;
            case 95945896:
                if (str.equals("dummy")) {
                    c = '\n';
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c = 11;
                    break;
                }
                break;
            case 399078087:
                if (str.equals("hardwareAccelerationAndroid")) {
                    c = '\f';
                    break;
                }
                break;
            case 1192042876:
                if (str.equals("enableSafeModeAndroid")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 1193882713:
                if (str.equals("renderMode")) {
                    c = 14;
                    break;
                }
                break;
            case 1410565912:
                if (str.equals("colorFilters")) {
                    c = 15;
                    break;
                }
                break;
            case 1438608771:
                if (str.equals("autoPlay")) {
                    c = 16;
                    break;
                }
                break;
            case 2049757303:
                if (str.equals(ViewProps.RESIZE_MODE)) {
                    c = 17;
                    break;
                }
                break;
            case 2111299681:
                if (str.equals("enableMergePathsAndroidForKitKatAndAbove")) {
                    c = 18;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setImageAssetsFolder(t, obj != null ? (String) obj : null);
                break;
            case 1:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceURL(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setTextFiltersIOS(t, (ReadableArray) obj);
                break;
            case 3:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceJson(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceName(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setCacheComposition(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setProgress(t, obj == null ? BitmapDescriptorFactory.HUE_RED : ((Double) obj).floatValue());
                break;
            case 7:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setTextFiltersAndroid(t, (ReadableArray) obj);
                break;
            case '\b':
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSourceDotLottieURI(t, obj != null ? (String) obj : null);
                break;
            case '\t':
                ((LottieAnimationViewManagerInterface) this.mViewManager).setLoop(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\n':
                ((LottieAnimationViewManagerInterface) this.mViewManager).setDummy(t, (ReadableMap) obj);
                break;
            case 11:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setSpeed(t, obj == null ? AudioStats.AUDIO_AMPLITUDE_NONE : ((Double) obj).doubleValue());
                break;
            case '\f':
                ((LottieAnimationViewManagerInterface) this.mViewManager).setHardwareAccelerationAndroid(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\r':
                ((LottieAnimationViewManagerInterface) this.mViewManager).setEnableSafeModeAndroid(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 14:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setRenderMode(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setColorFilters(t, (ReadableArray) obj);
                break;
            case 16:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setAutoPlay(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setResizeMode(t, obj != null ? (String) obj : null);
                break;
            case 18:
                ((LottieAnimationViewManagerInterface) this.mViewManager).setEnableMergePathsAndroidForKitKatAndAbove(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "resume":
                ((LottieAnimationViewManagerInterface) this.mViewManager).resume(t);
                break;
            case "play":
                ((LottieAnimationViewManagerInterface) this.mViewManager).play(t, readableArray.getInt(0), readableArray.getInt(1));
                break;
            case "pause":
                ((LottieAnimationViewManagerInterface) this.mViewManager).pause(t);
                break;
            case "reset":
                ((LottieAnimationViewManagerInterface) this.mViewManager).reset(t);
                break;
        }
    }
}
