package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.h1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0692h1 extends AbstractC0660e {
    public final long m;

    @NotNull
    public final String n;

    /* renamed from: com.contentsquare.android.sdk.h1$a */
    public static final class a extends AbstractC0660e.a<C0692h1> {
        public long k;

        @NotNull
        public String l;

        public a() {
            super(19);
            this.l = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0692h1(this);
        }
    }

    public C0692h1(a aVar) {
        super(aVar);
        this.m = aVar.k;
        this.n = aVar.l;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("Dynamic variable - Key: " + this.n + " - Value: " + this.m);
    }
}
