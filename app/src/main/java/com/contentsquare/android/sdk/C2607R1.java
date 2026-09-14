package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.R1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2607R1 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final String f2051m;

    /* JADX INFO: renamed from: n */
    public final int f2052n;

    /* JADX INFO: renamed from: o */
    public final int f2053o;

    /* JADX INFO: renamed from: p */
    public final int f2054p;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.R1$a */
    public static final class a extends AbstractC2730e.a<C2607R1> {

        /* JADX INFO: renamed from: k */
        @NotNull
        public String f2055k;

        /* JADX INFO: renamed from: l */
        public int f2056l;

        /* JADX INFO: renamed from: m */
        public int f2057m;

        /* JADX INFO: renamed from: n */
        public int f2058n;

        public a() {
            super(10);
            this.f2055k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2607R1(this);
        }
    }

    public C2607R1(a aVar) {
        super(aVar);
        this.f2051m = aVar.f2055k;
        this.f2052n = aVar.f2056l;
        this.f2053o = aVar.f2057m;
        this.f2054p = aVar.f2058n;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        String str;
        Logger logger = AbstractC2730e.f2545l;
        StringBuilder sb = new StringBuilder("Swipe ");
        int i = this.f2052n;
        if (i == 1) {
            str = "Up";
        } else if (i == 2) {
            str = "Down";
        } else if (i != 3) {
            str = i != 4 ? "Complex" : "Right";
        } else {
            str = "Left";
        }
        sb.append(str);
        sb.append(" Fast - Target: {Last view info: ");
        String path = this.f2051m;
        Intrinsics.checkNotNullParameter(path, "path");
        String strSubstring = path.substring(StringsKt.lastIndexOf$default((CharSequence) path, ">", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        sb.append('}');
        logger.m831i(sb.toString());
    }
}
