package com.contentsquare.android.sdk;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.N7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2574N7 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final String f1899m;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.N7$a */
    public static final class a extends AbstractC2730e.a<C2574N7> {

        /* JADX INFO: renamed from: k */
        @NotNull
        public String f1900k;

        public a() {
            super(22);
            this.f1900k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2574N7(this);
        }
    }

    public C2574N7(a aVar) {
        super(aVar);
        this.f1899m = aVar.f1900k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("User identifier hashed sent " + this.f1899m);
    }
}
