package com.google.android.gms.internal.base;

import android.os.Build;
import com.urbanairship.util.PendingIntentCompat;

/* loaded from: classes3.dex */
public final class zap {
    public static final int zaa;

    static {
        zaa = Build.VERSION.SDK_INT >= 31 ? PendingIntentCompat.FLAG_MUTABLE : 0;
    }
}
