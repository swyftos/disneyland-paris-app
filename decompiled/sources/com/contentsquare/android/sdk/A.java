package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.utils.ExtensionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class A extends Lambda implements Function1<View, Boolean> {
    public static final A a = new A();

    public A() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(View view) {
        View it = view;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(ExtensionsKt.isDerivedInstanceOf(it, "AppBarLayout"));
    }
}
