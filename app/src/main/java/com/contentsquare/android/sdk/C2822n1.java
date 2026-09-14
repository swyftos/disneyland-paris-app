package com.contentsquare.android.sdk;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2822n1 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f2899m;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.n1$a */
    public static final class a extends AbstractC2730e.a<C2822n1> {

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f2900k;

        public a() {
            super(29);
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2822n1(this);
        }
    }

    public C2822n1(a aVar) {
        super(aVar);
        this.f2899m = aVar.f2900k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("EtrScreenEvent - " + this.f2899m);
    }
}
