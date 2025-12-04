package com.urbanairship.reactnative;

import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u00020\b*\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/reactnative/ManifestUtils;", "", "<init>", "()V", "Landroid/content/Context;", "", "extenderClassName", "(Landroid/content/Context;)Ljava/lang/String;", "", "isHeadlessJSTaskEnabledOnStart", "(Landroid/content/Context;)Z", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManifestUtils {

    @NotNull
    public static final ManifestUtils INSTANCE = new ManifestUtils();

    private ManifestUtils() {
    }

    @Nullable
    public final String extenderClassName(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.urbanairship.reactnative.AIRSHIP_EXTENDER");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final boolean isHeadlessJSTaskEnabledOnStart(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.urbanairship.reactnative.ALLOW_HEADLESS_JS_TASK_BEFORE_MODULE", true);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
