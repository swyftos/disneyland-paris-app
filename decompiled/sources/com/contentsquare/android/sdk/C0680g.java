package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0680g extends AbstractC0660e {

    @Nullable
    public final String m;

    /* renamed from: com.contentsquare.android.sdk.g$a */
    public static final class a extends AbstractC0660e.a<C0680g> {

        @Nullable
        public String k;

        public a() {
            super(30);
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0680g(this);
        }
    }

    public C0680g(a aVar) {
        super(aVar);
        this.m = aVar.k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("ActivityEvent - name " + this.m);
    }
}
