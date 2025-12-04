package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.j3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0714j3 implements Y6 {

    @NotNull
    public static final I3 c = new I3(new J3());

    @Nullable
    public final String a;

    @NotNull
    public final String b;

    public C0714j3(@NotNull View view) {
        String strA;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 0) {
            strA = I4.a(view, "null");
        } else {
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            strA = view2 != null ? I4.a(view2, null) : null;
        }
        this.a = strA;
        this.b = c.a(view);
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
