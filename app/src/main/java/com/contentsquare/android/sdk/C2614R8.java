package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.R8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2614R8 implements InterfaceC2679Y6 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f2074a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f2075b;

    public C2614R8(@NotNull InterfaceC2679Y6 descriptor, @NotNull String eventWebViewTargetPath) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(eventWebViewTargetPath, "eventWebViewTargetPath");
        this.f2074a = descriptor.mo1023b();
        this.f2075b = descriptor.mo1022a() + "|webview|" + eventWebViewTargetPath;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @NotNull
    /* JADX INFO: renamed from: a */
    public final String mo1022a() {
        return this.f2075b;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @Nullable
    /* JADX INFO: renamed from: b */
    public final String mo1023b() {
        return this.f2074a;
    }
}
