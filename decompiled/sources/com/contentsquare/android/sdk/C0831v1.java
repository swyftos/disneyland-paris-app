package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.v1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0831v1 implements D1 {
    public boolean a;

    @Override // com.contentsquare.android.sdk.D1
    public final void a() {
        this.a = false;
    }

    @Override // com.contentsquare.android.sdk.D1
    public final void a(@NotNull AbstractC0707i6 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof C0811t1) {
            this.a = true;
        }
    }
}
