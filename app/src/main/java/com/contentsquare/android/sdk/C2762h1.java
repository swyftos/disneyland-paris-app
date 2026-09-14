package com.contentsquare.android.sdk;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.h1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2762h1 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    public final long f2680m;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final String f2681n;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.h1$a */
    public static final class a extends AbstractC2730e.a<C2762h1> {

        /* JADX INFO: renamed from: k */
        public long f2682k;

        /* JADX INFO: renamed from: l */
        @NotNull
        public String f2683l;

        public a() {
            super(19);
            this.f2683l = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2762h1(this);
        }
    }

    public C2762h1(a aVar) {
        super(aVar);
        this.f2680m = aVar.f2682k;
        this.f2681n = aVar.f2683l;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("Dynamic variable - Key: " + this.f2681n + " - Value: " + this.f2680m);
    }
}
