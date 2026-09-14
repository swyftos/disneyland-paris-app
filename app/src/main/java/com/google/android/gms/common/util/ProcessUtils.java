package com.google.android.gms.common.util;

import android.app.Application;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class ProcessUtils {
    private static String zza;

    @Nullable
    @KeepForSdk
    public static String getMyProcessName() {
        if (zza == null) {
            zza = Application.getProcessName();
        }
        return zza;
    }
}
