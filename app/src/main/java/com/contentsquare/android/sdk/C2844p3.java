package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.p3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2844p3 {

    /* JADX INFO: renamed from: a */
    public final long f3000a;

    /* JADX INFO: renamed from: b */
    public final long f3001b;

    /* JADX INFO: renamed from: c */
    public final boolean f3002c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final String f3003d;

    public C2844p3(@NotNull String endpoint, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        this.f3000a = j;
        this.f3001b = j2;
        this.f3002c = z;
        this.f3003d = endpoint;
    }
}
