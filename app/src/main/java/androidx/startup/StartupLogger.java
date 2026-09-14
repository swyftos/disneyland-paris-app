package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupLogger {
    /* JADX INFO: renamed from: i */
    public static void m379i(@NonNull String str) {
        Log.i("StartupLogger", str);
    }

    /* JADX INFO: renamed from: w */
    public static void m380w(@NonNull String str) {
        Log.w("StartupLogger", str);
    }

    /* JADX INFO: renamed from: e */
    public static void m378e(@NonNull String str, @Nullable Throwable th) {
        Log.e("StartupLogger", str, th);
    }
}
