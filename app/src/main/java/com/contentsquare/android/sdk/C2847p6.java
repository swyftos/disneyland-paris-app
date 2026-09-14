package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.p163io.FilesKt;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.p6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2847p6 extends Lambda implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2797k6 f3007a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2847p6(C2797k6 c2797k6) {
        super(1);
        this.f3007a = c2797k6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        C2678Y5 c2678y5 = this.f3007a.f2828a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        c2678y5.f2301a.putBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE, zBooleanValue);
        if (!zBooleanValue) {
            C2678Y5 c2678y6 = this.f3007a.f2828a;
            if (c2678y6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y6 = null;
            }
            C2542K5 c2542k5 = c2678y6.f2306f;
            c2542k5.f1790d = null;
            c2542k5.f1789c = null;
            c2542k5.f1791e = 0;
            if (c2542k5.f1792f.exists()) {
                FilesKt.deleteRecursively(c2542k5.f1792f);
            }
        }
        return Unit.INSTANCE;
    }
}
