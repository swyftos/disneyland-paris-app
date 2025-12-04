package com.contentsquare.android.sdk;

import android.system.Os;
import android.system.OsConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class B0 extends Lambda implements Function0<Long> {
    public static final B0 a = new B0();

    public B0() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(Os.sysconf(OsConstants._SC_CLK_TCK));
    }
}
