package com.contentsquare.android.sdk;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2872s1 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f3092m;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.s1$a */
    public static final class a extends AbstractC2730e.a<C2872s1> {

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f3093k;

        public a() {
            super(28);
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2872s1(this);
        }
    }

    public C2872s1(a aVar) {
        super(aVar);
        this.f3092m = aVar.f3093k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("EtrSessionEvent - " + this.f3092m);
    }
}
