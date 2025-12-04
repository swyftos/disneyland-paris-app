package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class U5 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ V5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U5(V5 v5) {
        super(1);
        this.a = v5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        Y5 y5 = this.a.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        y5.a.putBoolean(PreferencesKey.CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE, zBooleanValue);
        return Unit.INSTANCE;
    }
}
