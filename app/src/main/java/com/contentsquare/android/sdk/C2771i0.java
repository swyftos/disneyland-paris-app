package com.contentsquare.android.sdk;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2771i0 {

    /* JADX INFO: renamed from: a */
    public final int f2730a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f2731b;

    /* JADX INFO: renamed from: c */
    public final int f2732c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final ArrayList f2733d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public byte[] f2734e;

    public C2771i0(int i, int i2, @NotNull String appVersion) {
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.f2730a = i;
        this.f2731b = appVersion;
        this.f2732c = i2;
        this.f2733d = new ArrayList();
        this.f2734e = new byte[0];
    }
}
