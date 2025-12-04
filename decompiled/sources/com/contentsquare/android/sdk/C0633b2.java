package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.b2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0633b2 extends Lambda implements Function1<ViewLight, Boolean> {
    public static final C0633b2 a = new C0633b2();

    public C0633b2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(ViewLight viewLight) {
        ViewLight it = viewLight;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.getIsClickable());
    }
}
