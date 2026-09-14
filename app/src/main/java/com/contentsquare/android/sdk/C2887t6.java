package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.t6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2887t6 extends Lambda implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2797k6 f3112a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2492F5.b f3113b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2887t6(C2797k6 c2797k6, C2492F5.b bVar) {
        super(1);
        this.f3112a = c2797k6;
        this.f3113b = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        C2678Y5 c2678y5 = null;
        if (bool.booleanValue()) {
            C2678Y5 c2678y6 = this.f3112a.f2828a;
            if (c2678y6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                c2678y5 = c2678y6;
            }
            C2492F5 c2492f5 = c2678y5.f2307g;
            C2492F5.b bVar = this.f3113b;
            synchronized (c2492f5) {
                c2492f5.f1949a.add(bVar);
            }
        } else {
            C2678Y5 c2678y7 = this.f3112a.f2828a;
            if (c2678y7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                c2678y5 = c2678y7;
            }
            c2678y5.f2307g.m998a(this.f3113b);
        }
        return Unit.INSTANCE;
    }
}
