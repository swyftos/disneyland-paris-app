package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class J2 implements D1 {
    public long a;

    @Override // com.contentsquare.android.sdk.D1
    public final void a() {
        this.a = 0L;
    }

    @Override // com.contentsquare.android.sdk.D1
    public final void a(@NotNull AbstractC0707i6 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getTimestamp() > this.a) {
            this.a = event.getTimestamp();
        }
    }
}
