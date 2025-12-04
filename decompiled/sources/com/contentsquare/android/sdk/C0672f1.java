package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0660e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.f1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0672f1 extends AbstractC0660e {

    @NotNull
    public final String m;
    public final int n;
    public final int o;
    public final int p;

    /* renamed from: com.contentsquare.android.sdk.f1$a */
    public static final class a extends AbstractC0660e.a<C0672f1> {

        @NotNull
        public String k;
        public int l;
        public int m;
        public int n;

        public a() {
            super(9);
            this.k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0672f1(this);
        }
    }

    public C0672f1(a aVar) {
        super(aVar);
        this.m = aVar.k;
        this.n = aVar.l;
        this.o = aVar.m;
        this.p = aVar.n;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        Logger logger = AbstractC0660e.l;
        StringBuilder sb = new StringBuilder("Swipe ");
        int i = this.n;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Complex" : "Right" : "Left" : "Down" : "Up");
        sb.append(" Slow - Target: {Last view info: ");
        String path = this.m;
        Intrinsics.checkNotNullParameter(path, "path");
        String strSubstring = path.substring(StringsKt.lastIndexOf$default((CharSequence) path, ">", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        sb.append('}');
        logger.i(sb.toString());
    }
}
