package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class T5 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ V5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T5(V5 v5) {
        super(1);
        this.a = v5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Integer num) {
        int iIntValue = num.intValue();
        Y5 y5 = this.a.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        y5.a.putInt(PreferencesKey.CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, iIntValue);
        return Unit.INSTANCE;
    }
}
