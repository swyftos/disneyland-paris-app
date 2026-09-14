package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2716c5 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    public final int f2446m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final String f2447n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final CustomVar[] f2448o;

    /* JADX INFO: renamed from: p */
    public final boolean f2449p;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c5$a */
    public static final class a extends AbstractC2730e.a<C2716c5> {

        /* JADX INFO: renamed from: k */
        public int f2450k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public String f2451l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public CustomVar[] f2452m;

        /* JADX INFO: renamed from: n */
        public boolean f2453n;

        public a() {
            super(4);
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2716c5(this);
        }
    }

    public C2716c5(a aVar) {
        super(aVar);
        this.f2446m = aVar.f2450k;
        this.f2447n = aVar.f2451l;
        this.f2448o = aVar.f2452m;
        this.f2449p = aVar.f2453n;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        CustomVar[] customVarArr = this.f2448o;
        if (customVarArr == null || customVarArr.length == 0) {
            AbstractC2730e.f2545l.m831i("ScreenView - Screen name: " + this.f2447n + " - Screen number: " + this.f2549d);
            return;
        }
        AbstractC2730e.f2545l.m831i("ScreenView - Screen name: " + this.f2447n + " - Screen number: " + this.f2549d + " - cVars " + CustomVar.INSTANCE.generateCustomVarsLogMessage(this.f2448o));
    }
}
