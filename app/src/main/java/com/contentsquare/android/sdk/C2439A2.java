package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.A2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2439A2 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f1373m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final String f1374n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final String f1375o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final Integer f1376p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public final Integer f1377q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public final String f1378r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public final Long f1379s;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.A2$a */
    public static final class a extends AbstractC2730e.a<C2439A2> {

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f1380k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public String f1381l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public String f1382m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public Integer f1383n;

        /* JADX INFO: renamed from: o */
        @Nullable
        public Integer f1384o;

        /* JADX INFO: renamed from: p */
        @Nullable
        public String f1385p;

        /* JADX INFO: renamed from: q */
        @Nullable
        public Long f1386q;

        public a() {
            super(26);
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2439A2(this);
        }
    }

    public C2439A2(a aVar) {
        super(aVar);
        this.f1373m = aVar.f1380k;
        this.f1374n = aVar.f1381l;
        this.f1375o = aVar.f1382m;
        this.f1376p = aVar.f1384o;
        this.f1377q = aVar.f1383n;
        this.f1378r = aVar.f1385p;
        this.f1379s = aVar.f1386q;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        Logger logger = AbstractC2730e.f2545l;
        StringBuilder sb = new StringBuilder("JS Error (from ");
        sb.append(this.f1378r);
        sb.append(") - ");
        String str = this.f1373m;
        sb.append(str != null ? StringsKt.take(str, 100) : null);
        logger.m831i(sb.toString());
    }
}
