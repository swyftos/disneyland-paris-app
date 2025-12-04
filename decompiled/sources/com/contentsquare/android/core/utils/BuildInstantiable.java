package com.contentsquare.android.core.utils;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/contentsquare/android/core/utils/BuildInstantiable;", "", "()V", "androidSdkVersion", "", "getAndroidSdkVersion", "()I", TCEventPropertiesNames.TCD_MANUFACTURER, "", "getManufacturer", "()Ljava/lang/String;", TCEventPropertiesNames.TCD_MODEL, "getModel", "osReleaseVersion", "getOsReleaseVersion", "isAtLeastSdkVersion", "", "androidAPI", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BuildInstantiable {
    public final int getAndroidSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public final String getManufacturer() {
        return Build.MANUFACTURER;
    }

    @Nullable
    public final String getModel() {
        return Build.MODEL;
    }

    @NotNull
    public final String getOsReleaseVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    @ChecksSdkIntAtLeast(parameter = 0)
    public final boolean isAtLeastSdkVersion(int androidAPI) {
        return Build.VERSION.SDK_INT >= androidAPI;
    }
}
