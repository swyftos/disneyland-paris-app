package com.urbanairship.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ProcessUtils {
    public static boolean isMainProcess(@NonNull Application application) {
        String packageName = application.getApplicationInfo().processName;
        if (packageName == null) {
            packageName = application.getPackageName();
        }
        String processName = getProcessName(application);
        return processName != null && processName.equals(packageName);
    }

    @Nullable
    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static String getProcessName(@NonNull Context context) {
        return Application.getProcessName();
    }
}
