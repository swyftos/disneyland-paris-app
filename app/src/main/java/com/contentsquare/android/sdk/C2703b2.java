package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2703b2 extends Lambda implements Function1<ViewLight, Boolean> {

    /* JADX INFO: renamed from: a */
    public static final C2703b2 f2402a = new C2703b2();

    public C2703b2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(ViewLight viewLight) {
        ViewLight it = viewLight;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.getIsClickable());
    }
}
