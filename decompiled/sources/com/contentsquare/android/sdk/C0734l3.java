package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.l3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0734l3 extends Lambda implements Function0<Logger> {
    public static final C0734l3 a = new C0734l3();

    public C0734l3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Logger invoke() {
        return new Logger("NetworkAgent");
    }
}
