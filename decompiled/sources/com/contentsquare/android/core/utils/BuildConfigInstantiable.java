package com.contentsquare.android.core.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;", "", "()V", "buildType", "", "getBuildType", "()Ljava/lang/String;", "csSdkVersion", "getCsSdkVersion", "isDebug", "", "()Z", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BuildConfigInstantiable {
    @NotNull
    public final String getBuildType() {
        return "release";
    }

    @NotNull
    public final String getCsSdkVersion() {
        return "4.36.0";
    }

    public final boolean isDebug() {
        return false;
    }
}
