package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.n1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0752n1 extends AbstractC0660e {

    @Nullable
    public final String m;

    /* renamed from: com.contentsquare.android.sdk.n1$a */
    public static final class a extends AbstractC0660e.a<C0752n1> {

        @Nullable
        public String k;

        public a() {
            super(29);
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0752n1(this);
        }
    }

    public C0752n1(a aVar) {
        super(aVar);
        this.m = aVar.k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("EtrScreenEvent - " + this.m);
    }
}
