package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.d3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0654d3 extends Lambda implements Function0<Boolean> {
    public static final C0654d3 a = new C0654d3();

    public C0654d3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.ENABLE_HEAP_TRIPLET));
    }
}
