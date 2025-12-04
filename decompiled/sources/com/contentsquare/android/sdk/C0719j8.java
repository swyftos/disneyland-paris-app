package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import com.contentsquare.android.sdk.C0699h8;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.j8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0719j8 extends C0699h8.a {
    public final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0719j8(@NotNull Bitmap bitmap, int i) {
        super(bitmap, true);
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.e = i;
    }

    @Override // com.contentsquare.android.sdk.C0699h8.a, com.contentsquare.android.sdk.InterfaceC0679f8
    @NotNull
    public final String a(int i, int i2, int i3, int i4) {
        return super.a(i, i2 + this.e, i3, i4);
    }
}
