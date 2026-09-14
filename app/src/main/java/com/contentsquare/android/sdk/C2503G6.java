package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.G6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2503G6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1656a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final byte[] f1657b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final String f1658c;

    public C2503G6(@NotNull String key, @NotNull byte[] data, @NotNull String mimeType) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.f1656a = key;
        this.f1657b = data;
        this.f1658c = mimeType;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(C2503G6.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.contentsquare.android.internal.features.srm.SrmResource");
        return Intrinsics.areEqual(this.f1656a, ((C2503G6) obj).f1656a);
    }

    public final int hashCode() {
        return this.f1656a.hashCode();
    }

    @NotNull
    public final String toString() {
        return "SrmResource(key=" + this.f1656a + ", data=" + Arrays.toString(this.f1657b) + ", mimeType=" + this.f1658c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
