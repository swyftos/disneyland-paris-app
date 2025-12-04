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
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class RNCSliderManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCSliderManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCSliderManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        float fFloatValue = BitmapDescriptorFactory.HUE_RED;
        char c = 65535;
        switch (str.hashCode()) {
            case -1984141450:
                if (str.equals("vertical")) {
                    c = 0;
                    break;
                }
                break;
            case -1900655011:
                if (str.equals("maximumTrackTintColor")) {
                    c = 1;
                    break;
                }
                break;
            case -1736983259:
                if (str.equals("thumbImage")) {
                    c = 2;
                    break;
                }
                break;
            case -1681713095:
                if (str.equals("upperLimit")) {
                    c = 3;
                    break;
                }
                break;
            case -1021497397:
                if (str.equals("minimumTrackTintColor")) {
                    c = 4;
                    break;
                }
                break;
            case -981448432:
                if (str.equals("maximumTrackImage")) {
                    c = 5;
                    break;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    c = 6;
                    break;
                }
                break;
            case 3540684:
                if (str.equals("step")) {
                    c = 7;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    c = '\b';
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c = '\t';
                    break;
                }
                break;
            case 627674869:
                if (str.equals("inverted")) {
                    c = '\n';
                    break;
                }
                break;
            case 628733650:
                if (str.equals("accessibilityIncrements")) {
                    c = 11;
                    break;
                }
                break;
            case 718061361:
                if (str.equals("maximumValue")) {
                    c = '\f';
                    break;
                }
                break;
            case 1139400400:
                if (str.equals("trackImage")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 1155548865:
                if (str.equals("accessibilityUnits")) {
                    c = 14;
                    break;
                }
                break;
            case 1168687382:
                if (str.equals("tapToSeek")) {
                    c = 15;
                    break;
                }
                break;
            case 1192487427:
                if (str.equals("minimumValue")) {
                    c = 16;
                    break;
                }
                break;
            case 1209133370:
                if (str.equals("lowerLimit")) {
                    c = 17;
                    break;
                }
                break;
            case 1333596542:
                if (str.equals("minimumTrackImage")) {
                    c = 18;
                    break;
                }
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c = 19;
                    break;
                }
                break;
        }
        switch (c) {
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
            case '\b':
                RNCSliderManagerInterface rNCSliderManagerInterface3 = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNCSliderManagerInterface3.setValue(t, fFloatValue);
                break;
            case '\t':
                ((RNCSliderManagerInterface) this.mViewManager).setDisabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\n':
                ((RNCSliderManagerInterface) this.mViewManager).setInverted(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 11:
                ((RNCSliderManagerInterface) this.mViewManager).setAccessibilityIncrements(t, (ReadableArray) obj);
                break;
            case '\f':
                RNCSliderManagerInterface rNCSliderManagerInterface4 = (RNCSliderManagerInterface) this.mViewManager;
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                rNCSliderManagerInterface4.setMaximumValue(t, dDoubleValue);
                break;
            case '\r':
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
