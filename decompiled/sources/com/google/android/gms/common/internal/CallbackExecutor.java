package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ExecutorService;

@KeepForSdk
/* loaded from: classes3.dex */
public final class CallbackExecutor {
    @NonNull
    @KeepForSdk
    public static ExecutorService executorService() {
        return zzj.zza;
    }
}
