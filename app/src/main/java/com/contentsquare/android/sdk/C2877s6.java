package com.contentsquare.android.sdk;

import android.widget.LinearLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2877s6 extends Lambda implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2797k6 f3102a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LinearLayout f3103b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2877s6(C2797k6 c2797k6, LinearLayout linearLayout) {
        super(1);
        this.f3102a = c2797k6;
        this.f3103b = linearLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        C2678Y5 c2678y5 = this.f3102a.f2828a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        c2678y5.f2307g.f1950b = zBooleanValue;
        if (zBooleanValue) {
            LinearLayout linearLayout = this.f3103b;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout2 = this.f3103b;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }
}
