package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class R8 implements Y6 {

    @Nullable
    public final String a;

    @NotNull
    public final String b;

    public R8(@NotNull Y6 descriptor, @NotNull String eventWebViewTargetPath) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(eventWebViewTargetPath, "eventWebViewTargetPath");
        this.a = descriptor.b();
        this.b = descriptor.a() + "|webview|" + eventWebViewTargetPath;
    }

    @Override // com.contentsquare.android.sdk.Y6
    @NotNull
    public final String a() {
        return this.b;
    }

    @Override // com.contentsquare.android.sdk.Y6
    @Nullable
    public final String b() {
        return this.a;
    }
}
