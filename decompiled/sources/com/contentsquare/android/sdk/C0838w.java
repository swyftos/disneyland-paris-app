package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0838w {
    public static boolean a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.isLaidOut() && view.getVisibility() == 0 && !(view.getAnimation() == null && view.getMatrix().isIdentity());
    }
}
