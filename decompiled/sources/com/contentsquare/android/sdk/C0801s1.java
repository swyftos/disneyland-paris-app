package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.s1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0801s1 extends AbstractC0660e {

    @Nullable
    public final String m;

    /* renamed from: com.contentsquare.android.sdk.s1$a */
    public static final class a extends AbstractC0660e.a<C0801s1> {

        @Nullable
        public String k;

        public a() {
            super(28);
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0801s1(this);
        }
    }

    public C0801s1(a aVar) {
        super(aVar);
        this.m = aVar.k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("EtrSessionEvent - " + this.m);
    }
}
