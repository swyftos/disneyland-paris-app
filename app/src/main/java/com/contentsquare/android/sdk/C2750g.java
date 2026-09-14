package com.contentsquare.android.sdk;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g */
/* JADX INFO: loaded from: classes2.dex */
public final class C2750g extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f2651m;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.g$a */
    public static final class a extends AbstractC2730e.a<C2750g> {

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f2652k;

        public a() {
            super(30);
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2750g(this);
        }
    }

    public C2750g(a aVar) {
        super(aVar);
        this.f2651m = aVar.f2652k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("ActivityEvent - name " + this.f2651m);
    }
}
