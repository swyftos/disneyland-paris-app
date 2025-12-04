package com.urbanairship.android.layout.widget;

import androidx.annotation.Dimension;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;

/* loaded from: classes5.dex */
public interface Clippable {
    @MainThread
    void setClipPathBorderRadius(@Dimension float f);

    @RequiresApi(api = 30)
    @MainThread
    void setClipPathBorderRadius(@Dimension float[] fArr);
}
