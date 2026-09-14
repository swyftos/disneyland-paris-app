package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2627T1 implements InterfaceC2679Y6 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f2145a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f2146b;

    public C2627T1(@NotNull InterfaceC2679Y6 descriptor, @NotNull String eventBridgeTargetPath) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(eventBridgeTargetPath, "eventBridgeTargetPath");
        this.f2145a = descriptor.mo1023b();
        this.f2146b = descriptor.mo1022a() + "|flutter|" + eventBridgeTargetPath;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @NotNull
    /* JADX INFO: renamed from: a */
    public final String mo1022a() {
        return this.f2146b;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @Nullable
    /* JADX INFO: renamed from: b */
    public final String mo1023b() {
        return this.f2145a;
    }
}
