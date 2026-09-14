package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.S2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2618S2 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final String f2083m;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S2$a */
    public static final class a extends AbstractC2730e.a<C2618S2> {

        /* JADX INFO: renamed from: k */
        @NotNull
        public String f2084k;

        public a() {
            super(8);
            this.f2084k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2618S2(this);
        }
    }

    public C2618S2(a aVar) {
        super(aVar);
        this.f2083m = aVar.f2084k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        Logger logger = AbstractC2730e.f2545l;
        StringBuilder sb = new StringBuilder("Long press - Target: {Last view info: ");
        String path = this.f2083m;
        Intrinsics.checkNotNullParameter(path, "path");
        String strSubstring = path.substring(StringsKt.lastIndexOf$default((CharSequence) path, ">", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        sb.append('}');
        logger.m831i(sb.toString());
    }
}
