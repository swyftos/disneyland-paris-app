package com.urbanairship.permission;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.MainThread;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/permission/SystemSettingsLauncher;", "", "()V", "openAppNotificationSettings", "", "context", "Landroid/content/Context;", "openAppSettings", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SystemSettingsLauncher {
    @MainThread
    public final boolean openAppNotificationSettings(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.getApplicationContext().startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", UAirship.getPackageName()).addFlags(268435456));
            return true;
        } catch (ActivityNotFoundException e) {
            UALog.i(e, new Function0() { // from class: com.urbanairship.permission.SystemSettingsLauncher.openAppNotificationSettings.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to launch notification settings.";
                }
            });
            try {
                context.getApplicationContext().startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("app_package", UAirship.getPackageName()).putExtra("app_uid", UAirship.getAppInfo().uid).addFlags(268435456));
                return true;
            } catch (ActivityNotFoundException e2) {
                UALog.i(e2, new Function0() { // from class: com.urbanairship.permission.SystemSettingsLauncher.openAppNotificationSettings.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to launch notification settings.";
                    }
                });
                return openAppSettings(context);
            }
        }
    }

    @MainThread
    public final boolean openAppSettings(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").addCategory("android.intent.category.DEFAULT").addFlags(268435456).setData(Uri.parse("package:" + UAirship.getPackageName())));
            return true;
        } catch (ActivityNotFoundException e) {
            UALog.i(e, new Function0() { // from class: com.urbanairship.permission.SystemSettingsLauncher.openAppSettings.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to launch settings details activity.";
                }
            });
            try {
                context.startActivity(new Intent("android.settings.APPLICATION_SETTINGS").addCategory("android.intent.category.DEFAULT").addFlags(268435456).setData(Uri.parse("package:" + UAirship.getPackageName())));
                return true;
            } catch (ActivityNotFoundException e2) {
                UALog.i(e2, new Function0() { // from class: com.urbanairship.permission.SystemSettingsLauncher.openAppSettings.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to launch settings activity.";
                    }
                });
                return false;
            }
        }
    }
}
