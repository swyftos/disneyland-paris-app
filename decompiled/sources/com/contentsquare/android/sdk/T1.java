package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class T1 implements Y6 {

    @Nullable
    public final String a;

    @NotNull
    public final String b;

    public T1(@NotNull Y6 descriptor, @NotNull String eventBridgeTargetPath) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(eventBridgeTargetPath, "eventBridgeTargetPath");
        this.a = descriptor.b();
        this.b = descriptor.a() + "|flutter|" + eventBridgeTargetPath;
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
