package com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay;

import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ a.InterfaceC0038a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a.InterfaceC0038a interfaceC0038a) {
        super(0);
        this.a = interfaceC0038a;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.a.e();
        return Unit.INSTANCE;
    }
}
