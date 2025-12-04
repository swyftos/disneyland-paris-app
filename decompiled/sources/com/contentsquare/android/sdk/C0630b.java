package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0630b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function3<Integer, Integer, Long, Unit> a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ AbstractC0650d<View> e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C0630b(Function3<? super Integer, ? super Integer, ? super Long, Unit> function3, int i, int i2, long j, AbstractC0650d<View> abstractC0650d, int i3, int i4) {
        super(0);
        this.a = function3;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = abstractC0650d;
        this.f = i3;
        this.g = i4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.a.invoke(Integer.valueOf(this.b), Integer.valueOf(this.c), Long.valueOf(this.d));
        AbstractC0650d<View> abstractC0650d = this.e;
        abstractC0650d.b = this.f;
        abstractC0650d.c = this.g;
        abstractC0650d.d = 0L;
        return Unit.INSTANCE;
    }
}
