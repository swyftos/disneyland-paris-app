package com.contentsquare.android.sdk;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2752g1 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final C2831o0 f2658a = new C2831o0();

    /* JADX INFO: renamed from: a */
    public final boolean m1140a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        C2831o0 c2831o0 = this.f2658a;
        if (c2831o0 == null) {
            return true;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        return c2831o0.m1183a(applicationContext);
    }
}
