package com.rnmaps.maps;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;

/* loaded from: classes4.dex */
public abstract class MapFeature extends ReactViewGroup {
    public abstract void addToMap(Object obj);

    public abstract Object getFeature();

    public abstract void removeFromMap(Object obj);

    public MapFeature(Context context) {
        super(context);
    }
}
