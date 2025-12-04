package com.contentsquare.android.sdk;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.i0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0701i0 {
    public final int a;

    @NotNull
    public final String b;
    public final int c;

    @NotNull
    public final ArrayList d;

    @NotNull
    public byte[] e;

    public C0701i0(int i, int i2, @NotNull String appVersion) {
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.a = i;
        this.b = appVersion;
        this.c = i2;
        this.d = new ArrayList();
        this.e = new byte[0];
    }
}
