package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.J2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2529J2 implements InterfaceC2468D1 {

    /* JADX INFO: renamed from: a */
    public long f1741a;

    @Override // com.contentsquare.android.sdk.InterfaceC2468D1
    /* JADX INFO: renamed from: a */
    public final void mo895a() {
        this.f1741a = 0L;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2468D1
    /* JADX INFO: renamed from: a */
    public final void mo896a(@NotNull AbstractC2777i6 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getTimestamp() > this.f1741a) {
            this.f1741a = event.getTimestamp();
        }
    }
}
