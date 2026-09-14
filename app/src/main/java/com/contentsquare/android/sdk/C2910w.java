package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.w */
/* JADX INFO: loaded from: classes2.dex */
public final class C2910w {
    /* JADX INFO: renamed from: a */
    public static boolean m1225a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.isLaidOut() && view.getVisibility() == 0 && !(view.getAnimation() == null && view.getMatrix().isIdentity());
    }
}
