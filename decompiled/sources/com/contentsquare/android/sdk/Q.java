package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class Q {

    @NotNull
    public final byte[] a;

    @NotNull
    public final String b;

    public Q(@NotNull String url, @NotNull byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(url, "url");
        this.a = payload;
        this.b = url;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(Q.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.contentsquare.android.internal.features.sessionreplay.processing.dispatcher.BatchContainer");
        Q q = (Q) obj;
        return Arrays.equals(this.a, q.a) && Intrinsics.areEqual(this.b, q.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Arrays.hashCode(this.a) * 31);
    }

    @NotNull
    public final String toString() {
        return "BatchContainer(payload=" + Arrays.toString(this.a) + ", url=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
