package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.f1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2742f1 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final String f2592m;

    /* JADX INFO: renamed from: n */
    public final int f2593n;

    /* JADX INFO: renamed from: o */
    public final int f2594o;

    /* JADX INFO: renamed from: p */
    public final int f2595p;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.f1$a */
    public static final class a extends AbstractC2730e.a<C2742f1> {

        /* JADX INFO: renamed from: k */
        @NotNull
        public String f2596k;

        /* JADX INFO: renamed from: l */
        public int f2597l;

        /* JADX INFO: renamed from: m */
        public int f2598m;

        /* JADX INFO: renamed from: n */
        public int f2599n;

        public a() {
            super(9);
            this.f2596k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2742f1(this);
        }
    }

    public C2742f1(a aVar) {
        super(aVar);
        this.f2592m = aVar.f2596k;
        this.f2593n = aVar.f2597l;
        this.f2594o = aVar.f2598m;
        this.f2595p = aVar.f2599n;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        String str;
        Logger logger = AbstractC2730e.f2545l;
        StringBuilder sb = new StringBuilder("Swipe ");
        int i = this.f2593n;
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
        sb.append(" Slow - Target: {Last view info: ");
        String path = this.f2592m;
        Intrinsics.checkNotNullParameter(path, "path");
        String strSubstring = path.substring(StringsKt.lastIndexOf$default((CharSequence) path, ">", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        sb.append('}');
        logger.m831i(sb.toString());
    }
}
