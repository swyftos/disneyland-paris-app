package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.p3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0774p3 {
    public final long a;
    public final long b;
    public final boolean c;

    @NotNull
    public final String d;

    public C0774p3(@NotNull String endpoint, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        this.a = j;
        this.b = j2;
        this.c = z;
        this.d = endpoint;
    }
}
