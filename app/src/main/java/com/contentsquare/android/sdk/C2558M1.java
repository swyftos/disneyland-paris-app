package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.M1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2558M1 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2472D5 f1854a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2558M1(C2472D5 c2472d5) {
        super(0);
        this.f1854a = c2472d5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        return this.f1854a.f1520b.isFeatureFlagEnabled(JsonConfigFeatureFlagNames.SESSION_RECORDING_ENABLED) ? EnumC2551L4.EVALUATE : EnumC2551L4.PROPAGATE_STOP;
    }
}
