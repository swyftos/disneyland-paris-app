package com.swmansion.reanimated;

import android.graphics.Rect;
import android.view.View;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.swmansion.reanimated.ReactNativeUtils;

/* loaded from: classes4.dex */
public class BorderRadiiDrawableUtils {
    private static float getRadiusForCorner(View view, BorderRadiusProp borderRadiusProp, float f) {
        LengthPercentage borderRadius = BackgroundStyleApplicator.getBorderRadius(view, borderRadiusProp);
        if (borderRadius == null) {
            return f;
        }
        Rect bounds = view.getBackground().getBounds();
        return borderRadius.resolve(bounds.width(), bounds.height()).toPixelFromDIP().getHorizontal();
    }

    public static ReactNativeUtils.BorderRadii getBorderRadii(View view) {
        return new ReactNativeUtils.BorderRadii(getRadiusForCorner(view, BorderRadiusProp.BORDER_RADIUS, BitmapDescriptorFactory.HUE_RED), getRadiusForCorner(view, BorderRadiusProp.BORDER_TOP_LEFT_RADIUS, Float.NaN), getRadiusForCorner(view, BorderRadiusProp.BORDER_TOP_RIGHT_RADIUS, Float.NaN), getRadiusForCorner(view, BorderRadiusProp.BORDER_BOTTOM_LEFT_RADIUS, Float.NaN), getRadiusForCorner(view, BorderRadiusProp.BORDER_BOTTOM_RIGHT_RADIUS, Float.NaN));
    }
}
