package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class Q6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function0<Unit> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q6(com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.b bVar) {
        super(0);
        this.a = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.a.invoke();
        return Unit.INSTANCE;
    }
}
