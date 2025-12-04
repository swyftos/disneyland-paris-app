package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.l8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0739l8 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ View a;
    public final /* synthetic */ Runnable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0739l8(View view, RunnableC0749m8 runnableC0749m8) {
        super(1);
        this.a = view;
        this.b = runnableC0749m8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        this.a.removeCallbacks(this.b);
        return Unit.INSTANCE;
    }
}
