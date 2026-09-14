package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.o6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2837o6 extends Lambda implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2797k6 f2978a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f2979b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2837o6(C2797k6 c2797k6, View view) {
        super(1);
        this.f2978a = c2797k6;
        this.f2979b = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        C2678Y5 c2678y5 = this.f2978a.f2828a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        c2678y5.f2301a.putBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, zBooleanValue);
        if (!zBooleanValue) {
            c2678y5.f2301a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(c2678y5.m1074a()).getFPS());
        }
        if (!zBooleanValue) {
            c2678y5.f2301a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(c2678y5.m1074a()).ordinal());
        }
        this.f2978a.m1174a(this.f2979b);
        this.f2978a.m1175b(this.f2979b);
        return Unit.INSTANCE;
    }
}
