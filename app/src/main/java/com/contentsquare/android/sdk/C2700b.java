package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b */
/* JADX INFO: loaded from: classes2.dex */
public final class C2700b extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Function3<Integer, Integer, Long, Unit> f2391a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f2392b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f2393c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f2394d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ AbstractC2720d<View> f2395e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f2396f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ int f2397g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C2700b(Function3<? super Integer, ? super Integer, ? super Long, Unit> function3, int i, int i2, long j, AbstractC2720d<View> abstractC2720d, int i3, int i4) {
        super(0);
        this.f2391a = function3;
        this.f2392b = i;
        this.f2393c = i2;
        this.f2394d = j;
        this.f2395e = abstractC2720d;
        this.f2396f = i3;
        this.f2397g = i4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f2391a.invoke(Integer.valueOf(this.f2392b), Integer.valueOf(this.f2393c), Long.valueOf(this.f2394d));
        AbstractC2720d<View> abstractC2720d = this.f2395e;
        abstractC2720d.f2481b = this.f2396f;
        abstractC2720d.f2482c = this.f2397g;
        abstractC2720d.f2483d = 0L;
        return Unit.INSTANCE;
    }
}
