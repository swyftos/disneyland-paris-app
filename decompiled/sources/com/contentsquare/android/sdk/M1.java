package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class M1 extends Lambda implements Function0<L4> {
    public final /* synthetic */ D5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M1(D5 d5) {
        super(0);
        this.a = d5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        return this.a.b.isFeatureFlagEnabled(JsonConfigFeatureFlagNames.SESSION_RECORDING_ENABLED) ? L4.EVALUATE : L4.PROPAGATE_STOP;
    }
}
