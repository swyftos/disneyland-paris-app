package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGFeCompositeManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGFeCompositeManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeCompositeManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        float fFloatValue = BitmapDescriptorFactory.HUE_RED;
        byte b = -1;
        switch (str.hashCode()) {
            case -1221029593:
                if (str.equals("height")) {
                    b = 0;
                }
                break;
            case -934426595:
                if (str.equals("result")) {
                    b = 1;
                }
                break;
            case SyslogConstants.LOG_CLOCK /* 120 */:
                if (str.equals("x")) {
                    b = 2;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = 3;
                }
                break;
            case 3366:
                if (str.equals("k1")) {
                    b = 4;
                }
                break;
            case 3367:
                if (str.equals("k2")) {
                    b = 5;
                }
                break;
            case 3368:
                if (str.equals("k3")) {
                    b = 6;
                }
                break;
            case 3369:
                if (str.equals("k4")) {
                    b = 7;
                }
                break;
            case 104364:
                if (str.equals("in1")) {
                    b = 8;
                }
                break;
            case 104365:
                if (str.equals("in2")) {
                    b = 9;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 10;
                }
                break;
            case 1662708749:
                if (str.equals("operator1")) {
                    b = Ascii.f3535VT;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setResult(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 4:
                RNSVGFeCompositeManagerInterface rNSVGFeCompositeManagerInterface = (RNSVGFeCompositeManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGFeCompositeManagerInterface.setK1(t, fFloatValue);
                break;
            case 5:
                RNSVGFeCompositeManagerInterface rNSVGFeCompositeManagerInterface2 = (RNSVGFeCompositeManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGFeCompositeManagerInterface2.setK2(t, fFloatValue);
                break;
            case 6:
                RNSVGFeCompositeManagerInterface rNSVGFeCompositeManagerInterface3 = (RNSVGFeCompositeManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGFeCompositeManagerInterface3.setK3(t, fFloatValue);
                break;
            case 7:
                RNSVGFeCompositeManagerInterface rNSVGFeCompositeManagerInterface4 = (RNSVGFeCompositeManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNSVGFeCompositeManagerInterface4.setK4(t, fFloatValue);
                break;
            case 8:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setIn1(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setIn2(t, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setOperator1(t, (String) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
