package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.F5;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.t6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0816t6 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ C0727k6 a;
    public final /* synthetic */ F5.b b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0816t6(C0727k6 c0727k6, F5.b bVar) {
        super(1);
        this.a = c0727k6;
        this.b = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        Y5 y5 = null;
        if (bool.booleanValue()) {
            Y5 y52 = this.a.a;
            if (y52 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                y5 = y52;
            }
            F5 f5 = y5.g;
            F5.b bVar = this.b;
            synchronized (f5) {
                f5.a.add(bVar);
            }
        } else {
            Y5 y53 = this.a.a;
            if (y53 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                y5 = y53;
            }
            y5.g.a(this.b);
        }
        return Unit.INSTANCE;
    }
}
