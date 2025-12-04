package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public interface RNMapsWMSTileManagerInterface<T extends View> {
    void setMaximumNativeZ(T t, int i);

    void setMaximumZ(T t, int i);

    void setMinimumZ(T t, int i);

    void setOfflineMode(T t, boolean z);

    void setShouldReplaceMapContent(T t, boolean z);

    void setTileCacheMaxAge(T t, int i);

    void setTileCachePath(T t, @Nullable String str);

    void setTileSize(T t, int i);

    void setUrlTemplate(T t, @Nullable String str);
}
