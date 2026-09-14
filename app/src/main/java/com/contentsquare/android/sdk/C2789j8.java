package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.j8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2789j8 extends C2769h8.a {

    /* JADX INFO: renamed from: e */
    public final int f2790e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2789j8(@NotNull Bitmap bitmap, int i) {
        super(bitmap, true);
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.f2790e = i;
    }

    @Override // com.contentsquare.android.sdk.C2769h8.a, com.contentsquare.android.sdk.InterfaceC2749f8
    @NotNull
    /* JADX INFO: renamed from: a */
    public final String mo1134a(int i, int i2, int i3, int i4) {
        return super.mo1134a(i, i2 + this.f2790e, i3, i4);
    }
}
