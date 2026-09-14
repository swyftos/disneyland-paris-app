package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.utils.ExtensionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.A */
/* JADX INFO: loaded from: classes2.dex */
public final class C2436A extends Lambda implements Function1<View, Boolean> {

    /* JADX INFO: renamed from: a */
    public static final C2436A f1368a = new C2436A();

    public C2436A() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(View view) {
        View it = view;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(ExtensionsKt.isDerivedInstanceOf(it, "AppBarLayout"));
    }
}
