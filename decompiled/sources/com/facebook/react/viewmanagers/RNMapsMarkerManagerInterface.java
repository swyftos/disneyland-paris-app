package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
public interface RNMapsMarkerManagerInterface<T extends View> {
    void animateToCoordinates(T t, double d, double d2, int i);

    void hideCallout(T t);

    void redraw(T t);

    void redrawCallout(T t);

    void setAnchor(T t, @Nullable ReadableMap readableMap);

    void setCalloutAnchor(T t, @Nullable ReadableMap readableMap);

    void setCalloutOffset(T t, @Nullable ReadableMap readableMap);

    void setCoordinate(T t, @Nullable ReadableMap readableMap);

    void setCoordinates(T t, double d, double d2);

    void setDescription(T t, @Nullable String str);

    void setDisplayPriority(T t, @Nullable String str);

    void setDraggable(T t, boolean z);

    void setIdentifier(T t, @Nullable String str);

    void setImage(T t, @Nullable ReadableMap readableMap);

    void setIsPreselected(T t, boolean z);

    void setOpacity(T t, double d);

    void setPinColor(T t, @Nullable Integer num);

    void setSubtitleVisibility(T t, @Nullable String str);

    void setTitle(T t, @Nullable String str);

    void setTitleVisibility(T t, @Nullable String str);

    void setUseLegacyPinView(T t, boolean z);

    void showCallout(T t);
}
