package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2806l5 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    public final int f2850m;

    /* JADX INFO: renamed from: n */
    public final int f2851n;

    /* JADX INFO: renamed from: o */
    public final long f2852o;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.l5$a */
    public static final class a extends AbstractC2730e.a<C2806l5> {

        /* JADX INFO: renamed from: k */
        public int f2853k;

        /* JADX INFO: renamed from: l */
        public int f2854l;

        /* JADX INFO: renamed from: m */
        public long f2855m;

        public a() {
            super(23);
            this.f2855m = 250L;
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2806l5(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2806l5(@NotNull a builder) {
        super(builder);
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f2850m = builder.f2853k;
        this.f2851n = builder.f2854l;
        this.f2852o = builder.f2855m;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("Scroll - deltaX: " + this.f2850m + " - deltaY: " + this.f2851n + " - Duration: " + this.f2852o);
    }
}
