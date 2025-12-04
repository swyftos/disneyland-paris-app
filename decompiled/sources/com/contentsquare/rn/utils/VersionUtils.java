package com.contentsquare.rn.utils;

import android.os.Build;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/contentsquare/rn/utils/VersionUtils;", "", "<init>", "()V", "getSDKVersion", "", "isApiLevelAtLeast", "", "apiLevel", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VersionUtils {

    @NotNull
    public static final VersionUtils INSTANCE = new VersionUtils();

    private VersionUtils() {
    }

    private final int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    public final boolean isApiLevelAtLeast(int apiLevel) {
        return getSDKVersion() >= apiLevel;
    }
}
