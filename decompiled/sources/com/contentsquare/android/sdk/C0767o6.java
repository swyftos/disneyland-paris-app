package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.o6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0767o6 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ C0727k6 a;
    public final /* synthetic */ View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0767o6(C0727k6 c0727k6, View view) {
        super(1);
        this.a = c0727k6;
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
        y5.a.putBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, zBooleanValue);
        if (!zBooleanValue) {
            y5.a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(y5.a()).getFPS());
        }
        if (!zBooleanValue) {
            y5.a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(y5.a()).ordinal());
        }
        this.a.a(this.b);
        this.a.b(this.b);
        return Unit.INSTANCE;
    }
}
