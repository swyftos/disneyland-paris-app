package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class S5 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ V5 a;
    public final /* synthetic */ View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S5(V5 v5, View view) {
        super(1);
        this.a = v5;
        this.b = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        Y5 y5 = this.a.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        y5.a.putBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, zBooleanValue);
        this.a.a(this.b, zBooleanValue);
        return Unit.INSTANCE;
    }
}
