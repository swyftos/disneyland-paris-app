package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.X6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2670X6 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final String f2275m;

    /* JADX INFO: renamed from: n */
    public final boolean f2276n;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.X6$a */
    public static final class a extends AbstractC2730e.a<C2670X6> {

        /* JADX INFO: renamed from: k */
        @NotNull
        public String f2277k;

        /* JADX INFO: renamed from: l */
        public boolean f2278l;

        public a() {
            super(6);
            this.f2277k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2670X6(this);
        }
    }

    public C2670X6(a aVar) {
        super(aVar);
        this.f2275m = aVar.f2277k;
        this.f2276n = aVar.f2278l;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        Logger logger = AbstractC2730e.f2545l;
        StringBuilder sb = new StringBuilder("Tap - Target: {Last view info: ");
        String path = this.f2275m;
        Intrinsics.checkNotNullParameter(path, "path");
        String strSubstring = path.substring(StringsKt.lastIndexOf$default((CharSequence) path, ">", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        sb.append("} - Unresponsive: ");
        sb.append(this.f2276n);
        logger.m831i(sb.toString());
    }
}
