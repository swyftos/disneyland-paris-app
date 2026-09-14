package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2809l8 extends Lambda implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ View f2863a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Runnable f2864b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2809l8(View view, RunnableC2819m8 runnableC2819m8) {
        super(1);
        this.f2863a = view;
        this.f2864b = runnableC2819m8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        this.f2863a.removeCallbacks(this.f2864b);
        return Unit.INSTANCE;
    }
}
