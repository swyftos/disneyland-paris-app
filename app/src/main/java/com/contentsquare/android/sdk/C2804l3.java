package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2804l3 extends Lambda implements Function0<Logger> {

    /* JADX INFO: renamed from: a */
    public static final C2804l3 f2844a = new C2804l3();

    public C2804l3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Logger invoke() {
        return new Logger("NetworkAgent");
    }
}
