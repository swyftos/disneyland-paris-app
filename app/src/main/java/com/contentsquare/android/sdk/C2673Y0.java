package com.contentsquare.android.sdk;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Y0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2673Y0 implements Function1 {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String name = obj.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "obj.javaClass.name");
        return name;
    }
}
