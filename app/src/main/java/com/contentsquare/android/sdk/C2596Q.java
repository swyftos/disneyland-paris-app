package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Q */
/* JADX INFO: loaded from: classes2.dex */
public final class C2596Q {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final byte[] f1983a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f1984b;

    public C2596Q(@NotNull String url, @NotNull byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f1983a = payload;
        this.f1984b = url;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(C2596Q.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.contentsquare.android.internal.features.sessionreplay.processing.dispatcher.BatchContainer");
        C2596Q c2596q = (C2596Q) obj;
        return Arrays.equals(this.f1983a, c2596q.f1983a) && Intrinsics.areEqual(this.f1984b, c2596q.f1984b);
    }

    public final int hashCode() {
        return this.f1984b.hashCode() + (Arrays.hashCode(this.f1983a) * 31);
    }

    @NotNull
    public final String toString() {
        return "BatchContainer(payload=" + Arrays.toString(this.f1983a) + ", url=" + this.f1984b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
