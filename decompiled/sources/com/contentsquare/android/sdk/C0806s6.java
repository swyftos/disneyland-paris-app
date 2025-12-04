package com.contentsquare.android.sdk;

import android.widget.LinearLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.s6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0806s6 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ C0727k6 a;
    public final /* synthetic */ LinearLayout b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0806s6(C0727k6 c0727k6, LinearLayout linearLayout) {
        super(1);
        this.a = c0727k6;
        this.b = linearLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        Y5 y5 = this.a.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        y5.g.b = zBooleanValue;
        if (zBooleanValue) {
            LinearLayout linearLayout = this.b;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout2 = this.b;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }
}
