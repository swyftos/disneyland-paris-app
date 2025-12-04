package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.i1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0702i1 extends AbstractC0660e {

    @NotNull
    public final String m;

    @NotNull
    public final String n;

    /* renamed from: com.contentsquare.android.sdk.i1$a */
    public static final class a extends AbstractC0660e.a<C0702i1> {

        @NotNull
        public String k;

        @NotNull
        public String l;

        public a() {
            super(18);
            this.k = "";
            this.l = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0702i1(this);
        }
    }

    public C0702i1(a aVar) {
        super(aVar);
        this.m = aVar.k;
        this.n = aVar.l;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("Dynamic variable - Key: " + this.n + " - Value: " + this.m);
    }
}
