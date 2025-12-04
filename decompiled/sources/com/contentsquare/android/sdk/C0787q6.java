package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.q6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0787q6 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ C0727k6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0787q6(C0727k6 c0727k6) {
        super(1);
        this.a = c0727k6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Integer num) {
        int iIntValue = num.intValue();
        Y5 y5 = this.a.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        y5.a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC, iIntValue);
        return Unit.INSTANCE;
    }
}
