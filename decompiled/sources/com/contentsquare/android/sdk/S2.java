package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0660e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class S2 extends AbstractC0660e {

    @NotNull
    public final String m;

    public static final class a extends AbstractC0660e.a<S2> {

        @NotNull
        public String k;

        public a() {
            super(8);
            this.k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new S2(this);
        }
    }

    public S2(a aVar) {
        super(aVar);
        this.m = aVar.k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        Logger logger = AbstractC0660e.l;
        StringBuilder sb = new StringBuilder("Long press - Target: {Last view info: ");
        String path = this.m;
        Intrinsics.checkNotNullParameter(path, "path");
        String strSubstring = path.substring(StringsKt.lastIndexOf$default((CharSequence) path, ">", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        sb.append('}');
        logger.i(sb.toString());
    }
}
