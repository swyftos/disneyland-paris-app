package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.sdk.C0646c5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* renamed from: com.contentsquare.android.sdk.g5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0686g5 extends AbstractC0620a {
    public final /* synthetic */ E1 f;
    public final /* synthetic */ C0696h5 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0686g5(L3 l3, InterfaceC0832v2 interfaceC0832v2, E1 e1, C0696h5 c0696h5, Logger logger) {
        super(l3, logger, interfaceC0832v2);
        this.f = e1;
        this.g = c0696h5;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0620a
    public final void a(int i, @Nullable String str, @Nullable String str2, @NotNull CustomVar[] customVars, boolean z, @Nullable Long l, @Nullable String str3) throws JSONException {
        Intrinsics.checkNotNullParameter(customVars, "customVars");
        C0646c5.a aVar = (C0646c5.a) this.f.a(4, str2);
        aVar.k = i;
        aVar.l = str;
        aVar.m = customVars;
        aVar.n = z;
        if (l != null) {
            aVar.i = l.longValue();
        }
        C0696h5 c0696h5 = this.g;
        c0696h5.e = aVar;
        c0696h5.c.putLong(PreferencesKey.SCREEN_TIMESTAMP, aVar.i);
        if (C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.END_OF_SCREEN_VIEW) && aVar.c != 0) {
            C0696h5 c0696h52 = this.g;
            c0696h52.a.a(this.f.a(24, str3));
        }
        this.g.a.a(aVar);
    }
}
