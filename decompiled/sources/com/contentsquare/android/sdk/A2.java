package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0660e;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class A2 extends AbstractC0660e {

    @Nullable
    public final String m;

    @Nullable
    public final String n;

    @Nullable
    public final String o;

    @Nullable
    public final Integer p;

    @Nullable
    public final Integer q;

    @Nullable
    public final String r;

    @Nullable
    public final Long s;

    public static final class a extends AbstractC0660e.a<A2> {

        @Nullable
        public String k;

        @Nullable
        public String l;

        @Nullable
        public String m;

        @Nullable
        public Integer n;

        @Nullable
        public Integer o;

        @Nullable
        public String p;

        @Nullable
        public Long q;

        public a() {
            super(26);
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new A2(this);
        }
    }

    public A2(a aVar) {
        super(aVar);
        this.m = aVar.k;
        this.n = aVar.l;
        this.o = aVar.m;
        this.p = aVar.o;
        this.q = aVar.n;
        this.r = aVar.p;
        this.s = aVar.q;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        Logger logger = AbstractC0660e.l;
        StringBuilder sb = new StringBuilder("JS Error (from ");
        sb.append(this.r);
        sb.append(") - ");
        String str = this.m;
        sb.append(str != null ? StringsKt.take(str, 100) : null);
        logger.i(sb.toString());
    }
}
