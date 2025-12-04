package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public final class StartupLogger {
    public static void i(@NonNull String str) {
        Log.i("StartupLogger", str);
    }

    public static void w(@NonNull String str) {
        Log.w("StartupLogger", str);
    }

    public static void e(@NonNull String str, @Nullable Throwable th) {
        Log.e("StartupLogger", str, th);
    }
}
