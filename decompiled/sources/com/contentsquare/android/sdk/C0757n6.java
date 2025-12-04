package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.n6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0757n6 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ C0727k6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0757n6(C0727k6 c0727k6) {
        super(1);
        this.a = c0727k6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        Y5 y5 = this.a.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        y5.a.putBoolean(PreferencesKey.SESSION_REPLAY_FORCE_START, zBooleanValue);
        return Unit.INSTANCE;
    }
}
