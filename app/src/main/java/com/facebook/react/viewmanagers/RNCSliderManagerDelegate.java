package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCSliderManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNCSliderManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCSliderManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCSliderManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        float fFloatValue = BitmapDescriptorFactory.HUE_RED;
        byte b = -1;
        switch (str.hashCode()) {
            case -1984141450:
                if (str.equals("vertical")) {
                    b = 0;
                }
                break;
            case -1900655011:
                if (str.equals("maximumTrackTintColor")) {
                    b = 1;
                }
                break;
            case -1736983259:
                if (str.equals("thumbImage")) {
                    b = 2;
                }
                break;
            case -1681713095:
                if (str.equals("upperLimit")) {
                    b = 3;
                }
                break;
            case -1021497397:
                if (str.equals("minimumTrackTintColor")) {
                    b = 4;
                }
                break;
            case -981448432:
                if (str.equals("maximumTrackImage")) {
                    b = 5;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    b = 6;
                }
                break;
            case 3540684:
                if (str.equals("step")) {
                    b = 7;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    b = 8;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    b = 9;
                }
                break;
            case 627674869:
                if (str.equals("inverted")) {
                    b = 10;
                }
                break;
            case 628733650:
                if (str.equals("accessibilityIncrements")) {
                    b = Ascii.f3535VT;
                }
                break;
            case 718061361:
                if (str.equals("maximumValue")) {
                    b = Ascii.f3524FF;
                }
                break;
            case 1139400400:
                if (str.equals("trackImage")) {
                    b = Ascii.f3522CR;
                }
                break;
            case 1155548865:
                if (str.equals("accessibilityUnits")) {
                    b = Ascii.f3532SO;
                }
                break;
            case 1168687382:
                if (str.equals("tapToSeek")) {
                    b = Ascii.f3531SI;
                }
                break;
            case 1192487427:
                if (str.equals("minimumValue")) {
                    b = Ascii.DLE;
                }
                break;
            case 1209133370:
                if (str.equals("lowerLimit")) {
                    b = 17;
                }
                break;
            case 1333596542:
                if (str.equals("minimumTrackImage")) {
                    b = Ascii.DC2;
                }
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    b = 19;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNCSliderManagerInterface) this.mViewManager).setVertical(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNCSliderManagerInterface) this.mViewManager).setMaximumTrackTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 2:
                ((RNCSliderManagerInterface) this.mViewManager).setThumbImage(t, (ReadableMap) obj);
                break;
            case 3:
                RNCSliderManagerInterface rNCSliderManagerInterface = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNCSliderManagerInterface.setUpperLimit(t, fFloatValue);
                break;
            case 4:
                ((RNCSliderManagerInterface) this.mViewManager).setMinimumTrackTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 5:
                ((RNCSliderManagerInterface) this.mViewManager).setMaximumTrackImage(t, (ReadableMap) obj);
                break;
            case 6:
                ((RNCSliderManagerInterface) this.mViewManager).setTestID(t, obj != null ? (String) obj : null);
                break;
            case 7:
                RNCSliderManagerInterface rNCSliderManagerInterface2 = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                rNCSliderManagerInterface2.setStep(t, dDoubleValue);
                break;
            case 8:
                RNCSliderManagerInterface rNCSliderManagerInterface3 = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNCSliderManagerInterface3.setValue(t, fFloatValue);
                break;
            case 9:
                ((RNCSliderManagerInterface) this.mViewManager).setDisabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 10:
                ((RNCSliderManagerInterface) this.mViewManager).setInverted(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 11:
                ((RNCSliderManagerInterface) this.mViewManager).setAccessibilityIncrements(t, (ReadableArray) obj);
                break;
            case 12:
                RNCSliderManagerInterface rNCSliderManagerInterface4 = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                rNCSliderManagerInterface4.setMaximumValue(t, dDoubleValue);
                break;
            case 13:
                ((RNCSliderManagerInterface) this.mViewManager).setTrackImage(t, (ReadableMap) obj);
                break;
            case 14:
                ((RNCSliderManagerInterface) this.mViewManager).setAccessibilityUnits(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNCSliderManagerInterface) this.mViewManager).setTapToSeek(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 16:
                RNCSliderManagerInterface rNCSliderManagerInterface5 = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                rNCSliderManagerInterface5.setMinimumValue(t, dDoubleValue);
                break;
            case 17:
                RNCSliderManagerInterface rNCSliderManagerInterface6 = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNCSliderManagerInterface6.setLowerLimit(t, fFloatValue);
                break;
            case 18:
                ((RNCSliderManagerInterface) this.mViewManager).setMinimumTrackImage(t, (ReadableMap) obj);
                break;
            case 19:
                ((RNCSliderManagerInterface) this.mViewManager).setThumbTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
