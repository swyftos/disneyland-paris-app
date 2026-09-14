package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.j3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2784j3 implements InterfaceC2679Y6 {

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final C2520I3 f2765c = new C2520I3(new C2530J3());

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f2766a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f2767b;

    public C2784j3(@NotNull View view) {
        String strM942a;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 0) {
            strM942a = C2521I4.m942a(view, "null");
        } else {
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            strM942a = view2 != null ? C2521I4.m942a(view2, null) : null;
        }
        this.f2766a = strM942a;
        this.f2767b = f2765c.m939a(view);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @NotNull
    /* JADX INFO: renamed from: a */
    public final String mo1022a() {
        return this.f2767b;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @Nullable
    /* JADX INFO: renamed from: b */
    public final String mo1023b() {
        return this.f2766a;
    }
}
