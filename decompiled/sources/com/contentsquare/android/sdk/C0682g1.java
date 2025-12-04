package com.contentsquare.android.sdk;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.g1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0682g1 {

    @Nullable
    public final C0761o0 a = new C0761o0();

    public final boolean a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        C0761o0 c0761o0 = this.a;
        if (c0761o0 == null) {
            return true;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        return c0761o0.a(applicationContext);
    }
}
