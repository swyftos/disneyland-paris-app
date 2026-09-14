package com.contentsquare.android.sdk;

import android.system.Os;
import android.system.OsConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.B0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2447B0 extends Lambda implements Function0<Long> {

    /* JADX INFO: renamed from: a */
    public static final C2447B0 f1434a = new C2447B0();

    public C2447B0() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(Os.sysconf(OsConstants._SC_CLK_TCK));
    }
}
