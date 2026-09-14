package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.q1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2852q1 implements InterfaceC2468D1 {

    /* JADX INFO: renamed from: a */
    public boolean f3022a;

    @Override // com.contentsquare.android.sdk.InterfaceC2468D1
    /* JADX INFO: renamed from: a */
    public final void mo895a() {
        this.f3022a = false;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2468D1
    /* JADX INFO: renamed from: a */
    public final void mo896a(@NotNull AbstractC2777i6 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof C2832o1) {
            this.f3022a = true;
        }
    }
}
