package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.m6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2817m6 extends Lambda implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2797k6 f2886a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2817m6(C2797k6 c2797k6) {
        super(1);
        this.f2886a = c2797k6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        C2678Y5 c2678y5 = this.f2886a.f2828a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        c2678y5.f2301a.putBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, zBooleanValue);
        return Unit.INSTANCE;
    }
}
