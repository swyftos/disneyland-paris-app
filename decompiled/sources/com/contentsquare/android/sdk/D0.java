package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class D0 extends Lambda implements Function0<Logger> {
    public static final D0 a = new D0();

    public D0() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Logger invoke() {
        return new Logger("PerformanceDataProviderStat");
    }
}
