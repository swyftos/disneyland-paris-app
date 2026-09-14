package com.facebook.drawee.interfaces;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public interface DraweeHierarchy {
    Rect getBounds();

    Drawable getTopLevelDrawable();
}
