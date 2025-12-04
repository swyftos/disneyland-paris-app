package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class G6 {

    @NotNull
    public final String a;

    @NotNull
    public final byte[] b;

    @NotNull
    public final String c;

    public G6(@NotNull String key, @NotNull byte[] data, @NotNull String mimeType) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.a = key;
        this.b = data;
        this.c = mimeType;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(G6.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.contentsquare.android.internal.features.srm.SrmResource");
        return Intrinsics.areEqual(this.a, ((G6) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public final String toString() {
        return "SrmResource(key=" + this.a + ", data=" + Arrays.toString(this.b) + ", mimeType=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
