package com.contentsquare.android.sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C2476E extends FunctionReferenceImpl implements Function0<Long> {

    /* JADX INFO: renamed from: a */
    public static final C2476E f1531a = new C2476E();

    public C2476E() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
