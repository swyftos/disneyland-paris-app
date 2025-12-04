package androidx.core.app;

import android.app.ActivityManager;
import androidx.annotation.ReplaceWith;

/* loaded from: classes.dex */
public final class ActivityManagerCompat {
    @ReplaceWith(expression = "activityManager.isLowRamDevice()")
    @Deprecated
    public static boolean isLowRamDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
