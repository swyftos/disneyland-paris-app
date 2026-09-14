package com.contentsquare.android.sdk;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2772i1 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final String f2735m;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final String f2736n;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.i1$a */
    public static final class a extends AbstractC2730e.a<C2772i1> {

        /* JADX INFO: renamed from: k */
        @NotNull
        public String f2737k;

        /* JADX INFO: renamed from: l */
        @NotNull
        public String f2738l;

        public a() {
            super(18);
            this.f2737k = "";
            this.f2738l = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2772i1(this);
        }
    }

    public C2772i1(a aVar) {
        super(aVar);
        this.f2735m = aVar.f2737k;
        this.f2736n = aVar.f2738l;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("Dynamic variable - Key: " + this.f2736n + " - Value: " + this.f2735m);
    }
}
