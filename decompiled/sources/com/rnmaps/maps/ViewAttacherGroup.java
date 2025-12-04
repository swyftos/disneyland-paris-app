package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes4.dex */
public class ViewAttacherGroup extends ReactViewGroup {
    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public ViewAttacherGroup(Context context) {
        super(context);
        setWillNotDraw(true);
        setVisibility(0);
        setAlpha(BitmapDescriptorFactory.HUE_RED);
        setRemoveClippedSubviews(false);
        setClipBounds(new Rect(0, 0, 0, 0));
        setOverflow(ViewProps.HIDDEN);
    }
}
