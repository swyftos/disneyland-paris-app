package com.urbanairship.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class PendingIntentCompat {
    public static final int FLAG_MUTABLE = 33554432;

    private static int ensureExplicitMutability(int i) {
        return (33554432 & i) == 0 ? i | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : i;
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getActivity(context, i, intent, ensureExplicitMutability(i2));
    }

    public static PendingIntent getService(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getService(context, i, intent, ensureExplicitMutability(i2));
    }

    public static PendingIntent getBroadcast(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, i, intent, ensureExplicitMutability(i2));
    }
}
