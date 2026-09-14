package com.urbanairship.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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
