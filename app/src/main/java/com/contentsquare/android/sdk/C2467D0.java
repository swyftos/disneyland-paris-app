package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.D0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2467D0 extends Lambda implements Function0<Logger> {

    /* JADX INFO: renamed from: a */
    public static final C2467D0 f1508a = new C2467D0();

    public C2467D0() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Logger invoke() {
        return new Logger("PerformanceDataProviderStat");
    }
}
